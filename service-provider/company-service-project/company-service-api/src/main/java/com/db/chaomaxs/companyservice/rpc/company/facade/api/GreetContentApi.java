package com.db.chaomaxs.companyservice.rpc.company.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentUpdateReqDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 打招呼语
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface GreetContentApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/greetContent/save")
  BaseResponse save(@RequestBody GreetContentCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/greetContent/update")
  BaseResponse update(@RequestBody GreetContentUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/greetContent/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/greetContent/get/{id}")
  ObjectRestResponse<GreetContentRespDTO> getGreetContentById(@PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param userId 查询参数
   * @return
   */
  @PostMapping("/facade/greetContent/{userId}")
  ObjectRestResponse<GreetContentRespDTO> getGreetContentsByUserId(@PathVariable("userId") Long userId);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/greetContent/page")
  TableResultResponse<GreetContentRespDTO> page(@RequestBody GreetContentPageReqDTO pageReqDTO);

}
