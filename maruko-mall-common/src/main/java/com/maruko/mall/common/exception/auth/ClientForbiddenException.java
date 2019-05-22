package com.maruko.mall.common.exception.auth;


import com.maruko.mall.common.constant.CommonConstants;
import com.maruko.mall.common.exception.BaseException;

/**
 * Created by ace on 2017/9/12.
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
