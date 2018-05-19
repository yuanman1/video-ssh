<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>视频管理</title>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
    	<style type="text/css">
 		html {
	height: 100%;
}
body {
	height: 100%;
	margin: 0;
	min-width: 970px;
	min-height: 700px;
	display: flex;
	flex-direction: column;
}
 		iframe {
	flex-grow: 1px;
	height: 100%;
	width: 100%;
	border: none;
}
 		.pag {
	flex-grow: 1;
	display: flex;
	flex-direction: column;
}
.footer1{
       text-align: center;
      margin-bottom: 15px;
      font-size: 20px;
      
     }
    	</style>
  </head>
  <body>
    <div class="container">
     <nav class="navbar navbar-inverse" style="margin-left: -390px;margin-right: -390px;margin-bottom: 0px;">
      <div class="container-fluid" style="padding-left: 390px;">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">视频管理系统</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
          <ul class="nav navbar-nav">
            <li class="menu-title active"><a target="pageBox" href="${pageContext.request.contextPath }/admin1/videoList/videoList.action">视频管理</a></li>
            <li class="menu-title"><a target="pageBox" href="${pageContext.request.contextPath }/admin1/speakerList/speakerList.action">主讲人管理</a></li>
            <li class="menu-title"><a target="pageBox" href="${pageContext.request.contextPath }/admin1/courseList/courseList.action">课程管理</a></li>
            <li class="menu-title"><a target="pageBox" href="${pageContext.request.contextPath }/admin1/statisticsList/statisticsList.action">统计分析</a></li>
             <li><a href="#" style="padding-left: 590px;">admin</a></li>
              <li><a href="${pageContext.request.contextPath }/admin/user_logout.action" class="glyphicon glyphicon-log-in" style="padding-left: 0px;"></a></li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    </div>
     <div class="pag">
	    		<iframe name="pageBox" src="${pageContext.request.contextPath }/admin1/video/videoList.action"></iframe>
		    <div class="footer1">
		    	智游教育 ©2017 河南智游臻龙教育科技有限公司
		    </div>
	    </div>    
   
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
    <script type="text/javascript">
		$('.menu-title').click(function(){
			$('.menu-title').removeClass('active');
			$(this).addClass('active');
		});
		</script>
  </body>
</html>
