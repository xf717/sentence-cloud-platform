package com.github.xf717.managementweb.convert.notice;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendListQueryReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendPageReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendUpdateReqDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationExtendAddDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationExtendDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationExtendPageDTO;
import com.github.xf717.managementweb.controller.notice.dto.NoticeInformationExtendUpdateDTO;
import com.github.xf717.managementweb.controller.notice.vo.NoticeInformationExtendVO;


/**
 * 应用层实体对象转换内容管理通知信息_扩展信息表
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Mapper
public interface NoticeInformationExtendConvert {

        NoticeInformationExtendConvert INSTANCE = Mappers.getMapper(NoticeInformationExtendConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      NoticeInformationExtendCreateReqDTO convert(NoticeInformationExtendAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      NoticeInformationExtendUpdateReqDTO convert(NoticeInformationExtendUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param noticeInformationExtendDTO 查询参数对象
   * @return
   */
  @Mappings({})
      NoticeInformationExtendListQueryReqDTO convert(
      NoticeInformationExtendDTO noticeInformationExtendDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      NoticeInformationExtendVO convert(NoticeInformationExtendRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<NoticeInformationExtendVO> convertList(List<NoticeInformationExtendRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<NoticeInformationExtendVO> convert(
      TableResultResponse<NoticeInformationExtendRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      NoticeInformationExtendPageReqDTO convert(NoticeInformationExtendPageDTO pageDTO);

}
