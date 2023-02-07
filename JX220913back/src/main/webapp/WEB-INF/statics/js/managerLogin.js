function login() {
    $.ajax({
        url:"manager/findManager",
        data:$("#loginForm").serialize(),
        dataType:"json",
        success:function (map) {
            var i = map.manager;
            var list = map.treeVos;
            switch (i) {
                case 0:
                    alert("登录失败");
                    break;
                case 1:
                    alert("登录成功");
                    //清空
                    $("#loginForm")[0].reset();
                    $(location).attr('href', 'back');
                    localStorage.setItem("list",JSON.stringify(list));
                    localStorage.setItem("managerName",JSON.stringify(map.managerName));
                    localStorage.setItem("roleName",JSON.stringify(map.roleName));
                    break;
                case 2:
                    alert("验证码错误");
                    break;
            }
        }
    })

}

function changeCode(){
    $("#codeImage").attr('src','authCode?abc='+Math.random());//链接后添加Math.random，确保每次产生新的验证码，避免缓存问题。
}


