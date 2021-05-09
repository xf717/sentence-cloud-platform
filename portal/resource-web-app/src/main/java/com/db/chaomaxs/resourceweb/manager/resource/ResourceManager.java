package com.db.chaomaxs.resourceweb.manager.resource;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.oss.core.cloud.OssFactory;
import com.db.chaomaxs.resourceservice.enums.ResourceErrorCodeConstants;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceCreateReqDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.dto.ResourceRespDTO;
import com.db.chaomaxs.resourceservice.rpc.resource.facade.ResourceRpcFacade;
import com.db.chaomaxs.resourceweb.controller.resource.dto.ResourceAddDTO;
import com.db.chaomaxs.resourceweb.controller.resource.dto.ResourceDTO;
import com.db.chaomaxs.resourceweb.controller.resource.dto.ResourcePageDTO;
import com.db.chaomaxs.resourceweb.controller.resource.dto.ResourceUpdateDTO;
import com.db.chaomaxs.resourceweb.controller.resource.vo.ResourceUploadVO;
import com.db.chaomaxs.resourceweb.controller.resource.vo.ResourceVO;
import com.db.chaomaxs.resourceweb.convert.resource.ResourceConvert;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ResourceManager
 *
 * @author xiaofeng
 * @date 2021-03-29 19:47:07
 */
@Service
@Validated
public class ResourceManager {

  @Autowired
  private ResourceRpcFacade resourceRpcFacade;

  @Autowired
  private OssFactory ossFactory;

  /**
   * 文件上传
   *
   * @param data
   * @param suffix
   * @return
   */
  public String upload(byte[] data, String suffix) {
    String fileUrl = ossFactory.build().uploadSuffix(data, suffix);
    if (StringUtils.isEmpty(fileUrl)) {
      throw ServiceExceptionUtil.exception(ResourceErrorCodeConstants.UPLOAD_ERROR);
    }

//    ResourceCreateReqDTO resourceCreate = new ResourceCreateReqDTO()
//        .setFileName(fileName)
//        .setFileSize(fileSize)
//        .setFileType(fileType)
//        .setFileUrl(fileUrl);
//    ObjectRestResponse<Long> objectRestResponse = resourceRpcFacade.save(resourceCreate);
//    objectRestResponse.checkError();

//    ResourceUploadVO resourceUpload = new ResourceUploadVO()
//        .setResourceId(objectRestResponse.getData())
//        .setFileUrl(fileUrl);
    return fileUrl;
  }

  /**
   * 添加数据
   *
   * @param resourceAddDTO 添加参数
   * @return
   */
  public int save(ResourceAddDTO resourceAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = resourceRpcFacade
        .save(ResourceConvert.INSTANCE.convert(resourceAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param resourceUpdateDTO 更新参数
   * @return
   */
  public int update(ResourceUpdateDTO resourceUpdateDTO) {
    BaseResponse baseResponse = resourceRpcFacade
        .update(ResourceConvert.INSTANCE.convert(resourceUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = resourceRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public ResourceVO getResourceById(Long id) {
    ObjectRestResponse<ResourceRespDTO> objectRestResponse = resourceRpcFacade.getResourceById(
        id);
    objectRestResponse.checkError();
    return ResourceConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param resourceDTO 查询参数
   * @return
   */
  public List<ResourceVO> listResources(ResourceDTO resourceDTO) {
    ObjectRestResponse<List<ResourceRespDTO>> objectRestResponse = resourceRpcFacade.listResources(
        ResourceConvert.INSTANCE.convert(resourceDTO));
    objectRestResponse.checkError();
    return ResourceConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<ResourceVO> pageResource(ResourcePageDTO pageReqDTO) {
    TableResultResponse<ResourceRespDTO> tableResultResponse = resourceRpcFacade
        .page(ResourceConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return ResourceConvert.INSTANCE.convert(tableResultResponse);
  }


}
