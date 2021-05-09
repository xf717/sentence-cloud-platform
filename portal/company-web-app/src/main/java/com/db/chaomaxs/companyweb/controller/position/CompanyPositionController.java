package com.db.chaomaxs.companyweb.controller.position;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionAddDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionUpdateDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionPageDTO;
import com.db.chaomaxs.companyweb.controller.position.vo.CompanyPositionBasePageVO;
import com.db.chaomaxs.companyweb.controller.position.vo.CompanyPositionPageVO;
import com.db.chaomaxs.companyweb.controller.position.vo.CompanyPositionVO;
import com.db.chaomaxs.companyweb.manager.position.CompanyPositionManager;
import com.db.chaomaxs.companyweb.service.position.vo.PositionDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-03-29 16:36:57
 */
@Api(value = "企业_职位", description = "企业_职位", tags = "CompanyPosition")
@RestController
@RequestMapping("/rest/companyPosition")
public class CompanyPositionController {

    @Autowired
    private CompanyPositionManager companyPositionManager;

    /**
     * 添加数据
     *
     * @param addDTO
     * @return
     */
    @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
    @PostMapping("/save")
    public BaseResponse save(@Valid @RequestBody CompanyPositionAddDTO addDTO) {
        companyPositionManager.save(addDTO);
        return BaseResponse.success("保存成功");
    }

    /**
     * 更新数据
     *
     * @param updateDTO
     * @return
     */
    @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
    @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
    @PutMapping("/update/{id}")
    public BaseResponse update(@Valid @RequestBody CompanyPositionUpdateDTO updateDTO) {
        companyPositionManager.update(updateDTO);
        return BaseResponse.success("更新成功");
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
        companyPositionManager.remove(id);
        return BaseResponse.success("删除成功");
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
    public ObjectRestResponse<CompanyPositionVO> getCompanyPositionById(@PathVariable("id") Long id) {
        return ObjectRestResponse.success(companyPositionManager.getCompanyPositionById(id));
    }

    @ApiOperation(value = "获取对象数据", nickname = "get")
    @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
    @GetMapping("/detail/{id}")
    public ObjectRestResponse<PositionDetailVO> getCompanyPositionDetailById(@PathVariable("id") Long id) {
        return ObjectRestResponse.success(companyPositionManager.getCompanyPositionDetailById(id));
    }

    @ApiOperation(value = "招聘端手机分页", nickname = "page")
    @PostMapping("/base/page")
    public TableResultResponse<CompanyPositionBasePageVO> basePage(@RequestBody CompanyPositionPageDTO pageReqDTO) {
        return companyPositionManager.basePageCompanyPosition(pageReqDTO);
    }

    @ApiOperation(value = "招聘端PC分页", nickname = "page")
    @PostMapping("/page")
    public TableResultResponse<CompanyPositionPageVO> page(@RequestBody CompanyPositionPageDTO pageReqDTO) {
        return companyPositionManager.pageCompanyPosition(pageReqDTO);
    }
}
