package com.github.xf717.userweb.convert.resume;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserEnclosureResumeUpdateReqDTO;
import com.github.xf717.userweb.controller.resume.dto.UserEnclosureResumeAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserEnclosureResumeDTO;
import com.github.xf717.userweb.controller.resume.dto.UserEnclosureResumePageDTO;
import com.github.xf717.userweb.controller.resume.dto.UserEnclosureResumeUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserEnclosureResumeVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_附件_简历
 *
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserEnclosureResumeConvert {

  UserEnclosureResumeConvert INSTANCE = Mappers.getMapper(UserEnclosureResumeConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  UserEnclosureResumeCreateReqDTO convert(UserEnclosureResumeAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  UserEnclosureResumeUpdateReqDTO convert(UserEnclosureResumeUpdateDTO updateDTO);

  /**
   * 对象转换
   *
   * @param userEnclosureResumeDTO 查询参数对象
   * @return
   */
  @Mappings({})
  UserEnclosureResumeListQueryReqDTO convert(UserEnclosureResumeDTO userEnclosureResumeDTO);

  /**
   * 对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
  UserEnclosureResumeVO convert(UserEnclosureResumeRespDTO respDTO);

  /**
   * list 转换成 VO list
   *
   * @param listResp
   * @return
   */
  @Mappings({})
  List<UserEnclosureResumeVO> convertList(List<UserEnclosureResumeRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<UserEnclosureResumeVO> convert(
      TableResultResponse<UserEnclosureResumeRespDTO> tableResultResponse);

  /**
   * 分页对象转换
   *
   * @param pageDTO
   * @return
   */
  @Mappings({})
  UserEnclosureResumePageReqDTO convert(UserEnclosureResumePageDTO pageDTO);

}
