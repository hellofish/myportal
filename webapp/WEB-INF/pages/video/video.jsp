<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%String BasePath=request.getContextPath(); %>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
  <link href="<%=BasePath %>/css/video.css" rel="stylesheet">
  <%@include file="/commons/css.jsp" %>
  <script src="<%=BasePath %>/scripts/video/prefixfree.min.js"></script>
  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Video Show</title>
    <style type="text/css">
		html{background-color:#E3E3E3; font-size:14px; color:#000; font-family:'微软雅黑'}
	</style>
  </head>
  <body>
  <script type="text/javascript">
  
  	function playvideo(){
  		alert('haha')
  	}
  
  </script>
  	<div class="container">
     <div class="videocontainer">
		<div id="carousel">
			<figure><img src="${ctx }/image/aqi.mov" alt="" onclick="playvideo()" id="1"></figure>
			<figure><img src="${ctx }/image/video/2.jpg" alt=""></figure>
			<figure><img src="${ctx }/image/video/3.jpg" alt=""></figure>
			<figure><img src="${ctx }/image/video/4.jpg" alt=""></figure>
			<figure><img src="${ctx }/image/video/5.jpg" alt=""></figure>
			<figure><img src="${ctx }/image/video/6.jpg" alt=""></figure>
			<figure><img src="${ctx }/image/video/7.jpg" alt=""></figure>
			<figure><img src="${ctx }/image/video/8.jpg" alt=""></figure>
		</div>
	</div>
	
	<div id="pvideo" style="">
		<video id="media" width="720" height="400" controls> 
   				 <source src="${ctx }/image/11.m4v">
    			
  		</video>
	</div>
	<%@include file="../portals/footer.jsp" %>
   </div>
  </body>
</html>
