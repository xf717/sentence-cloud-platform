package com.db.chaomaxs.systemservice.rpc.content.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.AgreementInformationExtendPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 内容管理-协议信息_扩展息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
public interface AgreementInformationExtendApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/agreementInformationExtend/save")
	BaseResponse save(@RequestBody AgreementInformationExtendCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/agreementInformationExtend/update")
	BaseResponse update(@RequestBody AgreementInformationExtendUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/agreementInformationExtend/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/agreementInformationExtend/get/{id}")
	ObjectRestResponse<AgreementInformationExtendRespDTO> getAgreementInformationExtendById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/agreementInformationExtend/list")
	ObjectRestResponse<List<AgreementInformationExtendRespDTO>> listAgreementInformationExtends(
      @RequestBody AgreementInformationExtendListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/agreementInformationExtend/page")
	TableResultResponse<AgreementInformationExtendRespDTO> page(
      @RequestBody AgreementInformationExtendPageReqDTO pageReqDTO);

}
