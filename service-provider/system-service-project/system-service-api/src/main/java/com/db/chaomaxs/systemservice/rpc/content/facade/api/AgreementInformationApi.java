package com.db.chaomaxs.systemservice.rpc.content.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 内容管理-协议信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
public interface AgreementInformationApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/agreementInformation/save")
  BaseResponse save(@RequestBody AgreementInformationCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/agreementInformation/update")
  BaseResponse update(@RequestBody AgreementInformationUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/agreementInformation/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/agreementInformation/get/{id}")
  ObjectRestResponse<AgreementInformationRespDTO> getAgreementInformationById(
      @PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/agreementInformation/list")
  ObjectRestResponse<List<AgreementInformationRespDTO>> listAgreementInformations(
      @RequestBody AgreementInformationListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/agreementInformation/page")
  TableResultResponse<AgreementInformationRespDTO> page(
      @RequestBody AgreementInformationPageReqDTO pageReqDTO);


  /**
   * 根据Id查找
   *
   * @param code
   * @return
   */
  @GetMapping("/facade/agreementInformation/get/code")
  ObjectRestResponse<AgreementInformationRespDTO> getAgreementInformationByCode(
      @RequestParam("code") String code);

}
