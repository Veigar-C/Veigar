function check() {
	var userName = document.getElementById('username').value;
	var pass = document.getElementById('password').value;
	var inputCode = document.getElementById("input").value;

	if(userName == "" || userName == null || userName == '请输入用户名') {
		alert("账号不能为空");
		return false;
	} else if(pass == "" || pass == null || pass == '请输入密码') {
		alert("密码不能为空");
		return false;
	} else if(inputCode == "" || inputCode == null || inputCode == '请输入验证码') {
		alert("验证码不能为空");
		return false;
	} else if( validate() === false) {
		alert("验证码错误");
		return false;
	} else {
		tologin();
		return true;
	}
}

var code; //在全局定义验证码 
//产生验证码 
function createCode() {
	code = "";
	var codeLength = 4; //验证码的长度  Math.random()*10 <= 5 ? 4 : 5
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
	var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写 
	if(inputCode != code) {
		//若输入的验证码与产生的验证码不一致时 
		createCode(); //刷新验证码
		document.getElementById("input").value = ""; //清空文本框
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

function placeholder(){
   
//判断浏览器是否支持placeholder属性
supportPlaceholder='placeholder'in document.createElement('input'),
placeholder = function(input){
   
    var text = input.attr('placeholder'),
    defaultValue = input.defaultValue;
   
    if(!defaultValue){
      input.val(text).addClass("phcolor");
    }
    
    input.focus(function(){
      if(input.val() == text){
        $(this).val("");
      }
    });
   
    input.blur(function(){
      if(input.val() == ""){       
        $(this).val(text).addClass("phcolor");
      }
    });
   
    //输入的字符不为灰色
    input.keydown(function(){
      $(this).removeClass("phcolor");
    });
};
   
//当浏览器不支持placeholder属性时，调用placeholder函数
	if(!supportPlaceholder){
	    $('input').each(function(){
	      text = $(this).attr("placeholder");
	      if($(this).attr("type") == "text"){
	        placeholder($(this));
	      }
	    });
	}
}

function getTime(){
	var time = document.getElementById('get_time');
	var myDate = new Date();
	var week = myDate.getDay();
	switch(week)
	{
		case 1:
		week = '一';
		break;
		case 2:
		week = '二';
		break;
		case 3:
		week = '三';
		break;
		case 4:
		week = '四';
		break;
		case 5:
		week = '五';
		break;
		case 6:
		week = '六';
		break;
		case 7:
		week = '天';
		break;
	}
	var today = "今天是" + myDate.getFullYear()+"年 "+myDate.getMonth()+"月 "+myDate.getDate()+"日 星期"+week;
	time.innerHTML=today;
}

function tologin(){
    var user = $('#username').val();
    var pass = $('#password').val();
    $.ajax({
        type:"POST",
        url:"login",//在url中传参
        //async : false,//true为异步
        contentType:"application/json; charset=utf-8",
        dataType:"json",
        data: JSON.stringify({
            'username': user,
            'password': pass
        }),
        error : function() {
        },
        success : function(data) {
        	if(data){
                window.location.href = "http://localhost:8080/veigar/manager.do";
			} else{
        		$('#message').html("用户名或密码有误");
			}

        }
    });
}