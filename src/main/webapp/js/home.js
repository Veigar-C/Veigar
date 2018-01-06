var code; //在全局定义验证码 
//产生验证码 
function createCode() {
    code = "";
    var codeLength = 4;//Math.random()*10 <= 5 ? 4 : 5; //验证码的长度
    var checkCode = document.getElementById("code");
    var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    //随机数
    for(var i = 0; i < codeLength; i++) {
        //循环操作
        var index = Math.floor(Math.random() * 36);
        //取得随机数的索引（0~35）
        code += random[index]; //根据索引取得随机数加到code上
    }
    checkCode.value = code; //把code值赋给验证码
}
//校验验证码 
function validate() {
    var inputCode = document.getElementById("yzm").value.toUpperCase(); //取得输入的验证码并转化为大写
    if(inputCode != code) {
        //若输入的验证码与产生的验证码不一致时
        createCode(); //刷新验证码
        document.getElementById("yzm").value = ""; //清空文本框
        return false;
    } else { //输入正确时  alert("^-^");
        return true;
    }
}

//设置此处的原因是每次进入界面展示一个随机的验证码，不设置则为空
window.onload = function() {
    createCode();
    placeholder();
    getTime();
}

function clear_button(){
    document.getElementById("clear-context").value=" ";
};

var hmzl,cp_num,fdj_num,cj_num,yzm;

function check() {
    hmzl = document.getElementById('day').value;
    cp_num = document.getElementById('cp_num').value;
    fdj_num = document.getElementById("fdj_num").value;
    cj_num = document.getElementById("cj_num").value;
    yzm = document.getElementById("yzm").value;

    if(hmzl == "" || hmzl == null) {
        alert("号牌种类不能为空");
        return false;
    } else if(cp_num == "" || cp_num == null) {
        alert("车牌号码不能为空");
        return false;
    } else if(fdj_num == "" || fdj_num == null) {
        alert("发动机号不能为空");
        return false;
    } else if(cj_num == "" || cj_num == null) {
        alert("车架号不能为空");
        return false;
    }else if(yzm == "" || yzm == null) {
        alert("验证码不能为空");
        return false;
    } else if( validate() === false) {
        alert("验证码错误");
        return false;
    } else if( selectUser() === false){
        return false;
    } else {
        return true;
    }
}

// function selectUser() {
//     var xmlhttp = new XMLHttpRequest();
//     xmlhttp.onreadystatechange = function () {
//         if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//             document.getElementById("test").innerHTML = xmlhttp.responseText;
//         }
//     }
//     xmlhttp.open("GET", "selectDriver?hmzl="+hmzl+"&cp_num="+cp_num+"&fdj_num="+fdj_num+"&cj_num="+cj_num, true);
//     xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//     xmlhttp.send();
//     return false;
// }

$(document).ready(function(){
    $("#selectUser").click( function(){
        var c_type = $("#day").val();//取得用户输入的消息变量
        var cp_num = $("#cp_num").val();
        var fdj_num = $("#fdj_num").val();
        var cj_num = $("#cj_num").val();

    $.ajax({//提交请求给Controller处理。
        type:"POST",
        url:"checkDriver.do",//在url中传参
        //async : false,//true为异步
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        data: JSON.stringify({
            'carType': c_type,
            'carNum':cp_num,
            'carEngineNum':fdj_num,
            'carIdentificantionCode':cj_num
        }),
        success: function(data){
            $("#test").html(data);
            if(data == cp_num){
                window.location.href = "selectDriver.do?carNum="+data;
            }
        }
    });
    return false;
});
});
