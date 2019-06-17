package com.maruko.mall.user.server.client.facade.api;

import com.maruko.mall.common.msg.BaseResponse;
import com.maruko.mall.common.msg.ListRestResponse;
import com.maruko.mall.common.msg.ObjectRestResponse;
import com.maruko.mall.common.msg.TableResultResponse;
import com.maruko.mall.common.page.PageRestRequest;
import com.maruko.mall.user.server.client.dto.UserThirdDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
public interface IUserThirdFacade {

	/**
	 * 添加数据
	 * @param userThirdDTO
	 * @return
	 */
	@PostMapping("/facade/userThird/add")
	BaseResponse add(@RequestBody UserThirdDTO userThirdDTO);

	/**
	 * 更新数据
	 * @param userThirdDTO
	 * @return
	 */
	@PutMapping("/facade/userThird/update")
	BaseResponse update(@RequestBody UserThirdDTO userThirdDTO);

	/**
	 * 根据ID删除数据
	 * @param id
	 * @return
	 */
	@DeleteMapping("/facade/userThird/remove/{id}")
	BaseResponse remove(@PathVariable("id") Integer id);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	@GetMapping("/facade/userThird/findById/{id}")
	ObjectRestResponse<UserThirdDTO> findById(@PathVariable("id") Integer id);


	/**
	 * 根据条件查找数据
	 * @param userThirdDTO
	 * @return
	 */
	@PostMapping("/facade/userThird/query")
	ListRestResponse<UserThirdDTO> query(@RequestBody UserThirdDTO userThirdDTO);

	/**
	 * 查找数据显示分页
	 * @param pageRestRequest
	 * @return
	 */
	@PostMapping("/facade/userThird/page")
	TableResultResponse<UserThirdDTO> page(@RequestBody PageRestRequest<UserThirdDTO> pageRestRequest);

	/**
	 * 根据条件查找数据
	 * @param userThirdDTO
	 * @return
	 */
	@PostMapping("/facade/userThird/findByCondition")
	ObjectRestResponse<UserThirdDTO> findByCondition(@RequestBody UserThirdDTO userThirdDTO);

}
