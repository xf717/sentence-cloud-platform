package com.maruko.mall.common.exception.auth;


import com.maruko.mall.common.constant.CommonConstants;
import com.maruko.mall.common.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class ClientTokenException extends BaseException {
    public ClientTokenException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
