package com.db.chaomaxs.companyservice.rpc.collect.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.collect.CompanyUserCollectRpcImpl;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectRespDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.UserCollectPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.UserCollectRespDTO;
import com.db.chaomaxs.companyservice.rpc.collect.facade.api.CompanyUserCollectApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业_用户_收藏
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class CompanyUserCollectRpcController implements CompanyUserCollectApi {

    @Autowired
    private CompanyUserCollectRpcImpl companyUserCollectRpc;

    @Override
    public BaseResponse save(@RequestBody CompanyUserCollectCreateReqDTO companyUserCollectCreateReqDTO) {
        return companyUserCollectRpc.save(companyUserCollectCreateReqDTO);
    }

    @Override
    public BaseResponse remove(@PathVariable("id") Long id) {
        return companyUserCollectRpc.remove(id);
    }

    @Override
    public ObjectRestResponse<CompanyUserCollectRespDTO> getCompanyUserCollectById(@PathVariable("id") Long id) {
        return companyUserCollectRpc.getCompanyUserCollectById(id);
    }

    @Override
    public TableResultResponse<CompanyUserCollectRespDTO> page(@RequestBody CompanyUserCollectPageReqDTO pageReqDTO) {
        return companyUserCollectRpc.page(pageReqDTO);
    }

    @Override
    public TableResultResponse<UserCollectRespDTO> userPage(@RequestBody UserCollectPageReqDTO pageReqDTO) {
        return companyUserCollectRpc.userPage(pageReqDTO);
    }
}
