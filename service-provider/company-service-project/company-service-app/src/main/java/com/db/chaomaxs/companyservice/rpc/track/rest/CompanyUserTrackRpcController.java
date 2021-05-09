package com.db.chaomaxs.companyservice.rpc.track.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.track.CompanyUserTrackRpcImpl;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackRespDTO;
import com.db.chaomaxs.companyservice.rpc.track.facade.api.CompanyUserTrackApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@RestController
public class CompanyUserTrackRpcController implements CompanyUserTrackApi {

    @Autowired
    private CompanyUserTrackRpcImpl companyUserTrackRpc;

    @Override
    public BaseResponse save(@RequestBody CompanyUserTrackCreateReqDTO companyUserTrackCreateReqDTO) {
        return companyUserTrackRpc.save(companyUserTrackCreateReqDTO);
    }


    @Override
    public TableResultResponse<CompanyUserTrackRespDTO> page(@RequestBody CompanyUserTrackPageReqDTO page) {
        return companyUserTrackRpc.page(page);
    }

    @Override
    public ObjectRestResponse<CompanyUserTrackRespDTO> getCompanyUserTrackById(@PathVariable("id") Long id) {
        return companyUserTrackRpc.getCompanyUserTrackById(id);
    }
}
