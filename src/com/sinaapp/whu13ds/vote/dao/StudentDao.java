package com.sinaapp.whu13ds.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sinaapp.whu13ds.vote.db.JDBCUtils;
import com.sinaapp.whu13ds.vote.vo.Student;

public class StudentDao {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public boolean insert(long number) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into student(number) values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, number);
			pstmt.execute();
			JDBCUtils.release(conn);
			return true;
		} catch (Exception e) {
			System.out.println("加入数据异常");
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(long number) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update student set count = (count+1) where number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, number);
			pstmt.execute();
			pstmt.close();
			JDBCUtils.release(conn);
			return true;
		} catch (Exception e) {
			System.out.println("更新数据异常");
			e.printStackTrace();
			return false;
		}
	}

	public Student query(long number) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from student where number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, number);
			rs = pstmt.executeQuery();
			Student student = new Student();
			while (rs.next()) {
				student.setNumber(number);
				student.setName(rs.getString(3));
				student.setCount(rs.getInt(4));
			}
			JDBCUtils.release(rs, pstmt);
			JDBCUtils.release(conn);
			return student;
		} catch (Exception e) {
			System.out.println("查询数据异常");
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Student> queryForList(){
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Student> studentList = new ArrayList<Student>();
			while (rs.next()) {
				Student student = new Student();
				student.setNumber(rs.getLong(2));
				student.setName(rs.getString(3));
				student.setCount(rs.getInt(4));
				studentList.add(student);
			}
			JDBCUtils.release(rs, pstmt);
			JDBCUtils.release(conn);
			return studentList;
		} catch (Exception e) {
			System.out.println("查询数据异常");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateFlag(Long number){
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update student set flag = 1 where number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, number);
			pstmt.execute();
			pstmt.close();
			JDBCUtils.release(conn);
			return true;
		} catch (Exception e) {
			System.out.println("更新标志位异常");
			e.printStackTrace();
			return false;
		}
	
	}
	
	public int queryFlag(Long number){
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select flag from student where number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, number);
			rs = pstmt.executeQuery();
			int flag = 0;
			while(rs.next()){
				flag = rs.getInt("flag");
			}
			JDBCUtils.release(rs, pstmt);
			return flag;
		} catch (Exception e) {
			System.out.println("更新标志位异常");
			e.printStackTrace();
			return 0;
		}
		
	}
}
