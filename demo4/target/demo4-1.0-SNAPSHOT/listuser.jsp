<%@ page import="com.example.demo4.User" %>
<%@ page import ="java.sql.*"%>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: sux19
  Date: 2023/9/11
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script type = "text/javascript">--%>
<%--    function sb (){--%>
<%--        document.autoform0.action = "listServlet";--%>
<%--        document.autoform0.submit();--%>
<%--    }--%>

<%--</script>--%>
<html>
<head>
    <title>Listuser</title>
</head>
<body>    <h1>Listuser</h1>
    <div>
        <%
            out.println("LoginName");
            String data0=(String)request.getAttribute("LoginName");
            out.println(data0);
            out.println("Gender");
            String data1=(String)request.getAttribute("Sex");
            if(data1.equals("1")){
                out.println("男");
            }else{
                out.println("女");
            }
            out.println("Address");
            String data2=(String)request.getAttribute("Address");
            out.println(data2);


            session.setAttribute("LoginName",data0);
            session.setAttribute("Sex",data1);
            session.setAttribute("Address",data2);
        %>

<%--        <form action = "listServlet" name="autoform0">--%>
<%--            <%String s =(String)request.getAttribute(Nm) %>--%>
<%--            <input type="text" name="NNN" value=s>--%>

<%--        <script text="javascript">--%>
<%--            sb();--%>
<%--        </script>--%>
        <div>
            <button onclick="window.location.href='login.jsp';">logout</button>       <%--//to login--%>
            <button onclick="window.location.href='mod.jsp';">modify</button>            <%--//to mod--%>
        </div>
    </div>


</body>
</html>
