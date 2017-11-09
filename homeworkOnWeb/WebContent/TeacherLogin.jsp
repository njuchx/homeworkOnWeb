<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.chen.users.Users"/>
<jsp:useBean id="userTeacher" class="com.chen.users.Teacher"/>
<jsp:useBean id="teacherDao" class="com.chen.dao.TeacherDao"/>

<jsp:setProperty name="user" property="*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生登录</title>
</head>
<body>
<%
if(teacherDao.teacherLogin(user)){
	userTeacher = teacherDao.find(user);
	out.print("教师登录成功<br>");
	out.print("学号："+userTeacher.getTeacherID()+"<br>");
	out.print("姓名："+userTeacher.getName()+"<br>");
	session.setAttribute("User", userTeacher);
	session.setAttribute("identity", "teacher");
	response.sendRedirect(request.getContextPath()+"/teacher/index.jsp");
}else{
	out.print("登陆失败，用户名或密码错误,3秒后自动返回登录界面");
	response.setHeader("refresh", "3;URL=index.jsp");
}
%>
<a href="index.jsp">返回登录界面</a>
</body>
</html>