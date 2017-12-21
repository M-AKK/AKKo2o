package com.akk.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 头条实体类
 * @author: Created by Akk_Mac
 * @Date: 2017/12/21 17:15
 */
@Data
public class HeadLine {

	private Long lineId;
	private String lineName;
	private String lineLink;
	private String lineImg;

    /**
     * 权重
     */
	private Integer priority;
    /**
     * 0:不可用；1:可用
     */
	private Integer enableStatus;

	private Date createTime;
	private Date lastEditTime;

}
