package com.chen.servlet;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			Student student = (Student) session.getAttribute("user");
			student.modifyPassword(newPassword);
			response.sendRedirect(request.getContextPath()
					+ "/student/index.jsp");
		} else if (identity.equals("teacher")) {
			Teacher teacher = (Teacher) session.getAttribute("user");
			teacher.modifyPassword(newPassword);
			response.sendRedirect(request.getContextPath()
					+ "/teacher/index.jsp");
		} else if (identity.equals("assteacher")) {
			AssTeacher assTeacher = (AssTeacher) session.getAttribute("user");
			assTeacher.modifyPassword(newPassword);
			response.sendRedirect(request.getContextPath()
					+ "/teacher/index.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
}


