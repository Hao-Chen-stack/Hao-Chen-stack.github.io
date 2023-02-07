function login() {
    $.ajax({
        url:"user/findUser",
        data:$("#loginForm").serialize(),
        dataType:"json",
        success:function (i) {
            switch (i) {
                case 0:
                    alert("登录失败");
                    break;
                case 1:
                    alert("登录成功");
                    $(location).attr('href', 'userIndex');
                    break;
                case 2:
                    alert("验证码错误");
                    break;
            }
        }
    })

}

function register() {
    $.ajax({
        url: "user/addUser",
        data: $("#registerForm").serialize(),
        dataType: "json",
        success: function (i) {
            switch (i) {
                case 1:
                    alert("注册成功")
                    break;
                case 2:
                    alert("账号已存在")
                    break;
                case 3:
                    alert("两次输入密码不一致")
                    break;
            }
        }
    })
}


function changeCode(){
    $("#codeImage").attr('src','authCode?abc='+Math.random());//链接后添加Math.random，确保每次产生新的验证码，避免缓存问题。
}