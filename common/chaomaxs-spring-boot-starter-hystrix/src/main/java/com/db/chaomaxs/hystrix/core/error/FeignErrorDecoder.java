package com.db.chaomaxs.hystrix.core.error;

import com.db.chaomaxs.common.framework.exception.GlobalException;
import com.db.chaomaxs.common.framework.exception.ServiceException;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.util.mapper.JsonMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.nio.charset.Charset;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StreamUtils;

/**
 * FeignErrorDecoder
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/21 20:23
 */
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

  @Override
  public Exception decode(String methodKey, Response response) {
    if (response.status() != HttpStatus.OK.value()) {
      log.info("methodKey: {}", methodKey);
      log.info("status: {}", response.status());
      try {
        String content = StreamUtils
            .copyToString(response.body().asInputStream(), Charset.defaultCharset());
        log.info("content: {}", content);
        BaseResponse baseResponse = JsonMapper.INSTANCE.fromJson(content, BaseResponse.class);
        return new ServiceException(baseResponse.getCode(), baseResponse.getMessage());
      } catch (IOException e) {
        log.error("decode异常：{}", e.getMessage());
        e.printStackTrace();
      }
    }
    return new GlobalException(500, "FeignErrorDecoder 自定义异常错误!");
  }
}
