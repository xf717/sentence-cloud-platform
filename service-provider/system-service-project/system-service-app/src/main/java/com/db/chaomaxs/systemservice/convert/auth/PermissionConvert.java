package com.db.chaomaxs.systemservice.convert.auth;

import com.db.chaomaxs.common.framework.vo.user.UserInfo;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.MenuTreeRespDTO;
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
