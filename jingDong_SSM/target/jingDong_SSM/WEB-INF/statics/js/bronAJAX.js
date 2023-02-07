//原生AJAX
//1.创建XMLHttpRequest对象
var xhr;
if (window.XMLHttpRequest){
    xhr = new XMLHttpRequest();
}else {
    xhr = new ActiveXObject("Microsoft.XMLHTTP");
}
//2.发送请求
xhr.open("get","region?action=findRegionList",true);
xhr.send();

//3.添加onreadystatechange事件
xhr.onreadystatechange=function () {
        if (xhr.status==200 && xhr.readyState==4){
            console.log(xhr.responseText)
            //JSON.parse,JSON.stringfy
            var regionList = JSON.parse(xhr.responseText)
            for (var i = 0;i <regionList.length;i++){
                console.log(regionList[i])
            }
        }
    }
