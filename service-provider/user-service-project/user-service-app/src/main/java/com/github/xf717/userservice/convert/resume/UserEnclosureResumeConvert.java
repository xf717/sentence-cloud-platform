package com.github.xf717.userservice.convert.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserEnclosureResumeDO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserEnclosureResumeConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserEnclosureResumeConvert {

        UserEnclosureResumeConvert INSTANCE = Mappers.getMapper(UserEnclosureResumeConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserEnclosureResumeDO convert(UserEnclosureResumeCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserEnclosureResumeDO convert(UserEnclosureResumeUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserEnclosureResumeRespDTO> convertList(List<UserEnclosureResumeDO> list);

  /**
   * 对象转换
   *
   * @param userEnclosureResumeDO
   * @return
   */
      UserEnclosureResumeRespDTO convert(UserEnclosureResumeDO userEnclosureResumeDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserEnclosureResumeRespDTO> convertPage(IPage<UserEnclosureResumeDO> page);


}
