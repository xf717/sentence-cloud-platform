package com.github.xf717.userweb.controller.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userweb.controller.user.dto.UserPositionCollectAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserPositionCollectPageDTO;
import com.github.xf717.userweb.controller.user.vo.UserPositionCollectVO;
import com.github.xf717.userweb.manager.user.UserPositionCollectManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_职位_收藏
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Api(value = "用户_职位_收藏", description = "用户_职位_收藏", tags = "用户_职位_收藏")
@RestController
@RequestMapping("/rest/userPositionCollect")
public class UserPositionCollectController {

  @Autowired
  private UserPositionCollectManager userPositionCollectManager;

  /**
   * 添加收藏数据
   *
   * @param addDTO
   * @return
   */
  @ApiOperation(value = "添加收藏数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody UserPositionCollectAddDTO addDTO) {
    userPositionCollectManager.save(addDTO);
    return BaseResponse.success("保存成功");
  }


  /**
   * 取消收藏
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "取消收藏", nickname = "remove")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @DeleteMapping("/remove/{id}")
  public BaseResponse remove(@PathVariable("id") Long id) {
    userPositionCollectManager.remove(id);
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
  public ObjectRestResponse<UserPositionCollectVO> getUserPositionCollectById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse.success(userPositionCollectManager.getUserPositionCollectById(id));
  }

  /**
   * 根据参数查询数据,分页
   * @param pageReqDTO
   * @return
   */
  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<UserPositionCollectVO> page(
      @RequestBody UserPositionCollectPageDTO pageReqDTO) {
    return userPositionCollectManager.pageUserPositionCollect(pageReqDTO);
  }

}
