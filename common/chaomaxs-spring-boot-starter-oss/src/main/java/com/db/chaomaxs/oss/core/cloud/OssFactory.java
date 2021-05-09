package com.db.chaomaxs.oss.core.cloud;

import com.db.chaomaxs.oss.config.CloudStorageConfig;
import com.db.chaomaxs.oss.constant.OssConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 文件上传Factory
 *
 * @author xiaofeng
 */
@Component
public class OssFactory {

  @Autowired
  private CloudStorageConfig config;

  public CloudStorageService build() {
    if (config.getType().equals(OssConstant.TYPE_QINIU)) {
      return new QiniuCloudStorageService(config);
    } else if (config.getType().equals(OssConstant.TYPE_ALIYUN)) {
      return new AliyunCloudStorageService(config);
    } else if (config.getType().equals(OssConstant.TYPE_QCLOUD)) {
      return new QcloudCloudStorageService(config);
    }
    return null;
  }

}
