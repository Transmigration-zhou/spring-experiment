package cn.edu.zust.se.model;

import lombok.Data;

import java.util.Date;

@Data
public class Concern {
    private int id;
    private int concerner_id;
    private int concerned_id;
    private Date concern_time;
}
