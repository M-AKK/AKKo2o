package com.akk.o2o.dto;

import com.akk.o2o.entity.Shop;
import com.akk.o2o.enums.ShopStateEnum;
import lombok.Data;

import java.util.List;

/**
 * 封装执行后结果
 */
@Data
public class ShopExecution {

	// 结果状态
	private int state;

	// 状态标识
	private String stateInfo;

	// 店铺数量
	private int count;

	// 操作的shop（增删改店铺的时候用）
	private Shop shop;

	// 获取的shop列表(查询店铺列表的时候用)
	private List<Shop> shopList;

	public ShopExecution() {
	}

	// 失败的构造器
	public ShopExecution(ShopStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// 成功的构造器
	public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shop = shop;
	}

	// 成功的构造器
	public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopList = shopList;
	}

}