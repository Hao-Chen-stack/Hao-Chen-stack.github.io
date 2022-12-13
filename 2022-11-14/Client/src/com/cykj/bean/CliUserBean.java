package com.cykj.bean;

public class CliUserBean {
    private String qqId;
    private String nickname;
    private int age;
    private String password;
    private String address;

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //构造函数
    public CliUserBean(){

    }

    public CliUserBean(String qqId, String nickname, int age, String password, String address) {
        this.qqId = qqId;
        this.nickname = nickname;
        this.age = age;
        this.password = password;
        this.address = address;

    }

    @Override
    public String toString() {
        return "CliUserBean{" +
                "qqId='" + qqId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
