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
    <script type="text/javascript" src="js/dL_table.js"></script>
</head>

<body class="easyui-layout">
<div data-options="region:'center',title:'行驶证信息'">
    <table id="list_data" cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th field="id" width="100" data-options="hidden:'true'">id</th>
            <th field="carNum" width="100">车牌号</th>
            <th field="carType" width="100">车辆类型</th>
            <th field="carProperty" width="100">使用性质</th>
            <th field="carBrand" width="100">品牌型号</th>
            <th field="carIdentificantionCode" width="100">车辆识别号</th>
            <th field="carEngineNum" width="100">发动机号</th>
            <th field="registerDate" width="150">注册日期</th>
            <th field="issuingDate" width="150">发证日期</th>
            <th field="loadNum" width="100">核载人数</th>
        </tr>
        </thead>
    </table>
</div>

</body>


</html>