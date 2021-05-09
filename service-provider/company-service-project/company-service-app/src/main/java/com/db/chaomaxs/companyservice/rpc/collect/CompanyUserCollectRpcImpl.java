package com.db.chaomaxs.companyservice.rpc.collect;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.collect.CompanyUserCollectManager;
import com.db.chaomaxs.companyservice.rpc.collect.dto.*;
import com.db.chaomaxs.companyservice.rpc.collect.facade.CompanyUserCollectRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author momo
 * @data 2021-03-26 10:18:33
 */
@Slf4j
@Service
public class CompanyUserCollectRpcImpl implements CompanyUserCollectRpcFacade {

    @Autowired
    private CompanyUserCollectManager companyUserCollectManager;

    @Override
    public BaseResponse save(CompanyUserCollectCreateReqDTO companyUserCollectCreateReqDTO) {
        companyUserCollectManager.saveCompanyUserCollect(companyUserCollectCreateReqDTO);
        return BaseResponse.success("保存成功");
    }

    @Override
    public BaseResponse remove(Long id) {
        companyUserCollectManager.deleteCompanyUserCollect(id);
        return BaseResponse.success("删除成功");
    }

    @Override
    public ObjectRestResponse<CompanyUserCollectRespDTO> getCompanyUserCollectById(Long id) {
        return new ObjectRestResponse<>().data(companyUserCollectManager.getCompanyUserCollectById(id));
    }

    @Override
    public TableResultResponse<CompanyUserCollectRespDTO> page(CompanyUserCollectPageReqDTO pageReqDTO) {
        PageResult<CompanyUserCollectRespDTO> pageResult = companyUserCollectManager.pageCompanyUserCollect(pageReqDTO);
        TableResultResponse<CompanyUserCollectRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        return tableResultResponse;
    }

    @Override
    public TableResultResponse<UserCollectRespDTO> userPage(UserCollectPageReqDTO pageReqDTO) {
        PageResult<UserCollectRespDTO> pageResult = companyUserCollectManager.pageCompanyUserCollect(pageReqDTO);
        TableResultResponse<UserCollectRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(), pageResult.getList());
        return tableResultResponse;
    }

}
