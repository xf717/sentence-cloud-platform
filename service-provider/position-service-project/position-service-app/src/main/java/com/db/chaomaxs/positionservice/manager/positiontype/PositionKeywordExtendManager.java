package com.db.chaomaxs.positionservice.manager.positiontype;

import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.service.positiontype.PositionKeywordExtendService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionKeywordExtendManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Service
@Validated
public class PositionKeywordExtendManager {

  @Autowired
  private PositionKeywordExtendService positionKeywordExtendService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int savePositionKeywordExtend(PositionKeywordExtendCreateReqDTO createReqDTO) {
    return positionKeywordExtendService.savePositionKeywordExtend(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updatePositionKeywordExtend(PositionKeywordExtendUpdateReqDTO updateReqDTO) {
      return positionKeywordExtendService.updatePositionKeywordExtend(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deletePositionKeywordExtend(Long id) {
    return positionKeywordExtendService.deletePositionKeywordExtend(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<PositionKeywordExtendRespDTO> listPositionKeywordExtends(PositionKeywordExtendListQueryReqDTO listQueryReqDTO) {
    return positionKeywordExtendService.listPositionKeywordExtends(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public PositionKeywordExtendRespDTO getPositionKeywordExtendById(Long id) {
    return positionKeywordExtendService.getPositionKeywordExtendById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<PositionKeywordExtendRespDTO> pagePositionKeywordExtend(PositionKeywordExtendPageReqDTO page) {
    return positionKeywordExtendService.pagePositionKeywordExtend(page);
  }


}
