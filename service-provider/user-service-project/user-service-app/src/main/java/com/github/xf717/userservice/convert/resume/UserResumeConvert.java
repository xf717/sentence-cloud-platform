package com.github.xf717.userservice.convert.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserResumeDO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPersonalInfoUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserResumeConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Mapper
public interface UserResumeConvert {

        UserResumeConvert INSTANCE = Mappers.getMapper(UserResumeConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserResumeDO convert(UserResumeCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserResumeDO convert(UserResumeUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserResumeRespDTO> convertList(List<UserResumeDO> list);

  /**
   * 对象转换
   *
   * @param userResumeDO
   * @return
   */
      UserResumeRespDTO convert(UserResumeDO userResumeDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserResumeRespDTO> convertPage(IPage<UserResumeDO> page);

  /**
   * updateReq 转换
   *
   * @param personalInfoUpdateReqDTO
   * @return
   */
  UserResumeDO convertPersonalInfo(UserPersonalInfoUpdateReqDTO personalInfoUpdateReqDTO);
}
