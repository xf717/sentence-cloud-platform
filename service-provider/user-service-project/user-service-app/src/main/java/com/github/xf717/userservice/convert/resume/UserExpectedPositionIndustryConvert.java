package com.github.xf717.userservice.convert.resume;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.userservice.dal.mysql.dataobject.resume.UserExpectedPositionIndustryDO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * UserExpectedPositionIndustryConvert
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@Mapper
public interface UserExpectedPositionIndustryConvert {

  UserExpectedPositionIndustryConvert INSTANCE = Mappers
      .getMapper(UserExpectedPositionIndustryConvert.class);

  /**
   * createReq 转换
   *
   * @param createReqDTO
   * @return
   */
  UserExpectedPositionIndustryDO convert(UserExpectedPositionIndustryCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
  UserExpectedPositionIndustryDO convert(UserExpectedPositionIndustryUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<UserExpectedPositionIndustryRespDTO> convertList(List<UserExpectedPositionIndustryDO> list);

  /**
   * 对象转换
   *
   * @param userExpectedPositionIndustryDO
   * @return
   */
  UserExpectedPositionIndustryRespDTO convert(
      UserExpectedPositionIndustryDO userExpectedPositionIndustryDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<UserExpectedPositionIndustryRespDTO> convertPage(
      IPage<UserExpectedPositionIndustryDO> page);


}
