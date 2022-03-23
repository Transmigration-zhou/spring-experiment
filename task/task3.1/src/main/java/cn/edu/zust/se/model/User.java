package cn.edu.zust.se.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String intro;
    private String gender;
    private String province;
    private String city;
    private Date regist_time;
    private String type;
    private String email;
    private String mobile;
    private String QQ;
    private String status;
}
