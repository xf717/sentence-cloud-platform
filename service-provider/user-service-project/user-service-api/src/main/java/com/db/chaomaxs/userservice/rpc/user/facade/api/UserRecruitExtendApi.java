package com.db.chaomaxs.userservice.rpc.user.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserRecruitExtendPageReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_招聘_扩展表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:54:37
 */
public interface UserRecruitExtendApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userRecruitExtend/save")
	BaseResponse save(@RequestBody UserRecruitExtendCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userRecruitExtend/update")
	BaseResponse update(@RequestBody UserRecruitExtendUpdateReqDTO updateReqDTO);

	/**
	 * 根据ID删除数据
	 * @param id  id
	 * @return
	 */
	@DeleteMapping("/facade/userRecruitExtend/remove/{id}")
	BaseResponse remove(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 * @param id id
	 * @return
	 */
	@GetMapping("/facade/userRecruitExtend/get/{id}")
	ObjectRestResponse<UserRecruitExtendRespDTO> getUserRecruitExtendById(@PathVariable("id") Long id);


	/**
	 * 根据条件查找数据
	 * @param listQuery  查询参数
	 * @return
	 */
	@PostMapping("/facade/userRecruitExtend/list")
	ObjectRestResponse<List<UserRecruitExtendRespDTO>> listUserRecruitExtends(
      @RequestBody UserRecruitExtendListQueryReqDTO listQuery);

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/userRecruitExtend/page")
	TableResultResponse<UserRecruitExtendRespDTO> page(
      @RequestBody UserRecruitExtendPageReqDTO pageReqDTO);

}
