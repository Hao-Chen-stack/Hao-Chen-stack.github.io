//文档加载事件
$(function () {
    findBillList();
})


//查询资金账户列表
function findBillList() {
    $.ajax({
        url:"bill/findBillList",
        // data:$("#searchFrom").serialize(),
        dataType:"json",
        success:function (map) {
            var billList = map.billList
            var managerBalance = map.managerBalance
            var html="";
            var h2="";
            for (var i = 0;i <billList.length;i++){

                html+="<tr>"

                html+="<td>"
                html+=billList[i].billdate
                html+="</td>"


                html+="<td>"
                html+=billList[i].userName
                html+="</td>"


                html+="<td>"
                html+=billList[i].billtype
                html+="</td>"

                html+="<td>"
                html+=billList[i].amount
                html+="</td>"

                html+="</tr>"
            }
            //余额
            h2+="<p>"
            h2+="余额："+managerBalance
            h2+="</p>"

            // document.getElementById("tb").innerHTML=html;
            $("#tb").html(html);
            $("#managerBalanceAdd").html(h2)

        }
    })
}