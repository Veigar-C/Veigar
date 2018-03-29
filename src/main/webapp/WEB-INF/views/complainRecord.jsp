<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Full Layout - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="EasyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="EasyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="EasyUI/demo/demo.css">
    <script type="text/javascript" src="EasyUI/jquery.min.js"></script>
    <script type="text/javascript" src="EasyUI/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/cR_table.js"></script>
</head>

<body class="easyui-layout">
<div data-options="region:'center',title:'驾驶证信息'">
    <table id="list_data" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th field="id" width="100" data-options="hidden:'true'">id</th>
            <th field="code" width="100">违章单号</th>
            <th field="phone" width="100">手机号</th>
            <th field="cDate" width="200">申诉时间</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>