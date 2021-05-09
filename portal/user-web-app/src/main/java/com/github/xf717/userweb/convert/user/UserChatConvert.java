package com.github.xf717.userweb.convert.user;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserChatCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatListQueryReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatPageReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserChatUpdateReqDTO;
import com.github.xf717.userweb.controller.user.dto.UserChatAddDTO;
import com.github.xf717.userweb.controller.user.dto.UserChatDTO;
import com.github.xf717.userweb.controller.user.dto.UserChatPageDTO;
import com.github.xf717.userweb.controller.user.dto.UserChatUpdateDTO;
import com.github.xf717.userweb.controller.user.vo.UserChatVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_沟通
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Mapper
public interface UserChatConvert {

        UserChatConvert INSTANCE = Mappers.getMapper(UserChatConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      UserChatCreateReqDTO convert(UserChatAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      UserChatUpdateReqDTO convert(UserChatUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param userChatDTO 查询参数对象
   * @return
   */
  @Mappings({})
      UserChatListQueryReqDTO convert(UserChatDTO userChatDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      UserChatVO convert(UserChatRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<UserChatVO> convertList(List<UserChatRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<UserChatVO> convert(
      TableResultResponse<UserChatRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      UserChatPageReqDTO convert(UserChatPageDTO pageDTO);

}
