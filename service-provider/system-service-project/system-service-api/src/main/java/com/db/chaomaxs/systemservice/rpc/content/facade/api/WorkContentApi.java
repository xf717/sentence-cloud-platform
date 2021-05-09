package com.db.chaomaxs.systemservice.rpc.content.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentDetailRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.WorkContentUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 内容管理-工作内容息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
public interface WorkContentApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/workContent/save")
	BaseResponse save(@RequestBody WorkContentCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/workContent/update")
	BaseResponse update(@RequestBody WorkContentUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/workContent/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/workContent/get/{id}")
	ObjectRestResponse<WorkContentRespDTO> getWorkContentById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/workContent/list")
	ObjectRestResponse<List<WorkContentRespDTO>> listWorkContents(
      @RequestBody WorkContentListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/workContent/page")
	TableResultResponse<WorkContentRespDTO> page(@RequestBody WorkContentPageReqDTO pageReqDTO);

	/**
	 * 随机提供一条工作内容
	 * @return
	 */
	@GetMapping("/facade/workContent/detail")
	ObjectRestResponse<WorkContentDetailRespDTO> workContentDetail();
}
