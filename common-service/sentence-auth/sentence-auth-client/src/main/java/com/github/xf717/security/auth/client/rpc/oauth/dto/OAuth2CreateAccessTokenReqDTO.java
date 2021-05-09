package com.github.xf717.security.auth.client.rpc.oauth.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 访问令牌创建 REQUEST DTO
 *
 * @author xiaofeng
 */
@Data
@Accessors(chain = true)
public class OAuth2CreateAccessTokenReqDTO implements Serializable {

  private static final long serialVersionUID = 3288942822195931711L;
  private String username;
  private String userId;
  private String name;

}
