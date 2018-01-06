package com.akk.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 判断验证码是否正确
 * @author: Created by Akk_Mac
 * @Date: 2018/1/5 20:39
 */
public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request) {
        String verifyCodeExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = HttpServletRequestUtil.getString(request,
                "verifyCodeActual");
        if (verifyCodeActual == null
                || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}
