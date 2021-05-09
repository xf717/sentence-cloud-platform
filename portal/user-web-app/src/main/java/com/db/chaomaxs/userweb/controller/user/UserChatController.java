package com.db.chaomaxs.userweb.controller.user;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userweb.controller.user.dto.UserChatAddDTO;
import com.db.chaomaxs.userweb.controller.user.dto.UserChatPageDTO;
import com.db.chaomaxs.userweb.controller.user.vo.UserChatVO;
import com.db.chaomaxs.userweb.manager.user.UserChatManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户_沟通
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Api(value = "用户_沟通", description = "用户_沟通", tags = "用户_沟通")
@RestController
@RequestMapping("/rest/userChat")
public class UserChatController {

    @Autowired
    private UserChatManager userChatManager;

    /**
     * 添加数据
     *
     * @param addDTO
     * @return
     */
    @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
    @PostMapping("/save")
    public BaseResponse save(@Valid @RequestBody UserChatAddDTO addDTO) {
        userChatManager.save(addDTO);
        return BaseResponse.success("保存成功");
    }

    @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
    @PostMapping("/page")
    public TableResultResponse<UserChatVO> page(@RequestBody UserChatPageDTO pageReqDTO) {
        return userChatManager.pageUserChat(pageReqDTO);
    }

}
