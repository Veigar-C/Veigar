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
	<script type="text/javascript" src="js/vR_table.js"></script>
</head>

<body class="easyui-layout">
<div data-options="region:'center',title:'驾驶证信息'">
	<table id="list_data" cellspacing="0" cellpadding="0">
		<thead>
		<tr>
			<th field="id" width="100" data-options="hidden:'true'">id</th>
			<th field="code" width="100">违章单号</th>
			<th field="carNum" width="100">车牌号</th>
			<th field="vDate" width="100">违章日期</th>
			<th field="vContent" width="100">违章内容</th>
			<th field="vState" width="100">办理状态</th>
			<th field="vPoints" width="100">扣分数</th>
			<th field="vAddress" width="100">地址</th>
			<th field="vMoney" width="100">罚款数</th>
			<th field="vSMoney" width="100">手续费</th>
		</tr>
		</thead>
	</table>
</div>

</body>


</html>