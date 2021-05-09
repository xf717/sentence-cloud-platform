package com.db.chaomaxs.positionservice.service.positiontype;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.positionservice.convert.positiontype.PositionKeywordConvert;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.positiontype.PositionKeywordDO;
import com.db.chaomaxs.positionservice.dal.mysql.mapper.positiontype.PositionKeywordMapper;
import com.db.chaomaxs.positionservice.enums.PositionErrorCodeConstants;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionKeywordUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionKeywordService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class PositionKeywordService {

  @Autowired
  private PositionKeywordMapper positionKeywordMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int savePositionKeyword(PositionKeywordCreateReqDTO createReqDTO) {
    return positionKeywordMapper.insert(PositionKeywordConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updatePositionKeyword(PositionKeywordUpdateReqDTO updateReqDTO) {
          PositionKeywordDO positionKeywordDO = positionKeywordMapper.selectById(updateReqDTO.getId());
    if (positionKeywordDO == null) {
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
          positionKeywordDO = PositionKeywordConvert.INSTANCE.convert(updateReqDTO);
    int result = positionKeywordMapper.updateById(positionKeywordDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deletePositionKeyword(Long id) {
    if (positionKeywordMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = positionKeywordMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<PositionKeywordRespDTO> listPositionKeywords(PositionKeywordListQueryReqDTO listQueryReqDTO) {
    List<PositionKeywordDO> list = positionKeywordMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return PositionKeywordConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public PositionKeywordRespDTO getPositionKeywordById(Long id) {
          PositionKeywordDO positionKeywordDO = positionKeywordMapper.selectById(id);
    if (positionKeywordDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(PositionErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return PositionKeywordConvert.INSTANCE.convert(positionKeywordDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<PositionKeywordRespDTO> pagePositionKeyword(PositionKeywordPageReqDTO page) {
    IPage<PositionKeywordDO> positionKeywordPage = positionKeywordMapper.selectPage(page);
    return PositionKeywordConvert.INSTANCE.convertPage(positionKeywordPage);
  }


}
