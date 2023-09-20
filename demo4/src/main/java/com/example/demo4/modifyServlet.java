package com.example.demo4;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "modifyServlet",value = "/modifyServlet")
public class modifyServlet extends HttpServlet {
    PreparedStatement ps = null;
    Connection ct = null;
    int rs = 0;//UPGRADE complete or not
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
        String Nm = request.getParameter("UserName");
        String Pd = request.getParameter("PassWord");
        String Ge = request.getParameter("Gender");
        String Ad = request.getParameter("Address");
        String Se = "1";

        if(Ge.equals("男")){
            Se="1";
        }else{
            Se="0";
        }

        try{
            String sql   = "update t_staff_jinm set loginname ='"+Nm+"',password='"+Pd+"',sex='"+Se+"' ,address='"+Ad+"' WHERE loginname ='"+Nm+"';";
            ps= ct.prepareStatement(sql);
            rs = ps.executeUpdate();
            request.getRequestDispatcher("/login.jsp").forward(request,response);




        //hold on


    }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error :<");

        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
