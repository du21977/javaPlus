<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>OGNL表达式的细节</title>
</head>
<body>
<s:debug/>

<!--从请求域中获取数据：使用EL表达式-->
EL表达式：${name} <%-- 它是4大域搜索，由小到大逐个搜索，它使用的是pageContext的findAttribute方法--%>
<hr/>
<!--从值栈中获取数据：使用OGNL表达式-->
OGNL表达式：<s:property value="name"/>
</body>
</html>
