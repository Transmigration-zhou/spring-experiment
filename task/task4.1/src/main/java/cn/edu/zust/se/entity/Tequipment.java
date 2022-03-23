package cn.edu.zust.se.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@Entity
@Table(name = "tequipment")
public class Tequipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String code;
    @Column
    private Date add_time;
    @Column
    private Double price;
    @Column
    private String place;
    @Column
    private Integer user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Tuser equipmentuser;
}
