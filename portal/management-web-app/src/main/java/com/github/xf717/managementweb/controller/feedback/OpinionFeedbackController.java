package com.github.xf717.managementweb.controller.feedback;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.feedback.dto.OpinionFeedbackAddDTO;
import com.github.xf717.managementweb.controller.feedback.dto.OpinionFeedbackPageDTO;
import com.github.xf717.managementweb.controller.feedback.dto.OpinionFeedbackUpdateDTO;
import com.github.xf717.managementweb.controller.feedback.vo.OpinionFeedbackVO;
import com.github.xf717.managementweb.manager.feedback.OpinionFeedbackManager;
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
 * 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Api(value = "意见反馈信息表", description = "意见反馈信息表", tags = "OpinionFeedback")
@RestController
@RequestMapping("/rest/opinionFeedback")
public class OpinionFeedbackController {

  @Autowired
  private OpinionFeedbackManager opinionFeedbackManager;

  /**
   * 添加数据
   *
   * @param addDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody OpinionFeedbackAddDTO addDTO) {
    BaseContextHandler.getUserID();
    opinionFeedbackManager.save(addDTO);
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
  public BaseResponse update(@Valid @RequestBody OpinionFeedbackUpdateDTO updateDTO) {
    opinionFeedbackManager.update(updateDTO);
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
    opinionFeedbackManager.remove(id);
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
  public ObjectRestResponse<OpinionFeedbackVO> getOpinionFeedbackById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(opinionFeedbackManager.getOpinionFeedbackById(id));
  }



  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<OpinionFeedbackVO> page(
      @RequestBody OpinionFeedbackPageDTO pageReqDTO) {
    return opinionFeedbackManager.pageOpinionFeedback(pageReqDTO);
  }



}
