package com.github.xf717.security.gate.service;

import com.github.xf717.common.framework.vo.log.LogInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author xiaofeng
 * @create 2020/7/23.
 */
@Component
@Slf4j
public class LogServiceImpl implements LogService {

  @Autowired
  private WebClient.Builder webClientBuilder;

  @Override
  public void saveLog(LogInfo info) {
    Mono<Void> mono = webClientBuilder.build().
        post().uri("http://ace-admin/api/log/save").body(BodyInserters.fromValue(info)).retrieve()
        .bodyToMono(Void.class);
    // 输出结果
    log.debug(String.valueOf(mono.block()));
  }
}
