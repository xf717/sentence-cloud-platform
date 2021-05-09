package com.db.chaomaxs.security.auth.client.rpc.oauth.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 返回一些数据，用于业务操作
 *
 * @author xiaofeng
 */
@Data
@Accessors(chain = true)
public class OAuth2CreateAccessTokenRespDTO implements Serializable {

  private static final long serialVersionUID = -2148919375313832047L;
  private String userId;
  private String name;
  private String tokenId;
  private String token;

}
