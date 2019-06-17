package com.maruko.mall.user.server.rest;

import com.maruko.mall.user.server.client.dto.UserThirdDTO;
import com.maruko.mall.user.server.client.facade.api.IUserThirdFacade;
import com.maruko.mall.user.server.service.IUserThirdService;
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
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@RestController
public class UserThirdController implements IUserThirdFacade {

	@Autowired
	private IUserThirdService userThirdService;

	@Override
	public BaseResponse add(@RequestBody UserThirdDTO userThirdDTO) {
		return userThirdService.add(userThirdDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserThirdDTO userThirdDTO) {
		return userThirdService.update(userThirdDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Integer id) {
		return userThirdService.remove(id);
	}

	@Override
	public ObjectRestResponse<UserThirdDTO> findById(@PathVariable("id") Integer id) {
		return userThirdService.findById(id);
	}

	@Override
	public ListRestResponse<UserThirdDTO> query(@RequestBody UserThirdDTO userThirdDTO) {
		return userThirdService.query(userThirdDTO);
	}

	@Override
	public TableResultResponse<UserThirdDTO> page(@RequestBody PageRestRequest<UserThirdDTO> pageRestRequest) {
		return userThirdService.page(pageRestRequest.getData(), pageRestRequest.getPage());
	}

	@Override
	public ObjectRestResponse<UserThirdDTO> findByCondition(@RequestBody UserThirdDTO userThirdDTO) {
		return userThirdService.findByCondition(userThirdDTO);
	}
}