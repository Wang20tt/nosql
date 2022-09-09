<%--
  Created by IntelliJ IDEA.
  User: wangziteng
  Date: 2021/11/21
  Time: 5:42 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/fortext.css">
</head>
<body background="image/bg2.png" style=" background-repeat:no-repeat ;background-size:100% 100%;
background-attachment: fixed;">
<textarea class="text1" rows="13" cols="40" readonly="readonly"  >
使用Java语言连接MongoDB，实现数据查询

（1）找出年龄小于20岁的所有学生
（2）找出年龄小于20岁且是软件学院的学生
（3）找出学生关系中的所有学生
（4）求所有学生的姓名、年龄
（5）找出年龄小于20岁的学生的姓名、性别
（6）检索所有课程情况
（7）检索先行课号为“300001”的课程名
（8）找出年龄大于50岁的老师
（9）找出所有的男老师
（10）找出所有在CS学院的老师
</textarea>
<table>
    <tr>
        <th>id</th>
        <th>书名</th>
        <th>作者</th>
    </tr>
    <c:forEach items="${students}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.bookName}</td>
            <td>${sth.author}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>