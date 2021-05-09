package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.companyservice.rpc.track.dto.CompanyUserTrackRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackRespDTO;
import com.github.xf717.userweb.service.postition.bo.UserPositionBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author momo
 * @date 2021-05-06 09:45
 */
@Mapper
public interface UserPositionConvert {
    UserPositionConvert INSTANCE = Mappers.getMapper(UserPositionConvert.class);

    /**
     * 用户足迹转为用户职位对象
     *
     * @param tableResultResponse
     * @return
     */
    @Mappings({})
    TableResultResponse<UserPositionBO> convertFromUserTrack(TableResultResponse<UserTrackRespDTO> tableResultResponse);


    /**
     * 用户足迹转为用户职位对象
     *
     * @param tableResultResponse
     * @return
     */
    @Mappings({})
    TableResultResponse<UserPositionBO> convertFromCompanyUserTrack(TableResultResponse<CompanyUserTrackRespDTO> tableResultResponse);


    /**
     * 用户足迹转为用户职位对象
     *
     * @param companyUserTrackRespDTO
     * @return
     */
    @Mappings({})
    UserPositionBO convertFromUserTrack(CompanyUserTrackRespDTO companyUserTrackRespDTO);


}
