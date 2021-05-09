package com.github.xf717.systemservice.rpc.auth.dto;

import lombok.Data;

/**
 * @author xiaofeng
 * @create 2020/7/17.
 */
@Data
public class AccessInterfaceRespDTO {

  String path;
  String method;
}
