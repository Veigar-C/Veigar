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
	<script type="text/javascript" src="js/driver_table.js"></script>
</head>

<body class="easyui-layout">
<div data-options="region:'center',title:'驾驶证信息'">
	<table id="list_data" cellspacing="0" cellpadding="0">
		<thead>
		<tr>
			<th field="name" width="100">姓名</th>
			<th field="address" width="100">地址</th>
			<th field="sex" width="100">性别</th>
			<th field="idCard" width="100">身份证号</th>
			<th field="birth_Date" width="100">出生日期</th>
			<th field="issue_Date" width="100">发证日期</th>
			<th field="permit_Type" width="100">准驾类型</th>
			<th field="expiration_Date" width="100">有效期限</th>
			<th field="carNum" width="100">车牌号</th>
			<th field="id" width="100">id</th>
		</tr>
		</thead>
	</table>
</div>

</body>


</html>