package com.github.xf717.userservice.convert.resume;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserCredentialDO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserCredentialUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserCredentialConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserCredentialConvert {

  UserCredentialConvert INSTANCE = Mappers.getMapper(UserCredentialConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserCredentialDO convert(UserCredentialCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserCredentialDO convert(UserCredentialUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserCredentialRespDTO> convertList(List<UserCredentialDO> list);

  /**
   * 对象转换
   *
   * @param userCredentialDO
   * @return
   */
  UserCredentialRespDTO convert(UserCredentialDO userCredentialDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserCredentialRespDTO> convertPage(IPage<UserCredentialDO> page);


}
