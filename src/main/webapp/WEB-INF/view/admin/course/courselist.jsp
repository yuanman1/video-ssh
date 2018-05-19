<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>课程管理</title>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
    <div class="jumbotron">
    <h2>课程列表-课程管理</h2>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath }/admin/course_addcourse.action">添加课程</a>
	 <table class="table table-hover">
      <thead>
        <tr>
          <th>序号</th>
          <th>标题</th>
          <th>学科</th>
          <th>简介</th>
              <th>编辑</th>
              <th>删除</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${list }" var="course" varStatus="status">
        <tr>
          <th scope="row">${status.count }</th>
          <td>${course.course_name }</td>
          <td>${course.subject.subject_name }</td>
          <td>${course.course_descr }</td>
          <td><a href="${pageContext.request.contextPath }/admin/course_updatecourse.action?id1=${course.id}" class="glyphicon glyphicon-edit"></a></td>
          <td><a onclick="deleteFun(${course.id})" class="glyphicon glyphicon-trash"></a></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
    </div>
   
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
     <script type="text/javascript">
    function deleteFun(id){
		if(confirm("你确定要删除吗？")){
			location.href="${pageContext.request.contextPath }/admin/course_deletecourse.action?id1="+id;
		}
	}
    </script>
  </body>
</html>
