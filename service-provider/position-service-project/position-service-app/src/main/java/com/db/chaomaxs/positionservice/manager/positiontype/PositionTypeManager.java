package com.db.chaomaxs.positionservice.manager.positiontype;

import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypePageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeUpdateReqDTO;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.service.positiontype.PositionTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionTypeManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:02:00
 */
@Service
@Validated
public class PositionTypeManager {

  @Autowired
  private PositionTypeService positionTypeService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int savePositionType(PositionTypeCreateReqDTO createReqDTO) {
    return positionTypeService.savePositionType(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updatePositionType(PositionTypeUpdateReqDTO updateReqDTO) {
      return positionTypeService.updatePositionType(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deletePositionType(Long id) {
    return positionTypeService.deletePositionType(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<PositionTypeRespDTO> listPositionTypes(PositionTypeListQueryReqDTO listQueryReqDTO) {
    return positionTypeService.listPositionTypes(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public PositionTypeRespDTO getPositionTypeById(Long id) {
    return positionTypeService.getPositionTypeById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<PositionTypeRespDTO> pagePositionType(PositionTypePageReqDTO page) {
    return positionTypeService.pagePositionType(page);
  }


  /**
   * 根据参数查询所有可显示分类
   * @param listQueryReqDTO  查询参数
   * @return
   */
  public List<PositionTypeRespDTO> listDisplayPositionType(PositionTypeListQueryReqDTO listQueryReqDTO) {
    return positionTypeService.listDisplayPositionType(listQueryReqDTO);
  }

  /**
   * 根据parentId查询数据,不分页
   * @param parentId  查询参数
   * @return
   */
  public List<PositionTypeRespDTO> listPositionTypeByParentId(Long parentId) {
    return positionTypeService.listPositionTypeByParentId(parentId);
  }
}
