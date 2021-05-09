package com.db.chaomaxs.companyweb.controller.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyweb.controller.company.dto.GreetContentEnableHideDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.GreetContentUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.GreetContentVO;
import com.db.chaomaxs.companyweb.manager.company.GreetContentManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 打招呼语
 *
 * @author wst
 * @date 2021-03-26 10:18:33
 */
@Api(value = "打招呼语", description = "打招呼语", tags = "GreetContent")
@RestController
@RequestMapping("/rest/greetContent")
public class GreetContentController {

  @Autowired
  private GreetContentManager greetContentManager;


  /**
   * 更新数据
   *
   * @param greetContentUpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody GreetContentUpdateDTO greetContentUpdateDTO) {
    greetContentManager.update(greetContentUpdateDTO);
    return BaseResponse.success("更新成功");
  }



  @ApiOperation(value = "查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<GreetContentVO> listGreetContents() {
    return ObjectRestResponse.success(greetContentManager.listGreetContents());
  }

  /**
   * 打招呼语按钮开关，更新数据
   * @param greetContentEnableHideDTO
   * @return
   */
  @ApiOperation(value = "打招呼语按钮开关，更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/enable/hide/update")
  public BaseResponse updateEnableHideDTO(@Valid @RequestBody GreetContentEnableHideDTO greetContentEnableHideDTO) {
    greetContentManager.updateEnableHideDTO(greetContentEnableHideDTO);
    return BaseResponse.success("更新成功");
  }

}
