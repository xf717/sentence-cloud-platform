package com.github.xf717.userweb.controller.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserBlacklistUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserBlacklistVO;
import com.github.xf717.userweb.manager.user.UserBlacklistManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_黑名单
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Api(value = "用户_黑名单", description = "用户_黑名单", tags = "用户_黑名单")
@RestController
@RequestMapping("/rest/userBlacklist")
public class UserBlacklistController {

  @Autowired
  private UserBlacklistManager userBlacklistManager;

  /**
   * 添加数据
   *
   * @param addDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody UserBlacklistAddDTO addDTO) {
    userBlacklistManager.save(addDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param updateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody UserBlacklistUpdateDTO updateDTO) {
    userBlacklistManager.update(updateDTO);
    return BaseResponse.success("更新成功");
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "删除数据", nickname = "remove")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @DeleteMapping("/remove/{id}")
  public BaseResponse remove(@PathVariable("id") Long id) {
    userBlacklistManager.remove(id);
    return BaseResponse.success("删除成功");
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
  public ObjectRestResponse<UserBlacklistVO> getUserBlacklistById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(userBlacklistManager.getUserBlacklistById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<UserBlacklistVO>> listUserBlacklists(
      @Valid @RequestBody UserBlacklistDTO userBlacklistDTO) {
    List<UserBlacklistVO> list = userBlacklistManager.listUserBlacklists(userBlacklistDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<UserBlacklistVO> page(@RequestBody UserBlacklistPageDTO pageReqDTO) {
    return userBlacklistManager.pageUserBlacklist(pageReqDTO);
  }

}
