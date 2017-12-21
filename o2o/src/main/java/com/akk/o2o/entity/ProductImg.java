package com.akk.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 商品图片实体类，商品的详情图片
 * @author: Created by Akk_Mac
 * @Date: 2017/12/21 17:15
 */
@Data
public class ProductImg {

	private Long productImgId;

	/**
	 * 图片地址
	 */
	private String imgAddr;
	private String imgDesc;

	/**
	 * 权重
	 */
	private Integer priority;
	private Date createTime;
	private Long productId;

}
