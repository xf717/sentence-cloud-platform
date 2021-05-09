package com.db.chaomaxs.companyweb.service.position;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;

import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyweb.convert.position.CompanyPositionConvert;
import com.db.chaomaxs.companyweb.service.compnay.CompanyService;
import com.db.chaomaxs.companyweb.service.dictionary.DictionaryService;
import com.db.chaomaxs.companyweb.service.position.vo.PositionDetailVO;
import com.db.chaomaxs.companyweb.service.user.UserService;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendRespDTO;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Set;

/**
 * @author momo
 * @date 2021-04-30 10:13
 */
@Service
public class PositionService {

    @Autowired
    private CompanyPositionRpcFacade companyPositionRpcFacade;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DictionaryService dictionaryService;


    public PositionDetailVO getPositionDetail(Long id) {
        ObjectRestResponse<CompanyPositionDetailRespDTO> restResponse = companyPositionRpcFacade.getCompanyPositionById(id);
        CompanyPositionDetailRespDTO positionDetailRespDTO = restResponse.getData();
        if (positionDetailRespDTO == null) {
            return new PositionDetailVO();
        }
        Set<Long> dictionaryIds = Sets.newHashSet();
        dictionaryIds.add(positionDetailRespDTO.getEducationId());
        dictionaryIds.add(positionDetailRespDTO.getExperienceId());
        Map<String, Object> positionExtMap = getPositionExt(positionDetailRespDTO.getCompanyUserId(), dictionaryIds);
        return buildPosition(positionDetailRespDTO, positionExtMap);
    }

    private PositionDetailVO buildPosition(CompanyPositionDetailRespDTO companyPositionRespDTO, Map<String, Object> positionExtMap) {
        PositionDetailVO positionDetailVO = CompanyPositionConvert.INSTANCE.convertDetail(companyPositionRespDTO);
        UserExtendRespDTO userInfo = (UserExtendRespDTO) positionExtMap.get("userInfo");
        CompanyInfoRespDTO companyInfo = (CompanyInfoRespDTO) positionExtMap.get("companyInfo");
        Map<Long, String> dictionaryInfoMap = (Map<Long, String>) positionExtMap.get("dictionaryInfoMap");
        if (userInfo != null) {
            positionDetailVO.setRealName(userInfo.getRealName());
        }
        if (companyInfo != null) {
            positionDetailVO.setShortName(companyInfo.getShortName());
            positionDetailVO.setFullName(companyInfo.getFullName());
            positionDetailVO.setDevelopmentStage(dictionaryInfoMap.get(companyInfo.getDevelopmentStageDictionaryId()));
            positionDetailVO.setCompanyScope(dictionaryInfoMap.get(companyInfo.getScopeDictionaryId()));
            positionDetailVO.setIndustryName(dictionaryInfoMap.get(companyInfo.getIndustryId()));
            positionDetailVO.setLogoUrl(companyInfo.getLogoUrl());
            positionDetailVO.setLongitude(companyInfo.getLongitude());
            positionDetailVO.setLatitude(companyInfo.getLatitude());
        }
        return positionDetailVO;
    }


    private Map<String, Object> getPositionExt(Long companyUserId, Set<Long> dictionaryIds) {
        Map<String, Object> map = Maps.newHashMap();
        //获取用户基本信息和企业id
        UserExtendRespDTO userExtendResp = userService.getById(companyUserId);
        //获取企业基本信息和规模id和发展id
        CompanyInfoRespDTO companyInfoResp = companyService.getById(userExtendResp.getCompanyId());
        dictionaryIds.add(companyInfoResp.getDevelopmentStageDictionaryId());
        dictionaryIds.add(companyInfoResp.getScopeDictionaryId());
        dictionaryIds.add(companyInfoResp.getIndustryId());
        Map<Long, String> dictionaryInfoMap = dictionaryService.getByIds(dictionaryIds);
        map.put("userInfo", userExtendResp);
        map.put("companyInfo", companyInfoResp);
        map.put("dictionaryInfoMap", dictionaryInfoMap);
        return map;
    }
}
