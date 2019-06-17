package com.maruko.mall.user.server.rest;

import com.maruko.mall.user.server.client.dto.UserExtendDTO;
import com.maruko.mall.user.server.client.facade.api.IUserExtendFacade;
import com.maruko.mall.user.server.service.IUserExtendService;
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
 * 用户_扩展表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@RestController
public class UserExtendController implements IUserExtendFacade {

	@Autowired
	private IUserExtendService userExtendService;

	@Override
	public BaseResponse add(@RequestBody UserExtendDTO userExtendDTO) {
		return userExtendService.add(userExtendDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserExtendDTO userExtendDTO) {
		return userExtendService.update(userExtendDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Integer id) {
		return userExtendService.remove(id);
	}

	@Override
	public ObjectRestResponse<UserExtendDTO> findById(@PathVariable("id") Integer id) {
		return userExtendService.findById(id);
	}

	@Override
	public ListRestResponse<UserExtendDTO> query(@RequestBody UserExtendDTO userExtendDTO) {
		return userExtendService.query(userExtendDTO);
	}

	@Override
	public TableResultResponse<UserExtendDTO> page(@RequestBody PageRestRequest<UserExtendDTO> pageRestRequest) {
		return userExtendService.page(pageRestRequest.getData(), pageRestRequest.getPage());
	}

	@Override
	public ObjectRestResponse<UserExtendDTO> findByCondition(@RequestBody UserExtendDTO userExtendDTO) {
		return userExtendService.findByCondition(userExtendDTO);
	}
}