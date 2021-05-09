package com.github.xf717.systemservice.service.content;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.convert.content.ProblemInformationExtendConvert;
import com.github.xf717.systemservice.dal.mysql.dataobject.content.ProblemInformationExtendDO;
import com.github.xf717.systemservice.dal.mysql.mapper.content.ProblemInformationExtendMapper;
import com.github.xf717.systemservice.enums.SystemErrorCodeConstants;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ProblemInformationExtendUpdateReqDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ProblemInformationExtendService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class ProblemInformationExtendService {

  @Autowired
  private ProblemInformationExtendMapper problemInformationExtendMapper;

  /**
  * 保存数据
* @param createReqDTO
* @return
*/
  public int saveProblemInformationExtend(ProblemInformationExtendCreateReqDTO createReqDTO) {
    return problemInformationExtendMapper.insert(ProblemInformationExtendConvert.INSTANCE.convert(createReqDTO));
  }

  /**
  * 更新数据
* @param updateReqDTO
* @return
*/
  public int updateProblemInformationExtend(ProblemInformationExtendUpdateReqDTO updateReqDTO) {
          ProblemInformationExtendDO problemInformationExtendDO = problemInformationExtendMapper.selectById(updateReqDTO.getId());
    if (problemInformationExtendDO == null) {
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
          problemInformationExtendDO = ProblemInformationExtendConvert.INSTANCE.convert(updateReqDTO);
    int result = problemInformationExtendMapper.updateById(problemInformationExtendDO);
    return result;
  }

  /**
  * 删除数据
* @param id
* @return
*/
  public int deleteProblemInformationExtend(Long id) {
    if (problemInformationExtendMapper.selectById(id) == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    int result = problemInformationExtendMapper.deleteById(id);
    return result;
  }

  /**
  * 数据查询
* @param listQueryReqDTO
* @return
*/
  public List<ProblemInformationExtendRespDTO> listProblemInformationExtends(ProblemInformationExtendListQueryReqDTO listQueryReqDTO) {
    List<ProblemInformationExtendDO> list = problemInformationExtendMapper.selectList(listQueryReqDTO);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return ProblemInformationExtendConvert.INSTANCE.convertList(list);
  }

  /**
  * 根据id获取对象
* @param id
* @return
*/
  public ProblemInformationExtendRespDTO getProblemInformationExtendById(Long id) {
          ProblemInformationExtendDO problemInformationExtendDO = problemInformationExtendMapper.selectById(id);
    if (problemInformationExtendDO == null) {
      // 错误码要自定义
      throw ServiceExceptionUtil
          .exception(SystemErrorCodeConstants.NOT_EXISTS.getCode());
    }
    return ProblemInformationExtendConvert.INSTANCE.convert(problemInformationExtendDO);
  }

  /**
  * 分类
* @param page
* @return
*/
  public PageResult<ProblemInformationExtendRespDTO> pageProblemInformationExtend(ProblemInformationExtendPageReqDTO page) {
    IPage<ProblemInformationExtendDO> problemInformationExtendPage = problemInformationExtendMapper.selectPage(page);
    return ProblemInformationExtendConvert.INSTANCE.convertPage(problemInformationExtendPage);
  }


}
