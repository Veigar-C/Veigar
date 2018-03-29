/**
 * Created by Administrator on 2018/3/24.
 */
function complain() {
    var code = document.getElementById('code').value;//取得用户输入的消息变量
    var phone = document.getElementById('phone').value;
    var content = document.getElementById('content').value;

    if(phone==null ||phone ==""){
        alert("手机号不能为空");
        return false;
    }else if(content==null || content==""){
        alert("申诉内容不能为空");
        return false;
    }else{
        // $.ajax({//提交请求给Controller处理。
        //     type: "POST",
        //     url: "submitCR",//在url中传参
        //     //async : false,//true为异步
        //     contentType: "application/json; charset=utf-8",
        //     dataType: "json",
        //     data: JSON.stringify({
        //         'code': code,
        //         'phone': phone,
        //         'content': content
        //     }),
        //     success: function (data) {
        //
        //     }
        // });
        window.location.href="submitCR?code="+code+"&phone="+phone+"&content="+content;
    }


}