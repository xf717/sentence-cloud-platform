package com.db.chaomaxs.userservice.rpc.resume.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_资格证书表
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
public interface UserCredentialApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userCredential/save")
	BaseResponse save(@RequestBody UserCredentialCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userCredential/update")
	BaseResponse update(@RequestBody UserCredentialUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userCredential/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userCredential/get/{id}")
	ObjectRestResponse<UserCredentialRespDTO> getUserCredentialById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userCredential/list")
	ObjectRestResponse<List<UserCredentialRespDTO>> listUserCredentials(
      @RequestBody UserCredentialListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userCredential/page")
	TableResultResponse<UserCredentialRespDTO> page(@RequestBody UserCredentialPageReqDTO pageReqDTO);

}
