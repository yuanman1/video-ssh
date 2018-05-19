<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>编辑主讲人</title>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
    <div class="jumbotron">
    <h2>主讲人管理-编辑主讲人</h2>
    </div>
    <form class="form-horizontal" action="${pageContext.request.contextPath }/admin/speaker_updatespeaker1.action" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">名字</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="speaker_name" value="${speaker.speaker_name }" placeholder="主讲人姓名">
    </div>
  </div>
  
  
  
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">职业</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="speaker_job" value="${speaker.speaker_job }" placeholder="主讲人职业">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">头像图片</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="speaker_head_url" value="${speaker.speaker_head_url }" placeholder="主讲人头像地址，网络图片">
    </div>
  </div>
  
   <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
<textarea class="form-control" rows="3" name="speaker_descr">${speaker.speaker_descr }</textarea> 
    </div>
  </div>
  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="hidden" name="id" value="${speaker.id }">
   <button type="submit" class="btn btn-primary">保存</button>
   <a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>
  </form>
    </div>
   
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
  </body>
</html>
