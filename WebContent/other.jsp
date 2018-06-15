<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
	<input type="text" name="idvar">
	<input type="text" name="idvar">
	<a id="kakao-login-btn"></a>
	<a href="http://developers.kakao.com/logout"></a>
	<script type='text/javascript'>
		Kakao.init('8454f9464245b95555196d52f384cad9');

		Kakao.Auth.createLoginButton({
			container : '#kakao-login-btn',
			success : function(authObj) {
				Kakao.API.request({
					url:'/v2/user/me',
					success : function(res) {
						alert(JSON.stringify(res));
						alert(JSON.stringify(authObj));
						console.log(res.id);
						console.log(res.kakao_account.email);
						console.log(res.properties['nickname']);
					}
				})
			},
			fail : function(err) {
				alert(JSON.stringify(err));
			}
		});
	</script>
</body>
</html>