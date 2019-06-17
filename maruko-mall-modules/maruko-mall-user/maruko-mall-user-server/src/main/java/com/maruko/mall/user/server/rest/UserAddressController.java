package com.maruko.mall.user.server.rest;

import com.maruko.mall.user.server.client.dto.UserAddressDTO;
import com.maruko.mall.user.server.client.facade.api.IUserAddressFacade;
import com.maruko.mall.user.server.service.IUserAddressService;
import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.PageRestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户收货地址
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@RestController
public class UserAddressController implements IUserAddressFacade {

	@Autowired
	private IUserAddressService userAddressService;

	@Override
	public BaseResponse add(@RequestBody UserAddressDTO userAddressDTO) {
		return userAddressService.add(userAddressDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserAddressDTO userAddressDTO) {
		return userAddressService.update(userAddressDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Integer id) {
		return userAddressService.remove(id);
	}

	@Override
	public ObjectRestResponse<UserAddressDTO> findById(@PathVariable("id") Integer id) {
		return userAddressService.findById(id);
	}

	@Override
	public ListRestResponse<UserAddressDTO> query(@RequestBody UserAddressDTO userAddressDTO) {
		return userAddressService.query(userAddressDTO);
	}

	@Override
	public TableResultResponse<UserAddressDTO> page(@RequestBody PageRestRequest<UserAddressDTO> pageRestRequest) {
		return userAddressService.page(pageRestRequest.getData(), pageRestRequest.getPage());
	}

	@Override
	public ObjectRestResponse<UserAddressDTO> findByCondition(@RequestBody UserAddressDTO userAddressDTO) {
		return userAddressService.findByCondition(userAddressDTO);
	}
}