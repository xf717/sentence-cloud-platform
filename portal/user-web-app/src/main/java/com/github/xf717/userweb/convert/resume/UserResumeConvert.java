package com.github.xf717.userweb.convert.resume;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumePageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserResumeUpdateReqDTO;
import com.github.xf717.userweb.controller.resume.dto.UserResumeAddDTO;
import com.github.xf717.userweb.controller.resume.dto.UserResumeDTO;
import com.github.xf717.userweb.controller.resume.dto.UserResumePageDTO;
import com.github.xf717.userweb.controller.resume.dto.UserResumeUpdateDTO;
import com.github.xf717.userweb.controller.resume.vo.UserResumeVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_简历
 * @author xiaofeng
 * @date 2021-03-29 13:08:13
 */
@Mapper
public interface UserResumeConvert {

        UserResumeConvert INSTANCE = Mappers.getMapper(UserResumeConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      UserResumeCreateReqDTO convert(UserResumeAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      UserResumeUpdateReqDTO convert(UserResumeUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param userResumeDTO 查询参数对象
   * @return
   */
  @Mappings({})
      UserResumeListQueryReqDTO convert(UserResumeDTO userResumeDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      UserResumeVO convert(UserResumeRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<UserResumeVO> convertList(List<UserResumeRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<UserResumeVO> convert(
      TableResultResponse<UserResumeRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      UserResumePageReqDTO convert(UserResumePageDTO pageDTO);

}
