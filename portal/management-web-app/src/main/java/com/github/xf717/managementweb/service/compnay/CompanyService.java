package com.github.xf717.managementweb.service.compnay;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.companyservice.rpc.company.dto.CompanyInfoListReqDTO;
import com.github.xf717.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.github.xf717.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.github.xf717.companyservice.rpc.company.facade.CompanyInfoRpcFacade;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeListIdsReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserExtendRpcFacade;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author momo
 * @date 2021-04-27 14:24
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyInfoRpcFacade companyInfoRpcFacade;

    public Map<Long, String> getByIds(Set<Long> ids) {
        Map<Long, String> map = Maps.newHashMap();
        CompanyInfoListReqDTO reqDTO = new CompanyInfoListReqDTO();
        reqDTO.setIdsList(ids);
        ObjectRestResponse<List<CompanyInfoListRespDTO>> objectRestResponse = companyInfoRpcFacade.listCompanyInfoByIds(reqDTO);
        List<CompanyInfoListRespDTO> respDTOList = objectRestResponse.getData();
        if (CollectionUtils.isEmpty(respDTOList)) {
            return map;
        }
        map = respDTOList.stream().collect(Collectors.toMap(CompanyInfoListRespDTO::getId, CompanyInfoListRespDTO::getFullName));
        return map;
    }
}
