package cn.edu.zust.se.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Proxy(lazy = false)
@Setter
@Getter
@Entity
@Table(name = "tuser")
public class Tuser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String login_name;
    @Column
    private String real_name;
    @Column
    private String password;
    @Column
    private String tel;
    @Column
    private String email;
    @Column
    private Integer type;
    @Column
    private Date last_login_time;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "equipmentuser")
    private List<Tequipment> tequipment;
}
