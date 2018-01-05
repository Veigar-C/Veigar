<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <td>姓名:<input type="hidden" name="id"></td>
                    <td><input class="easyui-textbox" type="text" id="name" data-options="required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>地址:</td>
                    <td><input class="easyui-textbox" type="text" id="address" data-options="required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td>
                        <select class="easyui-combobox" id="sex" style="width: 50px">
                            <option value="男" selected="selected">男</option>
                            <option value="女">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>身份证号:</td>
                    <td><input class="easyui-textbox" type="text" id="idCard" data-options="required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>出生日期:</td>
                    <td>
                        <%--<input class="easyui-textbox" type="text" id="birth_Date" data-options="required:true"/>--%>
                        <input class="easyui-datebox" type="text" value="2015-1-1" name="birth_Date" data-options="sharedCalendar:'#cc'" id="birth_Date"/>
                    </td>
                </tr>
                <tr>
                    <td>发证日期:</td>
                    <td>
                        <%--<input class="easyui-textbox" type="text" id="issue_Date" data-options="required:true"/>--%>
                        <input class="easyui-datebox" value="2015-1-1" name="issue_Date" data-options="sharedCalendar:'#cc'" id="issue_Date"/>
                    </td>
                </tr>
                <tr>
                    <td>准驾类型:</td>
                    <td>
                        <select class="easyui-combobox" id="permit_Type" style="width: 50px">
                            <option value="A1">A1</option>
                            <option value="B1">B1</option>
                            <option value="C1" selected="selected">C1</option>
                            <option value="C2">C2</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>有效期限:</td>
                    <td>
                        <%--<input class="easyui-textbox" type="text" id="expiration_Date" data-options="required:true">--%>
                        <input class="easyui-datebox" value="2015-1-1" name="expiration_Date" data-options="sharedCalendar:'#cc'" id="expiration_Date">
                        </input>
                    </td>
                </tr>
                <tr>
                    <td>车牌号:</td>
                    <td><input class="easyui-textbox" type="text" id="carNum" data-options="required:true"/>
                    </td>
                </tr>
            </table>
            <div id="cc" class="easyui-calendar"></div>
        </form>
        <div style="padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
        </div>

    </div>
</div>
<script>

</script>

</body>

</html>
