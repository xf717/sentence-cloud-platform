package com.db.chaomaxs.positionservice.rpc.positiontype.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypePageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 职务职位分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
public interface PositionTypeApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/positionType/save")
	BaseResponse save(@RequestBody PositionTypeCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/positionType/update")
	BaseResponse update(@RequestBody PositionTypeUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/positionType/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/positionType/get/{id}")
	ObjectRestResponse<PositionTypeRespDTO> getPositionTypeById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/positionType/list")
	ObjectRestResponse<List<PositionTypeRespDTO>> listPositionTypes(
      @RequestBody PositionTypeListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/positionType/page")
	TableResultResponse<PositionTypeRespDTO> page(@RequestBody PositionTypePageReqDTO pageReqDTO);


	/**
	 * 根据参数查询所有可显示分类
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/positionType/list/display/position")
	ObjectRestResponse<List<PositionTypeRespDTO>> listDisplayPositionType(
			@RequestBody PositionTypeListQueryReqDTO listQuery);


	/**
	 * 根据parentId查询数据,不分页
	 * @param parentId  查询参数
	 * @return
	 */
	@GetMapping("/facade/positionType/list/position")
	ObjectRestResponse<List<PositionTypeRespDTO>> listPositionTypeByParentId(
			@RequestParam("parentId") Long parentId);

}
