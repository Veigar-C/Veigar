<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <title>Full Layout - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="EasyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="EasyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="EasyUI/demo/demo.css">
    <script type="text/javascript" src="EasyUI/jquery.min.js"></script>
    <script type="text/javascript" src="EasyUI/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="EasyUI/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/driver_form.js"></script>
</head>

<body class="easyui-layout">
<div class="easyui-panel" title="New Topic" style="width:100%;height:100%;">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" method="post" action="">
            <table cellpadding="5">
                <tr>
                    <td>账号:</td>
                    <td><input class="easyui-textbox" type="text" id="user" data-options="required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input class="easyui-textbox" type="text" id="pw_admin" data-options="required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>重复密码:</td>
                    <td><input class="easyui-textbox" type="text" id="pw_admin_check" data-options="required:true"/>
                    </td>
                </tr>
            </table>
        </form>
        <div style="padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="register()">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
        </div>

    </div>
</div>
<script>

</script>

</body>

</html>
