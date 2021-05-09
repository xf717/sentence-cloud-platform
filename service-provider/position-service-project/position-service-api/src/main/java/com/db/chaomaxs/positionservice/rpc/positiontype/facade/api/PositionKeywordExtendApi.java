package com.db.chaomaxs.positionservice.rpc.positiontype.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 职务关键词-扩展信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
public interface PositionKeywordExtendApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/positionKeywordExtend/save")
	BaseResponse save(@RequestBody PositionKeywordExtendCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/positionKeywordExtend/update")
	BaseResponse update(@RequestBody PositionKeywordExtendUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/positionKeywordExtend/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/positionKeywordExtend/get/{id}")
	ObjectRestResponse<PositionKeywordExtendRespDTO> getPositionKeywordExtendById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/positionKeywordExtend/list")
	ObjectRestResponse<List<PositionKeywordExtendRespDTO>> listPositionKeywordExtends(
      @RequestBody PositionKeywordExtendListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/positionKeywordExtend/page")
	TableResultResponse<PositionKeywordExtendRespDTO> page(
      @RequestBody PositionKeywordExtendPageReqDTO pageReqDTO);

}
