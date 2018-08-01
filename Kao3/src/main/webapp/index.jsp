<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.8.3/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
<script>
    $(function () {
        getentrys(0);
    })
    var page=0;
function getentrys(pageNum) {
    var cateid=$("#cate").val();
    $("#list").html('');
    $.ajax({
        url:"${pageContext.request.contextPath}/getEntrys",
        type:"POST",
        data:{cateid:cateid,pageNum:pageNum},
        success:function (data) {
            $.each(data.list,function (i,item) {
               var html="<tr><td>"+item.id+"</td><td>"+item.title+"</td><td>"+item.summary+"</td><td>"+item.uploaduser+"</td><td>"+item.createdate+"</td><td><a href='#' onclick='update("+item.id+")'>修改</a>     <a href='#' onclick='remove("+item.id+")'>删除</a></td></tr>"
                $("#list").append(html);
            })
            jQuery("#pagination").pagination(data.total, {
                current_page: pageNum,
                items_per_page: data.pageSize,
                callback: getentrys,
                load_first_page: true,
                prev_text: '上一页',
                next_text: '下一页'
            });
            page=pageNum;
            $("#list tr:even").css("background-color","aquamarine");
        }
    })
}
function update(id) {
    location.href="${pageContext.request.contextPath}/toUpdate?id="+id;
}
function remove(id) {
    $.ajax({
        url:"${pageContext.request.contextPath}/removeEntry",
        type:"POST",
        data:{"id":id},
        success:function (data) {
            getentrys(page);
            $("#list").after("<tr><td colspan='6' style='color:red;text-align: center'>删除成功</td></tr>");
        }
    })

}
function insert() {
    location.href="${pageContext.request.contextPath}/toInsert";
}
</script>
    <link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
<div>
     文档分类:<select id="cate" name="cate" onchange="getentrys()">
    <option value="0">全部</option>
<c:forEach items="${cates}" var="item">
    <option value="${item.id}">${item.name}</option>
</c:forEach>
</select>
    <button onclick="insert()">新增电子文档</button>
</div>
<div>
    <table border="1px soild">
        <thead>
        <tr>
            <td colspan="6" style="text-align: center">电子文档列表</td>
        </tr>
        <tr style="background-color: darkgrey">
        <td>文档编号</td><td>文档名称</td><td>文档摘要</td><td>上传者</td><td>上传时间</td><td>操作</td>
        </tr>
        </thead>
        <tbody id="list">

        </tbody>
    </table>
</div>
<div class="pagination" id="pagination"></div>
</body>
</html>
