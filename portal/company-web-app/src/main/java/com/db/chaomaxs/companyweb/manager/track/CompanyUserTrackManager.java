package com.db.chaomaxs.companyweb.manager.track;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.facade.CompanyUserTrackRpcFacade;
import com.db.chaomaxs.companyweb.controller.track.dto.CompanyUserTrackAddDTO;
import com.db.chaomaxs.companyweb.convert.track.CompanyUserTrackConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserTrackManager
 *
 * @author momo
 * @date 2021-03-26 10:18:32
 */
@Service
@Validated
public class CompanyUserTrackManager {

    @Autowired
    private CompanyUserTrackRpcFacade companyUserTrackRpcFacade;

    /**
     * 添加数据
     *
     * @param companyUserTrackAddDTO 添加参数
     * @return
     */
    public int save(CompanyUserTrackAddDTO companyUserTrackAddDTO) {
        CompanyUserTrackCreateReqDTO reqDTO = CompanyUserTrackConvert.INSTANCE.convert(companyUserTrackAddDTO);
        reqDTO.setCompanyUserId(BaseContextHandler.getUserId());
        BaseResponse baseResponse = companyUserTrackRpcFacade.save(reqDTO);
        baseResponse.checkError();
        return baseResponse.isSuccess() ? 1 : 0;
    }
}
