package com.github.xf717.userweb.controller.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userweb.controller.user.dto.UserInterviewPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserInterviewUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserInterviewVO;
import com.github.xf717.userweb.manager.user.UserInterviewManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Api(value = "用户面试表", description = "用户面试表", tags = "用户面试表")
@RestController
@RequestMapping("/rest/userInterview")
public class UserInterviewController {

  @Autowired
  private UserInterviewManager userInterviewManager;


  /**
   * 更新数据
   *
   * @param updateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody UserInterviewUpdateDTO updateDTO) {
    userInterviewManager.update(updateDTO);
    return BaseResponse.success("更新成功");
  }


  /**
   * 获取数据
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "获取对象数据", nickname = "get")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @GetMapping("/get/{id}")
  public ObjectRestResponse<UserInterviewVO> getUserInterviewById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(userInterviewManager.getUserInterviewById(id));
  }

  /**
   * 根据参数查询面试数据,分页
   *
   * @param pageReqDTO
   * @return
   */
  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<UserInterviewVO> page(@RequestBody UserInterviewPageDTO pageReqDTO) {
    return userInterviewManager.pageUserInterview(pageReqDTO);
  }

}
