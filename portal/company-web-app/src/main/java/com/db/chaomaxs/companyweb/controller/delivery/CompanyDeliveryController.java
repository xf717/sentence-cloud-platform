package com.db.chaomaxs.companyweb.controller.delivery;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.delivery.dto.CompanyDeliveryAddDTO;
import com.db.chaomaxs.companyweb.controller.delivery.dto.CompanyDeliveryPageDTO;
import com.db.chaomaxs.companyweb.controller.delivery.vo.CompanyDeliveryVO;
import com.db.chaomaxs.companyweb.manager.delivery.CompanyDeliveryManager;
import com.db.chaomaxs.companyweb.service.resume.vo.UserResumeInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业投递表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "企业投递表", description = "企业投递表", tags = "CompanyDelivery")
@RestController
@RequestMapping("/rest/companyDelivery")
public class CompanyDeliveryController {

    @Autowired
    private CompanyDeliveryManager companyDeliveryManager;

    /**
     * 添加数据
     *
     * @param companyDeliveryAddDTO
     * @return
     */
    @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
    @PostMapping("/save")
    public BaseResponse save(@Valid @RequestBody CompanyDeliveryAddDTO companyDeliveryAddDTO) {
        companyDeliveryManager.save(companyDeliveryAddDTO);
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
    public ObjectRestResponse<CompanyDeliveryVO> getCompanyDeliveryById(@PathVariable("id") Long id) {
        return ObjectRestResponse.success(companyDeliveryManager.getCompanyDeliveryById(id));
    }


    @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
    @PostMapping("/page")
    public TableResultResponse<UserResumeInfoVO> page(@RequestBody CompanyDeliveryPageDTO pageReqDTO) {
        return companyDeliveryManager.pageCompanyDelivery(pageReqDTO);
    }

}
