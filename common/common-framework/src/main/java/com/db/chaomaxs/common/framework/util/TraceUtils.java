package com.db.chaomaxs.common.framework.util;

import java.util.UUID;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;

/**
 * 链路跟踪工具
 *
 * @author xiaofeng
 */
public class TraceUtils {

  /**
   * 获得链路追踪编号
   * <p>
   * 一般来说，通过链路追踪编号，可以将访问日志，错误日志，链路追踪日志，logger 打印日志等，结合在一起，从而进行排错。
   * <p>
   * 默认情况下，我们使用 Apache SkyWalking 的 traceId 作为链路追踪编号。当然，可能会存在并未引入 Skywalking 的情况，此时使用 UUID 。
   *
   * @return 链路追踪编号
   */
  public static String getTraceId() {
    // 通过 SkyWalking 获取链路编号
    try {
      String traceId = TraceContext.traceId();
      if (StringUtils.hasText(traceId)) {
        return traceId;
      }
    } catch (Throwable ignore) {
    }
    // TODO 多次调用会问题
    return UUID.randomUUID().toString();
  }

}
