package com.db.chaomaxs.companyservice.rpc.enclosure.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.enclosure.EnclosureResumeRpcImpl;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumePageReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeRespDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.facade.api.EnclosureResumeApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业附件简历
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class EnclosureResumeRpcController implements EnclosureResumeApi {

  @Autowired
  private EnclosureResumeRpcImpl enclosureResumeRpc;

  @Override
  public BaseResponse save(@RequestBody EnclosureResumeCreateReqDTO createReqDTO) {
    return enclosureResumeRpc.save(createReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody EnclosureResumeUpdateReqDTO updateReqDTO) {
    return enclosureResumeRpc.update(updateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return enclosureResumeRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<EnclosureResumeRespDTO> getEnclosureResumeById(
      @PathVariable("id") Long id) {
    return enclosureResumeRpc.getEnclosureResumeById(id);
  }

  @Override
  public ObjectRestResponse<List<EnclosureResumeRespDTO>> listEnclosureResumes(
      @RequestBody EnclosureResumeListQueryReqDTO listQuery) {
    return enclosureResumeRpc.listEnclosureResumes(listQuery);
  }

  @Override
  public TableResultResponse<EnclosureResumeRespDTO> page(
      @RequestBody EnclosureResumePageReqDTO pageReqDTO) {
    return enclosureResumeRpc.page(pageReqDTO);
  }
}
