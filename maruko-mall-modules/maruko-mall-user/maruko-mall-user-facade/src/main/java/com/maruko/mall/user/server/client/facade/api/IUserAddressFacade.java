package com.maruko.mall.user.server.client.facade.api;

import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.PageRestRequest;
import com.maruko.mall.user.server.client.dto.UserAddressDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 用户收货地址
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface IUserAddressFacade {

	/**
	 * 添加数据
	 * @param userAddressDTO
	 * @return
	 */
	@PostMapping("/facade/userAddress/add")
	BaseResponse add(@RequestBody UserAddressDTO userAddressDTO);

	/**
	 * 更新数据
	 * @param userAddressDTO
	 * @return
	 */
	@PutMapping("/facade/userAddress/update")
	BaseResponse update(@RequestBody UserAddressDTO userAddressDTO);

	/**
	 * 根据ID删除数据
	 * @param id
	 * @return
	 */
	@DeleteMapping("/facade/userAddress/remove/{id}")
	BaseResponse remove(@PathVariable("id") Integer id);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	@GetMapping("/facade/userAddress/findById/{id}")
	ObjectRestResponse<UserAddressDTO> findById(@PathVariable("id") Integer id);


	/**
	 * 根据条件查找数据
	 * @param userAddressDTO
	 * @return
	 */
	@PostMapping("/facade/userAddress/query")
	ListRestResponse<UserAddressDTO> query(@RequestBody UserAddressDTO userAddressDTO);

	/**
	 * 查找数据显示分页
	 * @param pageRestRequest
	 * @return
	 */
	@PostMapping("/facade/userAddress/page")
	TableResultResponse<UserAddressDTO> page(@RequestBody PageRestRequest<UserAddressDTO> pageRestRequest);

	/**
	 * 根据条件查找数据
	 * @param userAddressDTO
	 * @return
	 */
	@PostMapping("/facade/userAddress/findByCondition")
	ObjectRestResponse<UserAddressDTO> findByCondition(@RequestBody UserAddressDTO userAddressDTO);

}
