package com.akk.o2o.service.impl;

import com.akk.o2o.dao.ShopDao;
import com.akk.o2o.dto.ShopExecution;
import com.akk.o2o.ecxeptions.ShopOperationException;
import com.akk.o2o.entity.Shop;
import com.akk.o2o.enums.ShopStateEnum;
import com.akk.o2o.service.ShopService;
import com.akk.o2o.util.FileUtil;
import com.akk.o2o.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;


	@Override
	@Transactional
	/**
	 * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
	 * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
	 * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
	 */
	public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException {
		//1.空值判断
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
		}
		try {
			//2.给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//3.执行插入操作
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			} else {
				try {
					//存储图片到相应的店铺图片文件夹
					if (shopImgInputStream != null) {
						addShopImg(shop, shopImgInputStream, fileName);
						effectedNum = shopDao.updateShop(shop);
						if (effectedNum <= 0) {
							throw new ShopOperationException("创建图片地址失败");
						}
					}
				} catch (Exception e) {
					throw new ShopOperationException("addShopImg error: "
							+ e.getMessage());
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("insertShop error: " + e.getMessage());
		}
        return new ShopExecution(ShopStateEnum.CHECK, shop);
	}

	private void addShopImg(Shop shop, InputStream shopImg, String fileName) {
		String dest = FileUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, fileName, dest);
		shop.setShopImg(shopImgAddr);
	}

}
