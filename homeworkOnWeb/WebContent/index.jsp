<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>作业提交管理系统</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<header class="header">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="header_title text-center">
					<h5>作业提交系统登录</h5>
					
				</div>
			</div>
		</div>
	</div>
</header>
<section class="wrap">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
			<div class="wrap_content">
			<div class="">
				<ul id="myTab" class="nav nav-tabs style_main">
				<li class="active"><a href="#student" data-toggle="tab">学生登录</a></li>
				<li><a href="#teacher" data-toggle="tab">教师登录</a></li>
				<li><a href="#assteacher" data-toggle="tab">助教登录</a></li>
				</ul>
			</div>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="student">
						<form action="StudentLogin.jsp" method="post">
							<div id="lo-form">
				
			    			<div class="form-group">
			    			<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input class="form-control input-lg" id="registid" name="username" placeholder="账号" type="text">
							</div>
			    
			  				</div>
			  				<div class="form-group">
			   				<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input id="password" name="password" class="form-control input-lg" placeholder="密码" type="password">
							</div>
			  				</div>
							  <button class="btn btn-lg btn-danger btn-block" type="submit">Sign in</button>
							</div>
						</form>
					</div>
					<div class="tab-pane fade" id="teacher">
						<form action="TeacherLogin.jsp" method="post" class="form_post">
							<div id="lo-form">
				
			    			<div class="form-group">
			    			<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input class="form-control input-lg" id="registid" name="username" placeholder="账号" type="text">
							</div>
			    
			  				</div>
			  				<div class="form-group">
			   				<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input id="password" name="password" class="form-control input-lg" placeholder="密码" type="password">
							</div>
			  				</div>
			 
							 
							  <button class="btn btn-lg btn-danger btn-block" type="submit">Sign in</button>
							  
							  
							</div>
						</form>
					</div>
					<div class="tab-pane fade" id="assteacher">
						<form action="AssTeacherLogin.jsp" method="post" class="form_post">
							<div id="lo-form">
				
			    			<div class="form-group">
			    			<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input class="form-control input-lg" id="registid" name="username" placeholder="账号" type="text">
							</div>
			    
			  				</div>
			  				<div class="form-group">
			   				<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input id="password" name="password" class="form-control input-lg" placeholder="密码" type="password">
							</div>
			  				</div>
			 
							  <!-- <div class="checkbox">
							    <label>
							      <input type="checkbox"> 记住我
							    </label>
							    <label class="pull-right">
							      <a id="find">忘记密码？点击我</a> 
							    </label>
							  </div> -->
							 <button class="btn btn-lg btn-danger btn-block" type="submit">Sign in</button>
							  
							</div>
						</form>
					</div>
				</div>
				
			</div><!-- wrap_content -->
				
			</div>
			
		</div>
		
	</div>
</section>
<footer class="footer navbar-fixed-bottom">
<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">

				<p>Copyright © 2017  ©陈旭</p>
			</div>
		</div>
	</div>	
</footer>
</body>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</html>