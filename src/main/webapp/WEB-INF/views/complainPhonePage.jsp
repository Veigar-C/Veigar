<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@declare id="questel"--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="css/jquery.mobile.min.css">
    <script src="js/jquery-1.6.4.min.js"></script>
    <script src="js/jquery.mobile.min.js"></script>
    <script src="js/cR_PhonePage.js"></script>
</head>
<body>
<div data-role="page" id="pageone">
    <div data-role="header">
        <h1>申诉</h1>
    </div>

    <div data-role="content">
        <form method="post" action="">
            <div data-role="fieldcontain">
                <label for="code">单号：</label>
                <input type="text" value="${requestScope.code}" id="code" readonly="readonly">
                <label for="phone">手机号码：</label>
                <input type="text" id="phone"><br>
                <label for="content">申诉内容:</label>
                <textarea id="content"></textarea>
            </div>
            <input type="submit" value="提交" data-theme="b" onclick="return complain()" />
        </form>
    </div>

    <div data-role="footer">
        <div data-role="footer">
            <h1>请按指定内容输入信息</h1>
        </div>
    </div>
</div>
</body>

</html>
