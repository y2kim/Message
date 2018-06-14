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
	$("#other").click(function(){
		$(location).attr("href","other.do");
	})
})
</script>
</head>
<body>
	<table border=1 align=center>
		<tr>
			<th colspan=3>Person Project
		</tr>
		<tr>
			<td><button id="Input">toInput</button>
			<td><button id="Output">toOutput</button>
			<td><button id="other">other</button>
		</tr>
	</table>
</body>
</html>