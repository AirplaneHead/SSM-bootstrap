<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
<div>
    <form id="testForm"  action="/add" method="post">
        <table>
            <tr>
                <td>姓名</td>
                <td><input name="name" type="text" placeholder="请输入姓名" class="easyui-validatebox" data-options="required:true" value="${name}" ></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input name="age" type="text" placeholder="请输入年龄" class="easyui-validatebox" data-options="required:true" value="${age}"></td>
            </tr>
        </table>
        <button type="submit">添加</button>
    </form>
</div>
</body>
</html>
