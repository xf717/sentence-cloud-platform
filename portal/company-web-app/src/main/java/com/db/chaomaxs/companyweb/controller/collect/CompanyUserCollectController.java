package com.db.chaomaxs.companyweb.controller.collect;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.collect.dto.CompanyUserCollectAddDTO;
import com.db.chaomaxs.companyweb.controller.collect.dto.CompanyUserCollectPageDTO;
import com.db.chaomaxs.companyweb.controller.collect.vo.CompanyUserCollectVO;
import com.db.chaomaxs.companyweb.manager.collect.CompanyUserCollectManager;
import com.db.chaomaxs.companyweb.service.resume.vo.UserResumeInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业_用户_收藏
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "企业_用户_收藏", description = "企业_用户_收藏", tags = "CompanyUserCollect")
@RestController
@RequestMapping("/rest/companyUserCollect")
public class CompanyUserCollectController {

    @Autowired
    private CompanyUserCollectManager companyUserCollectManager;

    /**
     * 添加数据
     *
     * @param companyUserCollectAddDTO
     * @return
     */
    @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
    @PostMapping("/save")
    public BaseResponse save(@Valid @RequestBody CompanyUserCollectAddDTO companyUserCollectAddDTO) {
        companyUserCollectManager.save(companyUserCollectAddDTO);
        return BaseResponse.success("保存成功");
    }

    /**
     * 获取数据
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取对象数据", nickname = "get")
    @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
    @GetMapping("/get/{id}")
    public ObjectRestResponse<CompanyUserCollectVO> getCompanyUserCollectById(@PathVariable("id") Long id) {
        return ObjectRestResponse.success(companyUserCollectManager.getCompanyUserCollectById(id));
    }


    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除数据", nickname = "remove")
    @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
    @DeleteMapping("/remove/{id}")
    public BaseResponse remove(@PathVariable("id") Long id) {
        companyUserCollectManager.remove(id);
        return BaseResponse.success("删除成功");
    }


    @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
    @PostMapping("/page")
    public TableResultResponse<UserResumeInfoVO> page(@RequestBody CompanyUserCollectPageDTO pageReqDTO) {
        return companyUserCollectManager.pageCompanyUserCollect(pageReqDTO);
    }

}
