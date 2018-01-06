package com.akk.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 店铺类别实体类
 * @author: Created by Akk_Mac
 * @Date: 2017/12/21 17:15
 */
@Data
public class ShopCategory {

	private Long shopCategoryId;
	private String shopCategoryName;
	private String shopCategoryDesc;
	private String shopCategoryImg;
	/**
	 * 权重
	 */
	private Integer priority;
	private Date createTime;
	private Date lastEditTime;
	/**
	 * 上级id
	 */
	private ShopCategory parent;

}
