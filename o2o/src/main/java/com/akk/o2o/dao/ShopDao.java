package com.akk.o2o.dao;

import com.akk.o2o.entity.Shop;

/**
 * @Description:
 * @author: Created by Akk_Mac
 * @Date: 2017/12/22 19:14
 */
public interface ShopDao {

    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     *
     * @param shop
     * @return effectedNum
     */
    int updateShop(Shop shop);
}
