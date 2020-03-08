package com.example.iablogbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tb_role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private long roleId;    // 主键.

    @Column(name = "role_name")
    private String roleName;    // 角色名称,如 admin/user

    @Column(name = "description")
    private String description; // 角色描述,用于UI显示

    // 角色 -- 权限关系：多对多
    @JsonIgnoreProperties(value = {"roles"})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_role_permission",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private List<Permission> permissions;

    // 用户 -- 角色关系：多对多
    @JsonIgnoreProperties(value = {"roles"})
    @ManyToMany
    @JoinTable(
            name = "tb_user_role",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )

    private List<User> users;   // 一个角色对应多个用户
}
