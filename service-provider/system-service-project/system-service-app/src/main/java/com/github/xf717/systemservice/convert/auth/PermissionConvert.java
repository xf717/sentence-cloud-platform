package com.github.xf717.systemservice.convert.auth;

import com.github.xf717.common.framework.vo.user.UserInfo;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.MenuTreeRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * PermissionConvert
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/30 16:45
 */
@Mapper
public interface PermissionConvert {

  PermissionConvert INSTANCE = Mappers.getMapper(
      PermissionConvert.class);

  /**
   * 用户信息转换
   *
   * @param baseUserRespDTO
   * @return
   */
  UserInfo convert(BaseUserRespDTO baseUserRespDTO);

  /**
   * 转换数据
   *
   * @param menus
   * @return
   */
  List<MenuTreeRespDTO> convert(List<BaseMenuRespDTO> menus);

}
