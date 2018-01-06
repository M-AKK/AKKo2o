package com.akk.o2o.service;

import com.akk.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @Description: 商品分类service
 * @author: Created by Akk_Mac
 * @Date: 2018/1/5 16:59
 */
public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
