<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.1.js"></script>
</head>
<body>

<form action="openUrl" target="iframe1">
<input type="text" name="url" >
<button type="submit">open</button>
</form>
<iframe name="iframe1"   style="width: 100%;height: 1000px;"   ></iframe>






</body>
<script type="text/javascript">
function pageInit(content){
	$("a",content.document).mouseover(function(){
		var curren=$(this);
		var s=[];
		while(curren&&curren.length>0){
			s.push(curren);
			curren=curren.parent();
		}
		generateXpath(s);
	});
	
}

function generateXpath(s){
	var str="";
	$(s).each(function(){
		if($(this)&&$(this).length>0){
			str="/"+$(this)[0].tagName+str;
		}
	});
	console.log(str.toLowerCase());
}

</script>
</html>