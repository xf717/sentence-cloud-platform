package com.github.xf717.passportweb.client.wx;

import com.github.xf717.common.framework.util.StringUtils;
import me.chanjar.weixin.common.api.WxConsts.QrConnectScope;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.stereotype.Service;

/**
 * WxMpServiceClent
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/15 19:37
 */
@Service
public class WxMpServiceClient {

  private static WxMpService wxMpService;

  static {
    wxMpService = new WxMpServiceImpl();
  }

  /**
   * 校验签名
   *
   * @param timestamp
   * @param nonce
   * @param signature
   * @return
   */
  public boolean checkSignature(String timestamp, String nonce, String signature) {
    return wxMpService.checkSignature(timestamp, nonce, signature);
  }


  /**
   * 生成扫码登录地址
   *
   * @param redirectUri
   * @return
   */
  public String createQrConnectUrl(final String redirectUri) {
    final String state = StringUtils.uuid(true);
    final String qrConnectUrl = wxMpService
        .buildQrConnectUrl(redirectUri, QrConnectScope.SNSAPI_LOGIN, state);
    return qrConnectUrl;
  }

  /**
   * 获取微信用户信息
   *
   * @param code
   * @return
   */
  public WxMpUser getUserInfo(final String code) {
    WxMpUser wxMpUser = null;
    try {
      WxOAuth2AccessToken wxOAuth2AccessToken = wxMpService.getOAuth2Service().getAccessToken(code);
      if (wxOAuth2AccessToken != null) {
        wxMpUser = wxMpService.getUserService().userInfo(wxOAuth2AccessToken.getOpenId());
      }
    } catch (WxErrorException e) {
      e.printStackTrace();
    }
    return wxMpUser;
  }

//  public void test() {
//    WxMpService wxMpService = new WxMpServiceImpl();
//    final String url = "http://sentence.xxxxxxxx/wx/oauth2";
//    try {
//      // 第一步
//      final String redirectUri = "http://sentence.xxx.com/wxloginCallback";
//
//      // 前端点击生成的二维码---qrConnectUrl 值 获得code
//
//      // 第二步 通过code 获取opneid 和access_token
//      final String code = "";
//      WxOAuth2AccessToken wxOAuth2AccessToken = wxMpService.getOAuth2Service().getAccessToken(code);
//      final String accessToken = wxOAuth2AccessToken.getAccessToken();
//      final String openId = wxOAuth2AccessToken.getOpenId();
//      final String unionId = wxOAuth2AccessToken.getUnionId();
//
//      // 获取用户信息
//      WxMpUser wxMpUser = wxMpService.getUserService().userInfo(openId);
//      // TODO 处理业务 进行登录操作
//    } catch (WxErrorException e) {
//      e.printStackTrace();
//    }


}
