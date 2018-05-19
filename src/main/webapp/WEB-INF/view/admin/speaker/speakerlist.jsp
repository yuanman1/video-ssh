<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="lyb" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主讲人管理</title>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
    <div class="jumbotron">
    <h2>主讲人列表-主讲人管理</h2>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath }/admin/speaker_addspeaker.action">添加主讲人</a>
  <form class="form-inline" style="float: right;" action="${pageContext.request.contextPath }/admin1/speaker/speakerList.action" method="post">
  <div class="form-group">
    <label for="exampleInputName2">名称</label>
    <input type="text" class="form-control" id="exampleInputName2" name="speaker_name" value="${speaker_name==null?'':speaker_name}" placeholder="主讲人名称">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">职位</label>
    <input type="text" class="form-control" id="exampleInputEmail2" name="speaker_job" value="${speaker_job==null?'':speaker_job}" placeholder="主讲人职位">
  </div>
  <button type="submit" class="btn btn-primary">查询</button>
</form>
	 <table class="table table-hover">
      <thead>
        <tr>
          <th>序号</th>
          <th>名称</th>
          <th>职位</th>
          <th>简介</th>
              <th>编辑</th>
              <th>删除</th>
        </tr>
      </thead>
      <tbody>
       <c:forEach items="${page.rows }" var="speaker" varStatus="status">
        <tr>
          <th scope="row">${status.count }</th>
          <td>${speaker.speaker_name }</td>
          <td>${speaker.speaker_job }</td>
          <td>${speaker.speaker_descr }</td>
          <td><a href="${pageContext.request.contextPath }/admin/speaker_updatespeaker.action?id1=${speaker.id}" class="glyphicon glyphicon-edit"></a></td>
          <td><a onclick="deleteFun(${speaker.id})" class="glyphicon glyphicon-trash"></a></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
     <lyb:page url="${pageContext.request.contextPath }/admin1/speaker/speakerList.action"/>
    </div>
   
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    function deleteFun(id){
		if(confirm("你确定要删除吗？")){
			location.href="${pageContext.request.contextPath }/admin/speaker_deletespeaker.action?id1="+id;
		}
	}
    </script>
  </body>
</html>
