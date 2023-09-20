<%--
  Created by IntelliJ IDEA.
  User: sux19
  Date: 2023/9/11
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="jdk.nashorn.internal.runtime.ECMAException" %>

<html>
<head>
    <title>test</title>
</head>
<body>
    <h1>Just A Test</h1>
    <%
      PreparedStatement ps = null;
      Connection ct = null;
      ResultSet rs = null;

      String url = "jdbc:sqlserver://192.168.16.27:1433;databaseName=suxcc_dev";
      String user = "suxcc_dev";
      String pwd = "suxcc_dev";

      try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          System.out.println("Driver Done");
      }
      catch (Exception e){
          e.printStackTrace();
          System.out.println("Driver Failed :<");
      }//Driver

      try {
          ct=DriverManager.getConnection(url,user,pwd);
          System.out.println("Connection Done");
      }
      catch (Exception e){
          e.printStackTrace();
          System.out.println("Connection failed :<");
      }//connection




        try{
            Statement stmt = ct.createStatement();
            String sql = "select * from t_staff_jinm where name == '炘'";

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("loginname");
                int gender = rs.getInt("sex");
                String address = rs.getString("address");

                System.out.println(id + name + gender + address);
                if(rs==null){
                    rs.close();
                    rs=null;
                }
                if(stmt==null){
                    stmt.close();
                    stmt=null;
                }

                if(ct==null){
                    ct.close();
                    ct=null;
                }

            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error :<");
        }





    %>

</body>
</html>
