package com.github.xf717.userweb.controller.resume;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userweb.controller.resume.dto.UserEnclosureResumeAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserEnclosureResumeUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserEnclosureResumeVO;
import com.github.xf717.userweb.manager.resume.UserEnclosureResumeManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
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
 * 用户_附件_简历
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Api(value = "用户_附件_简历", description = "用户_附件_简历", tags = "用户_附件_简历")
@RestController
@RequestMapping("/rest/userEnclosureResume")
public class UserEnclosureResumeController {

  @Autowired
  private UserEnclosureResumeManager userEnclosureResumeManager;

  /**
   * 上传附件简历，添加数据
   *
   * @param addDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody UserEnclosureResumeAddDTO addDTO)
      throws IOException {
    userEnclosureResumeManager.save(addDTO);
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
  public BaseResponse update(@Valid @RequestBody UserEnclosureResumeUpdateDTO updateDTO) {
    userEnclosureResumeManager.update(updateDTO);
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
    userEnclosureResumeManager.remove(id);
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
  public ObjectRestResponse<UserEnclosureResumeVO> getUserEnclosureResumeById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse.success(userEnclosureResumeManager.getUserEnclosureResumeById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<UserEnclosureResumeVO>> listUserEnclosureResumes() {
    List<UserEnclosureResumeVO> list = userEnclosureResumeManager.listUserEnclosureResumes();
    return ObjectRestResponse.success(list);
  }

}
