package com.github.xf717.systemservice.rpc.content;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.constant.CommonConstants;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.manager.content.IndustryTypeManager;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypePageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.IndustryTypeUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.facade.IndustryTypeRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Slf4j
@Service
public class IndustryTypeRpcImpl implements IndustryTypeRpcFacade {

  @Autowired
  private IndustryTypeManager industryTypeManager;

  @Override
  public BaseResponse save(IndustryTypeCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    industryTypeManager.saveIndustryType(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(IndustryTypeUpdateReqDTO updateReqDTO) {
    IndustryTypeRespDTO industryTypeRespDTO = getIndustryByNameAndParentId(
        updateReqDTO.getTypeName(),
        null == updateReqDTO.getParentId() ? CommonConstants.TREE_TOP_PARENT_ID
            : updateReqDTO.getParentId());
    if (null != industryTypeRespDTO) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.INDUSTRY_TYPE_EXISTS.getCode());
    }
    industryTypeManager.updateIndustryType(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    industryTypeManager.deleteIndustryType(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<IndustryTypeRespDTO> getIndustryTypeById(Long id) {
    IndustryTypeRespDTO industryType = industryTypeManager.getIndustryTypeById(id);
    return new ObjectRestResponse<>().data(industryType);
  }

  @Override
  public ObjectRestResponse<List<IndustryTypeRespDTO>> listIndustryTypes(
      IndustryTypeListQueryReqDTO listQuery) {
    List<IndustryTypeRespDTO> list = industryTypeManager.listIndustryTypes(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<IndustryTypeRespDTO> page(IndustryTypePageReqDTO pageReqDTO) {
    PageResult<IndustryTypeRespDTO> pageResult = industryTypeManager.pageIndustryType(pageReqDTO);
    TableResultResponse<IndustryTypeRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  /**
   * 根据参数查询所有可显示分类
   *
   * @param listQuery 查询参数
   * @return
   */
  @Override
  public ObjectRestResponse<List<IndustryTypeRespDTO>> listDisplayIndustry(
      IndustryTypeListQueryReqDTO listQuery) {
    List<IndustryTypeRespDTO> list = industryTypeManager.listDisplayIndustry(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  /**
   * 根据parentId查询数据,不分页
   *
   * @param parentId 查询参数
   * @return
   */
  @Override
  public ObjectRestResponse<List<IndustryTypeRespDTO>> listIndustryByParentId(Long parentId) {

    List<IndustryTypeRespDTO> list = industryTypeManager.getIndustryByParentId(parentId);
    return new ObjectRestResponse<>().data(list);
  }

  /**
   * 根据分类名称和父id查询
   *
   * @param typeName
   * @param parentId
   * @return
   */
  public IndustryTypeRespDTO getIndustryByNameAndParentId(String typeName, Long parentId) {
    if (null == parentId) {
      parentId = CommonConstants.TREE_TOP_PARENT_ID;
    }
    IndustryTypeListQueryReqDTO reqDTO = new IndustryTypeListQueryReqDTO();
    reqDTO.setTypeName(typeName);
    reqDTO.setParentId(parentId);
    return industryTypeManager.getIndustryByNameAndParentId(reqDTO);
  }


}
