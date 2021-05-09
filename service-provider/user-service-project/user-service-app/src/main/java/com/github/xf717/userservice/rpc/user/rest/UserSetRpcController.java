package com.github.xf717.userservice.rpc.user.rest;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.rpc.user.UserSetRpcImpl;
import com.github.xf717.userservice.rpc.user.dto.UserSetCreateReqDTO;
import com.github.xf717.userservice.rpc.user.facade.api.UserSetApi;
import com.github.xf717.userservice.rpc.user.dto.UserSetRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserSetUpdateReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_设置
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@RestController
public class UserSetRpcController implements UserSetApi {

    @Autowired
    private UserSetRpcImpl userSetRpc;

	@Override
	public BaseResponse save(@RequestBody UserSetCreateReqDTO createReqDTO) {
		return userSetRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody UserSetUpdateReqDTO updateReqDTO) {
		return userSetRpc.update(updateReqDTO);
	}

    @Override
    public ObjectRestResponse<UserSetRespDTO> getUserSetById(@PathVariable("id") Long id) {
        return userSetRpc.getUserSetById(id);
    }

	@Override
	public ObjectRestResponse<UserSetRespDTO> getUserSetByUserIdAndCompanyUserId(Long userId, Long companyUserId) {
		return userSetRpc.getUserSetByUserIdAndCompanyUserId(userId,companyUserId);
	}
}
