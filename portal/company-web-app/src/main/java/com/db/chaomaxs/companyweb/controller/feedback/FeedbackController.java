package com.db.chaomaxs.companyweb.controller.feedback;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackAddDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackPageDTO;
import com.db.chaomaxs.companyweb.controller.feedback.dto.FeedbackUpdateDTO;
import com.db.chaomaxs.companyweb.controller.feedback.vo.FeedbackVO;
import com.db.chaomaxs.companyweb.manager.feedback.FeedbackManager;
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
 * 帮助与反馈
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Api(value = "帮助与反馈", description = "帮助与反馈", tags = "Feedback")
@RestController
@RequestMapping("/rest/feedback")
public class FeedbackController {

  @Autowired
  private FeedbackManager feedbackManager;

  /**
   * 添加数据
   *
   * @param AddDTO
   * @return
   */
  @ApiOperation(value = "添加数据", produces = "application/json", nickname = "save")
  @PostMapping("/save")
  public BaseResponse save(@Valid @RequestBody FeedbackAddDTO feedbackAddDTO) {
    feedbackManager.save(feedbackAddDTO);
    return BaseResponse.success("保存成功");
  }

  /**
   * 更新数据
   *
   * @param UpdateDTO
   * @return
   */
  @ApiOperation(value = "更新数据", produces = "application/json", nickname = "update")
  @ApiImplicitParam(name = "id", dataType = "int", paramType = "path", required = true)
  @PutMapping("/update/{id}")
  public BaseResponse update(@Valid @RequestBody FeedbackUpdateDTO feedbackUpdateDTO) {
    feedbackManager.update(feedbackUpdateDTO);
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
    feedbackManager.remove(id);
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
  public ObjectRestResponse<FeedbackVO> getFeedbackById(@PathVariable("id") Long id) {
    return ObjectRestResponse.success(feedbackManager.getFeedbackById(id));
  }

  @ApiOperation(value = "根据参数查询数据,不分页", nickname = "list")
  @PostMapping("/list")
  public ObjectRestResponse<List<FeedbackVO>> listFeedbacks(
      @Valid @RequestBody FeedbackDTO feedbackDTO) {
    List<FeedbackVO> list = feedbackManager.listFeedbacks(feedbackDTO);
    return ObjectRestResponse.success(list);
  }

  @ApiOperation(value = "根据参数查询数据,分页", nickname = "page")
  @PostMapping("/page")
  public TableResultResponse<FeedbackVO> page(@RequestBody FeedbackPageDTO pageReqDTO) {
    return feedbackManager.pageFeedback(pageReqDTO);
  }

}
