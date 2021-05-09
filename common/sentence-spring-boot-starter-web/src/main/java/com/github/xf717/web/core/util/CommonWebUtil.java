package com.github.xf717.web.core.util;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.vo.CommonResult;
import com.github.xf717.web.core.constant.CommonsentenceConstants;
import java.util.Date;
import javax.servlet.ServletRequest;

public class CommonWebUtil {

  public static Integer getUserId(ServletRequest request) {
    return (Integer) request.getAttribute(CommonsentenceConstants.REQUEST_ATTR_USER_ID_KEY);
  }

  public static void setUserId(ServletRequest request, Integer userId) {
    request.setAttribute(CommonsentenceConstants.REQUEST_ATTR_USER_ID_KEY, userId);
  }

  public static Integer getUserType(ServletRequest request) {
    return (Integer) request.getAttribute(CommonsentenceConstants.REQUEST_ATTR_USER_TYPE_KEY);
  }

  public static void setUserType(ServletRequest request, Integer userType) {
    request.setAttribute(CommonsentenceConstants.REQUEST_ATTR_USER_TYPE_KEY, userType);
  }

  public static CommonResult getCommonResult(ServletRequest request) {
    return (CommonResult) request.getAttribute(CommonsentenceConstants.REQUEST_ATTR_COMMON_RESULT);
  }

  public static void setCommonResult(ServletRequest request, BaseResponse result) {
    request.setAttribute(CommonsentenceConstants.REQUEST_ATTR_COMMON_RESULT, result);
  }

  public static void setAccessStartTime(ServletRequest request, Date startTime) {
    request.setAttribute(CommonsentenceConstants.REQUEST_ATTR_ACCESS_START_TIME, startTime);
  }

  public static Date getAccessStartTime(ServletRequest request) {
    return (Date) request.getAttribute(CommonsentenceConstants.REQUEST_ATTR_ACCESS_START_TIME);
  }

}
