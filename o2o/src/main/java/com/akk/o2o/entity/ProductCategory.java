package com.akk.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 商品类别实体类
 * @author: Created by Akk_Mac
 * @Date: 2017/12/21 17:15
 */
@Data
public class ProductCategory {

	private Long productCategoryId;
	private Long shopId;
	private String productCategoryName;

	/**
	 * 权重
	 */
	private Integer priority;
	private Date createTime;

}
