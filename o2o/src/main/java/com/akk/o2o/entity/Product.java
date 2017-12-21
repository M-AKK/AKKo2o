package com.akk.o2o.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description: 商品实体类
 * @author: Created by Akk_Mac
 * @Date: 2017/12/21 17:15
 */
@Data
public class Product{

	private Long productId;
	private String productName;
	private String productDesc;

    /**
     * 简略图
     */
	private String imgAddr;

    /**
     * 原价
     */
	private String normalPrice;

    /**
     * 折扣价
     */
	private String promotionPrice;

    /**
     * 权重
     */
	private Integer priority;
	private Date createTime;

    /**
     * 最近的更新时间
     */
	private Date lastEditTime;

    /**
     * 0下架；1可用
     */
	private Integer enableStatus;

    /**
     * 商品详情列表，1对N的关系，一个商品拥有好几张展示图片
     */
	private List<ProductImg> productImgList;

    /**
     * 商品类别
     */
	private ProductCategory productCategory;

    /**
     * 所属店铺
     */
	private Shop shop;



}
