package com.akk.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 本地登录账号，还不知道干吗用的
 * @author: Created by Akk_Mac
 * @Date: 2017/12/21 17:15
 */
@Data
public class LocalAuth {

    private Long localAuthId;
    private String userName;
    private String password;
    private Long userId;
    private Date createTime;
    private Date lastEditTime;
    private PersonInfo personInfo;
}
