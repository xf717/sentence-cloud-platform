package com.github.xf717.passportweb.service.wx;

import com.github.xf717.passportweb.client.wx.WxMpServiceClient;
import javax.annotation.Resource;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.stereotype.Service;

/**
 * WxService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/16 8:23
 */
@Service
public class WxService {

  @Resource
  private WxMpServiceClient wxMpServiceClient;

  /**
   * 校验签名
   *
   * @param timestamp
   * @param nonce
   * @param signature
   * @return
   */
  public boolean checkSignature(String timestamp, String nonce, String signature) {
    return wxMpServiceClient.checkSignature(timestamp, nonce, signature);
  }

  /**
   * 生成二维码URL
   *
   * @param redirectUri
   * @return
   */
  public String createQrConnectUrl(final String redirectUri) {
    return wxMpServiceClient.createQrConnectUrl(redirectUri);
  }

  /**
   * 获取微信用户信息
   *
   * @param code
   * @return
   */
  public WxMpUser getUserInfo(final String code) {
    return wxMpServiceClient.getUserInfo(code);
  }


}
