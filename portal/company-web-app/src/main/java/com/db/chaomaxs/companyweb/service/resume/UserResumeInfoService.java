package com.db.chaomaxs.companyweb.service.resume;


import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.companyweb.convert.delivery.CompanyDeliveryConvert;
import com.db.chaomaxs.companyweb.service.dictionary.DictionaryService;
import com.db.chaomaxs.companyweb.service.resume.bo.UserResumeInfoBO;
import com.db.chaomaxs.companyweb.service.resume.vo.UserResumeInfoVO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserIdsReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserResumeDetailRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserResumeRpcFacade;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wst
 * @description: 用户简历信息
 * @date 2021/4/30 15:51
 */

@Service
public class UserResumeInfoService {

  @Autowired
  private UserResumeRpcFacade userResumeRpcFacade;

  @Autowired
  private DictionaryService dictionaryService;


  public List<UserResumeInfoVO> dealResumeDeliveryPageResp(
      TableResultResponse<UserResumeInfoBO> response) {
    Set<Long> userIds = response.getData().getRows().stream()
        .map(UserResumeInfoBO::getUserId).collect(Collectors.toSet());
    Map<String, Object> userResumeMap = getByIds(userIds);
    Set<Long> educationDictionaryIds = (Set<Long>) userResumeMap.get("educationDictionaryIds");
    Map<Long, UserResumeDetailRespDTO> userMap = (Map<Long, UserResumeDetailRespDTO>) userResumeMap
        .get("userMap");
    Map<Long, String> educationMap = dictionaryService.getByIds(educationDictionaryIds);
    List<UserResumeInfoVO> userResumeInfoList = new ArrayList<>();
    for (UserResumeInfoBO userResumeInfoBO : response.getData().getRows()) {
      UserResumeDetailRespDTO userResumeDetailRespDTO = userMap.get(userResumeInfoBO.getUserId());
      if (userResumeDetailRespDTO != null) {
        UserResumeInfoVO userResumeInfoVO = CompanyDeliveryConvert.INSTANCE
            .convert(userResumeDetailRespDTO);
        userResumeInfoVO.setEducation(educationMap.get(userResumeDetailRespDTO
            .getEducationDictionaryId()));
        userResumeInfoList.add(userResumeInfoVO);
      }
    }
    return userResumeInfoList;
  }


  public Map<String, Object> getByIds(Set<Long> ids) {
    Map<String, Object> map = Maps.newHashMap();
    Map<Long, UserResumeDetailRespDTO> userMap = Maps.newHashMap();
    Set<Long> educationDictionaryIds = Sets.newHashSet();
    UserIdsReqDTO userIdsReqDTO = new UserIdsReqDTO();
    userIdsReqDTO.setUserIds(ids);
    ObjectRestResponse<List<UserResumeDetailRespDTO>> objectRestResponse = userResumeRpcFacade
        .getResumeDetailByUserIds(userIdsReqDTO);
    objectRestResponse.checkError();
    List<UserResumeDetailRespDTO> userResumeDetailRespList = objectRestResponse.getData();
    if (CollectionUtils.isEmpty(userResumeDetailRespList)) {
      map.put("userMap", userMap);
      map.put("educationDictionaryIds", educationDictionaryIds);
      return map;
    }
    for (UserResumeDetailRespDTO userResumeDetailResp : userResumeDetailRespList) {
      userMap.put(userResumeDetailResp.getUserId(), userResumeDetailResp);
      educationDictionaryIds.add(userResumeDetailResp.getEducationDictionaryId());
    }
    map.put("userMap", userMap);
    map.put("educationDictionaryIds", educationDictionaryIds);
    return map;
  }

}
