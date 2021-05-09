package com.db.chaomaxs.positionservice.rpc.position.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionAuditReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionHandoverReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateStateDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.IdsReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.ManagementPositionPageRespDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 企业_职位
 *
 * @author momo
 * @date 2021-03-29 16:36:57
 */
public interface CompanyPositionApi {

    /**
     * 添加数据
     *
     * @param createReqDTO 添加参数
     * @return
     */
    @PostMapping("/facade/companyPosition/save")
    BaseResponse save(@RequestBody CompanyPositionCreateReqDTO createReqDTO);

    /**
     * 更新数据
     *
     * @param updateReqDTO 更新参数
     * @return
     */
    @PutMapping("/facade/companyPosition/update")
    BaseResponse update(@RequestBody CompanyPositionUpdateReqDTO updateReqDTO);

    /**
     * 根据ID删除数据
     *
     * @param id id
     * @return
     */
    @DeleteMapping("/facade/companyPosition/remove/{id}")
    BaseResponse remove(@PathVariable("id") Long id);

    /**
     * 根据Id查找
     *
     * @param id id
     * @return
     */
    @GetMapping("/facade/companyPosition/get/{id}")
    ObjectRestResponse<CompanyPositionDetailRespDTO> getCompanyPositionById(@PathVariable("id") Long id);

    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    @PostMapping("/facade/companyPosition/page")
    TableResultResponse<CompanyPositionPageRespDTO> page(@RequestBody CompanyPositionPageReqDTO pageReqDTO);

    /**
     * 查找数据显示分页
     *
     * @param idsReqDTO 分页参数
     * @return
     */
    @PostMapping("/facade/companyPosition/ids")
    ObjectRestResponse<List<CompanyPositionRespDTO>> getCompanyPositionsByIds(@RequestBody IdsReqDTO idsReqDTO);


    @PostMapping("/facade/companyPosition/update/state")
    BaseResponse updateCompanyPositionStatus(@RequestBody CompanyPositionAuditReqDTO companyPositionAuditReqDTO);


    @PostMapping("/facade/managementPosition/page")
    TableResultResponse<ManagementPositionPageRespDTO> managementPage(@RequestBody CompanyPositionPageReqDTO pageReqDTO);

    /**
     * 根据企业用户id修改企业职位状态
     * @param companyPositionUpdateStateDTO
     * @return
     */
    @PostMapping("/facade/companyPosition/update-by-companyUserId")
    BaseResponse updateByCompanyUserId(@RequestBody CompanyPositionUpdateStateDTO companyPositionUpdateStateDTO);

    /**
     * 职位交接
     * @param companyPositionHandoverReqDTO
     * @return
     */
    @PostMapping("/facade/companyPosition/handover")
    BaseResponse handover(@RequestBody CompanyPositionHandoverReqDTO companyPositionHandoverReqDTO);
}
