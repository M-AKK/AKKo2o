package com.akk.o2o.service.impl;

import com.akk.o2o.dao.ShopCategoryDao;
import com.akk.o2o.entity.ShopCategory;
import com.akk.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 商品分类service实现类
 * @author: Created by Akk_Mac
 * @Date: 2018/1/5 17:02
 */

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
