package com.github.xf717.userweb.controller.user;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userweb.controller.user.dto.UserHideCompanyBatchInsertDTO;
import com.github.xf717.userweb.controller.user.vo.UserHideCompanyVO;
import com.github.xf717.userweb.manager.user.UserHideSetManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 隐私设置
 *
 * @author wst, xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Api(value = "隐私设置", description = "隐私设置", tags = "隐私设置")
@RestController
@RequestMapping("/rest/user")
public class UserHideSetController {

  @Autowired
  private UserHideSetManager userHideSetManager;

  /**
   * 批量添加数据
   *
   * @param addDTO
   * @return
   */
  @ApiOperation(value = "批量添加数据", produces = "application/json", nickname = "save")
  @PostMapping("batch/save/hideCompany")
  public BaseResponse save(@Valid @RequestBody UserHideCompanyBatchInsertDTO addDTO) {
    userHideSetManager.save(addDTO);
    return BaseResponse.success("保存成功");
  }


  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "删除数据", nickname = "remove")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @DeleteMapping("/remove/{id}/hideCompany")
  public BaseResponse remove(@PathVariable("id") Long id) {
    userHideSetManager.remove(id);
    return BaseResponse.success("删除成功");
  }

  /**
   * 屏蔽公司分页查询
   *
   * @return
   */
  @ApiOperation(value = "查询屏蔽的公司", nickname = "listUserHideCompanys")
  @PostMapping("/hideCompany/list")
  public ObjectRestResponse<List<UserHideCompanyVO>> listUserHideCompanys() {
    return ObjectRestResponse.success(userHideSetManager.listUserHideCompanys());
  }

  /**
   * 隐藏简历，更新数据
   *
   * @param enabledHide
   * @return
   */
  @ApiOperation(value = "隐藏或开放简历", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/enabledHide/{enabledHide}/resume")
  public BaseResponse updateEnableHideResume(@PathVariable("enabledHide") Integer enabledHide) {
    userHideSetManager.updateEnableHideResume(enabledHide);
    return BaseResponse.success("更新成功");
  }

}
