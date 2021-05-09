package com.db.chaomaxs.positionservice.convert.position;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.CompanyPositionDO;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.GetCompanyPositionDO;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.GetCompanyPositionKeywordDO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionAuditReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;

import java.util.List;

import com.db.chaomaxs.positionservice.rpc.position.dto.ManagementPositionPageRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * CompanyPositionConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Mapper
public interface CompanyPositionConvert {

    CompanyPositionConvert INSTANCE = Mappers.getMapper(CompanyPositionConvert.class);

    /**
     * createReq 转换
     *
     * @param createReqDTO
     * @return
     */
    CompanyPositionDO convert(CompanyPositionCreateReqDTO createReqDTO);

    /**
     * updateReq 转换
     *
     * @param updateReqDTO
     * @return
     */
    CompanyPositionDO convert(CompanyPositionUpdateReqDTO updateReqDTO);

    /**
     * list 转换
     *
     * @param list
     * @return
     */
    List<CompanyPositionRespDTO> convertList(List<CompanyPositionDO> list);


    /**
     * 对象转换
     *
     * @param companyPositionDO
     * @return
     */
    CompanyPositionRespDTO convert(CompanyPositionDO companyPositionDO);

    /**
     * 对象转换
     *
     * @param getCompanyPositionDO
     * @return
     */
    CompanyPositionDetailRespDTO convertDetail(GetCompanyPositionDO getCompanyPositionDO);


    @Mapping(target = "status", ignore = true)
    CompanyPositionPageRespDTO convertPageResp(CompanyPositionDO companyPositionDO);

    /**
     * 分布转换对象
     *
     * @param page
     * @return
     */
    @Mapping(source = "records", target = "list")
    PageResult<CompanyPositionPageRespDTO> convertPage(IPage<CompanyPositionDO> page);

    @Mappings({
            @Mapping(source = "auditUserId", target = "updateBy"),
    })
    CompanyPositionDO convert(CompanyPositionAuditReqDTO auditReqDTO);

    @Mapping(target = "status", ignore = true)
    ManagementPositionPageRespDTO convertManagementPageResp(CompanyPositionDO companyPositionDO);
}
