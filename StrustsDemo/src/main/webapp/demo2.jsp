<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>ValueStack的使用细节</title>
</head>
<body>
<s:debug/>

<s:property value="name"></s:property>
<hr/>
<%--使用s:property标签不写任何属性时，获取的是栈顶对象--%>
<s:property/>
</body>
</html>
