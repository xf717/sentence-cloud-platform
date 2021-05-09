package com.db.chaomaxs.systemservice.rpc.content.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 行业分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
public interface IndustryTypeApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/industryType/save")
	BaseResponse save(@RequestBody IndustryTypeCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/industryType/update")
	BaseResponse update(@RequestBody IndustryTypeUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/industryType/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/industryType/get/{id}")
	ObjectRestResponse<IndustryTypeRespDTO> getIndustryTypeById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/industryType/list")
	ObjectRestResponse<List<IndustryTypeRespDTO>> listIndustryTypes(
      @RequestBody IndustryTypeListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/industryType/page")
	TableResultResponse<IndustryTypeRespDTO> page(@RequestBody IndustryTypePageReqDTO pageReqDTO);

	/**
	 * 根据参数查询所有可显示分类
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/industryType/list/display/industry")
	ObjectRestResponse<List<IndustryTypeRespDTO>> listDisplayIndustry(
			@RequestBody IndustryTypeListQueryReqDTO listQuery);


	/**
	 * 根据parentId查询数据,不分页
	 * @param parentId  查询参数
	 * @return
	 */
	@GetMapping("/facade/industryType/list/industry")
	ObjectRestResponse<List<IndustryTypeRespDTO>> listIndustryByParentId(
			@RequestParam("parentId") Long parentId);

}
