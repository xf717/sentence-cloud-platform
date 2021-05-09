package com.db.chaomaxs.sms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 阿里云相关配置
 *
 * @author xiaofeng
 */
@ConfigurationProperties("sms.aliyun")
public class AliyunSmsProperties {

  /**
   * accessKey id
   */
  private String accessKeyId;

  /**
   * accessSecret
   */
  private String accessSecret;

  /**
   * 默认值 dysmsapi.aliyuncs.com
   */
  private String sysDomain;

  /**
   * 默认值 cn-hangzhou
   */
  private String regionId;

  /**
   * 签名
   */
  private String signName;

  /**
   * 模板CODE
   */
  private String templateCode;

  public String getAccessKeyId() {
    return accessKeyId;
  }

  public AliyunSmsProperties setAccessKeyId(String accessKeyId) {
    this.accessKeyId = accessKeyId;
    return this;
  }

  public String getAccessSecret() {
    return accessSecret;
  }

  public AliyunSmsProperties setAccessSecret(String accessSecret) {
    this.accessSecret = accessSecret;
    return this;
  }

  public String getSysDomain() {
    return sysDomain;
  }

  public AliyunSmsProperties setSysDomain(String sysDomain) {
    this.sysDomain = sysDomain;
    return this;
  }

  public String getRegionId() {
    return regionId;
  }

  public AliyunSmsProperties setRegionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

  public String getSignName() {
    return signName;
  }

  public AliyunSmsProperties setSignName(String signName) {
    this.signName = signName;
    return this;
  }

  public String getTemplateCode() {
    return templateCode;
  }

  public AliyunSmsProperties setTemplateCode(String templateCode) {
    this.templateCode = templateCode;
    return this;
  }
}
