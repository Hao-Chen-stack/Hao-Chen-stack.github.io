//当前页数，默认从第一页开始
var page=1;
//每页显示的条数
var size=5;
//总页数
var pageSize;

var state;

//文档加载事件
$(function () {
    findUserList();
})

//按条件查询用户列表
function searchUser() {
    page=1;
    findUserList();
}

//查询用户列表
function findUserList() {
    $("#page").val(page)
    $("#size").val(size)
    $.ajax({
        url:"user/list",
        data:$("#searchFrom").serialize(),
        dataType:"json",
        success:function (map) {
            //更新当前页和总页数
            var counts = map.counts;
            pageSize = counts%size==0 ? counts/size : parseInt(counts/size)+1;
            $("#pageMsg").html("第"+page+"页/共"+pageSize+"页")
            var userList = map.data;
            var html="";
            for (var i = 0;i <userList.length;i++){
                var btnState = userList[i].userState!=1?"启用":"禁用"


                html+="<tr>"

                html+="<td>"
                html+=userList[i].userId
                html+="</td>"

                html+="<td>"
                html+=userList[i].userAcc
                html+="</td>"

                html+="<td>"
                html+=userList[i].userPwd
                html+="</td>"

                html+="<td>"
                html+=userList[i].userName
                html+="</td>"


                html+="<td>"
                html+=userList[i].userSex==1?"男":"女"
                html+="</td>"

                html+="<td>"
                html+=userList[i].userAge
                html+="</td>"

                html+="<td>"
                html+=userList[i].userPhone
                html+="</td>"

                html+="<td>"
                html+=userList[i].createTime
                html+="</td>"

                html+="<td>"
                html+=userList[i].userState==1?"启用":"禁用"
                html+="</td>"

                html+="<td>"
                html+=userList[i].userAddress
                html+="</td>"

                html+="<td>"
                html+=userList[i].userBalance
                html+="</td>"

                userId = userList[i].userId
                state = userList[i].userState
                html+="<td>"
                html+="<button type='button' onclick='updateDelUser("+userId+")'>删除</button>"
                html+="<button type='button' onclick='rePwd("+userId+")'>重置密码</button>"
                html+="<input type='button' onclick='onAndOffUser("+userId+","+state+")' value='"+btnState+"'> "
                html+="</td>"

                html+="</tr>"
            }

            // document.getElementById("tb").innerHTML=html;
            $("#tb").html(html);

        }
    })
}

//上一页
$("#prev").click(function () {
    if (page>1){
        page--;
        findUserList()
    }else {
        alert("已经是第一页")
    }
})

//下一页
$("#next").click(function () {
    if(page<pageSize){
        page++;
        findUserList()
    }else {
        alert("已经是最后一页")
    }

})

//逻辑删除用户
function updateDelUser(userId) {
    if(confirm("确定要删除该用户吗?")){
        $.ajax({
            url:"user/updateDelUser",
            data:{"userId":userId},
            async:true,
            method: "post",
            dataType:"json",
            success:function (i) {
                // var html = ''
                if (i>0){
                    // html = "删除成功"
                    layer.msg("删除成功")
                }else {
                    layer.msg("删除失败")
                    // html = "删除失败"
                }
                page=1;
                findUserList();
            }
        })
    }
}

//重置密码
function rePwd(userId) {
    if(confirm("确定要重置密码?")){
        $.ajax({
            url:"user/RePwd",
            data:{"userId":userId},
            async:true,
            method: "post",
            dataType:"json",
            success:function (i) {
                // var html = ''
                if (i>0){
                    // html = "删除成功"
                    layer.msg("重置成功")
                }else {
                    layer.msg("重置失败")
                    // html = "删除失败"
                }
                page=1;
                findUserList();
            }
        })
    }
}

//启用和禁用用户
function onAndOffUser(userId,userState) {
    $.ajax({
        url:"user/onAndOffUser",
        data:{"userId":userId,"userState":userState},
        dataType:"json",
        success:function (i) {
            if (i>0){
                layer.msg("操作成功")
            }else {
                layer.msg("操作失败")
            }
            page=1;
            findUserList();
        }
    })
}