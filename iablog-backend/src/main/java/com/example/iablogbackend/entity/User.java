package com.example.iablogbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;    // 主键

    @Column(name = "user_name", unique = true)
    private String userName;    // 登录账户,唯一.

    @Column(name = "name_to_show")
    private String nameToShow;  // 名称(匿名或真实姓名),用于UI显示

    @Column(name = "password")
    private String password;    //密码

    @JsonIgnoreProperties(value = {"users"})
    @ManyToMany(fetch = FetchType.EAGER)    // 立即从数据库中进行加载数据
    @JoinTable(
            name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;   // 一个用户具有多个角色
}
