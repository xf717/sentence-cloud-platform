package com.github.xf717.userweb.convert.resume;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperienceListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperiencePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperienceRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserProjectExperienceUpdateReqDTO;
import com.github.xf717.userweb.controller.resume.dto.UserProjectExperienceAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserProjectExperienceDTO;
import com.github.xf717.userweb.controller.resume.dto.UserProjectExperiencePageDTO;
import com.github.xf717.userweb.controller.resume.dto.UserProjectExperienceUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserProjectExperienceVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_项目经历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Mapper
public interface UserProjectExperienceConvert {

  UserProjectExperienceConvert INSTANCE = Mappers.getMapper(UserProjectExperienceConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserProjectExperienceCreateReqDTO convert(UserProjectExperienceAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserProjectExperienceUpdateReqDTO convert(UserProjectExperienceUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userProjectExperienceDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserProjectExperienceListQueryReqDTO convert(
      UserProjectExperienceDTO userProjectExperienceDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserProjectExperienceVO convert(UserProjectExperienceRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserProjectExperienceVO> convertList(List<UserProjectExperienceRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserProjectExperienceVO> convert(
      TableResultResponse<UserProjectExperienceRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserProjectExperiencePageReqDTO convert(UserProjectExperiencePageDTO pageDTO);

}
