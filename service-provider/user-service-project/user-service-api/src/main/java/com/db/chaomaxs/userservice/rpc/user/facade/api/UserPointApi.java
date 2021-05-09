package com.db.chaomaxs.userservice.rpc.user.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserPointPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
public interface UserPointApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userPoint/save")
	BaseResponse save(@RequestBody UserPointCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userPoint/update")
	BaseResponse update(@RequestBody UserPointUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userPoint/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userPoint/get/{id}")
	ObjectRestResponse<UserPointRespDTO> getUserPointById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userPoint/list")
	ObjectRestResponse<List<UserPointRespDTO>> listUserPoints(
      @RequestBody UserPointListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userPoint/page")
	TableResultResponse<UserPointRespDTO> page(@RequestBody UserPointPageReqDTO pageReqDTO);

}
