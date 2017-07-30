<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp" %>
<%@include file="/commons/css.jsp" %>
<%@include file="/commons/script.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Jiangzr's Blog</title>
  <style type="text/css">
    	body{margin: 0;padding: 0; padding-bottom: 70px;}
    	.left{float: left;width: 60%;}
    	.right{float: right;width: 20%;}
   </style>
  </head>
  <body>
   <div class="container" >
  	<script type="text/javascript">
  		//init page
  		$(".left").ready(function(){
  			$(".left").css("margin-left","5%");
  		})
  		$(".right").ready(function(){
  			$(".right").css("margin-right","10%");
  			$(".right").css("margin-top","150px");
  		})
  		
  		$(document).ready(function(){
    			var mydropdown = new customerDropDown($("#yeardropdown"))
    	});

  		//date format
		Date.prototype.format =function(format)
			{
				var o = {
				"M+" : this.getMonth()+1, //month
				"d+" : this.getDate(), //day
				"h+" : this.getHours(), //hour
				"m+" : this.getMinutes(), //minute
				"s+" : this.getSeconds(), //second
				"q+" : Math.floor((this.getMonth()+3)/3), //quarter
				"S" : this.getMilliseconds() //millisecond
				}
				if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
				(this.getFullYear()+"").substr(4- RegExp.$1.length));
				for(var k in o)if(new RegExp("("+ k +")").test(format))
				format = format.replace(RegExp.$1,
				RegExp.$1.length==1? o[k] :
				("00"+ o[k]).substr((""+ o[k]).length));
				return format;
			}
  		
		function ChangeDateFormat(time) {
				    if (time != null) {
				        var date = new Date(time);
				    	var formaDate = date.format('yyyy-MM-dd');
				    	return formaDate;
				    }
				}

  //callback when page_id clicked
    function func1(page_id,tagValue) {
    	var tagValues = new Array();
	  	if(tagValue === undefined){
	  		var choicetag = getChoiceTags()
	  		//alert('dafjklajfkla'+choicetag)
	  		if(!!choicetag&& choicetag.length ==0){
	  			//alert('9999')
	  			var tagValue = 8888
		  		tagValues.push(tagValue);
	  		}
	  		else{
	  			//alert('10000000')
		  		tagValues = getChoiceTags()
		  		//alert('100000tagValues'+tagValues)
	  		}
	  	}else{
	  		//alert('10000000')
	  		tagValues = getChoiceTags()
	  		//alert('100000tagValues'+tagValues)
	  	}
        var year =$("#placeholder").text()
        var url = "${ctx}/blog/bloglist/"+page_id+"/"+year
        $.ajax({  
            type: "POST",  
            url: url,
            data:{"tags":tagValues},
            dataType:"json",  
            success:function(data) {  
            	//alert('cccccccccccccccc')
            	$('#item_id').html('');
            	$('#blogsNum').html('');
            	//重写blog文本
                for(var i = 0;i<data[0].length;i++)
                {	
		            var date = ChangeDateFormat(data[0][i].postDate)
		            var tagDiv = getDivTags(data[0][i]);
		            var strContent = data[0][i].postContent
		           // alert('strContent'+strContent)
                  $('#item_id').append('<h2>'+data[0][i].postTitle+'</h2><h2><small>'+date+
                		  '<strong style="color:red">蒋泽瑞</strong></small></h2>'+
                		  tagDiv+
                		  '<p style="width:98%; height:80px; overflow: hidden;text-overflow: ellipsis;word-wrap: break-word;display: block; ">'+data[0][i].postContent+'</p>'+
                		  '<button type="button" class="btn btn-primary" style="margin-left:80%" data-toggle="modal" data-target=".blogcontent'+data[0][i].postId+'">详细内容</button>'+
                		  '<div class="modal fade blogcontent'+data[0][i].postId+'" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">'+
                		  '<div class="modal-dialog modal-lg">'+
                		  '<div class="modal-content">'+
                		  '<div class="modal-header">'+
                		  '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>'+
                		  '<h4 class="modal-title">'+data[0][i].postTitle+'</h4></div>'+
                		  '<div class="modal-body">'+data[0][i].postContent+'</div>'+
                		  '<div class="modal-footer">'+
                		  //'<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>'+
                		  //'<button type="button" class="btn btn-primary" >评论</button></div></div></div></div>'
                		  '<button type="button" class="btn btn-primary"  onclick="getComments('+data[0][i].postId+')" data-toggle="collapse" '+
                		  'data-target="#jzrcomments'+data[0][i].postId+'" aria-expanded="false" aria-controls="collapseExample">评论</button>'+
                		  '<div class="collapse" id="jzrcomments'+data[0][i].postId+'"></div><button type="button" class="btn btn-primary" data-toggle'+
                		  '="collapse" data-target="#comt'+data[0][i].postId+'" aria-expanded="false" aria-controls="collapseExample" >我要评论</button>'+
                		  '<div class="collapse" id="comt'+data[0][i].postId+'"><textarea id="comtext'+data[0][i].postId+'" class="form-control" rows="3">'+
                		  '</textarea><button type="submit" class="btn btn-info" onclick="saveComment('+data[0][i].postId+')">Confirm Submit</button></div>'+
		        		  '<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></div></div></div></div>'
                		  );
                }
                //重写当年blog数量
                //alert(data[1])
                for(var i=0;i<data[1].length;i++){
                	$('#blogsNum').append('<li class="list-group-item">'+data[1][i].month+'月<span class="badge">'+data[1][i].num+'</span></li>');
                }
             }    
         }); 
        //当前页
        $('.pagination').paginator({current_page: page_id, page_count: 15, button_number:5, pager_click: func1 });
    }

    $(function(){
        //init paginator
        $('.pagination').paginator({current_page: 1, page_count: 15, button_number:5, pager_click: func1 });
        //optional: enable paginator tooltips
        $('[data-toggle="tooltip"]').tooltip();
    });
    
    //yearselect onclick event
    function customerDropDown(selected){
    	this.dropdown = selected;
    	this.placeholder = this.dropdown.find(".placeholder");
    	this.option = this.dropdown.find("ul.dropdown-menu>li")
    	this.value = '';
    	this.index = -1;
    	this.initEvents();
    }
    
    //通过日期找到响应的blog
    function getBlogListByDate(selectedValue){
		//code something
		//alert('goto---->'+selectedValue)
		func1(1);
    }
        
    customerDropDown.prototype={
    		initEvents:function(){
    			var obj = this;
    			obj.dropdown.on("click",function(event){
    				$(this).toggleClass("active")
    			});
    			
    			//点击下拉列表的选项
    			obj.option.on("click",function(){
    				var option = $(this);
    				obj.text = option.find("a").text();
    				obj.value = option.attr("value");
    				obj.index = option.index();
    				obj.placeholder.text(obj.text);
    				getBlogListByDate(obj.value)
    			});
    			
    		},
    			
    			getText:function(){
    				return this.text;
    			},
    			getValue:function(){
    				return this.value;
    			},
    			getIndex:function(){
    				return this.index;
    			},
    }
    
    function getBtnTagValue(value,name,style){
    	//查看是否有已选择的标签
    	var isnull = $("#"+value).text();
    	//alert('1---'+isnull)
    	if(isnull == ""){
    		$('#tagSpan').append('<span id="'+value+'" style="width:30%; display:inline-block;'+
        	    	'float:left; margin-top:5px;margin-left:2px" class="label label-'+style+
        	    	'" value='+value+'>'+name+'</span>')
        	func1(1,value);
    	}
    	
    }
    
    function getChoiceTags(){
    	var ctags = new Array();
    	$("#tagSpan").find("span").each(function(){  
    		ctags.push($(this).attr("id"))
    	    //alert('span 的 ID 或者是名字是'+$(this).attr("id")); 
    	}); 
    	return ctags;
    }
    
    function clearTags(){
    	$('#tagSpan').html('')
    }
    
    //得到tags标签 
    function getDivTags(blog){
    	var strDivTag = ""
    	for(var i=0; i<blog.tags.length; i++){
    		strDivTag +='<span style="margin-left:2px" class="label label-'+blog.tags[i].tagStyle+'">'+blog.tags[i].blogTagName +'</span>'
    	}
    	return strDivTag;
    }
    
    //得到博客评论
    function getComments(value){
    	$('#jzrcomments'+value).html('')
 		//alert()
    	//通过返回的数据来重写评论里面的内容
    	var url = "${ctx}/blog/blogcomments/"+value
    	$.ajax({  
            type: "POST",  
            url: url,
            data:{"blogid":value},
            dataType:"json",  
            success:function(data) { 
            	//alert('data----->'+data)
            	if(data ==""){
            		$('#jzrcomments'+value).append('<div class="well" style="text-align:center">兄弟～！该篇文章没消息呢，给个意见呗～</div>')
            	}else{
            		 for(var i = 0;i<data.length;i++)
                     {	
            			 var cdate = ChangeDateFormat(data[i].commentDate)
            			 $('#jzrcomments'+value).append('<div class="well"><p style="text-align:left">'+data[i].commentContent+'</p>'
            			 +'<h4>By <strong>'+data[i].commentAuthor+'<small>'+cdate+'</small></strong></h4></div>')
                     }
            	}
            	//alert($('#jzrcomments'+value))
            }
    	})
    }
    
    function saveComment(value){
    	//alert('value'+value)
    	//alert('id'+$('#comtext'+value))
    	content = $('#comtext'+value).val();
    	//alert('comment_content------->'+content)
    	var url = "${ctx}/blog/savecomment/"+value+"/"+content
    	$.ajax({  
            type: "POST",  
            url: url,
            data:{"blogid":value,"content":content},
            dataType:"json",  
            success:function(data) { 
            	alert('success')
            }
    	});
    	$('#blogcontent').modal('hide')
   	    alert('🙏🙏🙏😄😄😄😄😄')
   	     $('#comtext'+value).val('');
    }
    
 </script>
	<div class="left"">
			<h1>The Jiangzerui's Blog</h1>
			<h2 style="margin-left:360px"><small><em>All in plain</em></small></h2>
				<div class="item" id="item_id">
					<c:forEach items ="${blogs}" var="blog"  >
						<h2>${blog.postTitle}</h2>
						<h2><small>${blog.postDate } By<strong style="color:red">蒋泽瑞</strong></small></h2>
							<!-- blogTag -->
								<c:forEach items = "${blog.tags}" var="tag">
									<span class="label label-${tag.tagStyle }">${tag.blogTagName}</span>
								</c:forEach>
						<p style="width:98%; height:80px; overflow: hidden;text-overflow: ellipsis;word-wrap: break-word;display: block;">${blog.postContent}</p>
						<!-- Large modal -->
						<button type="button" class="btn btn-primary" style="margin-left:80%" data-toggle="modal" data-target=".blogcontent${blog.postId}">详细内容</button>
						<div class="modal fade blogcontent${blog.postId}" id="blogcontent" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
						  <div class="modal-dialog modal-lg">
						    <div class="modal-content">
						    	<div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title">${blog.postTitle}</h4>
							    </div>
							    <div class="modal-body">
							        ${blog.postContent}
							    </div>
							    <div class="modal-footer">
							        <button type="button" class="btn btn-primary"  onclick="getComments(${blog.postId})" data-toggle="collapse" data-target="#jzrcomments${blog.postId}" aria-expanded="false" aria-controls="collapseExample">
							        	评论
							        </button>
							        <div class="collapse" id="jzrcomments${blog.postId}">
  										
									</div>
							        <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#comt${blog.postId}" aria-expanded="false" aria-controls="collapseExample" >我要评论</button>
								        <div class="collapse" id="comt${blog.postId}">
	  										<textarea id="comtext${blog.postId}" class="form-control" rows="3"></textarea>
	  										<button type="submit" class="btn btn-info" onclick="saveComment(${blog.postId})">Confirm Submit</button>
										</div>
							        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							    </div> 
						    </div>
						  </div>
						</div>
					</c:forEach>
				</div>	
		<ul class="pagination" ></ul>
	</div>
		<div class="right">
			<div class="panel panel-default">
  				<div class="panel-body">
  					<div id="blogtags">
  						<c:forEach items="${tags}" var="tag">
				    		<button type="button" id="btn${tag.blogTagCode}"  onclick="getBtnTagValue(${tag.blogTagCode},'${tag.blogTagName}','${tag.tagStyle}')" value="${tag.blogTagCode}" class="btn btn-${tag.tagStyle} btn-sm">${tag.blogTagName}</button>
				  		</c:forEach>
					</div>
  				</div>
			</div>
			
			
				<div class="panel panel-info">
					<div class="panel-heading"><button type="button" class="btn btn-warning btn-xs" onclick="clearTags()">清空</button>已选择标签</div>
					<div class="panel-body" >
						<span id="tagSpan"  ></span>
					</div>
				</div>
			
			
			<!-- Single button -->
			<div id="yeardropdown" class="dropdown">
				<div class="btn-group">
				  <button type="button" id="dropdown-menu" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				  	<span class="placeholder" id="placeholder">2015</span>
				  	<span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" role="menu">
				  	<c:forEach items="${years}" var="year">
				    	<li><a href="javascript:customerDropDown(this);">${year}</a></li>
				  	</c:forEach>
				  </ul>
				</div>
			</div>
			
			<ul class="list-group">
				<div id="blogsNum">
					<c:forEach items ="${amounts}" var="count"  >
	  				  <li class="list-group-item">${count.month}月<span class="badge">${count.num}</span></li>
					</c:forEach>
				</div>
			</ul>
		</div>
		<%@include file="../portals/footer.jsp" %>
	</div>
  </body>
</html>
