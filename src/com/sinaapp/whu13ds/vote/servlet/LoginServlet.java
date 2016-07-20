package com.sinaapp.whu13ds.vote.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinaapp.whu13ds.vote.dao.StudentDao;
import com.sinaapp.whu13ds.vote.vo.Student;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("number");
		Long number = Long.parseLong(num);
		StudentDao studentDao = new StudentDao();
		Student student = null;
		try{
		student = studentDao.query(number);
		}catch(Exception e){
			
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name="";
		try{
			name = student.getName();
		}catch(Exception e){
			
		}
		if("".equals(name)||name==null){
			out.println("学号错误！！");
		}else{
			out.println(name);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("number");
		Long number = Long.parseLong(num);
		StudentDao studentDao = new StudentDao();
		int flag = studentDao.queryFlag(number);
		HttpSession session = request.getSession();
		session.setAttribute("number", number);
		session.setAttribute("flag", flag);
		if(flag==0){
			studentDao.updateFlag(number);
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
