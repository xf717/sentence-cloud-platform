package com.github.xf717.managementweb.convert.notice;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationCreateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationListQueryReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationPageReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationRespDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationUpdateReqDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationAddDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationPageDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationUpdateDTO;
import com.github.xf717.managementweb.controller.notice.vo.NoticeInformationVO;


/**
 * 应用层实体对象转换通知信息表
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Mapper
public interface NoticeInformationConvert {

        NoticeInformationConvert INSTANCE = Mappers.getMapper(NoticeInformationConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      NoticeInformationCreateReqDTO convert(NoticeInformationAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      NoticeInformationUpdateReqDTO convert(NoticeInformationUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param noticeInformationDTO 查询参数对象
   * @return
   */
  @Mappings({})
      NoticeInformationListQueryReqDTO convert(NoticeInformationDTO noticeInformationDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      NoticeInformationVO convert(NoticeInformationRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<NoticeInformationVO> convertList(List<NoticeInformationRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<NoticeInformationVO> convert(
      TableResultResponse<NoticeInformationRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      NoticeInformationPageReqDTO convert(NoticeInformationPageDTO pageDTO);

}
