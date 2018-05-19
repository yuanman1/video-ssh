<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>编辑课程</title>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
    <div class="jumbotron">
    <h2>课程管理-编辑课程</h2>
    </div>
    <form class="form-horizontal" action="${pageContext.request.contextPath }/admin/course_updatecourse1.action" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="course_name" value="${course.course_name }" placeholder="课程标题">
    </div>
  </div>
  
  
  
 <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">学科</label>
    <div class="col-sm-10">
<select class="form-control" name="subject_id">
	<option>请选择学科</option>
	<c:forEach items="${list1 }" var="subject">
  <option value="${subject.id }" ${subject.id==course.subject.id?'selected':'' }>${subject.subject_name }</option>
   </c:forEach>
</select>
    </div>
  </div>
  
  
   <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
<textarea class="form-control" rows="3" name="course_descr">${course.course_descr }</textarea> 
    </div>
  </div>
  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="hidden" name="id" value="${course.id }">
   <button type="submit" class="btn btn-primary">保存</button>
   <a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>
  </form>
    </div>
   
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
  </body>
</html>
