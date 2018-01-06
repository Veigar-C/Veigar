<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/6
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <!--<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>-->
    <title></title>
    <link href="css/login.css" rel="stylesheet">
    <script src="js/login.js"></script>
    <script src="js/jquery-1.6.4.min.js"></script>
</head>

<body>
<div class="header">
    <div class="contain">
        <div class="header_logo">
            <div class="logo_img" />
            <img src="img/logo.png" />
        </div>
        <div class="header_title">
            <p>违章管理系统</p>
            <p class="p2">Veigar</p>
        </div>
    </div>
    <div class="header_time" id="get_time">
        <p id="today">今天是:星期？</p>
    </div>
</div>
</div>
<div style="min-width: 1170px;">
    <div class="content">
        <div class="login_position" id="lg-position">
            <div class="login_content">
                <div class="login_form">
                    <form action="login" method="post">
                        <div class="div-user">
                            <i class="icon-position icon_user"></i>
                            <input type="text" name="username" id="username" placeholder="请输入用户名" class="text" />
                        </div>
                        <div class="div-password">
                            <i class="icon-position icon-password"></i>
                            <input type="password" name="password" id="password" placeholder="请输入密码" />
                        </div>
                        <div class="div-check">
                            <input type="text" id="input" placeholder="请输入验证码" />
                            <div class="checkbox">
                                <input type="button" id="code" onclick="createCode()" class="checkstyle" />
                            </div>
                        </div>
                        <div class="submit-position">
                            <input type="button" value="登录" class="submit_style" onclick="return check()"/>
                        </div>
                        <div id="message"></div>
                    </form>
                </div>
            </div>
            <span class="shadow" id="shadows"></span>
        </div>
    </div>
</div>
<div class="footer contain">
    <p>2017 © 政企客户企业画像 by Veigar.</p>
</div>
</body>

</html>
