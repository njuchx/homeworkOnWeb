<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.chen.users.Users"/>
<jsp:useBean id="student" class="com.chen.users.Student" scope="application"/>
<jsp:useBean id="studentDao" class="com.chen.dao.StudentDao"/>

<jsp:setProperty name="user" property="*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生登录</title>
</head>
<body>
<%
if(studentDao.studentLogin(user)){
	student = studentDao.find(user);
	out.print("学生登录成功<br>");
	session.setAttribute("user", student);
	session.setAttribute("identity", "student");
	response.sendRedirect(request.getContextPath()+"/student/index.jsp");
}else{
	out.print("登陆失败，用户名或密码错误,3秒后自动返回登录界面");
	response.setHeader("refresh", "3;URL=index.jsp");
}
%>
<a href="index.jsp">返回登录界面</a>
</body>
</html>