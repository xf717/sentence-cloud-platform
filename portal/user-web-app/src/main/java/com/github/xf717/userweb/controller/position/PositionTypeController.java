package com.github.xf717.userweb.controller.position;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.positionservice.constant.CommonConstants;
import com.github.xf717.security.auth.client.annotation.IgnoreUserToken;
import com.github.xf717.userweb.controller.position.vo.PositionTypeVO;
import com.github.xf717.userweb.manager.position.PositionTypeManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * PositionTypeController
 *
 * @author ding
 * @version 1.0
 * @date
 */
@Api(value = "职位类别", description = "职位类别", tags = "职位类别")
@RestController
@RequestMapping("/rest/positionType")
public class PositionTypeController {
  @Autowired
  private PositionTypeManager positionTypeManager;


  @ApiOperation(value = "根据parentId查询数据,不分页,parentId不传默认获取顶级分类", nickname = "listPositionType")
  @GetMapping("/list")
  @IgnoreUserToken
  public ObjectRestResponse<List<PositionTypeVO>> listPositionType(
      @RequestParam(value = "parentId", required = false) Long parentId) {
    if (null == parentId) {
      parentId = CommonConstants.TREE_TOP_PARENT_ID;
    }
    List<PositionTypeVO> list = positionTypeManager.listPositionTypeByParentId(parentId);
    return ObjectRestResponse.success(list);
  }

  /**
   * 模糊职位类型
   *
   * @return
   */
  @ApiOperation(value = "模糊职位类型", nickname = "get")
  @GetMapping("/query")
  @IgnoreUserToken
  public ObjectRestResponse<List<PositionTypeVO>> queryPositionName(
      @RequestParam("positionName") String positionName) {
    return ObjectRestResponse.success(positionTypeManager.queryPositionName(positionName));
  }

}
