<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
</head>
<body>
	用户名<input type="text" name="userName" id="username">
	密码:<input type="text" name="passWord" id="password">
	<button id="aa">提交</button>
</body>
	<script type="text/javascript">
	  $('#aa').click(function(){
		$.ajax({
			async : false ,
			type : "get",
			url : '/HelloWorld/ajaxTest',
			data : {
				userName : $("#username").val(),
				passWord : $("#password").val()
			},
			success : function(obj) {
				console.log(obj);
				$("#msg").html('<div style="color:red">'+obj.json+'</div>');
			}
			});
	  }); 
	</script>
</html>