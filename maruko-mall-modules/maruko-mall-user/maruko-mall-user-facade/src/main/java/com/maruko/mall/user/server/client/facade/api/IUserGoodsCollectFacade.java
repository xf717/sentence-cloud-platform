package com.maruko.mall.user.server.client.facade.api;

import com.maruko.mall.user.server.client.dto.UserGoodsCollectDTO;
import com.ktpfx.common.msg.BaseResponse;
import com.ktpfx.common.msg.ListRestResponse;
import com.ktpfx.common.msg.ObjectRestResponse;
import com.ktpfx.common.msg.TableResultResponse;
import com.ktpfx.common.page.PageRestRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户_商品收藏表
 *
 * @author xiaofeng
 * @date 2019-06-04 22:35:12
 */
public interface IUserGoodsCollectFacade {

	/**
	 * 添加数据
	 * @param userGoodsCollectDTO
	 * @return
	 */
	@PostMapping("/facade/userGoodsCollect/add")
	BaseResponse add(@RequestBody UserGoodsCollectDTO userGoodsCollectDTO);

	/**
	 * 更新数据
	 * @param userGoodsCollectDTO
	 * @return
	 */
	@PutMapping("/facade/userGoodsCollect/update")
	BaseResponse update(@RequestBody UserGoodsCollectDTO userGoodsCollectDTO);

	/**
	 * 根据ID删除数据
	 * @param id
	 * @return
	 */
	@DeleteMapping("/facade/userGoodsCollect/remove/{id}")
	BaseResponse remove(@PathVariable("id") Integer id);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	@GetMapping("/facade/userGoodsCollect/findById/{id}")
	ObjectRestResponse<UserGoodsCollectDTO> findById(@PathVariable("id") Integer id);


	/**
	 * 根据条件查找数据
	 * @param userGoodsCollectDTO
	 * @return
	 */
	@PostMapping("/facade/userGoodsCollect/query")
	ListRestResponse<UserGoodsCollectDTO> query(@RequestBody UserGoodsCollectDTO userGoodsCollectDTO);

	/**
	 * 查找数据显示分页
	 * @param pageRestRequest
	 * @return
	 */
	@PostMapping("/facade/userGoodsCollect/page")
	TableResultResponse<UserGoodsCollectDTO> page(@RequestBody PageRestRequest<UserGoodsCollectDTO> pageRestRequest);

	/**
	 * 根据条件查找数据
	 * @param userGoodsCollectDTO
	 * @return
	 */
	@PostMapping("/facade/userGoodsCollect/findByCondition")
	ObjectRestResponse<UserGoodsCollectDTO> findByCondition(@RequestBody UserGoodsCollectDTO userGoodsCollectDTO);

}
