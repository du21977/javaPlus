<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录页面</title>
</head>
<body>
<form action="login" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    验证码：<input type="text" name="code"/>
            <img src="${pageContext.request.contextPath}/captchaAction">
</form>
</body>
</html>
