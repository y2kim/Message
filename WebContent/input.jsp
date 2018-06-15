<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
$(document).ready(function() {
	$("#submit").click(function() {
		 $("#insert").submit();
	});
})
</script>
</head>
<body>
		<form action="insert.do" method="post" id="insert">
			<table border="1">
				<tr>
				<td>네임</td>
				<td><input name="name" id="nam"></td>
				</tr>
				<tr>
				<td>메세지</td>
				<td><input name="message" id="msg"></td>
				</tr>
			</table>
		</form>
			<button id="submit" type="button">전송</button>
</body>
</html>