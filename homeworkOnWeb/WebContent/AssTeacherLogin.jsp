<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.chen.users.Users"/>
<jsp:useBean id="userAssTeacher" class="com.chen.users.AssTeacher"/>
<jsp:useBean id="assTeacherDao" class="com.chen.dao.AssTeacherDao"/>

<jsp:setProperty name="user" property="*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生登录</title>
</head>
<body>
<%
if(assTeacherDao.assTeacherLogin(user)){
	userAssTeacher = assTeacherDao.find(user);
	out.print("助教登录成功<br>");
	out.print("学号："+userAssTeacher.getAssTeacherID()+"<br>");
	out.print("姓名："+userAssTeacher.getName()+"<br>");
	session.setAttribute("User", userAssTeacher);
	session.setAttribute("identity", "assteacher");
	response.sendRedirect(request.getContextPath()+"/teacher/index.jsp");
}else{
	out.print("登陆失败，用户名或密码错误,3秒后自动返回登录界面");
	response.setHeader("refresh", "3;URL=index.jsp");
}
%>
<a href="index.jsp">返回登录界面</a>
</body>
</html>