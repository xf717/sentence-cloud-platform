package com.github.xf717.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserHideCompanyDO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserHideCompanyUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserHideCompanyConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserHideCompanyConvert {

  UserHideCompanyConvert INSTANCE = Mappers.getMapper(UserHideCompanyConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserHideCompanyDO convert(UserHideCompanyCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserHideCompanyDO convert(UserHideCompanyUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserHideCompanyRespDTO> convertList(List<UserHideCompanyDO> list);

  /**
   * 对象转换
   *
   * @param userHideCompanyDO
   * @return
   */
  UserHideCompanyRespDTO convert(UserHideCompanyDO userHideCompanyDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserHideCompanyRespDTO> convertPage(IPage<UserHideCompanyDO> page);


  /**
   * list 转换
   *
   * @param userHideCompanyList
   * @return
   */
  List<UserHideCompanyDO> listConvert(List<UserHideCompanyCreateReqDTO> userHideCompanyList);


}
