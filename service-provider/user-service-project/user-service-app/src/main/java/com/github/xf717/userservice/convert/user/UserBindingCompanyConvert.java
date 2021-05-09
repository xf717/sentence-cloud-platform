package com.github.xf717.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserBindingCompanyDO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyUpdateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingExtendRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingInfoRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserBindingCompanyConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Mapper
public interface UserBindingCompanyConvert {

  UserBindingCompanyConvert INSTANCE = Mappers.getMapper(UserBindingCompanyConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserBindingCompanyDO convert(UserBindingCompanyCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserBindingCompanyDO convert(UserBindingCompanyUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserBindingCompanyRespDTO> convertList(List<UserBindingCompanyDO> list);

  /**
   * 对象转换
   *
   * @param userBindingCompanyDO
   * @return
   */
  UserBindingCompanyRespDTO convert(UserBindingCompanyDO userBindingCompanyDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserBindingCompanyRespDTO> convertPage(IPage<UserBindingCompanyDO> page);

  /**
   * pageResult convert userBindingInfoRespDTOs
   * @param pageResult
   * @return
   */
  PageResult<UserBindingInfoRespDTO> convertToUserBindingInfo(PageResult<UserBindingCompanyRespDTO> pageResult);

  /**
   * userBindingCompanyDOs conver userBindingExtendRespDTOs
   * @param userBindingCompanyDOs
   * @return
   */
  List<UserBindingExtendRespDTO> convert(List<UserBindingCompanyDO> userBindingCompanyDOs);


}
