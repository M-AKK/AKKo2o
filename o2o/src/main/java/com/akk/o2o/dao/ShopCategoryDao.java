package com.akk.o2o.dao;

import com.akk.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 商品类别
 * @author: Created by Akk_Mac
 * @Date: 2018/1/5 15:58
 */
public interface ShopCategoryDao {

    /**
     * 查找商品类别
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
