/**
 * Created by Administrator on 2018/1/5.
 */
//			var c = $('#bb').datebox('getValue');

function submitForm() {
    var id = $("#id").val();
    var name = $("#name").val();
    var address = $("#address").val();
    var sex = $("#sex").val();
    var idCard = $("#idCard").val();
    var birth_Date = $("#birth_Date").val();
    var issue_Date = $("#issue_Date").val();
    var permit_Type = $("#permit_Type").val();
    var expiration_Date = $("#expiration_Date").val();
    var carNum = $("#carNum").val();
    var urls;
    if(id==null||id==""){
        urls = "addDriver,do";
    }else {
        urls = "modifyDriver.do";
    }
    $.ajax({ //提交请求给Controller处理。
        type: "POST",
        url: urls, //在url中传参
        async : false,//true为异步
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({
            'id':id,
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
                alert("修改成功");
                window.location.href = "toDriver.do";
            }else{
                alert("身份证或车牌已存在");
                //录入失败
            }
        }
    });
}

function submitPWForm() {
    var pass = $("#password").val();
    var pass1 = $("#password1").val();
    var pass2 = $("#password2").val();
    if(pass1 != pass2  ){
        alert("重复密码与新的密码不一致！");
        return;
    }else if(pass == null || pass==""){
        alert("原始密码不能为空！");
        return;
    }else if(pass1 == null || pass1==""){
        alert("新的密码不能为空！");
        return;
    }else if(pass2==null || pass2==""){
        alert("重复密码不能为空！");
        return;
    }else{
        $.ajax({ //提交请求给Controller处理。
            type: "POST",
            url: "modifyPW.do?pass1="+pass+"&pass2="+pass1, //在url中传参
            async : false,//true为异步
            contentType: "application/json; charset=utf-8",
            success: function(data) {
                if(data=="MODIFIED"){
                    alert("修改成功");
                    // "录入成功"
                }else{
                    alert("密码错误");
                    //录入失败
                }
            }
        });
    }
}

function register() {
    var user = $("#user").val();
    var pass1 = $("#pw_admin").val();
    var pass2 = $("#pw_admin_check").val();
    if(pass1 != pass2  ){
        alert("重复密码与密码不一致！");
        return;
    }else if(user == null || user==""){
        alert("用户名不能为空！");
        return;
    }else if(pass1 == null || pass1==""){
        alert("密码不能为空！");
        return;
    }else if(pass2==null || pass2==""){
        alert("重复密码不能为空！");
        return;
    }else{
        $.ajax({ //提交请求给Controller处理。
            type: "POST",
            url: "registerAdmin.do", //在url中传参
            async : false,//true为异步
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify({
                'username':user,
                'password': pass1,
            }),
            success: function(data) {
                if(data){
                    alert("添加管理员成功！");
                }else{
                    alert("账号已存在！");
                }
            }
        });
    }
}

function clearForm() {
    $('#ff').form('clear');
}
