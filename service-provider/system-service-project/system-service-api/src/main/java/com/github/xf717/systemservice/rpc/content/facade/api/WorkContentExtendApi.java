package com.github.xf717.systemservice.rpc.content.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.WorkContentExtendPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 内容管理-工作内容_扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
public interface WorkContentExtendApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/workContentExtend/save")
	BaseResponse save(@RequestBody WorkContentExtendCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/workContentExtend/update")
	BaseResponse update(@RequestBody WorkContentExtendUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/workContentExtend/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/workContentExtend/get/{id}")
	ObjectRestResponse<WorkContentExtendRespDTO> getWorkContentExtendById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/workContentExtend/list")
	ObjectRestResponse<List<WorkContentExtendRespDTO>> listWorkContentExtends(
      @RequestBody WorkContentExtendListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/workContentExtend/page")
	TableResultResponse<WorkContentExtendRespDTO> page(
      @RequestBody WorkContentExtendPageReqDTO pageReqDTO);

}
