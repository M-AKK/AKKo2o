package com.akk.o2o.web.shop;

import com.akk.o2o.dto.ShopExecution;
import com.akk.o2o.ecxeptions.ShopOperationException;
import com.akk.o2o.entity.PersonInfo;
import com.akk.o2o.entity.Shop;
import com.akk.o2o.enums.ShopStateEnum;
import com.akk.o2o.service.ShopService;
import com.akk.o2o.util.CodeUtil;
import com.akk.o2o.util.FileUtil;
import com.akk.o2o.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopManagementController {
	@Autowired
	private ShopService shopService;

	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}
		//1.接收并转换相应的参数，包括店铺信息以及图片信息
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }

		MultipartHttpServletRequest multipartRequest = null;
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			multipartRequest = (MultipartHttpServletRequest) request;
			shopImg = (CommonsMultipartFile) multipartRequest
					.getFile("shopImg");
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "上传图片不能为空");
			return modelMap;
		}

		// 2.注册店铺
		if (shop != null && shopImg != null) {
		    // 可以直接从session获取注册信息

				PersonInfo user = new PersonInfo();
				user.setUserId(1L);
				shop.setOwner(user);
                /*File shopImgFile = new File(FileUtil.getImgBasePath() + FileUtil.getRandomFileName());
                try {
                    shopImgFile.createNewFile();
                } catch (IOException e) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", e.getMessage());
                    return modelMap;
                }*/
                /*try {
                    inputStreamToFile(shopImg.getInputStream(), shopImgFile);
                } catch (IOException e) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", e.getMessage());
                    return modelMap;
                }*/
                ShopExecution se;
                try {
                    se = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
                    // 如果是创建成功就是待审核的状态
                    if (se.getState() == ShopStateEnum.CHECK.getState()) {
                        modelMap.put("success", true);

                    } else {
                        modelMap.put("success", false);
                        // getStateInfo返回状态对应的注释
                        modelMap.put("errMsg", se.getStateInfo());
                    }
                } catch (ShopOperationException e) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", e.getMessage());
                } catch (IOException e) {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", e.getMessage());
                }
                return modelMap;
			} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入店铺信息");
			return modelMap;
		}
		// 3.返回结果

	}

    /**
     * 把CommonsMultipartFile通过inputstream转换成File类型
     * @param ins
     * @param file
     */
    /*private static void inputStreamToFile(InputStream ins, File file) {
        FileOutputStream os = null;
        try{
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while((bytesRead = ins.read(buffer)) != -1) {
                os.write(buffer,0, bytesRead);
            }
        } catch (Exception e) {
            throw new RuntimeException("调用inputStreamToFile产生异常："+e.getMessage());
        } finally {
            try {
                if(os != null) {
                    os.close();
                }
                if(ins != null) {
                    ins.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("inputStreamToFile关闭io产生异常："+e.getMessage());
            }
        }
    }*/

}
