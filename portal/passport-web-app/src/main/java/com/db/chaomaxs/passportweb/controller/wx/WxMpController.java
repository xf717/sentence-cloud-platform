package com.db.chaomaxs.passportweb.controller.wx;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.passportweb.service.wx.WxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 求职_登录
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Api(value = "微信基础接口", description = "求职_登录", tags = "wx")
@RestController
@RequestMapping("/rest/wx")
public class WxMpController {

  @Autowired
  private WxService wxService;

  @Value("${wx.mp.redirect-uri}")
  private String redirectUri;

  /**
   * 校验签名
   *
   * @param timestamp
   * @param nonce
   * @param signature
   * @return
   */
  @GetMapping("/check/signature")
  @ApiOperation(value = "校验签名", nickname = "checkSignature")
  public ObjectRestResponse<Boolean> checkSignature(String timestamp, String nonce,
      String signature) {
    return ObjectRestResponse.success(wxService.checkSignature(timestamp, nonce, signature));
  }

  /**
   * 获取扫码地址地址
   *
   * @return
   */
  @GetMapping("/getQrConnectUrl")
  @ApiOperation(value = "获取扫码地址地址", nickname = "createQrConnectUrl")
  public ObjectRestResponse<String> getQrConnectUrl() {
    final String qrConnectUrl = wxService.createQrConnectUrl(redirectUri);
    return new ObjectRestResponse<>().data(qrConnectUrl);
  }


}
