package com.example.demo4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
@WebServlet(name = "addServlet", value = "/addServlet")
public class addServlet extends HttpServlet {
    PreparedStatement ps = null;
    Connection ct = null;
    ResultSet xt = null;
    ResultSet rs = null;
    String url = "jdbc:sqlserver://192.168.16.27:1433;databaseName=suxcc_dev";
    String user = "suxcc_dev";
    String pwd = "suxcc_dev";


    @Override
    public void init() {
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
        String NewName = request.getParameter("userName");
        String NewPassWord = request.getParameter("PassWord");
        String NewGender = request.getParameter("Gender");
        String NewAddress = request.getParameter("Address");
        String NewSex = "0";
        try{

            Statement stmt = ct.createStatement();
            String exsitionsql = "select loginname from t_staff_jinm\n"+"where loginname = '"+NewName+"'";

            xt = stmt.executeQuery(exsitionsql);


        if(!(xt==null)){
            if(NewGender.equals("男")){
                NewSex = "1";

            }else{
                NewSex = "0";
            }
            String sql   = "insert into t_staff_jinm VALUES('"+NewName+"','"+NewPassWord+"','"+NewSex+"','"+NewAddress+"')";
            stmt.executeUpdate(sql);
            request.getRequestDispatcher("/listuser.jsp").forward(request,response);
        }






        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error :<");
        }

    }


}
