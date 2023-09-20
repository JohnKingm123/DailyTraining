<%--
  Created by IntelliJ IDEA.
  User: sux19
  Date: 2023/9/11
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>modify</title>
</head>
<body>
<h1>Modify</h1>
<div>
    <form action="modifyServlet" >
        <div class ="main">
            <div>
                <lable>UserName</lable>

                <input name = "UserName" value = "">
            </div>
            <div>
                <lable>PassWord</lable>

                <input name = "PassWord" value = "">
            </div>

            <div>
                <lable>Gender</lable>

                <input name = "Gender" value = "">
            </div>

            <div>
                <lable>Address</lable>

                <input name = "Address" value = "">
            </div>

            <div>
                <button id = "confirm">confirm</button>              <%--// to the listuser with change--%>
            </div>
        </div>
    </form>
    <div>
        <button id = "cancel" onclick = "window.location.href='login.jsp';">cancel</button>
    </div>

</div>



</body>
</html>
