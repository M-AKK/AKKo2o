package com.akk.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @author: Created by Akk_Mac
 * @Date: 2017/12/21 16:33
 */
@Data
public class Area {

    /**
     * Id
     */
    private Long areaId;

    /**
     * 名称
     */
    private String areaName;


    /**
     * 权重
     */
    private Integer priority;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date lastEditTime;
}
