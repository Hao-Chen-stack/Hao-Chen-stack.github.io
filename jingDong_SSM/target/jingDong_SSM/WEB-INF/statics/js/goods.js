//当前页数，默认从第一页开始
var page=1;
//每页显示的条数
var size=5;
//总页数
var pageSize;

$(function () {
    findGoodsTypeList("gtypeId");
    findGoodsList();
})



//获取商品类型列表
function findGoodsTypeList(target) {
    $.ajax({
        url:"goods/typeList",
        dataType:"json",
        async:false,
        success:function (goodsTypeList) {
            var html="<option value='-1'>请选择类型</option>";
            for (var i = 0; i <goodsTypeList.length ; i++) {
                html+=`<option value="${goodsTypeList[i].gtypeId}">${goodsTypeList[i].gtypeName}</option>`;//反单引号不用考虑拼接问题
            }
            $("#"+target).html(html);
        }
    })
}

//按条件查询商品列表
function searchGoods() {
    page=1;
    findGoodsList()
}

//查询商品列表
function findGoodsList() {
    $("#page").val(page)
    $("#size").val(size)
    $.ajax({
        url:"goods/list",
        data:$("#searchFrom").serialize(),
        dataType:"json",
        success:function (map) {
            //更新当前页和总页数
            var counts = map.counts;
            pageSize = counts%size==0 ? counts/size : parseInt(counts/size)+1;
            $("#pageMsg").html("第"+page+"页/共"+pageSize+"页")
            var goodsList = map.data;
            var html="";
            for (var i = 0;i <goodsList.length;i++){
                html+="<tr>"

                html+="<td>"
                html+=goodsList[i].goodsId
                html+="</td>"

                html+="<td>"
                html+=goodsList[i].gtypeName
                html+="</td>"

                html+="<td>"
                html+=goodsList[i].goodsName
                html+="</td>"

                html+="<td>"
                html+=goodsList[i].goodsPrice
                html+="</td>"

                html+="<td>"
                html+="<img src='"+goodsList[i].goodsImage+"' alt=\"myImg\" style=\"width: 50px;height: 50px\">"
                html+="</td>"

                html+="<td>"
                html+=goodsList[i].goodsDetail
                html+="</td>"

                html+="<td>"
                html+=goodsList[i].goodsInventory
                html+="</td>"

                html+="<td>"
                html+=goodsList[i].createTime
                html+="</td>"

                html+="<td>"
                html+=goodsList[i].updateTime
                html+="</td>"

                goodsId = goodsList[i].goodsId
                html+="<td>"
                html+="<button type='button' onclick='delByGoodsId("+goodsId+")'>删除</button>"
                html+="<button type='button' onclick='openUpdWin("+JSON.stringify(goodsList[i])+")'>修改</button>"
                html+="</td>"

                html+="</tr>"
            }

            // document.getElementById("tb").innerHTML=html;
            $("#tb").html(html);

        }
    })
}

//提示框
// layer.confirm('确定要删除吗？', {
//     icon:3,
//     title:"提示",
//     btn: ['确定', '取消'],
//     submit:function(index){
//         console.log("提交");
//         layer.close(index);
//     },
//     cancel:function(index,layero){
//         console.log("取消");
//         layer.close(index);
//     }
// });


//删除对应行
function delByGoodsId(goodsId) {
    if(confirm("确定要删除该商品吗?")){
        $.ajax({
            url:"goods/delByGoodsId",
            data:{"goodsId":goodsId},
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
                findGoodsList();
            }
        })
    }
}

//上一页
$("#prev").click(function () {
    if (page>1){
        page--
        findGoodsList()
    }else {
        layer.msg("已经是第一页")
    }
})

//下一页
$("#next").click(function () {
    if(page<pageSize){
        page++
        findGoodsList()
    }else {
        layer.msg("已经是最后一页")
    }

})

//打开添加窗口
function openAddWin() {
    //清空添加窗口的记录
    $("#addForm")[0].reset()
    //清除预览缩略图图片
    $("#goodsImage_img").attr("src","")
    findGoodsTypeList("gtypeIdAdd");
    $("#addWin").fadeIn(500)
}

//关闭添加窗口
function cancelAdd() {
    $("#addWin").fadeOut()
}

//确认添加
function addGoods() {
    $.ajax({
        url:"goods/addGoods",
        data:$("#addForm").serialize(),
        dataType:"json",
        success:function (result) {
            if (result>0){
                layer.msg("添加成功")
            }else {
                layer.msg("添加失败")
            }
            cancelAdd();
            findGoodsList()
        }
    })
}

//打开修改窗口,并且回显要修改的数据
function openUpdWin(tblgoods) {
    findGoodsTypeList("gtypeIdUpd");
    $("#gtypeIdUpd").val(tblgoods.gtypeId)
    $("#NameUpd").val(tblgoods.goodsName)
    $("#PriceUpd").val(tblgoods.goodsPrice)
    //回显商品缩略图
    $("#goodsImageUpd_img").attr("src",path+tblgoods.goodsImage)
    //回填图片路径到隐藏域中
    $("#goodsImageUpd_hidden").val(tblgoods.goodsImage);

    $("#DetailUpd").val(tblgoods.goodsDetail)
    $("#InventoryUpd").val(tblgoods.goodsInventory)

    //添加商品id到form表单的隐藏域里面
    $("#goodsIdUpd").val(tblgoods.goodsId)

    $("#updWin").fadeIn(500)
    console.log(tblgoods);
}

//取消修改
function cancelUpd() {
    $("#updWin").fadeOut()
}

//确认修改
function updGoods() {
    $.ajax({
        url:"goods/upd",
        data:$("#updForm").serialize(),
        dataType:"json",
        success:function (i) {
            if (i>0){
                layer.msg("修改成功")
            }else {
                layer.msg("修改失败")
            }
            cancelUpd();
            findGoodsList();
        }
    })
}

//用来做缓存
// sessionStorage
// localStorage

//图片上传
function updateFile(target) {
    // var file_fujian = $("input[name='ID']").val();
    // //判断文件是否为空
    // if (file_fujian==""){
    //     layer.msg("请选择上传的附件",{icon:1,time:1000});
    //     return false;
    // }
    // //判断文件大小
    // var size1 = $("input[name='ID']")[0].files[0].size;
    // if (size1>104857600){
    //     layer.msg("上传的福建不能大于100M",{icon:1,time:2000});
    //     return false;
    // }
    //
    // bool = true;
    // var type = "file";
    var formData = new FormData();//实例化一个FormData来进行文件上传
    formData.append("myFile",$("#"+target)[0].files[0]);
    $.ajax({
        type:"POST",
        url:"uploads",
        data:formData,
        async: false,
        processData: false,
        contentType:false,
        success:function (res) {
            alert("上传成功："+res)
            // $("#myImg").attr("src",res);
            // $("#myImg").show(500);
            $("#"+target+"_hidden").val(res)
            $("#"+target+"_img").attr("src",path+res)
        }
    });
}