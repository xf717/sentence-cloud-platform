package com.github.xf717.userservice.convert.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.user.UserInterviewDO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInterviewUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserInterviewConvert
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Mapper
public interface UserInterviewConvert {

        UserInterviewConvert INSTANCE = Mappers.getMapper(UserInterviewConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      UserInterviewDO convert(UserInterviewCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      UserInterviewDO convert(UserInterviewUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserInterviewRespDTO> convertList(List<UserInterviewDO> list);

  /**
   * 对象转换
   *
   * @param userInterviewDO
   * @return
   */
      UserInterviewRespDTO convert(UserInterviewDO userInterviewDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserInterviewRespDTO> convertPage(IPage<UserInterviewDO> page);


}
