package com.example.iablogbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tb_permission")
public class Permission {

    @Id
    @GeneratedValue
    @Column(name = "permission_id")
    private long permissionId;  // 主键.

    @Column(name = "permission_name")
    private String permissionName;  // 权限名称,如 user:select

    @Column(name = "description")
    private String description; // 权限描述,用于UI显示

    @Column(name = "url")
    private String url; // 权限地址.

    @JsonIgnoreProperties(value = {"permissions"})
    @ManyToMany
    @JoinTable(
            name = "tb_role_permission",
            joinColumns = {@JoinColumn(name = "permission_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;   // 一个权限可以被多个角色使用
}
