<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

</style>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
$(document).ready(function() {
	$("#Input").click(function(){
		$(location).attr("href","input.do");
	})
	$("#Output").click(function(){
		$(location).attr("href","output.do");
	})
})
</script>
</head>
<body>
	<table border=1 align=center>
		<tr>
			<th colspan=2>Person Project
		</tr>
		<tr>
			<td><button id="Input">toInput</button>
			<td><button id="Output">toOutput</button>
		</tr>
	</table>
</body>
</html>