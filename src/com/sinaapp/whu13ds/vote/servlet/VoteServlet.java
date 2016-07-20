package com.sinaapp.whu13ds.vote.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinaapp.whu13ds.vote.dao.StudentDao;
import com.sinaapp.whu13ds.vote.utils.StringUtils;
import com.sinaapp.whu13ds.vote.vo.Student;

/**
 * Servlet implementation class VoteServlet
 */
public class VoteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 StudentDao studentDao = new StudentDao();
		 List<Student> studentList = studentDao.queryForList();
		 request.setAttribute("studentList",studentList);
		 request.getRequestDispatcher("vote.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=new String(request.getParameter("number").getBytes("ISO-8859-1"),"UTF-8");
		 String num2 = StringUtils.remove(num);
		 long number = Long.parseLong(num2);
		 StudentDao stuDao = new StudentDao();
		 int count=0;
		 try{
		 stuDao.update(number);
		 Student student = stuDao.query(number);
		 count = student.getCount();
		 }catch(Exception e){
			 request.getRequestDispatcher("error.jsp").forward(request,response);
		 }
		 PrintWriter out = response.getWriter();
		 out.println(count);
	}

}
