//当前页数，默认从第一页开始
var page=2;
//每页显示的条数
var size=3;
//总页数
var pageSize;


//文档加载事件
$(function () {
    findRegionByParentId(0,'province')
    findRegionList();
})

//查询省份列表
function findRegionByParentId(parentId,target) {
    $.ajax({
        url: "region/ByParentId",
        data: {parentId:parentId},
        async:false,
        // method: "post",
        dataType: "json",
        success:function (regionList) {
            var html = ''
            if (target=='province'||target=='addProvince'){
                html = "<option value='-1'>请选择省</option>"
            }else if (target=='city' ||target=='addCity' ){
                html = "<option value='-1'>请选择市</option>"
            }
            // // console.log(regionList)
            // var html = "<option value='-1'>请选择省</option>"
            for (var i =0;i<regionList.length;i++){
                html+="<option value='"+regionList[i].regionId+"'>"+regionList[i].regionName+"</option>>"
            }
            document.getElementById(target).innerHTML=html
        }
    })
}

function findByCondition() {
    page=1;
    findRegionList()
}

function findRegionList() {
    /*
    * 1,url :请求路经
    * 2、data :传参
    * 3, method : get/post
    * 4、async :同步/异步，默认异步( true )
    * 5,datatype : 'json '
    * 6, success :成功的回调函数
    * .......
    *  error
    *  before
    * .......
    */
    $.ajax({
        url:"region/list",
        // data:{"action": "findRegionList"},
        data:$("#form1").serialize()+"&page="+page+"&size="+size,//$("#form1").serialize()获取form表单中所有的参数
        method: "post",
        async:true,
        dataType:"json",
        success:function (map) {
            var result = map.data;
            console.log(result)
            // console.log(typeof map.counts)
            pageSize = map.counts%size==0 ? parseInt(map.counts/size) : (parseInt(map.counts/size)+1);
            //更新当前页和总页数
            $("#pageMsg").html("第"+page+"页/共"+pageSize+"页")
            // console.log(result)
            var html="";
            for (var i = 0;i <result.length;i++){
                html+="<tr>"
                html+="<td>"
                html+=result[i].regionId
                html+="</td>"
                html+="<td>"
                html+=result[i].province
                html+="</td>"
                html+="<td>"
                html+=result[i].city
                html+="</td>"
                html+="<td>"
                html+=result[i].area
                html+="</td>"
                html+="<td>"
                html+=result[i].regionStatus==1?"正常":"异常"
                html+="</td>"
                html+="<td>"
                delRid = result[i].regionId;
                pName = result[i].province;
                cityName = result[i].city;
                html+="<button type='button' name='action' value='deleteRow' onclick='deleteRow("+delRid+")'>删除</button>"
                html+="<button type='button' name='action' value='updateRegion' onclick='openUpdateWin("+delRid+",pName,cityName)'>修改</button>"
                html+="</td>"
                html+="</tr>"
            }

            document.getElementById("tb").innerHTML=html;

        }
    })
}

//删除对应行
function deleteRow(Rid) {
    $.ajax({
        url:"region/deleteRegionRow",
        data:{Rid:Rid},
        async:true,
        method: "post",
        dataType:"json",
        success:function (i) {
            // var html = ''
            if (i>0){
                // html = "删除成功"
                alert("删除成功")
                findRegionList()
            }else {
                alert("删除失败")
                // html = "删除失败"
            }
            document.getElementById("delMsg").innerHTML=html
        }
    })
}
//上一页
$("#prev").click(function () {
    if (page>1){
        page--
        findRegionList()
    }else {
        alert("已经是第一页")
    }
})

//下一页
$("#next").click(function () {
    if(page<pageSize){
        page++
        findRegionList()
    }else {
        alert("已经是最后一页")
    }

})

//打开添加窗口
function openAddWin() {
    findRegionByParentId(0,'addProvince')
    $("#addWin").fadeIn(500)

}

//关闭添加窗口
function cancelAdd() {
    $("#addWin").fadeOut()
    $("#addForm")[0].reset()
}

//确认添加
function addRegion() {
    $.ajax({
        url:"region/addRegion",
        data:$("#addForm").serialize(),
        dataType:"json",
        success:function (result) {
            if (result>0){
                alert("添加成功")
            }else {
                alert("添加失败")
            }
            cancelAdd();
            findRegionList()
        }
    })
}

//打开修改窗口
function openUpdateWin(Rid,pName,cityName) {
    $("#updateWin").fadeIn(500)
    $("#regionId").val(Rid)
    $("#pName").append(pName)
    $("#cityName").append(cityName)
}

//关闭修改窗口
function cancelUpdate() {
    $("#updateWin").fadeOut()
    $("#updateForm")[0].reset()
    $("#pName").remove()
    $("#cityName").remove()

}
//确认修改
function updateRegion() {
    $.ajax({
        url:"region/updateArea",
        data:$("#updateForm").serialize(),
        dataType:"json",
        success:function (i) {
            if (i){
                alert("修改成功")
            }else {
                alert("修改失败")
            }
            cancelUpdate();
            findRegionList()
        }
    })
}




