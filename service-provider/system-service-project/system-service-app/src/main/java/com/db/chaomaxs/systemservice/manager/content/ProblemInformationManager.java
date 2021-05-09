package com.db.chaomaxs.systemservice.manager.content;

import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.ProblemInformationUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.service.content.ProblemInformationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ProblemInformationManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class ProblemInformationManager {

  @Autowired
  private ProblemInformationService problemInformationService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveProblemInformation(ProblemInformationCreateReqDTO createReqDTO) {
    return problemInformationService.saveProblemInformation(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateProblemInformation(ProblemInformationUpdateReqDTO updateReqDTO) {
      return problemInformationService.updateProblemInformation(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteProblemInformation(Long id) {
    return problemInformationService.deleteProblemInformation(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<ProblemInformationRespDTO> listProblemInformations(ProblemInformationListQueryReqDTO listQueryReqDTO) {
    return problemInformationService.listProblemInformations(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public ProblemInformationRespDTO getProblemInformationById(Long id) {
    return problemInformationService.getProblemInformationById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<ProblemInformationRespDTO> pageProblemInformation(ProblemInformationPageReqDTO page) {
    return problemInformationService.pageProblemInformation(page);
  }


}
