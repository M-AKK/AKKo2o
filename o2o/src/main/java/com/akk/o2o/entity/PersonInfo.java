package com.akk.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @author: Created by Akk_Mac
 * @Date: 2017/12/21 16:58
 */
@Data
public class PersonInfo {

    private Long userId;
    private String name;
    private Date birthday;
    /**
     * 性别
     */
    private String gender;
    private String phone;
    private String email;
    private String profileImg;
    /**
     * 用户类型：1.顾客；2.店家；3.超级管理员
     */
    private Integer userType;
    /*private Integer customerFlag;
    private Integer shopOwnerFlag;
    private Integer adminFlag;*/
    private Date createTime;
    private Date lastEditTime;
    /**
     * 账号状态，可以禁用
     */
    private Integer enableStatus;
}
