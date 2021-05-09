package com.db.chaomaxs.userweb.controller.feedback;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userweb.controller.feedback.dto.OpinionFeedbackAddDTO;
import com.db.chaomaxs.userweb.controller.feedback.vo.OpinionFeedbackVO;
import com.db.chaomaxs.userweb.manager.feedback.OpinionFeedbackManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Api(value = "意见反馈信息表", description = "意见反馈信息表", tags = "意见反馈信息")
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
    opinionFeedbackManager.save(addDTO);
    return BaseResponse.success("保存成功");
  }


  @ApiOperation(value = "查询用户最后一条反馈", nickname = "userLastFeedback")
  @GetMapping("/get/user-feedback")
  public ObjectRestResponse<OpinionFeedbackVO>  getUserLastFeedback() {
    return ObjectRestResponse.success(opinionFeedbackManager.userLastFeedback());
  }

}
