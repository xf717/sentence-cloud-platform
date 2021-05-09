package com.db.chaomaxs.userservice.rpc.user.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyBatchInsertReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyPageReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserHideCompanyRespDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_屏蔽公司
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
public interface UserHideCompanyApi {

	/**
	 * 批量添加数据
	 * @param batchInsertReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userHideCompany/batch/save")
	BaseResponse save(@RequestBody UserHideCompanyBatchInsertReqDTO batchInsertReqDTO);


	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userHideCompany/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userHideCompany/get/{id}")
	ObjectRestResponse<UserHideCompanyRespDTO> getUserHideCompanyById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userHideCompany/list")
	ObjectRestResponse<List<UserHideCompanyRespDTO>> listUserHideCompanys(
      @RequestBody UserHideCompanyListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userHideCompany/page")
	TableResultResponse<UserHideCompanyRespDTO> page(
      @RequestBody UserHideCompanyPageReqDTO pageReqDTO);

}
