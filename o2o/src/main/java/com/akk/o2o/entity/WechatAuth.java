package com.akk.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 微信账号实体类
 * @author: Created by Akk_Mac
 * @Date: 2017/12/21 17:12
 */
@Data
public class WechatAuth {

    /**
     * 主Id
     */
    private Long wechatAuthId;
    /*private Long userId;*/
    private String openId;
    private Date createTime;
    private PersonInfo personInfo;
}
