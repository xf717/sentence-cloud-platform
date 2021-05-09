package com.db.chaomaxs.companyservice.rpc.track;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.track.CompanyUserTrackManager;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackRespDTO;
import com.db.chaomaxs.companyservice.rpc.track.facade.CompanyUserTrackRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @data 2021-03-26 10:18:33
 */
@Slf4j
@Service
public class CompanyUserTrackRpcImpl implements CompanyUserTrackRpcFacade {

    @Autowired
    private CompanyUserTrackManager companyUserTrackManager;

    @Override
    public BaseResponse save(CompanyUserTrackCreateReqDTO companyUserTrackCreateReqDTO) {
        companyUserTrackManager.saveCompanyUserTrack(companyUserTrackCreateReqDTO);
        return BaseResponse.success("保存成功");
    }


    @Override
    public TableResultResponse<CompanyUserTrackRespDTO> page(CompanyUserTrackPageReqDTO pageReqDTO) {
        PageResult<CompanyUserTrackRespDTO> pageResult = companyUserTrackManager.pageCompanyUserTrack(pageReqDTO);
        TableResultResponse<CompanyUserTrackRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        return tableResultResponse;
    }

    @Override
    public ObjectRestResponse<CompanyUserTrackRespDTO> getCompanyUserTrackById(Long id) {
        CompanyUserTrackRespDTO companyUserTrackRespDTO = companyUserTrackManager.getCompanyUserTrackById(id);
        return new ObjectRestResponse<>().data(companyUserTrackRespDTO);
    }

}
