package com.maruko.mall.user.server.rest;

import com.maruko.mall.user.server.client.dto.UserInfoDTO;
import com.maruko.mall.user.server.client.facade.api.IUserInfoFacade;
import com.maruko.mall.user.server.service.IUserInfoService;
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
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@RestController
public class UserInfoController implements IUserInfoFacade {

	@Autowired
	private IUserInfoService userInfoService;

	@Override
	public BaseResponse add(@RequestBody UserInfoDTO userInfoDTO) {
		return userInfoService.add(userInfoDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserInfoDTO userInfoDTO) {
		return userInfoService.update(userInfoDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Integer id) {
		return userInfoService.remove(id);
	}

	@Override
	public ObjectRestResponse<UserInfoDTO> findById(@PathVariable("id") Integer id) {
		return userInfoService.findById(id);
	}

	@Override
	public ListRestResponse<UserInfoDTO> query(@RequestBody UserInfoDTO userInfoDTO) {
		return userInfoService.query(userInfoDTO);
	}

	@Override
	public TableResultResponse<UserInfoDTO> page(@RequestBody PageRestRequest<UserInfoDTO> pageRestRequest) {
		return userInfoService.page(pageRestRequest.getData(), pageRestRequest.getPage());
	}

	@Override
	public ObjectRestResponse<UserInfoDTO> findByCondition(@RequestBody UserInfoDTO userInfoDTO) {
		return userInfoService.findByCondition(userInfoDTO);
	}
}