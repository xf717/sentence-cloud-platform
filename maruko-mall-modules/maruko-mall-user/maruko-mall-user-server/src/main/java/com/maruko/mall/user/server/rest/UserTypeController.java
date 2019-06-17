package com.maruko.mall.user.server.rest;

import com.maruko.mall.user.server.client.dto.UserTypeDTO;
import com.maruko.mall.user.server.client.facade.api.IUserTypeFacade;
import com.maruko.mall.user.server.service.IUserTypeService;
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
 * 用户_类型表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@RestController
public class UserTypeController implements IUserTypeFacade {

	@Autowired
	private IUserTypeService userTypeService;

	@Override
	public BaseResponse add(@RequestBody UserTypeDTO userTypeDTO) {
		return userTypeService.add(userTypeDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserTypeDTO userTypeDTO) {
		return userTypeService.update(userTypeDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Integer id) {
		return userTypeService.remove(id);
	}

	@Override
	public ObjectRestResponse<UserTypeDTO> findById(@PathVariable("id") Integer id) {
		return userTypeService.findById(id);
	}

	@Override
	public ListRestResponse<UserTypeDTO> query(@RequestBody UserTypeDTO userTypeDTO) {
		return userTypeService.query(userTypeDTO);
	}

	@Override
	public TableResultResponse<UserTypeDTO> page(@RequestBody PageRestRequest<UserTypeDTO> pageRestRequest) {
		return userTypeService.page(pageRestRequest.getData(), pageRestRequest.getPage());
	}

	@Override
	public ObjectRestResponse<UserTypeDTO> findByCondition(@RequestBody UserTypeDTO userTypeDTO) {
		return userTypeService.findByCondition(userTypeDTO);
	}
}