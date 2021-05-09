package com.db.chaomaxs.managementweb.controller.position;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.position.dto.ManagementPositionAuditDTO;
import com.db.chaomaxs.managementweb.controller.position.dto.ManagementPositionPageDTO;
import com.db.chaomaxs.managementweb.controller.position.dto.ManagementPositionUpdateDTO;
import com.db.chaomaxs.managementweb.controller.position.vo.ManagementPositionPageVO;
import com.db.chaomaxs.managementweb.controller.position.vo.ManagementPositionVO;
import com.db.chaomaxs.managementweb.manager.position.ManagementPositionManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "职位_管理", description = "后台管理", tags = "CompanyPosition")
@RestController
@RequestMapping("/rest/managementPosition")
public class ManagementPositionController {

    @Autowired
    private ManagementPositionManager managementPositionManager;


    /**
     * 更新数据
     *
     * @param updateDTO
     * @return
     */
    @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
    @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
    @PutMapping("/update/{id}")
    public BaseResponse update(@Valid @RequestBody ManagementPositionUpdateDTO updateDTO) {
        managementPositionManager.update(updateDTO);
        return BaseResponse.success("更新成功");
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
    public ObjectRestResponse<ManagementPositionVO> getCompanyPositionById(@PathVariable("id") Long id) {
        return ObjectRestResponse.success(managementPositionManager.getCompanyPositionById(id));
    }

    @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
    @PostMapping("/page")
    public TableResultResponse<ManagementPositionPageVO> page(@RequestBody ManagementPositionPageDTO pageReqDTO) {
        return managementPositionManager.pageCompanyPosition(pageReqDTO);
    }


    @ApiOperation(value = "职位审核", nickname = "page")
    @PostMapping("/update/status")
    public BaseResponse updateCompanyPositionStatus(@RequestBody ManagementPositionAuditDTO companyPositionAuditDTO) {
        managementPositionManager.updateCompanyPositionStatus(companyPositionAuditDTO);
        return BaseResponse.success("审核成功");
    }

}
