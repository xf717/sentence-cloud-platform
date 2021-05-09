package com.db.chaomaxs.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserThirdDO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserThirdUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserThirdConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserThirdConvert {

  UserThirdConvert INSTANCE = Mappers.getMapper(UserThirdConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserThirdDO convert(UserThirdCreateReqDTO createReqDTO);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserThirdDO convert(UserInfoCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserThirdDO convert(UserThirdUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserThirdRespDTO> convertList(List<UserThirdDO> list);

  /**
   * 对象转换
   *
   * @param userThirdDO
   * @return
   */
  UserThirdRespDTO convert(UserThirdDO userThirdDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserThirdRespDTO> convertPage(IPage<UserThirdDO> page);

  /**
   * 业务数据转换
   *
   * @param userInfoCreateReqDTO
   * @return
   */
  UserThirdCreateReqDTO convertUserThird(UserInfoCreateReqDTO userInfoCreateReqDTO);


}
