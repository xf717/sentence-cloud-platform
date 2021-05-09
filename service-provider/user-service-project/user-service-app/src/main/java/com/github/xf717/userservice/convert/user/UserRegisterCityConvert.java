package com.github.xf717.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserRegisterCityDO;
import com.github.xf717.userservice.rpc.user.dto.UserRegisterCityCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRegisterCityRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserRegisterCityUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserRegisterCityConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserRegisterCityConvert {

        UserRegisterCityConvert INSTANCE = Mappers.getMapper(UserRegisterCityConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserRegisterCityDO convert(UserRegisterCityCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserRegisterCityDO convert(UserRegisterCityUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserRegisterCityRespDTO> convertList(List<UserRegisterCityDO> list);

  /**
   * 对象转换
   *
   * @param userRegisterCityDO
   * @return
   */
      UserRegisterCityRespDTO convert(UserRegisterCityDO userRegisterCityDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserRegisterCityRespDTO> convertPage(IPage<UserRegisterCityDO> page);


}
