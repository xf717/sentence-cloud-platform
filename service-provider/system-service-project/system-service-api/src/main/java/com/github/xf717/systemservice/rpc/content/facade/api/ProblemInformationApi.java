package com.github.xf717.systemservice.rpc.content.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 内容管理-问题信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
public interface ProblemInformationApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/problemInformation/save")
	BaseResponse save(@RequestBody ProblemInformationCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/problemInformation/update")
	BaseResponse update(@RequestBody ProblemInformationUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/problemInformation/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/problemInformation/get/{id}")
	ObjectRestResponse<ProblemInformationRespDTO> getProblemInformationById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/problemInformation/list")
	ObjectRestResponse<List<ProblemInformationRespDTO>> listProblemInformations(
      @RequestBody ProblemInformationListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/problemInformation/page")
	TableResultResponse<ProblemInformationRespDTO> page(
      @RequestBody ProblemInformationPageReqDTO pageReqDTO);

}
