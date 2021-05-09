package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserMessageCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessageRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessageUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessageListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserMessagePageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户消息表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
public interface UserMessageApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userMessage/save")
	BaseResponse save(@RequestBody UserMessageCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userMessage/update")
	BaseResponse update(@RequestBody UserMessageUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userMessage/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userMessage/get/{id}")
	ObjectRestResponse<UserMessageRespDTO> getUserMessageById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userMessage/list")
	ObjectRestResponse<List<UserMessageRespDTO>> listUserMessages(
      @RequestBody UserMessageListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userMessage/page")
	TableResultResponse<UserMessageRespDTO> page(@RequestBody UserMessagePageReqDTO pageReqDTO);

}
