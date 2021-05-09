package com.github.xf717.systemservice.manager.content;

import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendUpdateReqDTO;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.service.content.ProblemInformationExtendService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ProblemInformationExtendManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class ProblemInformationExtendManager {

  @Autowired
  private ProblemInformationExtendService problemInformationExtendService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveProblemInformationExtend(ProblemInformationExtendCreateReqDTO createReqDTO) {
    return problemInformationExtendService.saveProblemInformationExtend(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateProblemInformationExtend(ProblemInformationExtendUpdateReqDTO updateReqDTO) {
      return problemInformationExtendService.updateProblemInformationExtend(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteProblemInformationExtend(Long id) {
    return problemInformationExtendService.deleteProblemInformationExtend(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<ProblemInformationExtendRespDTO> listProblemInformationExtends(ProblemInformationExtendListQueryReqDTO listQueryReqDTO) {
    return problemInformationExtendService.listProblemInformationExtends(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public ProblemInformationExtendRespDTO getProblemInformationExtendById(Long id) {
    return problemInformationExtendService.getProblemInformationExtendById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<ProblemInformationExtendRespDTO> pageProblemInformationExtend(ProblemInformationExtendPageReqDTO page) {
    return problemInformationExtendService.pageProblemInformationExtend(page);
  }


}
