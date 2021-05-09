package com.github.xf717.systemservice.convert.notice;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.dal.mysql.dataobject.notice.NoticeInformationDO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationCreateReqDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationRespDTO;
import com.github.xf717.systemservice.rpc.notice.dto.NoticeInformationUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * NoticeInformationConvert
 *
 * @author xiaofeng
 * @date 2021-03-29 18:09:32
 */
@Mapper
public interface NoticeInformationConvert {

        NoticeInformationConvert INSTANCE = Mappers.getMapper(NoticeInformationConvert.class);

  /**
   *  createReq 转换
   *
   * @param createReqDTO
   * @return
   */
      NoticeInformationDO convert(NoticeInformationCreateReqDTO createReqDTO);

  /**
   * updateReq 转换
   *
   * @param updateReqDTO
   * @return
   */
      NoticeInformationDO convert(NoticeInformationUpdateReqDTO updateReqDTO);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<NoticeInformationRespDTO> convertList(List<NoticeInformationDO> list);

  /**
   * 对象转换
   *
   * @param noticeInformationDO
   * @return
   */
      NoticeInformationRespDTO convert(NoticeInformationDO noticeInformationDO);

  /**
   * 分布转换对象
   *
   * @param page
   * @return
   */
  @Mapping(source = "records", target = "list")
  PageResult<NoticeInformationRespDTO> convertPage(IPage<NoticeInformationDO> page);


}
