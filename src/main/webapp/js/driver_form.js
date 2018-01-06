/**
 * Created by Administrator on 2018/1/5.
 */
//			var c = $('#bb').datebox('getValue');

function submitForm() {
    var name = $("#name").val();
    var address = $("#address").val();
    var sex = $("#sex").val();
    var idCard = $("#idCard").val();
    var birth_Date = $("#birth_Date").val();
    var issue_Date = $("#issue_Date").val();
    var permit_Type = $("#permit_Type").val();
    var expiration_Date = $("#expiration_Date").val();
    var carNum = $("#carNum").val();
    $.ajax({ //提交请求给Controller处理。
        type: "POST",
        url: "testAdd.do", //在url中传参
        async : false,//true为异步
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({
            'name': name,
            'address': address,
            'sex': sex,
            'idCard': idCard,
            'birth_Date': birth_Date,
            'issue_Date': issue_Date,
            'permit_Type': permit_Type,
            'expiration_Date': expiration_Date,
            'carNum': carNum
        }),
        success: function(data) {
            if(data){
                alert("录入成功");
               // "录入成功"
            }else{
                alert("身份证或车牌已存在");
                //录入失败
            }
        }
    });
}

function clearForm() {
    $('#ff').form('clear');
}
