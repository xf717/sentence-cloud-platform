package com.github.xf717.managementweb.manager.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupMemberAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupMemberDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupMemberPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseGroupMemberUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.BaseGroupMemberVO;
import com.github.xf717.managementweb.convert.auth.BaseGroupMemberConvert;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberRespDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseGroupMemberRpcFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseGroupMemberManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseGroupMemberManager {

  @Autowired
  private BaseGroupMemberRpcFacade baseGroupMemberRpcFacade;

  /**
   * 添加数据
   *
   * @param baseGroupMemberAddDTO 添加参数
   * @return
   */
  public int save(BaseGroupMemberAddDTO baseGroupMemberAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = baseGroupMemberRpcFacade
        .save(BaseGroupMemberConvert.INSTANCE.convert(baseGroupMemberAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param baseGroupMemberUpdateDTO 更新参数
   * @return
   */
  public int update(BaseGroupMemberUpdateDTO baseGroupMemberUpdateDTO) {
    BaseResponse baseResponse = baseGroupMemberRpcFacade
        .update(BaseGroupMemberConvert.INSTANCE.convert(baseGroupMemberUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = baseGroupMemberRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public BaseGroupMemberVO getBaseGroupMemberById(Long id) {
    ObjectRestResponse<BaseGroupMemberRespDTO> objectRestResponse = baseGroupMemberRpcFacade
        .getBaseGroupMemberById(id);
    objectRestResponse.checkError();
    return BaseGroupMemberConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param baseGroupMemberDTO 查询参数
   * @return
   */
  public List<BaseGroupMemberVO> listBaseGroupMembers(BaseGroupMemberDTO baseGroupMemberDTO) {
    ObjectRestResponse<List<BaseGroupMemberRespDTO>> objectRestResponse = baseGroupMemberRpcFacade
        .listBaseGroupMembers(BaseGroupMemberConvert.INSTANCE.convert(baseGroupMemberDTO));
    objectRestResponse.checkError();
    return BaseGroupMemberConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageDTO 分页参数
   * @return
   */
  public TableResultResponse<BaseGroupMemberVO> pageBaseGroupMember(
      BaseGroupMemberPageDTO pageDTO) {
    TableResultResponse<BaseGroupMemberRespDTO> tableResultResponse = baseGroupMemberRpcFacade
        .page(BaseGroupMemberConvert.INSTANCE.convert(pageDTO));
    tableResultResponse.checkError();
    return BaseGroupMemberConvert.INSTANCE.convert(tableResultResponse);
  }


}
