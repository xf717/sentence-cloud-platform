package com.db.chaomaxs.web.core.util;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.vo.CommonResult;
import com.db.chaomaxs.web.core.constant.CommonChaomaxsConstants;
import java.util.Date;
import javax.servlet.ServletRequest;

public class CommonWebUtil {

  public static Integer getUserId(ServletRequest request) {
    return (Integer) request.getAttribute(CommonChaomaxsConstants.REQUEST_ATTR_USER_ID_KEY);
  }

  public static void setUserId(ServletRequest request, Integer userId) {
    request.setAttribute(CommonChaomaxsConstants.REQUEST_ATTR_USER_ID_KEY, userId);
  }

  public static Integer getUserType(ServletRequest request) {
    return (Integer) request.getAttribute(CommonChaomaxsConstants.REQUEST_ATTR_USER_TYPE_KEY);
  }

  public static void setUserType(ServletRequest request, Integer userType) {
    request.setAttribute(CommonChaomaxsConstants.REQUEST_ATTR_USER_TYPE_KEY, userType);
  }

  public static CommonResult getCommonResult(ServletRequest request) {
    return (CommonResult) request.getAttribute(CommonChaomaxsConstants.REQUEST_ATTR_COMMON_RESULT);
  }

  public static void setCommonResult(ServletRequest request, BaseResponse result) {
    request.setAttribute(CommonChaomaxsConstants.REQUEST_ATTR_COMMON_RESULT, result);
  }

  public static void setAccessStartTime(ServletRequest request, Date startTime) {
    request.setAttribute(CommonChaomaxsConstants.REQUEST_ATTR_ACCESS_START_TIME, startTime);
  }

  public static Date getAccessStartTime(ServletRequest request) {
    return (Date) request.getAttribute(CommonChaomaxsConstants.REQUEST_ATTR_ACCESS_START_TIME);
  }

}
