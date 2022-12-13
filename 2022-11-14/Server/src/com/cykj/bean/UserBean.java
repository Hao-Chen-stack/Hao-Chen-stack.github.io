package com.cykj.bean;

public class UserBean {
    //qq用户的账号和密码
    private String qqId;
    private String password;
    private String username;
    private int age;
    private String address;

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //构造函数
    public UserBean() {

    }

    public UserBean(String qqId, String password) {
        this.qqId = qqId;
        this.password = password;
    }
}
