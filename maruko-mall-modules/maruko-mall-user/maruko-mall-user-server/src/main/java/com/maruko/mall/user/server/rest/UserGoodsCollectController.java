package com.maruko.mall.user.server.rest;

import com.maruko.mall.user.server.client.dto.UserGoodsCollectDTO;
import com.maruko.mall.user.server.client.facade.api.IUserGoodsCollectFacade;
import com.maruko.mall.user.server.service.IUserGoodsCollectService;
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
 * 用户_商品收藏表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@RestController
public class UserGoodsCollectController implements IUserGoodsCollectFacade {

	@Autowired
	private IUserGoodsCollectService userGoodsCollectService;

	@Override
	public BaseResponse add(@RequestBody UserGoodsCollectDTO userGoodsCollectDTO) {
		return userGoodsCollectService.add(userGoodsCollectDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserGoodsCollectDTO userGoodsCollectDTO) {
		return userGoodsCollectService.update(userGoodsCollectDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Integer id) {
		return userGoodsCollectService.remove(id);
	}

	@Override
	public ObjectRestResponse<UserGoodsCollectDTO> findById(@PathVariable("id") Integer id) {
		return userGoodsCollectService.findById(id);
	}

	@Override
	public ListRestResponse<UserGoodsCollectDTO> query(@RequestBody UserGoodsCollectDTO userGoodsCollectDTO) {
		return userGoodsCollectService.query(userGoodsCollectDTO);
	}

	@Override
	public TableResultResponse<UserGoodsCollectDTO> page(@RequestBody PageRestRequest<UserGoodsCollectDTO> pageRestRequest) {
		return userGoodsCollectService.page(pageRestRequest.getData(), pageRestRequest.getPage());
	}

	@Override
	public ObjectRestResponse<UserGoodsCollectDTO> findByCondition(@RequestBody UserGoodsCollectDTO userGoodsCollectDTO) {
		return userGoodsCollectService.findByCondition(userGoodsCollectDTO);
	}
}