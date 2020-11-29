<%--
  Created by IntelliJ IDEA.
  User: liqing
  Date: 2020/11/20
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
<form action="selectDownloadServlet" method="post" >
    <p><font color="#ffd700" size="5"> 你是否想成为高贵的VIP：</font></p>

    <div>
        <input type="radio" name="vip" value="yes" checked>
        <label>是的,我渴望力量</label>
    </div>

    <div>
        <input type="radio" name="vip" value="not">
        <label>谢谢,我是豹子头</label>
    </div>
    <input type="submit" value="确定">
</form>

</body>
</html>
