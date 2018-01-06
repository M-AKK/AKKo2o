package com.akk.o2o.ecxeptions;

/**
 * @Description:
 * @author: Created by Akk_Mac
 * @Date: 2017/12/22 20:31
 */
public class ShopOperationException extends RuntimeException {

    private static final long serialVersionUID = 6770293880802178460L;

    public ShopOperationException(String msg) {
        super(msg);
    }
}
