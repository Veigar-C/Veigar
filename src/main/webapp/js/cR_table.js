
$(document).ready(function(){
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
        url:'selectCR.do',
        dataType:'JSONP',
        remoteSort:false,
        idField:'fldId',
        singleSelect:false,//是否单选
        pagination:true,//分页控件
        rownumbers:true,//行号
        frozenColumns:[[
            {field:'ck',checkbox:true}
        ]],
        toolbar: [{
            text: '删除',
            iconCls: 'icon-remove',
            handler: function(){
                delById();
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
    });
});

function delById() {
    var ids = [];
    var rows = $('#list_data').datagrid('getSelections');
    for(var i=0; i<rows.length; i++){
        ids.push(rows[i].id);
    }
    $.ajax({
        async : false,
        url : "delCRById.do",
        traditional: true,
        type : 'POST',
        data : {
            ids:ids
        },

        error : function() {
            alert('删除过程出现了某些错误');
        },
        success : function(data) {
            alert("删除成功")
            $('#list_data').datagrid('reload');
        }
    });

}/**
 * Created by Administrator on 2018/3/23.
 */
