package com.akk.o2o.service;

import com.akk.o2o.dto.ShopExecution;
import com.akk.o2o.ecxeptions.ShopOperationException;
import com.akk.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * 店铺操作service
 */
public interface ShopService {

	/**
	 * 创建商铺
	 * @param Shop shop
	 * @return ShopExecution shopExecution
	 * @throws Exception
	 */
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String FileName) throws ShopOperationException;



}
