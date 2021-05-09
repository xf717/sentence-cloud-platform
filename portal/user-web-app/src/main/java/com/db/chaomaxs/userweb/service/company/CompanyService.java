package com.db.chaomaxs.userweb.service.company;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyInfoRpcFacade;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author momo
 * @date 2021-04-30 10:12
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyInfoRpcFacade companyInfoRpcFacade;

    public Map<String, Object> getByIds(Set<Long> ids) {
        CompanyInfoListReqDTO reqDTO = new CompanyInfoListReqDTO();
        reqDTO.setIdsList(ids);
        ObjectRestResponse<List<CompanyInfoListRespDTO>> objectRestResponse = companyInfoRpcFacade.listCompanyInfoByIds(reqDTO);
        List<CompanyInfoListRespDTO> respDTOList = objectRestResponse.getData();
        Map<String, Object> map = Maps.newHashMap();
        Map<Long, CompanyInfoListRespDTO> companyInfoMap = Maps.newHashMap();
        Set<Long> dictionaryIds = Sets.newHashSet();
        if (CollectionUtils.isEmpty(respDTOList)) {
            map.put("companyInfoMap", companyInfoMap);
            map.put("dictionaryIds", dictionaryIds);
            return map;
        }
        for (CompanyInfoListRespDTO companyInfoListRespDTO : respDTOList) {
            companyInfoMap.put(companyInfoListRespDTO.getId(), companyInfoListRespDTO);
            dictionaryIds.add(companyInfoListRespDTO.getDevelopmentStageDictionaryId());
            dictionaryIds.add(companyInfoListRespDTO.getScopeDictionaryId());
        }
        map.put("companyInfoMap", companyInfoMap);
        map.put("dictionaryIds", dictionaryIds);
        return map;
    }


    public CompanyInfoRespDTO getById(Long id) {
        ObjectRestResponse<CompanyInfoRespDTO> response = companyInfoRpcFacade.getCompanyInfoById(id);
        return response.getData();
    }
}
