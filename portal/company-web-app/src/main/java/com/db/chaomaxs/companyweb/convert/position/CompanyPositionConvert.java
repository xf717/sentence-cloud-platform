package com.db.chaomaxs.companyweb.convert.position;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionAuditDTO;
import com.db.chaomaxs.companyweb.controller.position.vo.CompanyPositionBasePageVO;
import com.db.chaomaxs.companyweb.controller.position.vo.CompanyPositionPageVO;
import com.db.chaomaxs.companyweb.service.position.vo.PositionDetailVO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionAuditReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionAddDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionPageDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionUpdateDTO;
import com.db.chaomaxs.companyweb.controller.position.vo.CompanyPositionVO;

import java.util.List;

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
public interface CompanyPositionConvert {

    CompanyPositionConvert INSTANCE = Mappers.getMapper(CompanyPositionConvert.class);

    /**
     * AddDTO convert AddBO
     *
     * @param addDTO 转换对象
     * @return
     */
    @Mappings({})
    CompanyPositionCreateReqDTO convert(CompanyPositionAddDTO addDTO);

    /**
     * UpdateDTO convert UpdateBO
     *
     * @param updateDTO 转换对象
     * @return
     */
    @Mappings({})
    CompanyPositionUpdateReqDTO convert(CompanyPositionUpdateDTO updateDTO);

    /**
     * 对象转换
     *
     * @param companyPositionDTO 查询参数对象
     * @return
     */
    @Mappings({})
    CompanyPositionListQueryReqDTO convert(CompanyPositionDTO companyPositionDTO);

    /**
     * 对象转成VO
     *
     * @param respDTO 转换对象
     * @return
     */
    @Mappings({})
    CompanyPositionVO convert(CompanyPositionRespDTO respDTO);

    /**
     * list 转换成 VO list
     *
     * @param listResp
     * @return
     */
    @Mappings({})
    List<CompanyPositionVO> convertList(List<CompanyPositionRespDTO> listResp);

    /**
     * 分页转换
     *
     * @param tableResultResponse 转换对象
     * @return
     */
    @Mappings({})
    TableResultResponse<CompanyPositionVO> convert(
            TableResultResponse<CompanyPositionPageRespDTO> tableResultResponse);

    /**
     * 分页对象转换
     *
     * @param pageDTO
     * @return
     */
    @Mappings({})
    CompanyPositionPageReqDTO convert(CompanyPositionPageDTO pageDTO);


    /**
     * CompanyPositionAuditDTO convert CompanyPositionAuditReqDTO
     *
     * @param auditDTO 转换对象
     * @return
     */
    @Mappings({})
    CompanyPositionAuditReqDTO convert(CompanyPositionAuditDTO auditDTO);

    @Mappings({})
    CompanyPositionVO convert(CompanyPositionDetailRespDTO detailRespDTO);


    /**
     * 分页转换
     *
     * @param tableResultResponse 转换对象
     * @return
     */
    @Mappings({})
    TableResultResponse<CompanyPositionPageVO> convertPage(TableResultResponse<CompanyPositionPageRespDTO> tableResultResponse);

    /**
     * 分页转换
     * @param companyPositionDetailRespDTO
     * @return
     */
    @Mappings({})
    PositionDetailVO convertDetail(CompanyPositionDetailRespDTO companyPositionDetailRespDTO);

    /**
     * 分页转换
     * @param tableResultResponse
     * @return
     */
    @Mappings({})
    TableResultResponse<CompanyPositionBasePageVO> convertBasePage(TableResultResponse<CompanyPositionPageRespDTO> tableResultResponse);
}
