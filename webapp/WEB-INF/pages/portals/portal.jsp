<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp" %>
<%@include file="/commons/css.jsp" %>
<%@include file="/commons/script.jsp" %>
<!DOCTYPE html >
<html lang="zh-cn">
    <head>
       <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no">
		   <style type="text/css">
		   		body {
  						font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
 						font-size: 16px;
  						line-height: 1.42857143;
  						color: white;
  						text-decoration:none
					}
			     a{
			     	text-decoration:none
			      }
			     a:hover{ text-decoration:none;}
		    	.tcontainer{width: 80%;margin:0 auto;}
		
		   </style>
    </head>
    <body style="background:#333333">
     <script type="text/javascript">  
     $(document).ready(function() {
    	    $('#codeform').bootstrapValidator({
    	        message: 'This value is not valid',
    	        feedbackIcons: {
    	            valid: 'glyphicon glyphicon-ok',
    	            invalid: 'glyphicon glyphicon-remove',
    	            validating: 'glyphicon glyphicon-refresh'
    	        },
    	        fields: {
    	        	jzrPhone: {
    	                validators: {
    	                    notEmpty: {
    	                        message: '您好，我的手机号你不会不知道吧'
    	                    }
    	                }
    	            },
    	            clientPhone: {
    	                validators: {
    	                    notEmpty: {
    	                        message: '您的电话不要空啊'
    	                    }
    	                }
    	            }
    	        }
    	    });
    	});
     
     
     function lMessage(){
    	 var url = "${ctx}/message/saveM";
    	 $.ajax({
    		 type:"POST",  
             url: url,
             data:$('#mform').serialize(),
             dataType:"json",  
             success:function(data) {
            	 //showAlert("您已经提交了，请勿重复提交");
				 //location.reload() 
            	 //$('#exampleModal').modal('hide')
             }
            });
    	 $('#exampleModal').modal('hide')
    	  alert('🙏🙏🙏😄😄😄😄😄')
     }
    	 
    //获得Code
    function getCode(){
    	var url = "${ctx}/code/getcode";
    	alert(url)
   	 $.ajax({  
            type: "POST",  
            url: url,
            data:$('#codeform').serialize(),
            dataType:"json",  
            success:function(data){
            	alert('')
            	$('#noteCode').html('')
            	$('#codeform').html('')
            	$('#noteCode').append('<h4 id="noteCode" class="modal-title" id="codeModalLabel" style="color:red">您的邀请码是:'+data.code+'</h4>')
            }
            
           })
    }
     	
     </script>  
    	<div class="container-fluid" >
    	    <%@include file="header.jsp" %>		
				<div class="tcontainer" style="margin-top:15px">
					<div class="row" style="margin:0 auto;">
					  <div class="col-md-6">
					  	<div id="carousel-example-generic" class="carousel slide"  data-ride="carousel">
						  <div class="carousel-inner" role="listbox">
						    <div class="item active" ">
						      <img src="${ctx }/image/1-1.jpg"  class="img-responsive " alt="...">
						      <div class="carousel-caption">
						        ...
						      </div>
						    </div>
						    <div class="item">
						      <img src="${ctx }/image/1-1.jpg " class="img-responsive" alt="...">
						      <div class="carousel-caption">
						        ...
						      </div>
						    </div>
						  </div>
						  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						    <span class="glyphicon glyphicon-chevron-left"></span>
						    <span class="sr-only">Previous</span>
						  </a>
						  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						    <span class="glyphicon glyphicon-chevron-right"></span>
						    <span class="sr-only">Next</span>
						  </a>
						</div>
					  </div>
					  <div class="col-md-6">
						<div class="row" style="margin:0 auto;">
							<div style="background:red;text-align:center;padding: 20px 20px 20px 20px">
								<a data-toggle="modal" data-target="#exampleModal" style="color:white;cursor:hand">给我留言</a>
							</div>
								<!-- message model -->
								<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  									<div class="modal-dialog">
    									<div class="modal-content">
      										<div class="modal-header">
        										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        											<h4 class="modal-title" id="exampleModalLabel" style="color:black">感谢您的关注:</h4>
      										</div>
      										<div class="modal-body">
        										<form id="mform">
        										  <div class="form-group">
										            <label for="recipient-name" class="control-label" style="color:black">您的姓名:</label>
										            <input type="text" class="form-control" name="clientName" id="clientName">
										          </div>
										          <div class="form-group">
										            <label for="recipient-name" class="control-label" style="color:black">您的电话:</label>
										            <input type="text" class="form-control" name="clientPhone" id="clientPhone">
										          </div>
										          <div class="form-group">
										            <label for="message-text" class="control-label" style="color:black">Message:</label>
										            <textarea class="form-control" name="message" id="message"></textarea>
										          </div>
										        </form>
									      </div>
									      <div class="modal-footer">
									        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									        <button type="button" class="btn btn-primary" onclick="lMessage()">Send message</button>
									      </div>
									   </div>
									</div>
							   </div>
							<div class="row" style="margin:0 auto;">
								<div class="col-md-6" style="background:#6666CC;margin:10px 0 0 0">
									<div style="text-align:center;padding: 50px 55px 55px 55px;cursor:hand">APP</div>
								</div>
								<div class="col-md-6" style="background:#009933;margin:10px 0 0 0" >
									<div id="showCodeId" style="text-align:center;padding: 50px 55px 55px 55px;"><a data-toggle="modal" data-target="#codeModal" style="color:white;cursor:hand">邀请码</a></div>
								</div>
								<!-- 邀请码 -->
								<div class="modal fade" id="codeModal" tabindex="-1" role="dialog" aria-labelledby="codeModalLabel" aria-hidden="true">
  									<div class="modal-dialog">
    									<div class="modal-content">
      										<div class="modal-header">
        										<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        											<h4 id="noteCode" class="modal-title" id="codeModalLabel" style="color:red">获得邀请码后您可访问照片、视频等需要邀请码的内容</h4>
      										</div>
      										<div class="modal-body">
        										<form id="codeform" >
        										  <div class="form-group">
										            <label for="recipient-name" class="control-label" style="color:black">我的电话</label>
										            <input type="text" class="form-control" name="jzrPhone" id="jzrPhone">
										          </div>
										          <div class="form-group">
										            <label for="recipient-name" class="control-label" style="color:black">您的电话:</label>
										            <input type="text" class="form-control" name="user.clientPhone" id="clientPhone">
										          </div>
										          <div class="form-group">
										            <label for="recipient-name" class="control-label" style="color:black">您的姓名:</label>
										            <input type="text" class="form-control" name="user.userTrueName" id="clientName">
										          </div>
										          <div class="form-group">
										            <label for="recipient-name" class="control-label" style="color:black">您的邮箱:</label>
										            <input type="text" class="form-control" name="user.eMail" id="Email">
										          </div>
										          <div class="modal-footer">
									        		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									        		<button type="button" class="btn btn-primary" name="getcode" onclick="getCode()" value="Sign up">获得邀请码</button>
									      		  </div>
										        </form>
									      </div>
									      
									   </div>
									</div>
							   </div>
							</div>
						</div>
					  </div>
					</div>
				
				<!-- second row -->
				<div class="row" style="margin:0 auto;">
					<div class="col-md-4" style="margin:10px 0 0 0" data-toggle="tooltip" data-placement="top" title="您需要获得邀请码方可浏览">
					  	<a href="${ctx}/photo/photolist" >
						  	<div style="text-align:center;background:#66CCFF;padding: 75px 75px 75px 75px;color:white">
						  	相册
						  	</div>
					  	</a>
					</div>
					<div class="col-md-5" style="margin:10px 0 0 0" data-toggle="tooltip" data-placement="top" title="您需要获得邀请码方可浏览">
					  		<a href="${ctx}/video/videocollection"><div style="text-align:center;background:#669999;padding: 75px 75px 75px 75px;color:white">视频</div></a>
					</div>
					<div class="col-md-3" style="margin:10px 0 0 0">
							<div style="text-align:center;background:#0099CC;padding: 29px 29px 29px 29px;color:white;cursor:hand">WineFun</div>
					  		<div style="text-align:center;background:#FF9933;margin:10px 0 0 0;padding:30px 30px 30px 30px;cursor:hand">分享</div>
					</div>
				</div>
				
				<!-- third row -->
				<div class="row" style="margin:0 auto;">
					<div class="col-md-4" style="margin:10px 0 0 0">
						<a href="${ctx}/blog/bloglist"><div style="text-align:center;background:#CCCCCC;padding: 30px 30px 30px 30px;color:white;cursor:hand">博客</div></a>
					</div>
					<div class="col-md-4" style="margin:10px 0 0 0">
						<a href="${ctx}/xiaoshu/collections" >
							<div style="text-align:center;background:#FF6666;padding: 30px 30px 30px 30px;color:white;cursor:hand">小宝</div>
						</a>
					</div>
					<div class="col-md-4" style="margin:10px 0 0 0">
						<div style="text-align:center;background:#666699;padding: 30px 30px 30px 30px;color:white;cursor:hand">About Me</div>
					</div>
				</div>
			</div>
			<%@include file="footer.jsp" %>
		</div>
    </body>
 
</html>