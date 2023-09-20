package com.example.demo4;
import sun.security.util.Password;

import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet{


    User usr =new User();

    PreparedStatement ps = null;
    Connection ct = null;
    ResultSet rs = null;

    String url = "jdbc:sqlserver://192.168.16.27:1433;databaseName=suxcc_dev";
    String user = "suxcc_dev";
    String pwd = "suxcc_dev";



    public void init(){

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

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //usr.setLoginname(request.getParameter("UserName"));
        //usr.setPassword(request.getParameter("PassWord"));

//        PrintWriter out = response.getWriter();


        String realPd="";
        String Nm=request.getParameter("UserName");
        String Pd=request.getParameter("PassWord");




        //System.out.println(Nm);
        //System.out.println(Pd);
        usr.setLoginname((String) Nm);
        usr.setPassword((String) Pd);

        //System.out.println(usr.getLoginname());
        //System.out.println(usr.getPassword());

        try{
            Statement stmt = ct.createStatement();
            String sql   = "select * from t_staff_jinm WHERE loginname ='"+Nm+"'";

            rs = stmt.executeQuery(sql);


            if(rs==null){
                request.getRequestDispatcher("/error.jsp").forward(request,response);
                // go to error

            } else {
                rs.next();
                realPd = rs.getString("password");

                if(realPd.equals(usr.getPassword())){
                    //request.getRequestDispatcher("/listuser.jsp").forward(request,response);
                    //go tolist
                }
                else{
                    request.getRequestDispatcher("/error.jsp").forward(request,response);
                    //go to error
                }
            }

            String LOGINNAME=rs.getString("loginname");
            //String PASSWORD=rs.getString("password");
            String SEX=rs.getString("sex");
            String ADDRESS=rs.getString("address");
            request.setAttribute("LoginName", LOGINNAME);
            //request.setAttribute("PassWord", PASSWORD);
            request.setAttribute("Sex", SEX);
            request.setAttribute("Address", ADDRESS);
            request.getRequestDispatcher("listuser.jsp").forward(request, response);
            return;




        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error :<");
        }
    }//jsp data passing


}

//    SELECT password from t_staff_jinm
//    WHERE loginname = '敏'
//
//
//
//    insert into t_staff_jinm VALUES
//        ('考林','244413','1','地球')
