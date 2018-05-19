<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib prefix="lyb" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>视频管理</title>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
    <div class="jumbotron">
    <h2>视频列表-视频管理</h2>
    </div>
    <a class="btn btn-primary" href="${pageContext.request.contextPath }/admin/video_addvideo.action">添加视频</a>
   <a class="btn btn-primary" onclick="deleteall()">批量删除 <span class="badge">0</span></a>
  <form class="form-inline" style="float: right;" action="${pageContext.request.contextPath }/admin1/video/videoList.action" method="post">
	  <div class="form-group">
	    <label class="sr-only" for="exampleInputEmail3">Email address</label>
	    <input type="text" class="form-control" id="exampleInputEmail3" name="video_title" placeholder="视频标题">
	  </div>
	 <select class="form-control" name="speaker_name">
	 	 <option value="">请选择主讲人</option>
	 	 <c:forEach items="${speaker }" var="sp">
  <option value="${sp.speaker_name }">${sp.speaker_name }</option>
         </c:forEach>
     </select>
	    <select class="form-control" name="course_name">
	    	 <option value="">请选择课程</option>
   <c:forEach items="${course }" var="co">
  <option value="${co.course_name }">${co.course_name }</option>
         </c:forEach>
       </select>
	  
  <button type="submit" class="btn btn-default" style="background-color: #337AB7;color: white;" name="chaxun" value="查询">查询</button>

</form>
	 <table class="table table-hover">
      <thead>
        <tr>
        	<th>    
        		<div class="checkbox">
  <label>
    <input type="checkbox" id="biaoti" value="option1" name="all" click="all()" aria-label="...">
  </label>
          </div>
        	</th>
          <th>序号</th>
          <th>名称</th>
          <th>介绍</th>
          <th>讲师</th>
           <th>课程</th>
            <th>时长(秒)</th>
             <th>播放次数</th>
              <th>编辑</th>
              <th>删除</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${page.rows }" var="video" varStatus="status">
        <tr>
        	<td>
          	<div class="checkbox">
  <label>
    <input type="checkbox" id="blankCheckbox" value="${video.id}" class="other" name="deleteid" onclick="other()" aria-label="...">
  </label>
          </div>	
          </td>
          <th scope="row">${status.count }</th>
          <td>${video.video_title }</td>
          <td>${video.video_descr }</td>
          <td>${video.speakers.speaker_name }</td>
          <td>${video.courses.course_name }</td>
          <td>${video.video_length }</td>
          <td>${video.video_play_times }</td>
          <td><a href="${pageContext.request.contextPath }/admin/video_updatevideo.action?id1=${video.id}" class="glyphicon glyphicon-edit"></a></td>
          <td><a onclick="deleteFun(${video.id})" class="glyphicon glyphicon-trash"></a></td>
        </tr>
       </c:forEach>
      </tbody>
    </table>
    
     <lyb:page url="${pageContext.request.contextPath }/admin1/video/videoList.action"/>
    </div> 
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/jquery-confirm.min.js"></script>
    <script type="text/javascript">
	$("#biaoti").click(function all(){
		$("input[type='checkbox']").prop("checked",$("#biaoti").prop("checked"));
		if($("#biaoti").prop("checked")){
			 $(".badge").text($(".other").size());
		}else{
			 $(".badge").text("0");
		}
	});
	 function other(){
		 var num=0;
		$(".other").each(function (a,b){
		 	if($(b).prop("checked")){  
				num++;
			} 
		});
		$("#biaoti").prop("checked",num==$(".other").size());
		 $(".badge").text(num);
	  };
	function deleteall(){
		var d="";
		$(".other").each(function (a,b){
		 	if($(b).prop("checked")){  
		 		var c=$(b).prop("value")
		 		d+="id2="+c+"&";
			} 
	});
		var f=d.substring(0,d.length-1);
		if (confirm("确定要删除所选内容吗？")) {
			alert(f);
			location="${pageContext.request.contextPath }/admin/video_deleteallvideo.action?"+f;
		}
	};
	function deleteFun(id){
		if(confirm("你确定要删除吗？")){
			location.href="${pageContext.request.contextPath }/admin/video_deletevideo.action?id1="+id;
		}
	}
</script>
  </body>
</html>
