package com.github.xf717.userweb.controller.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.security.auth.client.annotation.IgnoreUserToken;
import com.github.xf717.userweb.controller.resume.dto.UserWorkExperienceAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserWorkExperienceUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.CompanyVO;
import com.github.xf717.userweb.controller.resume.vo.UserReferenceVO;
import com.github.xf717.userweb.controller.resume.vo.UserWorkExperienceVO;
import com.github.xf717.userweb.manager.resume.UserWorkExperienceManager;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_工作经历
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Api(value = "用户_工作经历", description = "用户_工作经历", tags = "用户_工作经历")
@RestController
@RequestMapping("/rest/userWorkExperience")
public class UserWorkExperienceController {

  @Autowired
  private UserWorkExperienceManager userWorkExperienceManager;

  /**
   * 添加数据
   *
   * @param addDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody UserWorkExperienceAddDTO addDTO) {
    userWorkExperienceManager.save(addDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param updateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @PutMapping("/update")
  public BaseResponse update(@Valid @RequestBody UserWorkExperienceUpdateDTO updateDTO) {
    userWorkExperienceManager.update(updateDTO);
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
    userWorkExperienceManager.remove(id);
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
  public ObjectRestResponse<UserWorkExperienceVO> getUserWorkExperienceById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse.success(userWorkExperienceManager.getUserWorkExperienceById(id));
  }

  /**
   * 填写个人资料查询数据
   *
   * @return
   */
  @ApiOperation(value = "填写个人资料查询数据", nickname = "get")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @GetMapping("/get/last/step")
  public ObjectRestResponse<UserWorkExperienceVO> getLastStepByUserId() {
    return ObjectRestResponse.success(userWorkExperienceManager.getLastStepByUserId());
  }

  /**
   * 模糊查询公司名称
   *
   * @return
   */
  @ApiOperation(value = "模糊查询公司名称", nickname = "get")
  @GetMapping("/query")
  @IgnoreUserToken
  public ObjectRestResponse<List<CompanyVO>> queryByCompanyName(
      @RequestParam("fullName") String fullName) {
    return ObjectRestResponse.success(userWorkExperienceManager.queryByCompanyName(fullName));
  }

  /**
   * 工作经历-看看别人怎么写
   *
   * @return
   */
  @ApiOperation(value = "看看别人怎么写", nickname = "get")
  @GetMapping("/reference")
  @IgnoreUserToken
  public ObjectRestResponse<UserReferenceVO> workExperienceReference() {
    return ObjectRestResponse.success(userWorkExperienceManager.workExperienceReference());
  }

}
