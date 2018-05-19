<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加课程</title>
    <link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
    <div class="jumbotron">
    <h2>统计-统计分析</h2>
    </div>
   <div id="main" style="width: 100%;height:600px; margin: auto auto;"></div>
    </div>
   
    <script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/static/js/echarts.min.js"></script>
     <script type="text/javascript">
     // 基于准备好的dom，初始化echarts实例
     var myChart = echarts.init(document.getElementById('main'));

     // 指定图表的配置项和数据
     var option = {
         title: {
             text: '课程平均播放次数 \n信息来源zhiyou100.com',
             x: 'center'
         },
         tooltip: {},
         legend: {
             data:['平均播放次数'],
             x: 'right'
         },
         xAxis: {
        	 data: [
        	 <c:forEach items="${course }" var="cou">
            	"${cou.course_name }",
        	 </c:forEach>
        	 ]
         },
         yAxis: {
        	 name: '平均播放次数'
         },
         series: [{
        	 name: '平均播放次数',
             barWidth: "50px",
             type: 'bar',
             data: [
            	 <c:forEach items="${times }" var="time">
                 "${time }",
             	 </c:forEach>  
             ],
             itemStyle:{
            	 normal:{
            		 color:'#89c7ff'
            	 }
             }
         }]
     };

     // 使用刚指定的配置项和数据显示图表。
     myChart.setOption(option);
    </script>
  </body>
</html>
