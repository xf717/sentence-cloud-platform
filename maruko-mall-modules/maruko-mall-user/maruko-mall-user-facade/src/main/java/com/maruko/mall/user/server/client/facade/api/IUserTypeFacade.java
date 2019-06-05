package com.maruko.mall.user.server.client.facade.api;

import com.maruko.mall.user.server.client.dto.UserTypeDTO;
import com.ktpfx.common.msg.BaseResponse;
import com.ktpfx.common.msg.ListRestResponse;
import com.ktpfx.common.msg.ObjectRestResponse;
import com.ktpfx.common.msg.TableResultResponse;
import com.ktpfx.common.page.PageRestRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户_类型表
 *
 * @author xiaofeng
 * @date 2019-06-04 22:35:12
 */
public interface IUserTypeFacade {

	/**
	 * 添加数据
	 * @param userTypeDTO
	 * @return
	 */
	@PostMapping("/facade/userType/add")
	BaseResponse add(@RequestBody UserTypeDTO userTypeDTO);

	/**
	 * 更新数据
	 * @param userTypeDTO
	 * @return
	 */
	@PutMapping("/facade/userType/update")
	BaseResponse update(@RequestBody UserTypeDTO userTypeDTO);

	/**
	 * 根据ID删除数据
	 * @param id
	 * @return
	 */
	@DeleteMapping("/facade/userType/remove/{id}")
	BaseResponse remove(@PathVariable("id") Integer id);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	@GetMapping("/facade/userType/findById/{id}")
	ObjectRestResponse<UserTypeDTO> findById(@PathVariable("id") Integer id);


	/**
	 * 根据条件查找数据
	 * @param userTypeDTO
	 * @return
	 */
	@PostMapping("/facade/userType/query")
	ListRestResponse<UserTypeDTO> query(@RequestBody UserTypeDTO userTypeDTO);

	/**
	 * 查找数据显示分页
	 * @param pageRestRequest
	 * @return
	 */
	@PostMapping("/facade/userType/page")
	TableResultResponse<UserTypeDTO> page(@RequestBody PageRestRequest<UserTypeDTO> pageRestRequest);

	/**
	 * 根据条件查找数据
	 * @param userTypeDTO
	 * @return
	 */
	@PostMapping("/facade/userType/findByCondition")
	ObjectRestResponse<UserTypeDTO> findByCondition(@RequestBody UserTypeDTO userTypeDTO);

}
