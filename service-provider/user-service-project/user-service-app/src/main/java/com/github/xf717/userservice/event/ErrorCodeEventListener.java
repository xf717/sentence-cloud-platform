package com.github.xf717.userservice.event;

import com.github.xf717.common.framework.exception.ErrorCode;
import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import java.util.Arrays;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaofeng
 */
@Component
public class ErrorCodeEventListener {

  /**
   * 启动时将错误码初始化到内存中 可参考 https://www.cnblogs.com/ssslinppp/p/7607509.html
   */
  @EventListener(ApplicationReadyEvent.class)
  public void loadErrorCodes() {
    Arrays.stream(UserErrorCodeConstants.class.getFields()).forEach(field -> {
      if (field.getType() != ErrorCode.class) {
        return;
      }
      try {
        ErrorCode errorCode = (ErrorCode) field.get(UserErrorCodeConstants.class);
        System.out.println("code==" + errorCode.getCode() + " message==" + errorCode.getMessage());
        ServiceExceptionUtil.put(errorCode.getCode(), errorCode.getMessage());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    });
  }

}
