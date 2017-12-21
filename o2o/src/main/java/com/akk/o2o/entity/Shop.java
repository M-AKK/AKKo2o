package com.akk.o2o.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description: 店铺实体类
 * @author: Created by Akk_Mac
 * @Date: 2017/12/21 17:15
 */
@Data
public class Shop {

	private Long shopId;

	/**
	 * 谁创建的
	 */
	private PersonInfo owner;
	private String shopName;
	private String shopDesc;
	private String shopAddr;
	private String phone;
	private String shopImg;

	/**
	 * 权重
	 */
	private Integer priority;

	private Date createTime;
	private Date lastEditTime;
	/**
	 * 状态：1不可用；2审核中；3可用
	 */

	private Integer enableStatus;
	/**
	 * 超级管理员给店家的建议
	 */
	private String advice;

	private Area area;

	/**
	 * 店铺类别
	 */
	private ShopCategory shopCategory;


}
