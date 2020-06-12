<%--
  Created by IntelliJ IDEA.
  User: tlk
  Date: 2020/5/16
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: red">nihao  欢迎你</h1>
${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }
<br/>
<br/>
${adminList}
</body>
</html>
