package com.db.chaomaxs.userweb.controller.resume;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userweb.controller.resume.dto.UserExpectedPositionAddDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserExpectedPositionUpdateDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserPositionWantedStatusDTO;
import com.db.chaomaxs.userweb.controller.resume.vo.UserExpectedAndStatusVO;
import com.db.chaomaxs.userweb.controller.resume.vo.UserExpectedPositionVO;
import com.db.chaomaxs.userweb.manager.resume.UserExpectedPositionManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
 * 用户_期望职位
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Api(value = "用户_期望职位", description = "用户_期望职位", tags = "用户_期望职位")
@RestController
@RequestMapping("/rest/userExpectedPosition")
public class UserExpectedPositionController {

  @Autowired
  private UserExpectedPositionManager userExpectedPositionManager;

  /**
   * 添加数据
   *
   * @param addDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody UserExpectedPositionAddDTO addDTO) {
    userExpectedPositionManager.save(addDTO);
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
  public BaseResponse update(@Valid @RequestBody UserExpectedPositionUpdateDTO updateDTO) {
    userExpectedPositionManager.update(updateDTO);
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
    userExpectedPositionManager.remove(id);
    return BaseResponse.success("删除成功");
  }

  /**
   * 获取数据
   *
   * @param id
   * @return
   */
  @ApiOperation(value = "获取对象数据", nickname = "get")
  @GetMapping("/get/{id}")
  public ObjectRestResponse<UserExpectedPositionVO> getUserExpectedPositionById(
      @PathVariable("id") Long id) {
    return ObjectRestResponse.success(userExpectedPositionManager.getUserExpectedPositionById(id));
  }


  @ApiOperation(value = "根据用户id查询求职期望和当前求职状态", nickname = "get")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @GetMapping("/list/{userId}")
  public ObjectRestResponse<UserExpectedAndStatusVO> getUserExpectedPositionByUserId(
      @PathVariable("userId") Long userId) {
    return ObjectRestResponse
        .success(userExpectedPositionManager.getUserExpectedAndStatusByUserId(userId));
  }

	/**
	 *
	 * 更新求职状态
	 * @param updateDTO
	 * @return
	 */
	@ApiOperation(value = "更新求职状态", produces = "application/json", nickname = "update")
	@PutMapping("/update/status")
	public BaseResponse update(@Valid @RequestBody UserPositionWantedStatusDTO updateDTO) {
		userExpectedPositionManager.updatePositionWantedStatus(updateDTO);
		return BaseResponse.success("更新成功");
	}
}
