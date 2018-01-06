package com.akk.o2o.dao;

import com.akk.o2o.BaseTest;
import com.akk.o2o.entity.Area;
import com.akk.o2o.entity.PersonInfo;
import com.akk.o2o.entity.Shop;
import com.akk.o2o.entity.ShopCategory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {

	@Autowired
	private ShopDao shopDao;

	@Test
	public void testAInsertShop() throws Exception {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory sc = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		sc.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setShopName("mytest1");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		shop.setShopImg("test1");
		shop.setCreateTime(new Date());
		/*shop.setLastEditTime(new Date());*/
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(sc);
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}

    /*@Test
    public void testDUpdateShop() {
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        Area area = new Area();
        area.setAreaId(1L);
        shop.setArea(area);
        ShopCategoryDao shopCategory = new ShopCategoryDao();
        shopCategory.setShopCategoryId(1L);
        shop.setShopCategory(shopCategory);
        shop.setShopName("四季花");
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
    }*/


}
