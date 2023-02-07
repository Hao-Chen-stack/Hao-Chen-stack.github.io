//当前页数，默认从第一页开始
var page=1;
//每页显示的条数
var size=5;
//总页数
var pageSize;

//文档加载事件
$(function () {
    findAppointListBySomeCondition();
})

//按条件查询咨询师预约列表
function searchManager() {
    page=1;
    findAppointListBySomeCondition();
}

//查询咨询师列表
function findAppointListBySomeCondition() {
    $.ajax({
        url: "appointment/findAppointListBySomeCondition",
        data: $("#searchFrom").serialize() + "&page=" + page + "&size=" + size,
        dataType: "json",
        async: false,
        success:function (map) {
            //更新当前页和总页数
            var counts = map.counts;
            pageSize = counts%size==0 ? counts/size : parseInt(counts/size)+1;
            $("#pageMsg").html("第"+page+"页/共"+pageSize+"页")
            var appointList = map.data;
            var html="";
            for (var i = 0; i <appointList.length ; i++) {
                html+="<tr>"

                html+="<td>"
                html+=appointList[i].appointmentdate
                html+="</td>"

                html+="<td>"
                html+=appointList[i].appointmenttime
                html+="</td>"

                html+="<td>"
                html+=appointList[i].realName
                html+="</td>"

                html+="<td>"
                html+=appointList[i].areaName
                html+="</td>"

                html+="<td>"
                html+=appointList[i].userName
                html+="</td>"


                html+="<td>"
                html+=appointList[i].completeTime==null?"未完成":appointList[i].completeTime
                html+="</td>"

                html+="<td>"
                html+=appointList[i].appointstate
                html+="</td>"

                html+="<td>"
                html+="<button type='button' class=\"layui-btn layui-btn-normal\" onclick='toAppointmentDetails("+appointList[i].appointmentId+","+appointList[i].userId+","+appointList[i].managerAcc+")'>查看详情</button>"
                // html+="<button type='button' class=\"layui-btn layui-btn-normal\">查看详情</button>"
                if (appointList[i].appointstate==="已预约"){
                    // html+="<button type=\"button\" class=\"layui-btn\" onclick='isCheck("+appointListByMAcc[i].appointmentId+","+appointListByMAcc[i].userId+","+appointListByMAcc[i].managerAcc+")'>终止预约</button>"
                    html+="<button type=\"button\" class=\"layui-btn layui-btn-danger\" onclick='isAns("+appointList[i].appointmentId+")'>终止预约</button>"
                }
                html+="</td>"

                html+="</tr>"
            }

            $("#tb").html(html);
        }
    })
}

//上一页
$("#prev").click(function () {
    if (page>1){
        page--;
        findAppointListBySomeCondition()
    }else {
        alert("已经是第一页")
    }
})

//下一页
$("#next").click(function () {
    if(page<pageSize){
        page++;
        findAppointListBySomeCondition()
    }else {
        alert("已经是最后一页")
    }

})

//跳转到预约详情
function toAppointmentDetails(appointmentId,userId,managerAcc) {
    //在跳转时将参数传递
    var clazz = {appointmentId:appointmentId,userId:userId,managerAcc:managerAcc};
    var twoUrl = encodeURI('AppointmentDetails?clazz='+JSON.stringify(clazz));//对象转字符串
    $(location).attr('href', twoUrl);
    localStorage.setItem("managerAcc",JSON.stringify(managerAcc));

    //传递给用户评价列表
    localStorage.setItem("userId",userId);
}

//确认终止预约
function isAns(appointmentId) {
    layer.open({
        title: '确认终止'
        ,content: '是否确认终止'
        ,btn: ['是', '否']
        ,yes: function(){
            $.ajax({
                url: "appointment/updateAppointStateToStopByUId",
                data:{"appointmentId":appointmentId},
                dataType: "json",
                success:function (i) {
                    if (i>0){
                        alert("状态修改成已终止成功");
                        $(location).attr('href', 'AdminAppointList');
                    }else {
                        alert("状态修改成已终止失败");
                    }
                }
            })
        }
        ,btn2: function(){
            //否按钮关闭回调
            //return false 开启该代码可禁止点击该按钮关闭
        }
        ,cancel: function(){
            //右上角关闭回调
            //return false 开启该代码可禁止点击该按钮关闭
        }
    });
}