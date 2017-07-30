<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%String BasePath=request.getContextPath(); %>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Xiaoshu Show</title>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<%=BasePath %>/css/xiaoshumonth.css" rel="stylesheet">
        <link href="<%=BasePath %>/css/xiaoshucollection.css" rel="stylesheet">
        <script src="<%=BasePath%>/scripts/jquery-1.11.1.js"></script>
        <script src="<%=BasePath%>/scripts/layer/layer.min.js"></script>
        <script src="<%=BasePath%>/scripts/layer/extend/layer.ext.js"></script>
  		
  
    <style type="text/css">
		html{background-color:#E3E3E3; font-size:14px; color:#000; font-family:'微软雅黑'}
		a,a:hover{ text-decoration:none;}
		pre{font-family:'微软雅黑'}
		.box{padding:20px; background-color:#fff; margin:20px 100px; border-radius:5px;}
		.box a{padding-right:15px;}
		#about_hide{display:none}
		.layer_text{background-color:#fff; padding:20px;}
		.layer_text p{margin-bottom: 10px; text-indent: 2em; line-height: 23px;}
		.button{display:inline-block; *display:inline; *zoom:1; line-height:30px; padding:0 20px; background-color:#56B4DC; color:#fff; font-size:14px; border-radius:3px; cursor:pointer; font-weight:normal;}
		.imgs img{width:300px;padding:0 20px 20px;}
    </style>
    
    </head>
    <body>
        <div class="container">
        <script type="text/javascript">
        
        
        ;!function(){
        	layer.use('extend/layer.ext.js', function(){
        	    //初始加载即调用，所以需放在ext回调里
        	    layer.ext = function(){
        	        layer.photosPage({
        	            title: '',
        	            id: 100, //相册id，可选
        	            parent:'#showimgs'
        	        });
        	    };
        	});
        	}();
        
        //init page
  		$(".codrops-demos").ready(function(){
  			$("#mlist").append('<a id="m2" class="current-demo" onclick="getmonth(2)">2 month</a>'+
  					'<a id="m3" onclick="getmonth(3)">3 month</a>'+
  					'<a id="m4" onclick="getmonth(4)">4 month</a>'+
  					'<a id="m5" onclick="getmonth(5)">5 month</a>'+
  					'<a id="m6" onclick="getmonth(6)">6 month</a>'+
  					'<a id="m7" onclick="getmonth(7)">7 month</a>'+
  					'<a id="m8" onclick="getmonth(8)">8 month</a>'+
  					'<a id="m9" onclick="getmonth(9)">9 month</a>'+
  					'<a id="m10" onclick="getmonth(10)">10 month</a>'+
  					'<a id="m11" onclick="getmonth(11)">11 month</a>'+
  					'<a id="m12" onclick="getmonth(12)">12 month</a>')
  		});
        
        
        
        function getmonth(mon){
        	$('a').removeClass("current-demo");
        	$('#m'+mon).addClass("current-demo");
        	$('#pShow').css("display","")
        	$('#photoplay').css("display","none")
        	var year = $('#year').text();
        	$('#nowMon').text(mon);
        	var url = "${ctx}/xiaoshu/collections/"+year+"/"+mon
        	$.ajax({  
                type: "POST",  
                url: url,
       			data:{"year":year,"mon":mon},
                dataType:"json",  
                success:function(data) { 
                for(var i = 0;i<data.length;i++){
                	var j = i + 1;
                 $(".cr-bgimg div span:nth-child("+j+")").css("background-image","url("+data[i].path+")");
                }
               
                }
        	});
       }
        
        function getMorePhoto(){
        	$('#showimgs').html('')
        	var year = $('#year').text();
        	var mon =$('#nowMon').text()
        	var url = "${ctx}/xiaoshu/cdetail/"+year+"/"+mon
        	$.ajax({  
                type: "POST",  
                url: url,
       			data:{"year":year,"mon":mon},
                dataType:"json",  
                success:function(data) { 
                	$('#pShow').css("display","none")
                	$('#photoplay').css("display","")
                	for(var i = 0;i<data.length;i++){
	                	$('#showimgs').append(
	                		'<img src="'+data[i].path+'" >'		
	                	)
                	}
            	    //初始加载即调用，所以需放在ext回调里
            	        layer.photosPage({
            	            title: '',
            	            id: 100, //相册id，可选
            	            parent:'#showimgs'
            	        });
                }
        	});
        }
       
        
        </script>
			<header>
				<h1>小数数的成长轨迹 <span id="year">2015</span></h1><span id="nowMon" hidden="ture">2</span>
				<p class="codrops-demos"  id="mlist">
				
				</p>
			</header>
			<div class="box" id="photoplay" style="display:none" >
    				<div id="showimgs" class="imgs" >
    				<!--  
        				<img src="../image/shushu/2015/2/detail/2-1.jpg" >
        				<img src="../image/shushu/2015/2/detail/2-2.jpg" >
        				<img src="../image/shushu/2015/2/detail/2-3.jpg" >
        				<img src="../image/shushu/2015/2/detail/2-4.jpg" >
        			-->
    				</div>
			</div>
			<span id="pShow" >
			<section class="cr-container" id="container">	
					
				<input id="select-img-1" name="radio-set-1" type="radio" class="cr-selector-img-1" checked/>
				<label for="select-img-1" class="cr-label-img-1">1</label>
				
				<input id="select-img-2" name="radio-set-1" type="radio" class="cr-selector-img-2" />
				<label for="select-img-2" class="cr-label-img-2">2</label>
				
				<input id="select-img-3" name="radio-set-1" type="radio" class="cr-selector-img-3" />
				<label for="select-img-3" class="cr-label-img-3">3</label>
				
				<input id="select-img-4" name="radio-set-1" type="radio" class="cr-selector-img-4" />
				<label for="select-img-4" class="cr-label-img-4">4</label>
				
				
				<div class="cr-bgimg" id="photoImg">
						<!-- 定义photo内容 -->
					<div>
						<span>Slice 1 - Image 1</span>
						<span>Slice 1 - Image 2</span>
						<span>Slice 1 - Image 3</span>
						<span>Slice 1 - Image 4</span>
					</div>
					<div>
						<span>Slice 2 - Image 1</span>
						<span>Slice 2 - Image 2</span>
						<span>Slice 2 - Image 3</span>
						<span>Slice 2 - Image 4</span>
					</div>
					<div>
						<span>Slice 3 - Image 1</span>
						<span>Slice 3 - Image 2</span>
						<span>Slice 3 - Image 3</span>
						<span>Slice 3 - Image 4</span>
					</div>
					<div>
						<span>Slice 4 - Image 1</span>
						<span>Slice 4 - Image 2</span>
						<span>Slice 4 - Image 3</span>
						<span>Slice 4 - Image 4</span>
					</div>	
				</div>
			    
				<div class="cr-titles">
					<a href="javascript:void(0)" onclick="getMorePhoto()">
						<h3><span>I</span><span>more photos</span></h3>
						<h3><span>LOVE</span><span>more photos</span></h3>
						<h3><span>MY</span><span>more photos</span></h3>
						<h3><span>SHUSHU</span><span>more photos</span></h3>
					</a>
				</div>
			</section>
			</span>
			
				

        </div>
    </body>
</html>