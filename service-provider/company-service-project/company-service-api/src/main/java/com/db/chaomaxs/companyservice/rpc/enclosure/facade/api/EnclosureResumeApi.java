package com.db.chaomaxs.companyservice.rpc.enclosure.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumePageReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeRespDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 企业附件简历
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface EnclosureResumeApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/enclosureResume/save")
  BaseResponse save(@RequestBody EnclosureResumeCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/enclosureResume/update")
  BaseResponse update(@RequestBody EnclosureResumeUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/enclosureResume/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/enclosureResume/get/{id}")
  ObjectRestResponse<EnclosureResumeRespDTO> getEnclosureResumeById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/enclosureResume/list")
  ObjectRestResponse<List<EnclosureResumeRespDTO>> listEnclosureResumes(
      @RequestBody EnclosureResumeListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/enclosureResume/page")
  TableResultResponse<EnclosureResumeRespDTO> page(
      @RequestBody EnclosureResumePageReqDTO pageReqDTO);

}
