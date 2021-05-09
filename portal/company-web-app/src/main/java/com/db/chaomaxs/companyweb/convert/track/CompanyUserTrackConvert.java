package com.db.chaomaxs.companyweb.convert.track;

import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackCreateReqDTO;
import com.db.chaomaxs.companyweb.controller.track.dto.CompanyUserTrackAddDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换企业我的足迹
 *
 * @author momo
 * @date 2021-03-26 10:18:32
 */
@Mapper
public interface CompanyUserTrackConvert {

    CompanyUserTrackConvert INSTANCE = Mappers.getMapper(CompanyUserTrackConvert.class);

    /**
     * AddDTO convert AddBO
     *
     * @param addDTO 转换对象
     * @return
     */
    @Mappings({})
    CompanyUserTrackCreateReqDTO convert(CompanyUserTrackAddDTO addDTO);


}
