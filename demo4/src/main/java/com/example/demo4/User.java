package com.example.demo4;

public class User {
    private  int id=0;
    private  String loginname ="";
    private  String password = "";
    private  String gender = "";
    private  String address = "";

    public void User(){

    }

    public void setId(int a){
        this.id = a;
    }
    public void setLoginname(String a){
        this.loginname = a;
    }
    public void setPassword(String a){
        this.password = a;
    }
    public void setGender(String a){
        this.gender = a;
    }
    public void setAddress(String a){
        this.address = a;
    }


    public int getId(){
        return id;
    }

    public  String getLoginname(){
        return loginname;
    }

    public  String getPassword(){
        return password;
    }
    public  String getGender(){
        return gender;
    }
    public  String getAddress(){
        return address;
    }

}
