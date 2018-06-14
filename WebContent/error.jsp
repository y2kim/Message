<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
에러발생!
	3초후 원래 페이지로 돌아갑니다.
	<script>
		setTimeout(function() {
			location.href="index.jsp";
		}, 3000);
	</script>
</body>
</html>