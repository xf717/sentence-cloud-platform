package com.github.xf717.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserDeliveryDO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserDeliveryUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserDeliveryConvert
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
@Mapper
public interface UserDeliveryConvert {

  UserDeliveryConvert INSTANCE = Mappers.getMapper(UserDeliveryConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserDeliveryDO convert(UserDeliveryCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserDeliveryDO convert(UserDeliveryUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserDeliveryRespDTO> convertList(List<UserDeliveryDO> list);

  /**
   * 对象转换
   *
   * @param userDeliveryDO
   * @return
   */
  UserDeliveryRespDTO convert(UserDeliveryDO userDeliveryDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserDeliveryRespDTO> convertPage(IPage<UserDeliveryDO> page);


}
