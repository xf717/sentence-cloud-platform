package com.db.chaomaxs.positionservice.manager.positiontype;

import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.service.positiontype.PositionKeywordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionKeywordManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Service
@Validated
public class PositionKeywordManager {

  @Autowired
  private PositionKeywordService positionKeywordService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int savePositionKeyword(PositionKeywordCreateReqDTO createReqDTO) {
    return positionKeywordService.savePositionKeyword(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updatePositionKeyword(PositionKeywordUpdateReqDTO updateReqDTO) {
      return positionKeywordService.updatePositionKeyword(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deletePositionKeyword(Long id) {
    return positionKeywordService.deletePositionKeyword(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<PositionKeywordRespDTO> listPositionKeywords(PositionKeywordListQueryReqDTO listQueryReqDTO) {
    return positionKeywordService.listPositionKeywords(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public PositionKeywordRespDTO getPositionKeywordById(Long id) {
    return positionKeywordService.getPositionKeywordById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<PositionKeywordRespDTO> pagePositionKeyword(PositionKeywordPageReqDTO page) {
    return positionKeywordService.pagePositionKeyword(page);
  }


}
