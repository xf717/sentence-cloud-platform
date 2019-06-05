package com.maruko.mall.user.server.client.facade.api;


import com.maruko.mall.user.server.client.dto.UserExtendDTO;

/**
 * 用户_扩展表
 *
 * @author xiaofeng
 * @date 2019-06-04 22:35:12
 */
public interface IUserExtendFacade {

	/**
	 * 添加数据
	 * @param userExtendDTO
	 * @return
	 */
	@PostMapping("/facade/userExtend/add")
	BaseResponse add(@RequestBody UserExtendDTO userExtendDTO);

	/**
	 * 更新数据
	 * @param userExtendDTO
	 * @return
	 */
	@PutMapping("/facade/userExtend/update")
	BaseResponse update(@RequestBody UserExtendDTO userExtendDTO);

	/**
	 * 根据ID删除数据
	 * @param id
	 * @return
	 */
	@DeleteMapping("/facade/userExtend/remove/{id}")
	BaseResponse remove(@PathVariable("id") Integer id);

	/**
	 * 根据Id查找
	 * @param id
	 * @return
	 */
	@GetMapping("/facade/userExtend/findById/{id}")
	ObjectRestResponse<UserExtendDTO> findById(@PathVariable("id") Integer id);


	/**
	 * 根据条件查找数据
	 * @param userExtendDTO
	 * @return
	 */
	@PostMapping("/facade/userExtend/query")
	ListRestResponse<UserExtendDTO> query(@RequestBody UserExtendDTO userExtendDTO);

	/**
	 * 查找数据显示分页
	 * @param pageRestRequest
	 * @return
	 */
	@PostMapping("/facade/userExtend/page")
	TableResultResponse<UserExtendDTO> page(@RequestBody PageRestRequest<UserExtendDTO> pageRestRequest);

	/**
	 * 根据条件查找数据
	 * @param userExtendDTO
	 * @return
	 */
	@PostMapping("/facade/userExtend/findByCondition")
	ObjectRestResponse<UserExtendDTO> findByCondition(@RequestBody UserExtendDTO userExtendDTO);

}
