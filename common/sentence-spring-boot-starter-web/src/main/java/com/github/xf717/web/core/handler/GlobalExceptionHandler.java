package com.github.xf717.web.core.handler;

import static com.github.xf717.common.framework.exception.enums.GlobalErrorCodeConstants.BAD_REQUEST;
import static com.github.xf717.common.framework.exception.enums.GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR;

import com.github.xf717.common.framework.exception.BaseException;
import com.github.xf717.common.framework.exception.GlobalException;
import com.github.xf717.common.framework.exception.ServiceException;
import com.github.xf717.common.framework.exception.auth.ClientTokenException;
import com.github.xf717.common.framework.exception.auth.UserInvalidException;
import com.github.xf717.common.framework.exception.auth.UserTokenException;
import com.github.xf717.common.framework.exception.enums.GlobalErrorCodeConstants;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.util.ExceptionUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理器
 *
 * @author xiaofeng
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Value("${spring.application.name}")
  private String applicationName;

  /**
   * 客户端TOKEN 异常
   *
   * @param response
   * @param ex
   * @return
   */
  @ExceptionHandler(ClientTokenException.class)
  public BaseResponse clientTokenExceptionHandler(HttpServletResponse response,
      ClientTokenException ex) {
    logger.error("[clientTokenExceptionHandler]", ex.getMessage(), ex);
    return BaseResponse.error(GlobalErrorCodeConstants.FORBIDDEN.getCode(), ex.getMessage());
  }

  /**
   * 用户TOKEN 异常
   *
   * @param response
   * @param ex
   * @return
   */
  @ExceptionHandler(UserTokenException.class)
  public BaseResponse userTokenExceptionHandler(HttpServletResponse response,
      UserTokenException ex) {
    logger.error("[userTokenExceptionHandler]", ex.getMessage(), ex);
    return BaseResponse.error(GlobalErrorCodeConstants.UNAUTHORIZED.getCode(), ex.getMessage());
  }

  /**
   * 用户验证异常
   *
   * @param response
   * @param ex
   * @return
   */
  @ExceptionHandler(UserInvalidException.class)
  public BaseResponse userInvalidExceptionHandler(HttpServletResponse response,
      UserInvalidException ex) {
    response.setStatus(200);
    logger.error("[userInvalidExceptionHandler]", ex.getMessage(), ex);
    return BaseResponse.error(ex.getStatus(), ex.getMessage());
  }

  /**
   * 基础异常
   *
   * @param response
   * @param ex
   * @return
   */
  @ExceptionHandler(BaseException.class)
  public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
    logger.error("[baseExceptionHandler]", ex.getMessage(), ex);
    return new BaseResponse(ex.getStatus(), ex.getMessage());
  }

  /**
   * Spring MVC 参数异常 例如说，接口上设置了 @RequestParam("xx") 参数，结果并未传递 xx 参数
   *
   * @param response
   * @param ex
   * @return
   */
  @ExceptionHandler(value = MissingServletRequestParameterException.class)
  public BaseResponse missingServletRequestParameterExceptionHandler(HttpServletResponse response,
      MissingServletRequestParameterException ex) {
    logger.warn("[missingServletRequestParameterExceptionHandler]", ex);
    return BaseResponse
        .error(BAD_REQUEST.getCode(), String.format("请求参数缺失:%s", ex.getParameterName()),
            ExceptionUtil.getRootCauseMessage(ex));
  }

  /**
   * 处理 SpringMVC 请求参数类型错误
   * <p>
   * 例如说，接口上设置了 @RequestParam("xx") 参数为 Integer，结果传递 xx 参数类型为 String
   */
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public BaseResponse methodArgumentTypeMismatchExceptionHandler(
      MethodArgumentTypeMismatchException ex) {
    logger.warn("[methodArgumentTypeMismatchExceptionHandler]", ex);
    return BaseResponse.error(BAD_REQUEST.getCode(), String.format("请求参数类型错误:%s", ex.getMessage()),
        ExceptionUtil.getRootCauseMessage(ex));
  }

  /**
   * 处理 SpringMVC 参数校验不正确
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public BaseResponse methodArgumentNotValidExceptionExceptionHandler(
      MethodArgumentNotValidException ex) {
    logger.warn("[methodArgumentNotValidExceptionExceptionHandler]", ex);
    FieldError fieldError = ex.getBindingResult().getFieldError();
    assert fieldError != null; // 断言，避免告警
    return BaseResponse.error(BAD_REQUEST.getCode(),
        String.format("请求参数不正确:%s", fieldError.getDefaultMessage())
        , ExceptionUtil.getRootCauseMessage(ex)
    );
  }

  /**
   * 处理 SpringMVC 参数绑定不正确，本质上也是通过 Validator 校验
   */
  @ExceptionHandler(BindException.class)
  public BaseResponse bindExceptionHandler(BindException ex) {
    logger.warn("[handleBindException]", ex);
    FieldError fieldError = ex.getFieldError();
    assert fieldError != null; // 断言，避免告警
    return BaseResponse
        .error(BAD_REQUEST.getCode(), String.format("请求参数不正确:%s", fieldError.getDefaultMessage()),
            ExceptionUtil.getRootCauseMessage(ex));
  }

  /**
   * 处理 Validator 校验不通过产生的异常
   */
  @ExceptionHandler(value = ConstraintViolationException.class)
  public BaseResponse constraintViolationExceptionHandler(HttpServletResponse response,
      ConstraintViolationException ex) {
    logger.info("[constraintViolationExceptionHandler]", ex);
    ConstraintViolation<?> constraintViolation = ex.getConstraintViolations().iterator().next();
    return BaseResponse
        .error(BAD_REQUEST.getCode(), String.format("请求参数不正确:%s", constraintViolation.getMessage()),
            ExceptionUtil.getRootCauseMessage(ex));
  }

  /**
   * 处理 SpringMVC 请求地址不存在
   * <p>
   * 注意，它需要设置如下两个配置项： 1. spring.mvc.throw-exception-if-no-handler-found 为 true 2.
   * spring.mvc.static-path-pattern 为 /statics/**
   */
  @ExceptionHandler(NoHandlerFoundException.class)
  public BaseResponse noHandlerFoundExceptionHandler(NoHandlerFoundException ex) {
    logger.warn("[noHandlerFoundExceptionHandler]", ex);
    return BaseResponse.error(
        GlobalErrorCodeConstants.NOT_FOUND.getCode(),
        String.format("请求地址不存在:%s", ex.getRequestURL()), ExceptionUtil.getRootCauseMessage(ex));
  }

  /**
   * 处理 SpringMVC 请求方法不正确
   * <p>
   * 例如说，A 接口的方法为 GET 方式，结果请求方法为 POST 方式，导致不匹配
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public BaseResponse httpRequestMethodNotSupportedExceptionHandler(
      HttpRequestMethodNotSupportedException ex) {
    logger.warn("[httpRequestMethodNotSupportedExceptionHandler]", ex);
    return BaseResponse.error(GlobalErrorCodeConstants.METHOD_NOT_ALLOWED.getCode(),
        String.format("请求方法不正确:%s", ex.getMessage()), ExceptionUtil.getRootCauseMessage(ex));
  }

  /**
   * 处理业务异常 ServiceException
   * <p>
   * 例如说，商品库存不足，用户手机号已存在。
   */
  @ExceptionHandler(value = ServiceException.class)
  public BaseResponse serviceExceptionHandler(ServiceException ex) {
    logger.info("[serviceExceptionHandler]", ex);
    return BaseResponse.error(ex.getCode(), ex.getMessage());
  }

  /**
   * 处理全局异常 ServiceException
   * <p>
   * 例如说，请求超时，调用的 远程 服务系统异常
   */
  @ExceptionHandler(value = GlobalException.class)
  public BaseResponse globalExceptionHandler(HttpServletRequest req, GlobalException ex) {
    // 系统异常时，才打印异常日志
    if (INTERNAL_SERVER_ERROR.getCode().equals(ex.getCode())) {
      // 插入异常日志
//      this.createExceptionLog(req, ex);
      // 普通全局异常，打印 info 日志即可
    } else {
      logger.info("[globalExceptionHandler]", ex);
    }
    // 返回 ERROR CommonResult
    return BaseResponse.error(ex);
  }

  /**
   * 处理 Consumer 本地参数校验时，抛出的 ValidationException 异常
   */
  @ExceptionHandler(value = ValidationException.class)
  public BaseResponse validationException(ValidationException ex) {
    logger.warn("[constraintViolationExceptionHandler]", ex);
    // 无法拼接明细的错误信息，因为 Dubbo Consumer 抛出 ValidationException 异常时，是直接的字符串信息，且人类不可读
    return BaseResponse.error(BAD_REQUEST.getCode(), "请求参数不正确",
        ExceptionUtil.getRootCauseMessage(ex));
  }

  @ExceptionHandler(Exception.class)
  public BaseResponse defaultExceptionHandler(HttpServletRequest request,
      HttpServletResponse response, Exception ex) {
    logger.error("[defaultExceptionHandler]", ex);
    // 插入异常日志
//    this.createExceptionLog(req, ex);
    return BaseResponse.error(INTERNAL_SERVER_ERROR.getCode(),
        INTERNAL_SERVER_ERROR.getMessage(), ExceptionUtil.getRootCauseMessage(ex));
  }
}
