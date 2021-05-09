package com.db.chaomaxs.userweb.convert.resume;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialListQueryReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialPageReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserCredentialUpdateReqDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserCredentialAddDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserCredentialDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserCredentialPageDTO;
import com.db.chaomaxs.userweb.controller.resume.dto.UserCredentialUpdateDTO;
import com.db.chaomaxs.userweb.controller.resume.vo.UserCredentialVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * 应用层实体对象转换用户_资格证书表
 * @author xiaofeng
 * @date 2021-03-29 13:08:14
 */
@Mapper
public interface UserCredentialConvert {

        UserCredentialConvert INSTANCE = Mappers.getMapper(UserCredentialConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      UserCredentialCreateReqDTO convert(UserCredentialAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      UserCredentialUpdateReqDTO convert(UserCredentialUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param userCredentialDTO 查询参数对象
   * @return
   */
  @Mappings({})
      UserCredentialListQueryReqDTO convert(UserCredentialDTO userCredentialDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      UserCredentialVO convert(UserCredentialRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<UserCredentialVO> convertList(List<UserCredentialRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<UserCredentialVO> convert(
      TableResultResponse<UserCredentialRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      UserCredentialPageReqDTO convert(UserCredentialPageDTO pageDTO);

}
