package com.chen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.dao.StudentDao;
import com.chen.users.Student;

/**
 * Servlet implementation class SubmitHomework
 */
@WebServlet("/SubmitHomework")
public class SubmitHomework extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitHomework() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String stuID = (String) (((Student) session.getAttribute("user")).getStuID());
		String tskStuAnswer = request.getParameter("tskStuAnswer");
		String homeworkID = request.getParameter("homeworkID");
		String tskID = request.getParameter("tskID");
		String tskState = request.getParameter("tskState");
		System.out.println(stuID+tskStuAnswer+homeworkID+tskID+tskState);
		StudentDao studentDao = new StudentDao();
		studentDao.submitHomework(stuID,homeworkID,tskID,tskStuAnswer,tskState);
		response.sendRedirect(request.getContextPath() + "/student/dohomework.jsp");
	}

}
