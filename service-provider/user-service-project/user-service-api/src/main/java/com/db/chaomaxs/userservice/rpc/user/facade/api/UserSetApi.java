package com.db.chaomaxs.userservice.rpc.user.facade.api;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserSetUpdateReqDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户_设置
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
public interface UserSetApi {

	/**
	 * 添加数据
	 * @param createReqDTO 添加参数
	 * @return
	 */
	@PostMapping("/facade/userSet/save")
	BaseResponse save(@RequestBody UserSetCreateReqDTO createReqDTO);

	/**
	 * 更新数据
	 * @param updateReqDTO  更新参数
	 * @return
	 */
	@PutMapping("/facade/userSet/update")
	BaseResponse update(@RequestBody UserSetUpdateReqDTO updateReqDTO);

    /**
     * 根据Id查找
     *
     * @param id id
     * @return
     */
    @GetMapping("/facade/userSet/get/{id}")
    ObjectRestResponse<UserSetRespDTO> getUserSetById(@PathVariable("id") Long id);

	/**
	 * 根据Id查找
	 *
	 * @param
	 * @return
	 */
	@GetMapping("/facade/userSet/get")
	ObjectRestResponse<UserSetRespDTO> getUserSetByUserIdAndCompanyUserId(@RequestParam("id") Long userId,@RequestParam("companyUserId") Long companyUserId);
}
