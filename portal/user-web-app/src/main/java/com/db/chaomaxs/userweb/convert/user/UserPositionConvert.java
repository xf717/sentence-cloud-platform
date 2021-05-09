package com.db.chaomaxs.userweb.convert.user;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackRespDTO;
import com.db.chaomaxs.userweb.service.postition.bo.UserPositionBO;
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
