package com.db.chaomaxs.positionservice.service.positiontype;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.convert.positiontype.PositionKeywordExtendConvert;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype.PositionKeywordExtendDO;
import com.db.chaomaxs.positionservice.dal.mysql.mapper.positiontype.PositionKeywordExtendMapper;
import com.db.chaomaxs.positionservice.enums.PositionErrorCodeConstants;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordExtendUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionKeywordExtendService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class PositionKeywordExtendService {

  @Autowired
  private PositionKeywordExtendMapper positionKeywordExtendMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int savePositionKeywordExtend(PositionKeywordExtendCreateReqDTO createReqDTO) {
    return positionKeywordExtendMapper.insert(PositionKeywordExtendConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updatePositionKeywordExtend(PositionKeywordExtendUpdateReqDTO updateReqDTO) {
          PositionKeywordExtendDO positionKeywordExtendDO = positionKeywordExtendMapper.selectById(updateReqDTO.getId());
    if (positionKeywordExtendDO == null) {
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
          positionKeywordExtendDO = PositionKeywordExtendConvert.INSTANCE.convert(updateReqDTO);
    int result = positionKeywordExtendMapper.updateById(positionKeywordExtendDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deletePositionKeywordExtend(Long id) {
    if (positionKeywordExtendMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = positionKeywordExtendMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<PositionKeywordExtendRespDTO> listPositionKeywordExtends(PositionKeywordExtendListQueryReqDTO listQueryReqDTO) {
    List<PositionKeywordExtendDO> list = positionKeywordExtendMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return PositionKeywordExtendConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public PositionKeywordExtendRespDTO getPositionKeywordExtendById(Long id) {
          PositionKeywordExtendDO positionKeywordExtendDO = positionKeywordExtendMapper.selectById(id);
    if (positionKeywordExtendDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return PositionKeywordExtendConvert.INSTANCE.convert(positionKeywordExtendDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<PositionKeywordExtendRespDTO> pagePositionKeywordExtend(PositionKeywordExtendPageReqDTO page) {
    IPage<PositionKeywordExtendDO> positionKeywordExtendPage = positionKeywordExtendMapper.selectPage(page);
    return PositionKeywordExtendConvert.INSTANCE.convertPage(positionKeywordExtendPage);
  }


}
