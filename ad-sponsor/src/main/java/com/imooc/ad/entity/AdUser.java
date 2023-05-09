package com.imooc.ad.entity;


import com.imooc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//这是对应数据库表的数据
@Entity
@Table(name = "ad_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;


    @Column(name = "username",nullable = false)
    @Basic
    private String username;

    @Column(name = "token",nullable = false)
    @Basic
    private String token;

    @Basic
    @Column(name = "user_status", nullable = false)
    private Integer userStatus;

    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

//    正常传入
    public AdUser(String username, String token){
        this.username=username;
        this.token=token;
//        m枚举里面status是常量
        this.userStatus = CommonStatus.VALID.getStatus();
        this.createTime= new Date();
        this.updateTime =this.createTime;
    }

}
