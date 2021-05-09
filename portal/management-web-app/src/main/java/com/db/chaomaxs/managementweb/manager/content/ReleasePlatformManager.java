package com.db.chaomaxs.managementweb.manager.content;

import com.db.chaomaxs.managementweb.controller.content.dto.ReleasePlatformAddDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.ReleasePlatformUpdateDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.ReleasePlatformDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.ReleasePlatformPageDTO;
import com.db.chaomaxs.managementweb.controller.content.vo.ReleasePlatformVO;
import com.db.chaomaxs.managementweb.convert.content.ReleasePlatformConvert;
import com.db.chaomaxs.systemservice.rpc.content.dto.ReleasePlatformRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.facade.ReleasePlatformRpcFacade;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ReleasePlatformManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class ReleasePlatformManager {

  @Autowired
  private ReleasePlatformRpcFacade releasePlatformRpcFacade;

  /**
   * 添加数据
   * @param releasePlatformCreateReqDTO 添加参数
   * @return
   */
  public int save(ReleasePlatformAddDTO releasePlatformAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = releasePlatformRpcFacade
        .save(ReleasePlatformConvert.INSTANCE.convert(releasePlatformAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   * @param releasePlatformUpdateDTO  更新参数
   * @return
   */
  public int update(ReleasePlatformUpdateDTO releasePlatformUpdateDTO) {
    BaseResponse baseResponse = releasePlatformRpcFacade
        .update(ReleasePlatformConvert.INSTANCE.convert(releasePlatformUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   * @param id  id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = releasePlatformRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   * @param id id
   * @return
   */
  public ReleasePlatformVO getReleasePlatformById(Long id) {
    ObjectRestResponse<ReleasePlatformRespDTO> objectRestResponse = releasePlatformRpcFacade.getReleasePlatformById(
        id);
    objectRestResponse.checkError();
    return ReleasePlatformConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   * @param releasePlatformDTO  查询参数
   * @return
   */
  public List<ReleasePlatformVO> listReleasePlatforms(ReleasePlatformDTO releasePlatformDTO) {
    ObjectRestResponse<List<ReleasePlatformRespDTO>> objectRestResponse = releasePlatformRpcFacade.listReleasePlatforms(
                ReleasePlatformConvert.INSTANCE.convert(releasePlatformDTO));
    objectRestResponse.checkError();
    return ReleasePlatformConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   * @param pageReqDTO  分页参数
   * @return
   */
  public TableResultResponse<ReleasePlatformVO> pageReleasePlatform(ReleasePlatformPageDTO pageReqDTO) {
    TableResultResponse<ReleasePlatformRespDTO> tableResultResponse = releasePlatformRpcFacade
        .page(ReleasePlatformConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return ReleasePlatformConvert.INSTANCE.convert(tableResultResponse);
  }


}
