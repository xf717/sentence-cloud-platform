package com.db.chaomaxs.positionservice.rpc.position.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.UserPositionWantedPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户求职
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
public interface UserPositionWantedApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userPositionWanted/save")
	BaseResponse save(@RequestBody UserPositionWantedCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userPositionWanted/update")
	BaseResponse update(@RequestBody UserPositionWantedUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userPositionWanted/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userPositionWanted/get/{id}")
	ObjectRestResponse<UserPositionWantedRespDTO> getUserPositionWantedById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userPositionWanted/list")
	ObjectRestResponse<List<UserPositionWantedRespDTO>> listUserPositionWanteds(
      @RequestBody UserPositionWantedListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userPositionWanted/page")
	TableResultResponse<UserPositionWantedRespDTO> page(
      @RequestBody UserPositionWantedPageReqDTO pageReqDTO);

}
