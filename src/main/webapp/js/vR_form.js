/**
 * Created by Administrator on 2018/1/5.
 */
//			var c = $('#bb').datebox('getValue');

function submitForm() {
    var id = $("#id").val();
    var carNum = $("#carNum").val();
    var vDate = $("#vDate").val();
    var vContent = $("#vContent").val();
    var vState = $("#vState").val();
    var vPoints = $("#vPoints").val();
    var vAddress = $("#vAddress").val();
    var vMoney = $("#vMoney").val();
    var vSMoney = $("#vSMoney").val();
    var urls;
    if(id ==null || id ==""){
        urls = "addVR.do";
    }else{
        urls = "modifyVR.do";
    }
    $.ajax({ //提交请求给Controller处理。
        type: "POST",
        url: urls, //在url中传参
        async : false,//true为异步
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({
            'id':id,
            'carNum': carNum,
            'vDate': vDate,
            'vContent': vContent,
            'vState': vState,
            'vPoints': vPoints,
            'vAddress': vAddress,
            'vMoney': vMoney,
            'vSMoney': vSMoney
        }),
        success: function(data) {
            if(data){
                alert("操作成功");
                window.location.href = "toViolationRecord.do";
            }else{
                alert("出现了某些错误");
            }
        }
    });
}


function clearForm() {
    $('#ff').form('clear');
}
