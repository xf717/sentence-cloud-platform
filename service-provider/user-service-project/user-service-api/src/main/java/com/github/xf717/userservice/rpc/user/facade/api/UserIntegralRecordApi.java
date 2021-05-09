package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserIntegralRecordPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 记录用户签到记录信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
public interface UserIntegralRecordApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userIntegralRecord/save")
	BaseResponse save(@RequestBody UserIntegralRecordCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userIntegralRecord/update")
	BaseResponse update(@RequestBody UserIntegralRecordUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userIntegralRecord/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userIntegralRecord/get/{id}")
	ObjectRestResponse<UserIntegralRecordRespDTO> getUserIntegralRecordById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userIntegralRecord/list")
	ObjectRestResponse<List<UserIntegralRecordRespDTO>> listUserIntegralRecords(
      @RequestBody UserIntegralRecordListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userIntegralRecord/page")
	TableResultResponse<UserIntegralRecordRespDTO> page(
      @RequestBody UserIntegralRecordPageReqDTO pageReqDTO);

	/**
	 * 签到
	 *
	 * @param userId 添加参数
	 * @return
	 */
	@PostMapping("/facade/userIntegralRecord/sign/{userId}")
	BaseResponse sign(@PathVariable("userId") Long userId);
}
