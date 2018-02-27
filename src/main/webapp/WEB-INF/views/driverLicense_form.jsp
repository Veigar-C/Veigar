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
    <script type="text/javascript" src="js/dL_form.js"></script>

</head>

<body class="easyui-layout">
<div class="easyui-panel" title="New Topic" style="width:100%;height:100%;">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" method="post" action="">
            <table cellpadding="5">
                <tr>
                    <td>车牌号:<input class="easyui-textbox" type="hidden" id="id"  value="${requestScope.drivingLicense.id}"/></td>
                    <td><input class="easyui-textbox" type="text" id="carNum" data-options="required:true" value="${requestScope.drivingLicense.carNum}"/>
                    </td>
                </tr>
                <tr>
                    <td>车辆种类:</td>
                    <td><input class="easyui-textbox" type="text" id="carType" data-options="required:true" value="${requestScope.drivingLicense.carType}"/>
                    </td>
                </tr>
                <tr>
                    <td>使用性质:</td>
                    <td><input class="easyui-textbox" type="text" id="carProperty" data-options="required:true" value="${requestScope.drivingLicense.carProperty}"/>
                    </td>
                </tr>
                <tr>
                    <td>品牌型号:</td>
                    <td><input class="easyui-textbox" type="text" id="carBrand" data-options="required:true" value="${requestScope.drivingLicense.carBrand}"/></td>
                </tr>
                <tr>
                    <td>车辆识别号:</td>
                    <td><input class="easyui-textbox" type="text" id="carIdentificantionCode" data-options="required:true" value="${requestScope.drivingLicense.carIdentificantionCode}"/></td>
                </tr>
                <tr>
                    <td>发动机号:</td>
                    <td><input class="easyui-textbox" type="text" id="carEngineNum" data-options="required:true" value="${requestScope.drivingLicense.carEngineNum}"/></td>
                </tr>
                <tr>
                    <td>注册日期:</td>
                    <td>
                        <%--<input class="easyui-textbox" type="text" id="issue_Date" data-options="required:true"/>--%>
                        <input class="easyui-datebox"  value="${requestScope.drivingLicense.registerDate}" name="registerDate" data-options="sharedCalendar:'#cc'" id="registerDate"/>
                    </td>
                </tr>
                <tr>
                    <td>发证日期:</td>
                    <td>
                        <%--<input class="easyui-textbox" type="text" id="expiration_Date" data-options="required:true">--%>
                        <input class="easyui-datebox"  value="${requestScope.drivingLicense.issuingDate}" name="issuingDate" data-options="sharedCalendar:'#cc'" id="issuingDate">
                        </input>
                    </td>
                </tr>
                <tr>
                    <td>核载人数:</td>
                    <td><input class="easyui-textbox" type="text" id="loadNum" data-options="required:true" value="${requestScope.drivingLicense.loadNum}"/>
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
