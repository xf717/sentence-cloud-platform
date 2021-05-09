package com.github.xf717.userweb.service.postition;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.github.xf717.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.github.xf717.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.github.xf717.positionservice.rpc.position.dto.CompanyPositionRespDTO;
import com.github.xf717.positionservice.rpc.position.dto.IdsReqDTO;
import com.github.xf717.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendRespDTO;
import com.github.xf717.userweb.convert.position.PositionConvert;
import com.github.xf717.userweb.service.company.CompanyService;
import com.github.xf717.userweb.service.dictionary.DictionaryService;
import com.github.xf717.userweb.service.postition.bo.UserPositionBO;
import com.github.xf717.userweb.service.postition.vo.PositionDetailVO;
import com.github.xf717.userweb.service.postition.vo.PositionVO;
import com.github.xf717.userweb.service.user.UserService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<PositionVO> getPositionList(List<UserPositionBO> userPositionBOList) {
        if (CollectionUtils.isEmpty(userPositionBOList)) {
            return Lists.newArrayList();
        }
        Set<Long> positionIds = Sets.newHashSet();
        Set<Long> companyUserIds = Sets.newHashSet();
        for (UserPositionBO userPositionBO : userPositionBOList) {
            companyUserIds.add(userPositionBO.getCompanyUserId());
            positionIds.add(userPositionBO.getPositionId());
        }
        Map positionMap = batchGetPosition(positionIds);
        //临时定义的变量isNull职位是否为空 1=没有职位数据  1=有职位数据
        int isNull = (int) positionMap.get("isNull");
        if (isNull == 1) {
            return Lists.newArrayList();
        }
        Map<String, Object> positionExtMap = batchGetPositionExt(companyUserIds, (Set<Long>) positionMap.get("dictionaryIds"));
        return buildPositionList(userPositionBOList, (Map<Long, CompanyPositionRespDTO>) positionMap.get("positionInfoMap"), positionExtMap);
    }

    private Map batchGetPosition(Set<Long> positionIds) {
        Map map = Maps.newHashMap();
        IdsReqDTO idsReqDTO = new IdsReqDTO();
        idsReqDTO.setIds(positionIds);
        ObjectRestResponse<List<CompanyPositionRespDTO>> restResponse = companyPositionRpcFacade.getCompanyPositionsByIds(idsReqDTO);
        List<CompanyPositionRespDTO> positionList = restResponse.getData();
        if (CollectionUtils.isEmpty(positionList)) {
            map.put("isNull", 1);
            return map;
        }
        Set<Long> dictionaryIds = Sets.newHashSet();
        Map<Long, CompanyPositionRespDTO> positionInfoMap = Maps.newHashMap();
        for (CompanyPositionRespDTO respDTO : positionList) {
            dictionaryIds.add(respDTO.getExperienceId());
            dictionaryIds.add(respDTO.getEducationId());
            positionInfoMap.put(respDTO.getId(), respDTO);
        }
        map.put("isNull", 0);
        map.put("dictionaryIds", dictionaryIds);
        map.put("positionInfoMap", positionInfoMap);
        return map;
    }

    /**
     * @param userPositionBOList
     * @param positionInfoMap    职位的基本数据
     * @param positionExtMap
     * @return
     */
    private List<PositionVO> buildPositionList(List<UserPositionBO> userPositionBOList, Map<Long, CompanyPositionRespDTO> positionInfoMap, Map<String, Object> positionExtMap) {
        List<PositionVO> list = Lists.newArrayList();
        //获取用户信息 key->用户id value 用户对象
        Map<Long, UserExtendDetailRespDTO> userInfoMap = (Map<Long, UserExtendDetailRespDTO>) positionExtMap.get("userInfoMap");
        //获取企业信息 key->企业id value 企业对象
        Map<Long, CompanyInfoListRespDTO> companyInfoMap = (Map<Long, CompanyInfoListRespDTO>) positionExtMap.get("companyInfoMap");
        //获取字典信息 key->字典id value 值
        Map<Long, String> dictionaryInfoMap = (Map<Long, String>) positionExtMap.get("dictionaryInfoMap");
        //构建职位的信息
        for (UserPositionBO userPositionBO : userPositionBOList) {
            CompanyPositionRespDTO companyPositionRespDTO = positionInfoMap.get(userPositionBO.getPositionId());
            if (companyPositionRespDTO == null) {
                continue;
            }
            PositionVO positionVO = PositionConvert.INSTANCE.convert(companyPositionRespDTO);
            UserExtendDetailRespDTO userExtendDetailRespDTO = userInfoMap.get(userPositionBO.getCompanyUserId());
            if (userExtendDetailRespDTO != null) {
                positionVO.setRealName(userExtendDetailRespDTO.getRealName());
                positionVO.setPhoto(userExtendDetailRespDTO.getAvatarUrl());
                CompanyInfoListRespDTO companyInfoListRespDTO = companyInfoMap.get(
                    userExtendDetailRespDTO.getCompanyId());
                if (companyInfoListRespDTO != null) {
                    positionVO.setCompanyScope(dictionaryInfoMap.get(companyInfoListRespDTO.getScopeDictionaryId()));
                    positionVO.setDevelopmentStage(dictionaryInfoMap.get(companyInfoListRespDTO.getDevelopmentStageDictionaryId()));
                    positionVO.setCompanyName(companyInfoListRespDTO.getFullName());
                }
            }
            positionVO.setEducation(dictionaryInfoMap.get(companyPositionRespDTO.getEducationId()));
            positionVO.setExperience(dictionaryInfoMap.get(companyPositionRespDTO.getExperienceId()));

            list.add(positionVO);
        }
        return list;
    }

    /**
     * 获取职位的拓展信息
     */
    private Map<String, Object> batchGetPositionExt(Set<Long> companyUserIds, Set<Long> dictionaryIds) {
        Map<String, Object> map = Maps.newHashMap();
        //获取用户基本信息和企业id
        Map<String, Object> userMap = userService.getByIds(companyUserIds);
        Map<Long, UserExtendDetailRespDTO> userInfoMap = (Map<Long, UserExtendDetailRespDTO>) userMap.get("userInfoMap");
        Set<Long> companyIds = (Set<Long>) userMap.get("companyIds");
        //获取企业基本信息和规模id和发展id
        Map<String, Object> companyMap = companyService.getByIds(companyIds);
        Map<Long, CompanyInfoListRespDTO> companyInfoMap = (Map<Long, CompanyInfoListRespDTO>) companyMap.get("companyInfoMap");
        Set<Long> companyDictionaryIds = (Set<Long>) companyMap.get("dictionaryIds");
        dictionaryIds.addAll(companyDictionaryIds);
        Map<Long, String> dictionaryInfoMap = dictionaryService.getByIds(dictionaryIds);
        map.put("userInfoMap", userInfoMap);
        map.put("companyInfoMap", companyInfoMap);
        map.put("dictionaryInfoMap", dictionaryInfoMap);
        return map;
    }


    public PositionDetailVO getPositionDetail(UserPositionBO userPositionBO) {
        ObjectRestResponse<CompanyPositionDetailRespDTO> restResponse = companyPositionRpcFacade.getCompanyPositionById(userPositionBO.getPositionId());
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
        PositionDetailVO positionDetailVO = PositionConvert.INSTANCE.convert(companyPositionRespDTO);
        UserExtendRespDTO userInfo = (UserExtendRespDTO) positionExtMap.get("userInfo");
        CompanyInfoRespDTO companyInfo = (CompanyInfoRespDTO) positionExtMap.get("companyInfo");
        Map<Long, String> dictionaryInfoMap = (Map<Long, String>) positionExtMap.get("dictionaryInfoMap");
        if (userInfo != null) {
            positionDetailVO.setRealName(userInfo.getRealName());
        }
        if(companyInfo !=null){
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
