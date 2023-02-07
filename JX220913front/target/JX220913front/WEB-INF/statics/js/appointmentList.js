//当前页数，默认从第一页开始
var page=1;
//每页显示的条数
var size=5;
//总页数
var pageSize;

//文档加载事件
$(function () {
    findAppointList();
})

//查询预约列表
function findAppointList() {
    // $("#page").val(page)
    // $("#size").val(size)
    $.ajax({
        url:"appointment/findAppointList",
        data:{"page":page,"size":size},
        dataType:"json",
        success:function (map) {
            //更新当前页和总页数
            var counts = map.counts;
            pageSize = counts%size==0 ? counts/size : parseInt(counts/size)+1;
            $("#pageMsg").html("第"+page+"页/共"+pageSize+"页")
            var findAppointList = map.data;
            var html="";
            for (var i = 0;i <findAppointList.length;i++){

                html+="<tr>"

                html+="<td>"
                html+=findAppointList[i].appointmentdate
                html+="</td>"

                html+="<td>"
                html+=findAppointList[i].appointmenttime
                html+="</td>"

                html+="<td>"
                html+=findAppointList[i].managerAcc
                html+="</td>"

                html+="<td>"
                html+=findAppointList[i].areaName
                html+="</td>"

                html+="<td>"
                html+=findAppointList[i].appointstate
                html+="</td>"

                html+="<td>"
                if (findAppointList[i].appointstate==="已诊断"){
                    html+="<button type='button' class=\"layui-btn\" onclick='toManagerEvaluation("+findAppointList[i].managerAcc+","+findAppointList[i].appointmentId+")'>评价</button>"
                }
                html+="<button type='button' class=\"layui-btn layui-btn-normal\" onclick='toAppointmentDetails("+findAppointList[i].appointmentId+","+findAppointList[i].userId+","+findAppointList[i].managerAcc+")'>查看详情</button>"
                html+="<button type='button' class=\"layui-btn layui-btn-warm\" onclick='toConsultantFile("+findAppointList[i].managerAcc+")'>查看咨询师</button>"
                // html+="<button type='button' class=\"layui-btn layui-btn-warm\">查看咨询师</button>"
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
        findAppointList()
    }else {
        alert("已经是第一页")
    }
})

//下一页
$("#next").click(function () {
    if(page<pageSize){
        page++;
        findAppointList()
    }else {
        alert("已经是最后一页")
    }

})

// //返回
// $("#reu").click(function () {
//     location.reload();
// })

//跳转到咨询师档案
function toConsultantFile(managerAcc) {
    //在跳转时将参数传递
    $(location).attr('href', 'ConsultantFile?managerAcc='+managerAcc);
    localStorage.setItem("managerAcc",JSON.stringify(managerAcc));
}


//跳转到预约详情
function toAppointmentDetails(appointmentId,userId,managerAcc) {
    //在跳转时将参数传递
    var clazz = {appointmentId:appointmentId,userId:userId,managerAcc:managerAcc};
    var twoUrl = encodeURI('AppointmentDetails?clazz='+JSON.stringify(clazz));//对象转字符串
    $(location).attr('href', twoUrl);
    localStorage.setItem("managerAcc",JSON.stringify(managerAcc));

}

//跳转到咨询师评价
function toManagerEvaluation(managerAcc,appointmentId) {
    //在跳转时将参数传递
    var clazz = {managerAcc:managerAcc,appointmentId:appointmentId};
    // console.log(clazz)
    var twoUrl = encodeURI('managerEvaluation?clazz='+JSON.stringify(clazz));//对象转字符串
    $(location).attr('href', twoUrl);
    // $(location).attr('href', 'managerEvaluation?managerAcc='+managerAcc);
}
