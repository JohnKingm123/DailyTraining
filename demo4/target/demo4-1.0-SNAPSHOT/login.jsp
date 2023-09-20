<%--
  Created by IntelliJ IDEA.
  User: sux19
  Date: 2023/9/11
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <div id="loginContainer">
        <form action="loginServlet" <%--method = "post"--%>>
            <div class ="main">
                <div>
                    <lable>UserName</lable>
                <input type ="text" name = "UserName" value = "">
                </div>
                <div>
                    <lable>PassWord</lable>

                    <input name = "PassWord" value = "">
                </div>
                <div>
                    <input  type="submit" value = "login"><%--                    //to listuser or error--%>
                </div>
            </div>
        </form>
            <div class ="main">
                <div>
                    <button onclick="window.location.href='add.jsp';">register</button><%--                    // to regiser--%>
                </div>
            </div>
    </div>
</body>
</html>
