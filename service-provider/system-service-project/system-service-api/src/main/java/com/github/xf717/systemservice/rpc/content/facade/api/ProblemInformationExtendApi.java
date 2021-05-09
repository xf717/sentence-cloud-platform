package com.github.xf717.systemservice.rpc.content.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 内容管理-问题扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
public interface ProblemInformationExtendApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/problemInformationExtend/save")
	BaseResponse save(@RequestBody ProblemInformationExtendCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/problemInformationExtend/update")
	BaseResponse update(@RequestBody ProblemInformationExtendUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/problemInformationExtend/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/problemInformationExtend/get/{id}")
	ObjectRestResponse<ProblemInformationExtendRespDTO> getProblemInformationExtendById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/problemInformationExtend/list")
	ObjectRestResponse<List<ProblemInformationExtendRespDTO>> listProblemInformationExtends(
      @RequestBody ProblemInformationExtendListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/problemInformationExtend/page")
	TableResultResponse<ProblemInformationExtendRespDTO> page(
      @RequestBody ProblemInformationExtendPageReqDTO pageReqDTO);

}
