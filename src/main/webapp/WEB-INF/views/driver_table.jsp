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
</head>

<body class="easyui-layout">
<div data-options="region:'center',title:'驾驶证信息'">
	<table id="list_data" cellspacing="0" cellpadding="0">
		<thead>
		<tr>
			<th field="name" width="100">部门</th>
			<th field="address" width="100">网站</th>
			<th field="sex" width="100">名称</th>
			<th field="idCard" width="100">管理员</th>
			<th field="birth_Date" width="100">注释</th>
			<th field="issue_Date" width="100">类型</th>
			<th field="permit_Type" width="100">电话</th>
			<th field="expiration_Date" width="100">职务</th>
			<th field="carNum" width="100">启用监测</th>
			<th field="id" width="100">要重级别</th>
		</tr>
		</thead>
	</table>
</div>

</body>

<script>
    //datagrid初始化
    $('#list_data').datagrid({
        iconCls:'icon-edit',//图标
        width: 700,
        height: 'auto',
        nowrap: false,
        striped: true,
        border: true,
        collapsible:false,//是否可折叠的
        fit: true,//自动大小
        url:'testJson',
        dataType:'JSONP',
        //sortName: 'code',
        //sortOrder: 'desc',
        remoteSort:false,
        idField:'fldId',
        singleSelect:false,//是否单选
        pagination:true,//分页控件
        rownumbers:true,//行号
        frozenColumns:[[
            {field:'ck',checkbox:true}
        ]],
        toolbar: [{
            text: '添加',
            iconCls: 'icon-add',
            handler: function() {
                var rows = $('#list_data').datagrid('getSelections');

                if (rows.length == 1) {
                    alert(rows[0].id);
                } else {
                    //$.messager.alert('提示', '请选择一条记录！', 'warning');
                    $.messager.confirm('Confirm','Are you sure you want to delete record?',function(r){
                        if (r){
                            alert('ok');
                        }
                    });
                }
            }
        }, '-', {
            text: '修改',
            iconCls: 'icon-edit',
            handler: function() {
                openDialog("add_dialog","edit");
            }
        }, '-',{
            text: '删除',
            iconCls: 'icon-remove',
            handler: function(){
                delAppInfo();
            }
        }],
    });
    //设置分页控件
    var p = $('#list_data').datagrid('getPager');
    $(p).pagination({
        pageSize: 10,//每页显示的记录条数，默认为10
        pageList: [5,10,15],//可以设置每页记录条数的列表
        beforePageText: '第',//页数文本框前显示的汉字
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		/*onBeforeRefresh:function(){
		 $(this).pagination('loading');
		 alert('before refresh');
		 $(this).pagination('loaded');
		 }*/
    });
</script>
</html>