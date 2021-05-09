package com.db.chaomaxs.userservice.rpc.user.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRegisterCityPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户注册城市表，注册时保存
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
public interface UserRegisterCityApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userRegisterCity/save")
	BaseResponse save(@RequestBody UserRegisterCityCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userRegisterCity/update")
	BaseResponse update(@RequestBody UserRegisterCityUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userRegisterCity/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userRegisterCity/get/{id}")
	ObjectRestResponse<UserRegisterCityRespDTO> getUserRegisterCityById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userRegisterCity/list")
	ObjectRestResponse<List<UserRegisterCityRespDTO>> listUserRegisterCitys(
      @RequestBody UserRegisterCityListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userRegisterCity/page")
	TableResultResponse<UserRegisterCityRespDTO> page(
      @RequestBody UserRegisterCityPageReqDTO pageReqDTO);

}
