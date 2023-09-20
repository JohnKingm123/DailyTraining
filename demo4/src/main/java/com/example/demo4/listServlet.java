///*ABANDONED*/
package com.example.demo4;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "listServlet",value = "/listServlet")
public class listServlet extends HttpServlet {
    PreparedStatement ps = null;
    Connection ct = null;
    ResultSet rs = null;
    String url = "jdbc:sqlserver://192.168.16.27:1433;databaseName=suxcc_dev";
    String user = "suxcc_dev";
    String pwd = "suxcc_dev";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver Done");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Driver Failed :<");
        }//Driver

        try {
            ct= DriverManager.getConnection(url,user,pwd);
            System.out.println("Connection Done");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Connection failed :<");
        }//connection
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{

            Statement stmt = ct.createStatement();
            String Nm=request.getParameter("NNN");
            String sql   = "select * from t_staff_jinm WHERE loginname ='"+Nm+"'";


            rs = stmt.executeQuery(sql);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String N = rs.getString("loginname");
            String A = rs.getString("address");
            out.println("<div>"+"Name:");
            out.println(N+"</div>");
            out.println("<div>"+"Gender:");
            if(rs.getString("sex").equals("1")){
                out.println("男"+"</div>");
            }else{
                out.println("女"+"</div>");
            }
            out.println("<div>"+"Address:");
            out.println(A+"</div>");

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error :<");
        }




        //hold on


    }

    @Override
    public void destroy() {
        super.destroy();
    }
}