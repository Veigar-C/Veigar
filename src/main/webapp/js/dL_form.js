/**
 * Created by Administrator on 2018/1/5.
 */
//			var c = $('#bb').datebox('getValue');

function submitForm() {
    var id = $("#id").val();
    var carNum = $("#carNum").val();
    var carType = $("#carType").val();
    var carProperty = $("#carProperty").val();
    var carBrand = $("#carBrand").val();
    var carIdentificantionCode = $("#carIdentificantionCode").val();
    var carEngineNum = $("#carEngineNum").val();
    var registerDate = $("#registerDate").val();
    var issuingDate = $("#issuingDate").val();
    var loadNum = $("#loadNum").val();
    var urls;
    if(id ==null || id ==""){
        urls = "addDL.do";
    }else{
        urls = "modifyDL.do";
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
            'carType': carType,
            'carProperty': carProperty,
            'carBrand': carBrand,
            'carIdentificantionCode': carIdentificantionCode,
            'carEngineNum': carEngineNum,
            'registerDate': registerDate,
            'issuingDate': issuingDate,
            'loadNum': loadNum
        }),
        success: function(data) {
            if(data){
                alert("操作成功");
                window.location.href = "toDL.do";
            }else{
                if(urls == "addDL.do"){
                    alert("车牌号、车辆识别码或发动机号已存在");
                }else if(urls == "modifyDL.do"){
                    alert("修改过程出现某些错误");
                }

            }
        }
    });
}


function clearForm() {
    $('#ff').form('clear');
}
