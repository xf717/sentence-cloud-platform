package com.db.chaomaxs.userservice.rpc.user.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserBlacklistPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_黑名单
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
public interface UserBlacklistApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userBlacklist/save")
	BaseResponse save(@RequestBody UserBlacklistCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userBlacklist/update")
	BaseResponse update(@RequestBody UserBlacklistUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userBlacklist/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userBlacklist/get/{id}")
	ObjectRestResponse<UserBlacklistRespDTO> getUserBlacklistById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userBlacklist/list")
	ObjectRestResponse<List<UserBlacklistRespDTO>> listUserBlacklists(
      @RequestBody UserBlacklistListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userBlacklist/page")
	TableResultResponse<UserBlacklistRespDTO> page(@RequestBody UserBlacklistPageReqDTO pageReqDTO);

}
