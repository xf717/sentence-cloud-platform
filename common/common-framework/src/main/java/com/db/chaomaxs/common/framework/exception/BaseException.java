package com.db.chaomaxs.common.framework.exception;

/**
 * 参考 https://www.kancloud.cn/onebase/ob/484204 文章
 * <p>
 * 一共 10 位，分成四段
 * <p>
 * 第一段，1 位，类型 1 - 业务级别异常 2 - 系统级别异常
 * <p>
 * 第二段，3 位，系统类型
 *        001 - 服务鉴权
 *        002 - 网关服务
 *        003 - 系统管理服务
 *        004 - 应用中心服务
 *        005 - 资源中心服务
 *        006 - 模型管理服务
 *        ... - ......
 *
 * 第三段，3 位，模块
 *    不限制规则。
 *		一般建议，每个系统里面，可能有多个模块，可以再去做分段。以应用中心为例子
 *	 001 - 	应用管理模块
 *	 002 - 立即体验模块
 *	 003 - 接口管理模块
 *	 ... - ...
 *
 * 第四段，3 位，错误码
 *    不限制规则
 *    一般建议，每个模块自增。
 *
 *
 * @author xiaofeng
 * @date 2017/9/8
 */
public class BaseException extends RuntimeException {

  private int status = 200;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public BaseException() {
  }

  public BaseException(String message, int status) {
    super(message);
    this.status = status;
  }

  public BaseException(String message) {
    super(message);
  }

  public BaseException(String message, Throwable cause) {
    super(message, cause);
  }

  public BaseException(Throwable cause) {
    super(cause);
  }

  public BaseException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
