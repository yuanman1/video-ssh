<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>后台登录页面</title>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
    	<style type="text/css">
    		body{
    			margin: 0;
    		}
    		.denglu{
    			height: 400px;
    			width: 310px;
    		    margin: 300px auto;
    		}
    		button{
    			width: 253.333px;
    			float: left;
    		}
    	</style>
  </head>
  <body>
    <div class="container-fluid">
    	<div class="denglu">
    		 <img src="${pageContext.request.contextPath }/static/img/logo.png" alt="智游">
   <form class="form-horizontal" action="${pageContext.request.contextPath }/admin/user_login1.action" method="post">
  <div class="form-group">
    <div class="col-sm-offset-1 col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="login_name" placeholder="用户名">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-1 col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" name="login_pwd" placeholder="密码">
       <p style="color: red; font-size: 15px;">${errorMessage }</p>
    </div>
  </div>
   <div class="form-group">
    <div class="col-sm-offset-1 col-sm-10">
      <button type="submit" class="btn btn-success">登录</button>
    </div>
    </div>
</form>
</div>
    </div>
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
  </body>
</html>
