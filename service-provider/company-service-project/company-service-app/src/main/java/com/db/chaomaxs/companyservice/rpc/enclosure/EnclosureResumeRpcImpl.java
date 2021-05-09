package com.db.chaomaxs.companyservice.rpc.enclosure;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.enclosure.EnclosureResumeManager;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumePageReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeRespDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.facade.EnclosureResumeRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @data 2021-03-26 10:18:33
 */
@Slf4j
@Service
public class EnclosureResumeRpcImpl implements EnclosureResumeRpcFacade {

  @Autowired
  private EnclosureResumeManager enclosureResumeManager;

  @Override
  public BaseResponse save(EnclosureResumeCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    enclosureResumeManager.saveEnclosureResume(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(EnclosureResumeUpdateReqDTO updateReqDTO) {
    enclosureResumeManager.updateEnclosureResume(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    enclosureResumeManager.deleteEnclosureResume(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<EnclosureResumeRespDTO> getEnclosureResumeById(Long id) {
    EnclosureResumeRespDTO enclosureResume = enclosureResumeManager.getEnclosureResumeById(id);
    return new ObjectRestResponse<>().data(enclosureResume);
  }

  @Override
  public ObjectRestResponse<List<EnclosureResumeRespDTO>> listEnclosureResumes(
      EnclosureResumeListQueryReqDTO listQuery) {
    List<EnclosureResumeRespDTO> list = enclosureResumeManager.listEnclosureResumes(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<EnclosureResumeRespDTO> page(EnclosureResumePageReqDTO pageReqDTO) {
    PageResult<EnclosureResumeRespDTO> pageResult = enclosureResumeManager
        .pageEnclosureResume(pageReqDTO);
    TableResultResponse<EnclosureResumeRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
