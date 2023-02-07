//当前页数，默认从第一页开始
var page=1;
//每页显示的条数
var size=5;
//总页数
var pageSize;

var state;


//文档加载事件
$(function () {
    findManagerList();
})

//按条件查询用户列表
function searchManager() {
    page=1;
    findManagerList();
}


//查询用户列表
function findManagerList() {
    $("#page").val(page)
    $("#size").val(size)
    $.ajax({
        url:"manager/findManagerList",
        data:$("#searchFrom").serialize(),
        dataType:"json",
        success:function (map) {
            //更新当前页和总页数
            var counts = map.counts;
            pageSize = counts%size==0 ? counts/size : parseInt(counts/size)+1;
            $("#pageMsg").html("第"+page+"页/共"+pageSize+"页")
            var findManagerList = map.data;
            var html="";
            for (var i = 0;i <findManagerList.length;i++){
                var btnState = findManagerList[i].managerStatus!=1?"启用":"禁用"


                html+="<tr>"

                html+="<td>"
                html+=findManagerList[i].managerAcc
                html+="</td>"

                html+="<td>"
                html+=findManagerList[i].managerPwd
                html+="</td>"

                html+="<td>"
                html+=findManagerList[i].realName
                html+="</td>"

                html+="<td>"
                html+=findManagerList[i].title
                html+="</td>"


                html+="<td>"
                html+=findManagerList[i].school
                html+="</td>"

                html+="<td>"
                html+=findManagerList[i].managerStatus==1?"启用":"禁用"
                html+="</td>"


                managerId = findManagerList[i].managerId
                state = findManagerList[i].managerStatus
                html+="<td>"
                html+="<button type='button' onclick='updateDelManager("+managerId+")'>删除</button>"
                html+="<button type='button' onclick='rePwd("+managerId+")'>重置密码</button>"
                html+="<input type='button' onclick='onAndOffManager("+managerId+","+state+")' value='"+btnState+"'> "
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
        findManagerList()
    }else {
        alert("已经是第一页")
    }
})

//下一页
$("#next").click(function () {
    if(page<pageSize){
        page++;
        findManagerList()
    }else {
        alert("已经是最后一页")
    }

})

//逻辑删除后台用户
function updateDelManager(managerId) {
    if(confirm("确定要删除该用户吗?")){
        $.ajax({
            url:"manager/updateDelManager",
            data:{"managerId":managerId},
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
                findManagerList();
            }
        })
    }
}

//重置密码
function rePwd(managerId) {
    if(confirm("确定要重置密码?")){
        $.ajax({
            url:"manager/managerRePwd",
            data:{"managerId":managerId},
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
                findManagerList();
            }
        })
    }
}

//启用和禁用后台用户
function onAndOffManager(managerId,managerStatus) {
    $.ajax({
        url:"manager/onAndOffManager",
        data:{"managerId":managerId,"managerStatus":managerStatus},
        dataType:"json",
        success:function (i) {
            if (i>0){
                layer.msg("操作成功")
            }else {
                layer.msg("操作失败")
            }
            page=1;
            findManagerList();
        }
    })
}

//打开添加窗口
function openAddWin() {
    //清空添加窗口的记录
    $("#addForm")[0].reset()
    $("#addWin").fadeIn(500)
}

//关闭添加窗口
function cancelAdd() {
    $("#addWin").fadeOut()
}

//确认添加
function addManager() {

    $.ajax({
        url:"manager/addManager",
        data:$("#addForm").serialize(),
        dataType:"json",
        success:function (i) {
            switch (i) {
                case 1:
                    layer.msg("添加成功")
                    break;
                case 2:
                    layer.msg("账号已存在")
                    break;
                default:
                    layer.msg("添加失败")
                    break;

            }
            cancelAdd();
            findManagerList()
        }
    })
}

//动态添加咨询师的领域添加
function addAreaCheck(value) {
    if (value>1){
        // let htmladd4 = '<td style="text-align: right;">职称：</td>\n' +
        //     '           <td>\n' +
        //     '<!--                        <input type="text" placeholder="职称" id="addtitle" name="title" style="width: 100px;">-->\n' +
        //     '           <select name="titles" id="choosetitles" style="width: 100px;">\n' +
        //     '           <option value="-1">请选择用户职称</option>\n' +
        //     '           <option value="2">二级咨询师</option>\n' +
        //     '           <option value="3">三级咨询师</option>\n' +
        //     '           </select>\n' +
        //     '           </td>'

        let htmladd = '<input type="checkbox" name="areaName" id="1" value="发展心理学">发展心理学\n' +
            '\t\t     <input type="checkbox" name="areaName" id="2" value="学习心理学">学习心理学\n' +
            '\t\t\t <br>\n' +
            '\t\t     <input type="checkbox" name="areaName" id="3" value="人格心理学">人格心理学\n' +
            '\t\t     <input type="checkbox" name="areaName" id="4" value="感知心理学">感知心理学\n' +
            '\t\t\t <br>\n' +
            '\t\t     <input type="checkbox" name="areaName" id="5" value="比较心理学">比较心理学\n' +
            '\t\t     <input type="checkbox" name="areaName" id="6" value="认知心理学">认知心理学\n' +
            '\t\t\t <br>\n' +
            '\t\t     <input type="checkbox" name="areaName" id="7" value="犯罪心理学">犯罪心理学'

        let htmladd2 = '<td style="text-align: right;">费用:</td>\n' +
            '           <td>\n' +
            '           <input type="text" placeholder="费用" id="addprice" name="price" style="width: 100px;">\n' +
            '           </td>'

        let htmladd3 = '<td style="text-align: right;">背景:</td>\n' +
            '           <td>\n' +
            '           <input type="text" placeholder="背景" id="addbackground" name="background" style="width: 100px;">\n' +
            '           </td>'
        // $("#childTitleAdd").append(htmladd4)
        $("#childAdd").append(htmladd)
        $("#childPriceAdd").append(htmladd2)
        $("#childBackgroundAdd").append(htmladd3)

    }else {
        $("#childAdd").empty()
        $("#childPriceAdd").empty()
        $("#childBackgroundAdd").empty()
        // $("#childTitleAdd").empty()
    }
}


