//通过领域找到医生
function doctorMsgList(areaName) {
    $("#doctor").empty();
    $.ajax({
        url:"appointment/findRealName",
        // data:$("#addAppointment").serialize(),
        data:{"areaName":areaName},
        dataType:"json",
        success:function (doctorMsgList) {
            $("#doctor").append(
                '<option type="checkbox" name="managerAcc" value="">' + "请选择医生" + '</option>'
            )
            for (var i = 0; i < doctorMsgList.length; i++) {
                $("#doctor").append(
                    '<option type="checkbox" name="managerAcc" value="' + doctorMsgList[i].managerAcc + '">' + doctorMsgList[i].realName + '</option>'
                )
            }
        }
    })
}

//显示医生的全部相关信息
function doctorMsg(managerAcc) {
    $("#doctorname").empty()
    $("#doctorschool").empty()
    $("#doctorTitle").empty()
    $("#doctorprice").empty()
    $("#sector").empty()
    $("#background").empty()
    $.ajax({
        url: "appointment/doctorMsg",
        data: {"managerAcc":managerAcc},
        dataType: "json",
        success:function (map) {
            var doctorList = map.doctorMsgList;// 集合
            var areaList = map.areaNameList;// 集合
            // 集合取元素通过下标
            $("#doctorname").append(doctorList[0].realName)
            $("#doctorschool").append(doctorList[0].school)
            $("#doctorTitle").append(doctorList[0].title)
            $("#sector").append(areaList[0].areaName)
            $("#doctorprice").append(doctorList[0].price + "元/次")
            $("#background").append(doctorList[0].background)
            layui.element.init()//渲染
        }
    })

}

var orderDate=''
layui.use('laydate', function () {
    var laydate = layui.laydate;

    laydate.render({
        elem: '#test1'
        , done: function (startdate, date, endDate) {
            orderDate=startdate;
            var managerAcc = $("#doctor").val();
            {
                $("#time").empty()
                $("#time").append("   <tr>\n" +
                    "                        <td value=\"08:00~09:00\">\n" +
                    "                            <label >\n" +
                    "                                 <input disabled=\"disabled\" name=\"appointmenttime\" type=\"radio\"   value=\"08:00~09:00\">\n" +
                    "                                08:00~09:00   </label>\n" +
                    "                        </td>\n" +
                    "                        <td value=\"09:00~10:00\" >\n" +
                    "                            <label >\n" +
                    "                                <input disabled=\"disabled\"  name=\"appointmenttime\" type=\"radio\"  value=\"09:00~10:00\">\n" +
                    "                                09:00~10:00  </label>\n" +
                    "                        </td>\n" +
                    "                        <td value=\"10:00~11:00\" >\n" +
                    "                            <label value=\"10:00~11:00\">\n" +
                    "                                <input disabled=\"disabled\"  name=\"appointmenttime\" type=\"radio\"   value=\"10:00~11:00\">\n" +
                    "                                10:00~11:00    </label>\n" +
                    "                        </td>\n" +
                    "                        </td>\n" +
                    "                        <td value=\"11:00~12:00\" >\n" +
                    "                            <label >\n" +
                    "                                <input disabled=\"disabled\"  name=\"appointmenttime\" type=\"radio\"   value=\"11:00~12:00\">\n" +
                    "                                11:00~12:00    </label>\n" +
                    "                        </td>\n" +
                    "                    </tr>\n" +
                    "                        <tr>\n" +
                    "                            <td value=\"14:00~15:00\">\n" +
                    "                                <label >\n" +
                    "                                    <input disabled=\"disabled\" name=\"appointmenttime\" type=\"radio\"    value=\"14:00~15:00\">\n" +
                    "                                    14:00~15:00  </label>\n" +
                    "                            </td>\n" +
                    "                            <td value=\"15:00~16:00\">\n" +
                    "                                <label >\n" +
                    "                                    <input disabled=\"disabled\" name=\"appointmenttime\" type=\"radio\"    value=\"15:00~16:00\">\n" +
                    "                                    15:00~16:00     </label>\n" +
                    "                            </td>\n" +
                    "                            <td value=\"16:00~17:00\">\n" +
                    "                                <label >\n" +
                    "                                    <input disabled=\"disabled\" name=\"appointmenttime\" type=\"radio\"   value=\"16:00~17:00\">\n" +
                    "                                    16:00~17:00    </label>\n" +
                    "                            </td>\n" +
                    "                            <td value=\"17:00~18:00\">\n" +
                    "                                <label >\n" +
                    "                                    <input disabled=\"disabled\" name=\"appointmenttime\" type=\"radio\"    value=\"17:00~18:00\">\n" +
                    "                                    17:00~18:00   </label>\n" +
                    "\n" +
                    "                            </td>\n" +
                    "                        </tr>")
            }

            alert(startdate); //得到日期生成的值，如：2017-08-18
            $.ajax({
                url: "workTime/workTimeMsg",
                data: {"managerAcc":managerAcc,"workDate":startdate},
                dataType: "json",
                async: false,
                success: function (map) {
                    var workTimeList = map.workTimeMsg;
                    var workTimeMsgCount = map.counts;
                    for (var i = 0; i <workTimeList.length ; i++) {
                        if (workTimeMsgCount<1){
                            layer.msg("该日期不在工作日")
                        }else if (workTimeList[i].timeState === 1 && workTimeMsgCount>=1){
                            $("input[value=\""+workTimeList[i].workTime+"\"]").removeAttr("disabled")
                        }else if (workTimeList[i].timeState === 2 && workTimeMsgCount>=1){
                            $("td[value=\""+workTimeList[i].workTime+"\"]").attr("bgcolor","red")
                        }
                    }
                }
            })
        }
    });
});

//将用户所选和所填插入入数据库
function addUserCheckMsg() {
    $.ajax({
        url:"appointment/addUserCheckMsg",
        data:$("#addAppointment").serialize(),
        dataType:"json",
        success:function (i) {
            if (i>0){
                alert("预约成功");
                updateWorkTimeState();
                window.parent.location.href='userIndex';
            }else {
                alert("预约失败")
            }
        }
    })
}

//关闭我要预约窗口
function cancelAdd() {
    window.parent.location.href='userIndex';
}

//在点击我要预约之后更改工作时间状态
function updateWorkTimeState() {
    $.ajax({
        url:"appointment/updateWorkTimeState",
        data:{"timeState":2},
        dataType:"json",
        success:function (i) {
            if (i>0){
                layer.msg("咨询师工作时间状态改变成功");
            }else {
                layer.msg("咨询师工作时间状态改变失败");
            }
        }
    })

}

