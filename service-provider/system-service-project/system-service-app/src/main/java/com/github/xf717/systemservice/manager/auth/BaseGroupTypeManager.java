package com.github.xf717.systemservice.manager.auth;

import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypePageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupTypeUpdateReqDTO;
import com.github.xf717.systemservice.service.auth.BaseGroupTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * BaseGroupTypeManager
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Service
@Validated
public class BaseGroupTypeManager {

  @Autowired
  private BaseGroupTypeService baseGroupTypeService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveBaseGroupType(BaseGroupTypeCreateReqDTO createReqDTO) {
    return baseGroupTypeService.saveBaseGroupType(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateBaseGroupType(BaseGroupTypeUpdateReqDTO updateReqDTO) {
    return baseGroupTypeService.updateBaseGroupType(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteBaseGroupType(Long id) {
    return baseGroupTypeService.deleteBaseGroupType(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<BaseGroupTypeRespDTO> listBaseGroupTypes(
      BaseGroupTypeListQueryReqDTO listQueryReqDTO) {
    return baseGroupTypeService.listBaseGroupTypes(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public BaseGroupTypeRespDTO getBaseGroupTypeById(Long id) {
    return baseGroupTypeService.getBaseGroupTypeById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<BaseGroupTypeRespDTO> pageBaseGroupType(BaseGroupTypePageReqDTO page) {
    return baseGroupTypeService.pageBaseGroupType(page);
  }


}
