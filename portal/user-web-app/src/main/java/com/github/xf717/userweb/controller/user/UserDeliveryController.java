package com.github.xf717.userweb.controller.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userweb.controller.user.dto.UserDeliveryPageDTO;
import com.github.xf717.userweb.controller.user.vo.UserPositionCollectVO;
import com.github.xf717.userweb.manager.user.UserDeliveryManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业投递表
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Api(value = "企业投递表", description = "企业投递表", tags = "企业投递表")
@RestController
@RequestMapping("/rest/userDelivery")
public class UserDeliveryController {

    @Autowired
    private UserDeliveryManager userDeliveryManager;


    @ApiOperation(value = "用户投递根据参数查询数据,分页", nickname = "page")
    @PostMapping("/page")
    public TableResultResponse<UserPositionCollectVO> page(@RequestBody UserDeliveryPageDTO pageReqDTO) {
        return userDeliveryManager.pageUserDelivery(pageReqDTO);
    }

}
