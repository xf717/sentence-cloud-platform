package com.db.chaomaxs.security.auth.handler;

import com.db.chaomaxs.common.framework.constant.CommonConstants;
import com.db.chaomaxs.common.framework.exception.BaseException;
import com.db.chaomaxs.common.framework.exception.auth.ClientTokenException;
import com.db.chaomaxs.common.framework.exception.auth.UserInvalidException;
import com.db.chaomaxs.common.framework.exception.auth.UserTokenException;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO 鉴权服务先用着，后面看看有问题在调整,可能会出现BEAN 的问题
 *
 * @author xiaofeng
 * @date 2017/9/8
 */
@ControllerAdvice("com.db.chaomaxs")
@ResponseBody
public class GlobalExceptionHandler {

  private Logger logger = LoggerFactory.getLogger(
      GlobalExceptionHandler.class);

  @ExceptionHandler(ClientTokenException.class)
  public BaseResponse clientTokenExceptionHandler(HttpServletResponse response,
      ClientTokenException ex) {
    response.setStatus(403);
    logger.error(ex.getMessage(), ex);
    return new BaseResponse(ex.getStatus(), ex.getMessage());
  }

  @ExceptionHandler(UserTokenException.class)
  public BaseResponse userTokenExceptionHandler(HttpServletResponse response,
      UserTokenException ex) {
    response.setStatus(401);
    logger.error(ex.getMessage(), ex);
    return new BaseResponse(ex.getStatus(), ex.getMessage());
  }

  @ExceptionHandler(UserInvalidException.class)
  public BaseResponse userInvalidExceptionHandler(HttpServletResponse response,
      UserInvalidException ex) {
    response.setStatus(200);
    logger.error(ex.getMessage(), ex);
    return new BaseResponse(ex.getStatus(), ex.getMessage());
  }

  @ExceptionHandler(BaseException.class)
  public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
    logger.error(ex.getMessage(), ex);
    response.setStatus(500);
    return new BaseResponse(ex.getStatus(), ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public BaseResponse otherExceptionHandler(HttpServletResponse response, Exception ex) {
    response.setStatus(500);
    logger.error(ex.getMessage(), ex);
    return new BaseResponse(CommonConstants.EX_OTHER_CODE, ex.getMessage());
  }

}
