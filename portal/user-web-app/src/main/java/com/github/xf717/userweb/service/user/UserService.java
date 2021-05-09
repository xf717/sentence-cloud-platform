package com.github.xf717.userweb.service.user;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserExtendRespDTO;
import com.github.xf717.userservice.rpc.user.facade.UserExtendRpcFacade;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author momo
 * @date 2021-04-27 14:24
 */
@Service
public class UserService {
    @Autowired
    private UserExtendRpcFacade userExtendRpcFacade;

    public Map<String, Object> getByIds(Set<Long> ids) {
        Map<String, Object> map = Maps.newHashMap();
        Map<Long, UserExtendDetailRespDTO> userInfoMap = Maps.newHashMap();
        Set<Long> companyIds = Sets.newHashSet();
        UserExtendDetailReqDTO reqDTO = new UserExtendDetailReqDTO();
        reqDTO.setUserIds(ids);
        ObjectRestResponse<List<UserExtendDetailRespDTO>> objectRestResponse = userExtendRpcFacade.listUserExtendByUserIds(reqDTO);
        List<UserExtendDetailRespDTO> respDTOList = objectRestResponse.getData();
        if (CollectionUtils.isEmpty(respDTOList)) {
            map.put("userInfoMap", userInfoMap);
            map.put("companyIds", companyIds);
            return map;
        }
        for (UserExtendDetailRespDTO userExtendDetailRespDTO : respDTOList) {
            userInfoMap.put(userExtendDetailRespDTO.getUserId(), userExtendDetailRespDTO);
            companyIds.add(userExtendDetailRespDTO.getCompanyId());
        }
        map.put("userInfoMap", userInfoMap);
        map.put("companyIds", companyIds);
        return map;
    }

    public UserExtendRespDTO getById(Long id) {
        ObjectRestResponse<UserExtendRespDTO> response = userExtendRpcFacade.getUserExtendByUserId(id);
        return response.getData();
    }
}
