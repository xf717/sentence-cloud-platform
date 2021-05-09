package com.db.chaomaxs.sms.core.handler.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.db.chaomaxs.common.framework.util.mapper.JsonMapper;
import com.db.chaomaxs.sms.config.AliyunSmsProperties;
import com.db.chaomaxs.sms.core.handler.SmsSendHandler;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * SmsSendHandlerImpl
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 18:50
 */
@Component
public class AliyunSmsSendHandlerImpl implements SmsSendHandler {

  private static final String SYS_VERSION = "2017-05-25";

  private static final String SYS_ACTION_SEND_SMS = "SendSms";

  @Autowired
  @Qualifier("aliyunSmsProperties")
  private AliyunSmsProperties aliyunSmsProperties;

  @Override
  public boolean sendSms(String mobile, String code) {
    DefaultProfile profile = DefaultProfile
        .getProfile(aliyunSmsProperties.getRegionId(), aliyunSmsProperties.getAccessKeyId(),
            aliyunSmsProperties.getAccessSecret());
    IAcsClient client = new DefaultAcsClient(profile);
    CommonRequest request = new CommonRequest();
    request.setSysMethod(MethodType.POST);
    request.setSysDomain(aliyunSmsProperties.getSysDomain());
    request.setSysVersion(SYS_VERSION);
    request.setSysAction(SYS_ACTION_SEND_SMS);
    // 短信发送参数
    request.putQueryParameter("RegionId", aliyunSmsProperties.getRegionId());
    request.putQueryParameter("PhoneNumbers", mobile);
    request.putQueryParameter("SignName", aliyunSmsProperties.getSignName());
    request.putQueryParameter("TemplateCode", aliyunSmsProperties.getTemplateCode());
    request.putQueryParameter("TemplateParam", this.buildTemplateParam(code));
    try {
      CommonResponse response = client.getCommonResponse(request);
      return response.getHttpResponse().isSuccess();
    } catch (ServerException e) {
      e.printStackTrace();
    } catch (ClientException e) {
      e.printStackTrace();
    }
    return false;
  }

  private String buildTemplateParam(final String code) {
    Map<String, String> map = new HashMap<>(1);
    map.put("code", code);
    return JsonMapper.INSTANCE.toJson(map);
  }

}
