package com.db.chaomaxs.userservice.rpc.resume;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.manager.resume.UserExpectedPositionIndustryManager;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryPageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserExpectedPositionIndustryRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Slf4j
@Service
public class UserExpectedPositionIndustryRpcImpl implements UserExpectedPositionIndustryRpcFacade {

  @Autowired
  private UserExpectedPositionIndustryManager userExpectedPositionIndustryManager;

  @Override
  public BaseResponse save(UserExpectedPositionIndustryCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    userExpectedPositionIndustryManager.saveUserExpectedPositionIndustry(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(UserExpectedPositionIndustryUpdateReqDTO updateReqDTO) {
    userExpectedPositionIndustryManager.updateUserExpectedPositionIndustry(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    userExpectedPositionIndustryManager.deleteUserExpectedPositionIndustry(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<UserExpectedPositionIndustryRespDTO> getUserExpectedPositionIndustryById(
      Long id) {
    UserExpectedPositionIndustryRespDTO userExpectedPositionIndustry = userExpectedPositionIndustryManager
        .getUserExpectedPositionIndustryById(id);
    return new ObjectRestResponse<>().data(userExpectedPositionIndustry);
  }

  @Override
  public ObjectRestResponse<List<UserExpectedPositionIndustryRespDTO>> listUserExpectedPositionIndustrys(
      UserExpectedPositionIndustryListQueryReqDTO listQuery) {
    List<UserExpectedPositionIndustryRespDTO> list = userExpectedPositionIndustryManager
        .listUserExpectedPositionIndustrys(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<UserExpectedPositionIndustryRespDTO> page(
      UserExpectedPositionIndustryPageReqDTO pageReqDTO) {
    PageResult<UserExpectedPositionIndustryRespDTO> pageResult = userExpectedPositionIndustryManager
        .pageUserExpectedPositionIndustry(pageReqDTO);
    TableResultResponse<UserExpectedPositionIndustryRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
