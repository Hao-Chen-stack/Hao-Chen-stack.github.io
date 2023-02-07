//当前页数，默认从第一页开始
var page=1;
//每页显示的条数
var size=5;
//总页数
var pageSize;


//文档加载事件
$(function () {
    findAppointListByMAcc();
})

//按条件查询咨询师预约列表
function searchManager() {
    page=1;
    findAppointListByMAcc();
}

//查询咨询师预约列表
function findAppointListByMAcc() {
    $.ajax({
        url:"appointment/findAppointListByMAcc",
        data:$("#searchFrom").serialize()+"&page="+page+"&size="+size,
        dataType:"json",
        async:false,
        success:function (map) {
            //更新当前页和总页数
            var counts = map.counts;
            pageSize = counts%size==0 ? counts/size : parseInt(counts/size)+1;
            $("#pageMsg").html("第"+page+"页/共"+pageSize+"页")
            var appointListByMAcc = map.data;
            var html="";
            for (var i = 0; i <appointListByMAcc.length ; i++) {
                html+="<tr>"

                html+="<td>"
                html+=appointListByMAcc[i].appointmentdate
                html+="</td>"

                html+="<td>"
                html+=appointListByMAcc[i].appointmenttime
                html+="</td>"

                html+="<td>"
                html+=appointListByMAcc[i].userName
                html+="</td>"

                html+="<td>"
                html+=appointListByMAcc[i].areaName
                html+="</td>"


                html+="<td>"
                html+=appointListByMAcc[i].problem
                html+="</td>"

                html+="<td>"
                html+=appointListByMAcc[i].appointstate
                html+="</td>"

                html+="<td>"
                if (appointListByMAcc[i].appointstate==="已预约"){
                    html+="<button type=\"button\" class=\"layui-btn\" onclick='isCheck("+appointListByMAcc[i].appointmentId+","+appointListByMAcc[i].userId+","+appointListByMAcc[i].managerAcc+")'>确认预约</button>"
                }else if (appointListByMAcc[i].appointstate==="已确认"){
                    html+="<button type=\"button\" class=\"layui-btn layui-btn-danger\" onclick='toDiagnosticResponse("+appointListByMAcc[i].appointmentId+")'>诊断</button>"
                }
                html+="<button type='button' class=\"layui-btn layui-btn-normal\" onclick='toAppointmentDetails("+appointListByMAcc[i].appointmentId+","+appointListByMAcc[i].userId+","+appointListByMAcc[i].managerAcc+")'>查看详情</button>"
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
        findAppointListByMAcc()
    }else {
        alert("已经是第一页")
    }
})

//下一页
$("#next").click(function () {
    if(page<pageSize){
        page++;
        findAppointListByMAcc()
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

//跳转到诊断答复
function toDiagnosticResponse(appointmentId) {
    //在跳转时将参数传递
    $(location).attr('href', 'DiagnosticResponse?appointmentId='+appointmentId);

}

//确认预约
function isCheck(appointmentId,userId,managerAcc){
    $.ajax({
        url:"appointment/compareMPriceAndUBalance",
        data:{"userId":userId,"managerAcc":managerAcc},
        dataType:"json",
        success:function (i) {
            if (i>0){
                layer.open({
                    title: '确认预约'
                    ,content: '是否确认预约'
                    ,btn: ['是', '否']
                    ,yes: function(){
                        $.ajax({
                            url: "appointment/updateAppointState",
                            data:{"appointmentId":appointmentId},
                            dataType: "json",
                            success:function (i) {
                                if (i>0){
                                    layer.msg("确认完毕");
                                    addBillMsg(userId,managerAcc);
                                    updateMBalanceByMAcc(managerAcc);
                                    updateUBalanceByUId(managerAcc,userId);
                                    $(location).attr('href', 'DoctorAppointList');
                                }else {
                                    layer.msg("确认失败");
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
            }else {
                alert("用户余额不足，扣款失败");
                updateAppointStateByUId(appointmentId);
                findAppointListByMAcc();
            }
        }
    });

}

//点击已预约时插入消费记录到数据库
function addBillMsg(userId,managerAcc) {
    $.ajax({
        url: "bill/addBillMsg",
        data: {"userId":userId,"billtype":"预约","state":"支出","managerAcc":managerAcc},
        dataType: "json",
        success: function (i) {
            if (i > 0) {
                alert("生成消费记录成功");
            } else {
                alert("生成消费记录失败");
            }
        }
    })
}

//点击已预约时对咨询师余额进行相应的增加
function updateMBalanceByMAcc(managerAcc) {
    $.ajax({
        url:"manager/updateMBalanceByMAcc",
        data:{"managerAcc":managerAcc},
        dataType:"json",
        success:function (i) {
            if (i>0){
                alert("咨询师余额已增加")
            }else {
                alert("咨询师余额增加失败")
            }
        }
    })

}

//点击已预约时对用户余额进行相应的减少
function updateUBalanceByUId(managerAcc,userId) {
    $.ajax({
        url:"user/updateUBalanceByUId",
        data:{"managerAcc":managerAcc,"userId":userId},
        dataType:"json",
        success:function (i) {
            if (i>0){
                alert("用户余额已扣款")
            }else {
                alert("用户余额扣款失败")
            }
        }
    })

}

//根据预约id修改预约状态为预约失败
function updateAppointStateByUId(appointmentId) {
    $.ajax({
        url:"appointment/updateAppointStateByUId",
        data:{"appointmentId":appointmentId},
        dataType:"json",
        async:false,
        success:function (i) {
            if (i>0){
                layer.msg("已修改为预约失败");
            }else {
                layer.msg("未成功修改为预约失败");
            }
        }
    })
}

