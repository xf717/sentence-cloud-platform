package com.github.xf717.userweb.manager.user;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.companyservice.rpc.track.dto.CompanyUserTrackPageReqDTO;
import com.github.xf717.companyservice.rpc.track.dto.CompanyUserTrackRespDTO;
import com.github.xf717.companyservice.rpc.track.facade.CompanyUserTrackRpcFacade;
import com.github.xf717.userservice.rpc.user.dto.UserTrackCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserTrackRespDTO;
import com.github.xf717.userservice.rpc.user.facade.UserTrackRpcFacade;
import com.github.xf717.userweb.controller.user.dto.UserTrackAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserTrackPageDTO;
import com.github.xf717.userweb.convert.user.UserPositionConvert;
import com.github.xf717.userweb.convert.user.UserTrackConvert;
import com.github.xf717.userweb.service.postition.PositionService;
import com.github.xf717.userweb.service.postition.bo.UserPositionBO;
import com.github.xf717.userweb.service.postition.vo.PositionDetailVO;
import com.github.xf717.userweb.service.postition.vo.PositionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;

/**
 * UserTrackManager
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserTrackManager {

    @Autowired
    private UserTrackRpcFacade userTrackRpcFacade;


    @Autowired
    private CompanyUserTrackRpcFacade companyUserTrackRpcFacade;


    @Autowired
    private PositionService positionService;


    public void save(UserTrackAddDTO addDTO) {
        UserTrackCreateReqDTO userTrackCreateReqDTO = UserTrackConvert.INSTANCE.convert(addDTO);
        userTrackCreateReqDTO.setUserId(BaseContextHandler.getUserId());
        userTrackRpcFacade.save(userTrackCreateReqDTO);
    }

    /**
     * 查找数据显示分页
     *
     * @param pageDTO 分页参数
     * @return
     */
    public TableResultResponse<PositionVO> pageUserTrack(UserTrackPageDTO pageDTO) {
        UserTrackPageReqDTO pageReqDTO = UserTrackConvert.INSTANCE.convert(pageDTO);
        pageReqDTO.setUserId(BaseContextHandler.getUserId());
        TableResultResponse<UserTrackRespDTO> tableResultResponse = userTrackRpcFacade.page(pageReqDTO);
        tableResultResponse.checkError();
        TableResultResponse<UserPositionBO> boTableResultResponse = UserPositionConvert.INSTANCE.convertFromUserTrack(tableResultResponse);
        List<PositionVO> positionVOList = positionService.getPositionList(boTableResultResponse.getData().getRows());
        return new TableResultResponse(tableResultResponse.getData().getTotal(), positionVOList);
    }


    public TableResultResponse<PositionVO> companyPage(UserTrackPageDTO userTrackPageDTO) {
        CompanyUserTrackPageReqDTO companyUserTrackPageReqDTO = UserTrackConvert.INSTANCE
                .convertCompanyUserTrack(userTrackPageDTO);
        companyUserTrackPageReqDTO.setUserId(BaseContextHandler.getUserId());
        TableResultResponse<CompanyUserTrackRespDTO> tableResultResponse = companyUserTrackRpcFacade.page(companyUserTrackPageReqDTO);
        tableResultResponse.checkError();
        TableResultResponse<UserPositionBO> boTableResultResponse = UserPositionConvert.INSTANCE.convertFromCompanyUserTrack(tableResultResponse);
        List<PositionVO> positionVOList = positionService.getPositionList(boTableResultResponse.getData().getRows());
        return new TableResultResponse(tableResultResponse.getData().getTotal(), positionVOList);
    }

    public PositionDetailVO companyDetail(Long id) {
        ObjectRestResponse<CompanyUserTrackRespDTO> companyUserTrackResp = companyUserTrackRpcFacade.getCompanyUserTrackById(id);
        UserPositionBO userPositionBO=UserPositionConvert.INSTANCE.convertFromUserTrack(companyUserTrackResp.getData());
        return positionService.getPositionDetail(userPositionBO);
    }
}
