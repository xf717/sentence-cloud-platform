package com.maruko.mall.common.exception.auth;


import com.maruko.mall.common.constant.CommonConstants;
import com.maruko.mall.common.exception.BaseException;

/**
 * Created by ace on 2017/9/8.
 */
public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
