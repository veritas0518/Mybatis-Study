package com.mybatis.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName: User
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/10/10 18:24
 **/
@Alias("hello")
public class User {
    private int id;
    private String NAME;
    private String pwd;

    public User() {
    }

    public User(int id, String NAME, String pwd) {
        this.id = id;
        this.NAME = NAME;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
