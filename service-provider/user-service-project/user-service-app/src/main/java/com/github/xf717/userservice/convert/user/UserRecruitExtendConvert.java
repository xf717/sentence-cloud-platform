package com.github.xf717.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserRecruitExtendDO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRecruitExtendUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserRecruitExtendConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:54:37
 */
@Mapper
public interface UserRecruitExtendConvert {

        UserRecruitExtendConvert INSTANCE = Mappers.getMapper(UserRecruitExtendConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserRecruitExtendDO convert(UserRecruitExtendCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserRecruitExtendDO convert(UserRecruitExtendUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserRecruitExtendRespDTO> convertList(List<UserRecruitExtendDO> list);

  /**
   * 对象转换
   *
   * @param userRecruitExtendDO
   * @return
   */
      UserRecruitExtendRespDTO convert(UserRecruitExtendDO userRecruitExtendDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserRecruitExtendRespDTO> convertPage(IPage<UserRecruitExtendDO> page);


}
