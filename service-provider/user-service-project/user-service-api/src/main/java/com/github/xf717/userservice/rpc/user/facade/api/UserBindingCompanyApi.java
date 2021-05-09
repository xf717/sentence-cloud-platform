package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingInfoRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingStateUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingTransferReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户_企业绑定
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
public interface UserBindingCompanyApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userBindingCompany/save")
	BaseResponse save(@RequestBody UserBindingCompanyCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userBindingCompany/update")
	BaseResponse update(@RequestBody UserBindingCompanyUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userBindingCompany/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userBindingCompany/get/{id}")
	ObjectRestResponse<UserBindingCompanyRespDTO> getUserBindingCompanyById(
      @PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userBindingCompany/list")
	ObjectRestResponse<List<UserBindingCompanyRespDTO>> listUserBindingCompanys(
      @RequestBody UserBindingCompanyListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userBindingCompany/page")
	TableResultResponse<UserBindingInfoRespDTO> page(
      @RequestBody UserBindingCompanyPageReqDTO pageReqDTO);

	/**
	 * 绑定状态修改
	 * @param bindingStateUpdateReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userBindingCompany/update/binding-state")
	BaseResponse updateBindingState(@RequestBody UserBindingStateUpdateReqDTO bindingStateUpdateReqDTO);

	/**
	 * 获取公司所有绑定用户
	 * @param companyId
	 * @return
	 */
	@GetMapping("/facade/userBindingCompany/getAllBindingUser")
	ObjectRestResponse<List<UserBindingExtendRespDTO>> getAllBindingUser(@RequestParam("companyId") Long companyId);

	/**
	 * 管理员身份转移
	 * @param userBindingTransferReqDTO
	 * @return
	 */
	@PostMapping("/facade/userBindingCompany/managerTransfer")
	BaseResponse managerTransfer(@RequestBody UserBindingTransferReqDTO userBindingTransferReqDTO);

	/**
	 * 交接
	 * @param userBindingTransferReqDTO
	 * @return
	 */
	@PostMapping("/facade/userBindingCompany/handover")
	BaseResponse handover(@RequestBody UserBindingTransferReqDTO userBindingTransferReqDTO);

}
