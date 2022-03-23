package cn.edu.zust.se.model;

import lombok.Data;

import java.util.Date;

@Data
public class Picture {
    private int id;
    private String name;
    private String fname;
    private int user_id;
    private String intro;
    private String tags;
    private Date upload_time;
    private int click_num;
}
