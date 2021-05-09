package com.github.xf717.userweb.controller.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.security.auth.client.annotation.IgnoreUserToken;
import com.github.xf717.userweb.controller.resume.dto.UserEduExperienceAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserEduExperienceUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UniversityVO;
import com.github.xf717.userweb.controller.resume.vo.UserEduExperienceVO;
import com.github.xf717.userweb.manager.resume.UserEduExperienceManager;
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
 * 用户_教育经历表
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Api(value = "用户_教育经历表", description = "用户_教育经历表", tags = "用户_教育经历表")
@RestController
@RequestMapping("/rest/userEduExperience")
public class UserEduExperienceController {

  @Autowired
  private UserEduExperienceManager userEduExperienceManager;

  /**
   * 添加数据
   *
   * @param addDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody UserEduExperienceAddDTO addDTO) {
    userEduExperienceManager.save(addDTO);
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
  public BaseResponse update(@Valid @RequestBody UserEduExperienceUpdateDTO updateDTO) {
    userEduExperienceManager.update(updateDTO);
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
    userEduExperienceManager.remove(id);
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
  public ObjectRestResponse<UserEduExperienceVO> getUserEduExperienceById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse.success(userEduExperienceManager.getUserEduExperienceById(id));
  }

  /**
   * 填写个人资料查询教育经历数据
   *
   * @return
   */
  @ApiOperation(value = "个人资料查询数据", nickname = "get")
  @GetMapping("/query")
  @IgnoreUserToken
  public ObjectRestResponse<UserEduExperienceVO> getLastStepByUserId() {
    return ObjectRestResponse.success(userEduExperienceManager.getLastStepByUserId());
  }

  /**
   * 模糊查询高校
   *
   * @return
   */
  @ApiOperation(value = "模糊查询高校", nickname = "get")
  @GetMapping("/query/university")
  public ObjectRestResponse<List<UniversityVO>> queryUniversityName(
      @RequestParam("universityName") String universityName) {
    return ObjectRestResponse.success(userEduExperienceManager.queryUniversityName(universityName));
  }

}
