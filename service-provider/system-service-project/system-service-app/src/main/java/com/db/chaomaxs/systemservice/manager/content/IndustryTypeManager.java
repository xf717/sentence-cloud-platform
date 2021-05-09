package com.db.chaomaxs.systemservice.manager.content;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeUpdateReqDTO;
import com.db.chaomaxs.systemservice.service.content.IndustryTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * IndustryTypeManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class IndustryTypeManager {

  @Autowired
  private IndustryTypeService industryTypeService;

  /**
 * 保存数据
* @param createReqDTO
* @return
*/
  public int saveIndustryType(IndustryTypeCreateReqDTO createReqDTO) {
    return industryTypeService.saveIndustryType(createReqDTO);
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateIndustryType(IndustryTypeUpdateReqDTO updateReqDTO) {
      return industryTypeService.updateIndustryType(updateReqDTO);
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteIndustryType(Long id) {
    return industryTypeService.deleteIndustryType(id);
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<IndustryTypeRespDTO> listIndustryTypes(IndustryTypeListQueryReqDTO listQueryReqDTO) {
    return industryTypeService.listIndustryTypes(listQueryReqDTO);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public IndustryTypeRespDTO getIndustryTypeById(Long id) {
    return industryTypeService.getIndustryTypeById(id);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<IndustryTypeRespDTO> pageIndustryType(IndustryTypePageReqDTO page) {
    return industryTypeService.pageIndustryType(page);
  }


  /**
   * 根据参数查询所有可显示分类
   * @param listQueryReqDTO
   * @return
   */
  public List<IndustryTypeRespDTO> listDisplayIndustry(IndustryTypeListQueryReqDTO listQueryReqDTO) {
    return industryTypeService.listDisplayIndustry(listQueryReqDTO);
  }

  /**
   * 根据分类名称和父id查询
   *
   * @param reqDTO
   * @return
   */
  public IndustryTypeRespDTO getIndustryByNameAndParentId(IndustryTypeListQueryReqDTO reqDTO) {
    return industryTypeService.getIndustryByNameAndParentId(reqDTO);
  }


  /**
   * 根据parentId查询数据,不分页
   * @param parentId
   * @return
   */
  public List<IndustryTypeRespDTO> getIndustryByParentId(Long parentId) {
    return industryTypeService.listIndustryByParentId(parentId);
  }
}
