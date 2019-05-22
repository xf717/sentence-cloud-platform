package com.maruko.mall.common.msg.auth;

import com.maruko.mall.common.constant.RestCodeConstants;
import com.maruko.mall.common.msg.BaseResponse;

/**
 * Created by ace on 2017/8/23.
 */
public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
