package com.db.chaomaxs.systemservice.rpc.content;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.constant.CommonConstants;
import com.db.chaomaxs.systemservice.enums.SystemErrorCodeConstants;
import com.db.chaomaxs.systemservice.manager.content.IndustryTypeManager;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.facade.IndustryTypeRpcFacade;
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
