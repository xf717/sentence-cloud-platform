package com.db.chaomaxs.positionservice.service.position;


import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.positionservice.convert.position.CompanyPositionKeywordConvert;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.CompanyPositionKeywordDO;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.GetCompanyPositionKeywordDO;
import com.db.chaomaxs.positionservice.dal.mysql.mapper.position.CompanyPositionKeywordMapper;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionKeywordRespDTO;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.db.chaomaxs.positionservice.rpc.position.dto.IdsReqDTO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyPositionKeywordService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyPositionKeywordService {


    @Autowired
    private CompanyPositionKeywordMapper companyPositionKeywordMapper;


    /**
     * 数据查询
     *
     * @param companyPositionId
     * @return
     */
    public List<CompanyPositionKeywordRespDTO> getIdsByCompanyPositionId(Long companyPositionId) {
        List<GetCompanyPositionKeywordDO> companyPositionKeywordDOList = companyPositionKeywordMapper.getIdsByCompanyPositionId(companyPositionId);
        if (CollectionUtils.isEmpty(companyPositionKeywordDOList)) {
            return Collections.emptyList();
        }
        return CompanyPositionKeywordConvert.INSTANCE.convertList(companyPositionKeywordDOList);
    }

    public Map<Long, List<CompanyPositionKeywordRespDTO>> getIdsByCompanyPositionIds(IdsReqDTO idsReqDTO) {
        Map<Long, List<CompanyPositionKeywordRespDTO>> map = Maps.newHashMap();
        List<GetCompanyPositionKeywordDO> companyPositionKeywordDOList = companyPositionKeywordMapper.getIdsByCompanyPositionIds(idsReqDTO.getIds());
        if (CollectionUtils.isEmpty(companyPositionKeywordDOList)) {
            return map;
        }
        CompanyPositionKeywordRespDTO companyPositionKeywordRespDTO = null;
        for (GetCompanyPositionKeywordDO getCompanyPositionKeywordDO : companyPositionKeywordDOList) {
            if (!map.containsKey(getCompanyPositionKeywordDO.getCompanyPositionId())) {
                map.put(getCompanyPositionKeywordDO.getCompanyPositionId(), Lists.newArrayList());
            }
            companyPositionKeywordRespDTO = new CompanyPositionKeywordRespDTO();
            companyPositionKeywordRespDTO.setPositionKeywordId(getCompanyPositionKeywordDO.getPositionKeywordId());
            companyPositionKeywordRespDTO.setKeywordTitle(getCompanyPositionKeywordDO.getKeywordTitle());
            map.get(getCompanyPositionKeywordDO.getCompanyPositionId()).add(companyPositionKeywordRespDTO);
        }
        return map;
    }
}
