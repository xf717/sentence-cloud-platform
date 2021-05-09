package com.github.xf717.systemservice.convert.notice;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.notice.NoticeInformationExtendDO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendCreateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendRespDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationExtendUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * NoticeInformationExtendConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Mapper
public interface NoticeInformationExtendConvert {

        NoticeInformationExtendConvert INSTANCE = Mappers.getMapper(NoticeInformationExtendConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      NoticeInformationExtendDO convert(NoticeInformationExtendCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      NoticeInformationExtendDO convert(NoticeInformationExtendUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<NoticeInformationExtendRespDTO> convertList(List<NoticeInformationExtendDO> list);

  /**
   * 对象转换
   *
   * @param noticeInformationExtendDO
   * @return
   */
      NoticeInformationExtendRespDTO convert(NoticeInformationExtendDO noticeInformationExtendDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<NoticeInformationExtendRespDTO> convertPage(IPage<NoticeInformationExtendDO> page);


}
