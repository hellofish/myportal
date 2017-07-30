<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>test page</title>
    <!-- Bootstrap -->
    <%String cssBasePath=request.getContextPath(); %>
	<link href="<%=cssBasePath %>/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript">
	$('#myPopover').on('hidden.bs.popover', function () {
		  // do something…
		  alert()
		})
	</script>
  </head>
  <body>
    <h1>你好，世界！</h1>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="<%=cssBasePath %>/scripts/bootstrap.min.js"></script>
    

    <a href="#" tabindex="0" class="btn btn-lg btn-danger bs-docs-popover" role="button" data-toggle="popover" data-trigger="focus" title="Dismissible popover" data-content="And here's some amazing content. It's very engaging. Right?">Dismissible popover</a>
	<button name="mybutton" onclick="alert()"> click me</button>
	
	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <div class="input-group input-group">
  			<span class="input-group-addon">您的姓名</span>
  				<input type="text" class="form-control" placeholder="Username">
		</div>
		
		<div class="input-group">
  			<span class="input-group-addon">您的邮箱</span>
  				<input type="text" class="form-control" placeholder="Username">
  				<span class="input-group-addon">@</span><input type="text" class="form-control">
		</div>
		
		<div class="input-group">
  			<span class="input-group-addon">您的邀请码</span>
  				<input type="text" class="form-control" placeholder="Username">
		</div>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
    
  </body>
</html>