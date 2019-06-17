package com.maruko.mall.user.server.client.facade.api;

import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.PageRestRequest;
import com.maruko.mall.user.server.client.dto.UserIntegralDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface IUserIntegralFacade {

	/**
	 * 添加数据
	 * @param userIntegralDTO
	 * @return
	 */
	@PostMapping("/facade/userIntegral/add")
	BaseResponse add(@RequestBody UserIntegralDTO userIntegralDTO);

	/**
	 * 更新数据
	 * @param userIntegralDTO
	 * @return
	 */
	@PutMapping("/facade/userIntegral/update")
	BaseResponse update(@RequestBody UserIntegralDTO userIntegralDTO);

	/**
	 * 根据ID删除数据
	 * @param id
	 * @return
	 */
	@DeleteMapping("/facade/userIntegral/remove/{id}")
	BaseResponse remove(@PathVariable("id") Integer id);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	@GetMapping("/facade/userIntegral/findById/{id}")
	ObjectRestResponse<UserIntegralDTO> findById(@PathVariable("id") Integer id);


	/**
	 * 根据条件查找数据
	 * @param userIntegralDTO
	 * @return
	 */
	@PostMapping("/facade/userIntegral/query")
	ListRestResponse<UserIntegralDTO> query(@RequestBody UserIntegralDTO userIntegralDTO);

	/**
	 * 查找数据显示分页
	 * @param pageRestRequest
	 * @return
	 */
	@PostMapping("/facade/userIntegral/page")
	TableResultResponse<UserIntegralDTO> page(@RequestBody PageRestRequest<UserIntegralDTO> pageRestRequest);

	/**
	 * 根据条件查找数据
	 * @param userIntegralDTO
	 * @return
	 */
	@PostMapping("/facade/userIntegral/findByCondition")
	ObjectRestResponse<UserIntegralDTO> findByCondition(@RequestBody UserIntegralDTO userIntegralDTO);

}
