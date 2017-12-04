package com.chen.servlet;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chen.dao.AssTeacherDao;
import com.chen.dao.StudentDao;
import com.chen.dao.TeacherDao;
import com.chen.users.AssTeacher;
import com.chen.users.Student;
import com.chen.users.Teacher;

/**
 * Servlet implementation class ModifyPassword
 */
public class ModifyPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String newPassword = request.getParameter("newPassword");
		String identity = (String) session.getAttribute("identity");

		if (identity.equals("student")) {
			StudentDao studentDao = new StudentDao();
			studentDao.modifyPassword(((Student) session.getAttribute("user")).getStuID(),newPassword);
			response.sendRedirect(request.getContextPath()
					+ "/student/index.jsp");
		} else if (identity.equals("teacher")) {
			TeacherDao teacherDao = new TeacherDao();
			teacherDao.modifyPassword(((Teacher) session.getAttribute("user")).getTeacherID(),newPassword);
			response.sendRedirect(request.getContextPath()
					+ "/teacher/index.jsp");
		} else if (identity.equals("assteacher")) {
			AssTeacherDao assTeacherDao = new AssTeacherDao();
			assTeacherDao.modifyPassword(((AssTeacher) session.getAttribute("user")).getAssTeacherID(),newPassword);
			response.sendRedirect(request.getContextPath()
					+ "/teacher/index.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
}


