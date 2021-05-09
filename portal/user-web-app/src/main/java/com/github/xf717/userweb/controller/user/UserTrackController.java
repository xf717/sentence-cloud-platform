package com.github.xf717.userweb.controller.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userweb.controller.user.dto.UserTrackAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserTrackPageDTO;
import com.github.xf717.userweb.manager.user.UserTrackManager;
import com.github.xf717.userweb.service.postition.vo.PositionDetailVO;
import com.github.xf717.userweb.service.postition.vo.PositionVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * 我的足迹
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Api(value = "我的足迹", description = "我的足迹", tags = "我的足迹")
@RestController
@RequestMapping("/rest/userTrack")
public class UserTrackController {

    @Autowired
    private UserTrackManager userTrackManager;


    /**
     * 添加数据
     *
     * @param addDTO
     * @return
     */
    @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
    @PostMapping("/save")
    public BaseResponse save(@Valid @RequestBody UserTrackAddDTO addDTO) {
        userTrackManager.save(addDTO);
        return BaseResponse.success("保存成功");
    }

    /**
     * 根据参数查询数据,分页
     *
     * @param userTrackPageDTO
     * @return
     */
    @ApiOperation(value = "我的足迹", nickname = "page")
    @PostMapping("/page")
    public TableResultResponse<PositionVO> page(@RequestBody UserTrackPageDTO userTrackPageDTO) {
        return userTrackManager.pageUserTrack(userTrackPageDTO);
    }

    @ApiOperation(value = "看过我", nickname = "page")
    @PostMapping("/company/page")
    public TableResultResponse<PositionVO> companyPage(@RequestBody UserTrackPageDTO userTrackPageDTO) {
        return userTrackManager.companyPage(userTrackPageDTO);
    }


    @ApiOperation(value = "看过我", nickname = "page")
    @GetMapping("/company/get/{id}")
    public ObjectRestResponse<PositionDetailVO> companyDetail(@PathVariable("id") Long id) {
        return ObjectRestResponse.success(userTrackManager.companyDetail(id));
    }
}
