<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- index.html -->
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="keywords" content="在线抓取网页，仿八爪鱼">
<meta name="description" content="在线抓取网页，可以用js进行编程抓取">
<title>在线抓取网页，仿八爪鱼</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>

<body>
	<div class="row">
		<div class="col-lg-6">
			<div class="card border border-secondary">
				<div class="card-body">
				
						<div class="form-group row mb-0" >
						
							<div class="col-lg-12">
								<div class="input-group mb-3">
									<input type="text" class="form-control" name="url" id="urlInput"
										placeholder="输入要打开的网址"
									>
									<div class="input-group-append">
									<button type="button" id="openBtn" class="btn btn-success">打开</button>
									</div>
								</div>
							</div>
						</div>
				
				</div>
			</div>

			<iframe style="height: 1500px; width: 100%" class="border border-primary" id="window"
				></iframe>
		</div>
		<div class="col-lg-6"></div>
	</div>
</body>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="bundle.js"></script>
</html>

<script>
$("#openBtn").click(function(){
	$("#window").attr("src","/?url="+$("#urlInput").val());
});
</script>

<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "https://hm.baidu.com/hm.js?ab308ed79006a4303286418b887516ff";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>
