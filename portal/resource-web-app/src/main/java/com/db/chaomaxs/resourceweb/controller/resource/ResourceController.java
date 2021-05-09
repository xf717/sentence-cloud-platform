package com.db.chaomaxs.resourceweb.controller.resource;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.resourceservice.enums.ResourceErrorCodeConstants;
import com.db.chaomaxs.resourceweb.manager.resource.ResourceManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件资源表
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Api(value = "文件资源表", description = "文件资源表", tags = "文件上传")
@RestController
@RequestMapping("/rest/resource")
@RefreshScope
public class ResourceController {

  @Autowired
  private ResourceManager resourceManager;

  /**
   * 添加数据
   *
   * @param file
   * @return
   */
  @ApiOperation(value = "上传文件", nickname = "upload")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "file", dataType = "file", paramType = "query", required = true),
      @ApiImplicitParam(name = "fileType", dataType = "int", paramType = "query", required = true)
  })
  @PostMapping("/upload")
  public ObjectRestResponse<String> upload(
      @Valid @RequestParam("file") MultipartFile file) {
    if (file.isEmpty()) {
      throw ServiceExceptionUtil.exception(ResourceErrorCodeConstants.FILE_NOT_EMPTY.getCode());
    }
    final String suffix = file.getOriginalFilename()
        .substring(file.getOriginalFilename().lastIndexOf("."));
    String fileUrl = null;
    try {
      fileUrl = resourceManager.upload(file.getBytes(), suffix);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ObjectRestResponse<>().data(fileUrl);
  }

}
