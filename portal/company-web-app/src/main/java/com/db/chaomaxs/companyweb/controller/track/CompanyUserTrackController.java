package com.db.chaomaxs.companyweb.controller.track;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.companyweb.controller.track.dto.CompanyUserTrackAddDTO;
import com.db.chaomaxs.companyweb.manager.track.CompanyUserTrackManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * 企业我的足迹
 *
 * @author momo
 * @date 2021-03-26 10:18:32
 */
@Api(value = "企业我的足迹", description = "企业我的足迹", tags = "CompanyUserTrack")
@RestController
@RequestMapping("/rest/companyUserTrack")
public class CompanyUserTrackController {

    @Autowired
    private CompanyUserTrackManager companyUserTrackManager;

    /**
     * 添加数据
     *
     * @param companyUserTrackAddDTO
     * @return
     */
    @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
    @PostMapping("/save")
    public BaseResponse save(@Valid @RequestBody CompanyUserTrackAddDTO companyUserTrackAddDTO) {
        companyUserTrackManager.save(companyUserTrackAddDTO);
        return BaseResponse.success("保存成功");
    }
}
