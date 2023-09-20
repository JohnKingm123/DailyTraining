<%--
  Created by IntelliJ IDEA.
  User: sux19
  Date: 2023/9/11
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h1>Register</h1>
<div id ="registerContainer">
    <form action = "addServlet" >
<%--            action="registerServlet" method = "post">--%>
        <div class ="main">
            <div>
                <lable>UserName</lable>

                <input name = "userName" value = "">
            </div>
            <div>
                <lable>PassWord</lable>

                <input name = "PassWord" value = "">
            </div>

            <div>
                <lable>Gender</lable>

                <input name = "Gender" value = "">"男"或"女"
            </div>

            <div>
                <lable>Address</lable>

                <input name = "Address" value = "">
            </div>

            <div>
                <input type = "submit" value = "New_User"><%--                // to the listuser--%>
            </div>


        </div>

    </form>
    <div>
        <button id = "cancel" onclick = "window.location.href='login.jsp';">cancel</button>
    </div>

</div>


</body>
</html>
