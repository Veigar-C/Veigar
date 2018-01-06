<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>违章信息查询</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/viloation.css" />
    <link rel="stylesheet" href="css/jquery.mobile.min.css" />
    <script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
    <script type="text/javascript" src="js/jquery.mobile.min.js"></script>
    <script type="text/javascript" src="js/home.js" ></script>
</head>

</html>
</head>

<body>

<div data-role="page">

    <div data-role="header"  data-theme="b">
        <!--<a href="index.php" data-role="button" data-icon="home">返回首页</a>-->
        <h1>违章信息查询</h1>
    </div>
    <!-- /头部 -->
    <div id="test"></div>
    <div data-role="content"> <!--selectDriver.do-->
        <form action="" method="post" data-ajax="false">
            <ul data-role="listview" data-inset="true">
                <li data-role="fieldcontain">
                    <fieldset data-role="fieldcontain">
                        <label for="day" style="vertical-align: 100%;">号牌种类</label>
                        <select name="carType" id="day">
                            <option value="大型汽车">大型汽车</option>
                            <option value="小型汽车">小型汽车</option>
                            <option value="外籍汽车">外籍汽车</option>
                            <option value="摩托车">摩托车</option>
                        </select>
                    </fieldset>
                </li>
                <li data-role="fieldcontain">
                    <label for="day">车牌号码（粤）</label>
                    <input type="text" name="carNum" id="cp_num"/>
                </li>
                <li data-role="fieldcontain">
                    <label for="day">发动机号（后四位）</label>
                    <input type="text" name="carEngineNum" id="fdj_num"/>
                </li>
                <li data-role="fieldcontain">
                    <label for="day">车架号（后六位）</label>
                    <input type="text" name="carFrame" id="cj_num"/>
                </li>
                <li data-role="fieldcontain">
                    <label for="day">验证码</label>
                    <input type="text" name="yzm" id="yzm"/>
                    <input type="button" id="code" onclick="createCode()" class="checkstyle" />
                </li>

                <li data-role="fieldcontain">
                    <input type="button" value="提交" data-theme="b" onclick="return check()" id="selectUser"/>
                </li>
            </ul>
        </form>
    </div>
    <!-- /内容 -->

    <div data-role="footer"  data-theme="b">
        <h4>请按行驶证上的信息输入</h4>
    </div>
    <!-- /底部 -->
</div>
<!-- /页面 -->

</body>

</html>