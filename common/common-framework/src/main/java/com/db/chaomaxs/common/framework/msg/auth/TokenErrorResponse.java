package com.db.chaomaxs.common.framework.msg.auth;

import com.db.chaomaxs.common.framework.constant.RestCodeConstants;
import com.db.chaomaxs.common.framework.msg.BaseResponse;

/**
 * @author xiaofeng
 * @date 2017/8/23
 */
public class TokenErrorResponse extends BaseResponse {

  public TokenErrorResponse(String message) {
    super(RestCodeConstants.TOKEN_ERROR_CODE, message);
  }
}
