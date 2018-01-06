package com.akk.o2o.service;

import com.akk.o2o.BaseTest;
import com.akk.o2o.dto.ShopExecution;
import com.akk.o2o.entity.Area;
import com.akk.o2o.entity.PersonInfo;
import com.akk.o2o.entity.Shop;
import com.akk.o2o.entity.ShopCategory;
import com.akk.o2o.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;

	@Test
	public void testAddShop() throws Exception {
		Shop shop = new Shop();

		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shop.setOwner(owner);
		Area area = new Area();
		area.setAreaId(1);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(1L);
		shop.setShopName("测试店铺");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		shop.setShopImg("test1");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(sc);
        File shopImg = new File("/Users/Akk_mac/E_pan/IntelliJidea Project File/SpringBoot项目/o2o/images/item/headtitle/2017061320315746624.jpg");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}

}
