<%--
  Created by IntelliJ IDEA.
  User: 18221
  Date: 2018/7/24
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.8.3/jquery-1.8.3.js"></script>
    <script>
        function check() {
            var a = /^(\d{4})-(\d{2})-(\d{2})$/;
            var createdate=$("[name=createdate]").val();
            if($("[name=title]").val()==""||$("[name=createdate]").val()==""){
                alert("必填项不能为空")
                  return false;
            }else if(!a.test(createdate)){
                alert("日期格式不正确!")
                return false;
            }else {
                return true;
            }
        }
        function back() {
            history.go(-1);
        }
    </script>
</head>
<body>
<div>
    <form  method="post" onsubmit="return check()" action="/update">
    <table border="1px soild">
        <tr>
           <c:if test="${update!=null}">
               <td colspan="2" style="text-align: center;background-color: aquamarine">更改电子文档</td>
           </c:if>
            <c:if test="${update==null}">
                <td colspan="2" style="text-align: center;background-color: aquamarine">增加电子文档</td>
            </c:if>
        </tr>
        <c:if test="${update!=null}">
        <tr>
                <td>文档编号</td><td><input type="hidden" name="id" value="${update.id}">${update.id}</td>
        </tr>
        </c:if>
        <tr>
            <td>文档类型</td><td>
            <select id="cate" name="categoryId">
                <c:forEach items="${cates}" var="item">
                    <option value="${item.id}" <c:if test="${item.id==update.categoryId}">selected="selected"</c:if>>${item.name}</option>
                </c:forEach>
            </select>
        </td>
        </tr>
        <tr>
            <td>文档名称<span style="color: red">(*)</span></td><td><input type="text" name="title" value="${update.title}"></td>
        </tr>
        <tr>
            <td>文章摘要</td><td><textarea name="summary" style="width: 350px;height: 100px">${update.summary}</textarea></td>
        </tr>
        <tr>
            <td>上传人</td><td><input type="text" name="uploaduser" value="${update.uploaduser}"></td>
        </tr>
        <tr>
            <td>上传时间<span style="color: red">(*)</span></td><td><input type="text" name="createdate" value="${update.createdate}"> <c:if test="${update==null}">(yyyy-MM-dd)
            </c:if></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="提交" ><button onclick="back()">返回</button></td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
