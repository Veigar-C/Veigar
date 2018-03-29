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
    <script type="text/javascript" src="js/vR_form.js"></script>

</head>

<body class="easyui-layout">
<div class="easyui-panel" title="New Topic" style="width:100%;height:100%;">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" method="post" action="">
            <table cellpadding="5">
                <tr>
                    <td>违章单号:</td>
                    <td><input class="easyui-textbox" type="text" id="code" data-options="required:true" value="${requestScope.violationRecord.code}"/>
                    </td>
                </tr>
                <tr>
                    <td>车牌号:<input type="hidden" name="id" id="id" value="${requestScope.violationRecord.id}"></td>
                    <td><input class="easyui-textbox" type="text" id="carNum" data-options="required:true" value="${requestScope.violationRecord.carNum}"/>
                    </td>
                </tr>
                <tr>
                    <td>违章时间:</td>
                    <td><input class="easyui-datebox" type="text" name="vDate" data-options="sharedCalendar:'#cc'" id="vDate" value="${requestScope.violationRecord.vDate}"/>
                    </td>
                </tr>
                <tr>
                    <td>违章内容:</td>
                    <td><input class="easyui-textbox" type="text" id="vContent" data-options="required:true" value="${requestScope.violationRecord.vContent}"/>
                    </td>
                </tr>
                <tr>
                    <td>状态:</td>
                    <td>
                        <select class="easyui-combobox" id="vState" style="width: 100px">
                            <c:if test="${requestScope.violationRecord.vState == '可办理' || requestScope.violationRecord.vState == null}">
                                <option value="可办理" selected="selected">可办理</option>
                                <option value="已办理">已办理</option>
                            </c:if>
                            <c:if test="${requestScope.violationRecord.vState == '已办理'}">
                                <option value="可办理">可办理</option>
                                <option value="已办理" selected="selected">已办理</option>
                            </c:if>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>扣分数:</td>
                    <td><input class="easyui-textbox" type="text" id="vPoints" data-options="required:true" value="${requestScope.violationRecord.vPoints}"/>
                    </td>
                </tr>
                <tr>
                    <td>违章地址:</td>
                    <td><input class="easyui-textbox" type="text" id="vAddress" data-options="required:true" value="${requestScope.violationRecord.vAddress}"/>
                    </td>
                </tr>
                <tr>
                    <td>罚款数:</td>
                    <td><input class="easyui-textbox" type="text" id="vMoney" data-options="required:true" value="${requestScope.violationRecord.vMoney}"/>
                    </td>
                </tr>
                <tr>
                    <td>手续费:</td>
                    <td><input class="easyui-textbox" type="text" id="vSMoney" data-options="required:true" value="${requestScope.violationRecord.vSMoney}"/>
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
