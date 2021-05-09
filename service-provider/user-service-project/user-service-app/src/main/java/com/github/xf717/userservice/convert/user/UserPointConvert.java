package com.github.xf717.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserPointDO;
import com.github.xf717.userservice.rpc.user.dto.UserPointCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPointRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPointUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserPointConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserPointConvert {

        UserPointConvert INSTANCE = Mappers.getMapper(UserPointConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserPointDO convert(UserPointCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserPointDO convert(UserPointUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserPointRespDTO> convertList(List<UserPointDO> list);

  /**
   * 对象转换
   *
   * @param userPointDO
   * @return
   */
      UserPointRespDTO convert(UserPointDO userPointDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserPointRespDTO> convertPage(IPage<UserPointDO> page);


}
