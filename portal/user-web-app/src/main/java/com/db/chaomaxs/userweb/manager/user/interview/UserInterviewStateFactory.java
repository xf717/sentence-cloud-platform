package com.db.chaomaxs.userweb.manager.user.interview;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.companyservice.rpc.interview.dto.CompanyUserInterviewUpdateStateReqDTO;
import com.db.chaomaxs.userservice.enums.user.UserInterviewEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import com.google.common.collect.Maps;
import java.util.Map;
import org.springframework.stereotype.Service;


/**
 * @author momo
 * @date 2021-04-08 10:06
 */
@Service
public class UserInterviewStateFactory {

    private static Map<Integer, UserInterview> userInterviewStateMap = Maps.newHashMap();

    private static void initUserInterviewState() {
        if (userInterviewStateMap.isEmpty()) {
            userInterviewStateMap.put(UserInterviewEnum.ACCEPT_INTERVIEW.getCode(), new AcceptInterview());
            userInterviewStateMap.put(UserInterviewEnum.REFUSE_INTERVIEW.getCode(), new RefuseInterview());
            userInterviewStateMap.put(UserInterviewEnum.ACCEPT_OFFER.getCode(), new AcceptOffer());
            userInterviewStateMap.put(UserInterviewEnum.REFUSE_OFFER.getCode(), new RefuseOffer());
            userInterviewStateMap.put(UserInterviewEnum.USER_CANCEL_INTERVIEW.getCode(), new UserCancelInterview());
        }
    }


    public BaseResponse updateUserInterviewState(UserInterviewUpdateReqDTO userInterviewUpdateReqDTO) {
        initUserInterviewState();
        UserInterview userInterview = userInterviewStateMap.get(userInterviewUpdateReqDTO.getStatus());
        return userInterview.updateUserInterviewState(userInterviewUpdateReqDTO);
    }

    public BaseResponse updateCompanyUserInterviewState(
        CompanyUserInterviewUpdateStateReqDTO companyUserInterviewUpdateStateReqDTO) {
        initUserInterviewState();
        UserInterview userInterview = userInterviewStateMap.get(companyUserInterviewUpdateStateReqDTO.getStatus());
        return userInterview.updateCompanyUserInterviewState(companyUserInterviewUpdateStateReqDTO);
    }
}
