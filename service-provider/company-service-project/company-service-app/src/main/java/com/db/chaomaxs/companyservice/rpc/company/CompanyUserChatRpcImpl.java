package com.db.chaomaxs.companyservice.rpc.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.company.CompanyUserChatManager;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatStatisticRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.PositionIdsReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.facade.CompanyUserChatRpcFacade;

import java.util.List;
import java.util.Map;

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
public class CompanyUserChatRpcImpl implements CompanyUserChatRpcFacade {

    @Autowired
    private CompanyUserChatManager companyUserChatManager;

    @Override
    public BaseResponse save(CompanyUserChatCreateReqDTO companyUserChatCreateReqDTO) {
        companyUserChatManager.saveCompanyUserChat(companyUserChatCreateReqDTO);
        return BaseResponse.success("保存成功");
    }


    @Override
    public ObjectRestResponse<CompanyUserChatRespDTO> getCompanyUserChatById(Long id) {
        CompanyUserChatRespDTO companyUserChatRespDTO = companyUserChatManager.getCompanyUserChatById(id);
        return new ObjectRestResponse<>().data(companyUserChatRespDTO);
    }


    @Override
    public TableResultResponse<CompanyUserChatRespDTO> page(CompanyUserChatPageReqDTO pageReqDTO) {
        PageResult<CompanyUserChatRespDTO> pageResult = companyUserChatManager.pageCompanyUserChat(pageReqDTO);
        TableResultResponse<CompanyUserChatRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        return tableResultResponse;
    }

    @Override
    public Map<Long, CompanyUserChatStatisticRespDTO> getStatisticByPositionIds(PositionIdsReqDTO positionIdsReqDTO) {
        return companyUserChatManager.getStatisticByPositionIds(positionIdsReqDTO);
    }

}
