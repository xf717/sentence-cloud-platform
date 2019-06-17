package com.maruko.mall.user.server.rest;

import com.maruko.mall.user.server.client.dto.UserIntegralDTO;
import com.maruko.mall.user.server.client.facade.api.IUserIntegralFacade;
import com.maruko.mall.user.server.service.IUserIntegralService;
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
 * 用户_积分表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@RestController
public class UserIntegralController implements IUserIntegralFacade {

	@Autowired
	private IUserIntegralService userIntegralService;

	@Override
	public BaseResponse add(@RequestBody UserIntegralDTO userIntegralDTO) {
		return userIntegralService.add(userIntegralDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserIntegralDTO userIntegralDTO) {
		return userIntegralService.update(userIntegralDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Integer id) {
		return userIntegralService.remove(id);
	}

	@Override
	public ObjectRestResponse<UserIntegralDTO> findById(@PathVariable("id") Integer id) {
		return userIntegralService.findById(id);
	}

	@Override
	public ListRestResponse<UserIntegralDTO> query(@RequestBody UserIntegralDTO userIntegralDTO) {
		return userIntegralService.query(userIntegralDTO);
	}

	@Override
	public TableResultResponse<UserIntegralDTO> page(@RequestBody PageRestRequest<UserIntegralDTO> pageRestRequest) {
		return userIntegralService.page(pageRestRequest.getData(), pageRestRequest.getPage());
	}

	@Override
	public ObjectRestResponse<UserIntegralDTO> findByCondition(@RequestBody UserIntegralDTO userIntegralDTO) {
		return userIntegralService.findByCondition(userIntegralDTO);
	}
}