package com.db.chaomaxs.managementweb.convert.position;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.managementweb.controller.position.dto.ManagementPositionAuditDTO;
import com.db.chaomaxs.managementweb.controller.position.dto.ManagementPositionPageDTO;
import com.db.chaomaxs.managementweb.controller.position.dto.ManagementPositionUpdateDTO;
import com.db.chaomaxs.managementweb.controller.position.vo.ManagementPositionPageVO;
import com.db.chaomaxs.managementweb.controller.position.vo.ManagementPositionVO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionAuditReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.ManagementPositionPageRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换企业_职位
 *
 * @author xiaofeng
 * @date 2021-03-29 16:36:57
 */
@Mapper
public interface ManagementPositionConvert {

    ManagementPositionConvert INSTANCE = Mappers.getMapper(ManagementPositionConvert.class);


    @Mappings({})
    CompanyPositionUpdateReqDTO convert(ManagementPositionUpdateDTO updateDTO);


    @Mappings({})
    TableResultResponse<ManagementPositionPageVO> convert(
            TableResultResponse<ManagementPositionPageRespDTO> tableResultResponse);


    @Mappings({})
    ManagementPositionVO convert(CompanyPositionDetailRespDTO pageDTO);

    @Mappings({})
    CompanyPositionAuditReqDTO convert(ManagementPositionAuditDTO companyPositionAuditDTO);


    @Mappings({})
    CompanyPositionPageReqDTO convert(ManagementPositionPageDTO managementPositionPageDTO);


}
