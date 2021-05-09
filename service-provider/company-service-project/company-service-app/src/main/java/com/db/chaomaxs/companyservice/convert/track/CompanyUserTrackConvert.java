package com.db.chaomaxs.companyservice.convert.track;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.track.CompanyUserTrackDO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * CompanyUserTrackConvert
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Mapper
public interface CompanyUserTrackConvert {

    CompanyUserTrackConvert INSTANCE = Mappers.getMapper(CompanyUserTrackConvert.class);

    /**
     * 将 CompanyUserTrackDTO 转成 CompanyUserTrackVO
     *
     * @param createReqDTO
     * @return
     */
    CompanyUserTrackDO convert(CompanyUserTrackCreateReqDTO createReqDTO);


    /**
     * companyUserTrackDO 转为 CompanyUserTrackRespDTO
     *
     * @param companyUserTrackDO
     * @return
     */
    CompanyUserTrackRespDTO convert(CompanyUserTrackDO companyUserTrackDO);


    /**
     * 分布转换对象
     *
     * @param page
     * @return
     */
    @Mapping(source = "records", target = "list")
    PageResult<CompanyUserTrackRespDTO> convertPage(IPage<CompanyUserTrackDO> page);


}
