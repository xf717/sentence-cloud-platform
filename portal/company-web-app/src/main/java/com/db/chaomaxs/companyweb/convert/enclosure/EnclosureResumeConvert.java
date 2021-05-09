package com.db.chaomaxs.companyweb.convert.enclosure;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumePageReqDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeRespDTO;
import com.db.chaomaxs.companyservice.rpc.enclosure.dto.EnclosureResumeUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumeAddDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumeDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumePageDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.dto.EnclosureResumeUpdateDTO;
import com.db.chaomaxs.companyweb.controller.enclosure.vo.EnclosureResumeVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换企业附件简历
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface EnclosureResumeConvert {

  EnclosureResumeConvert INSTANCE = Mappers.getMapper(EnclosureResumeConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  EnclosureResumeCreateReqDTO convert(EnclosureResumeAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  EnclosureResumeUpdateReqDTO convert(EnclosureResumeUpdateDTO updateDTO);

  @Mappings({})
  EnclosureResumeListQueryReqDTO convert(EnclosureResumeDTO enclosureResumeDTO);

  /**
   * BO convert VO
   *
   * @param enclosureResumeRespDTO 转换对象
   * @return
   */
  @Mappings({})
  EnclosureResumeVO convert(EnclosureResumeRespDTO enclosureResumeRespDTO);

  @Mappings({})
  List<EnclosureResumeVO> convertList(List<EnclosureResumeRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<EnclosureResumeVO> convert(
      TableResultResponse<EnclosureResumeRespDTO> tableResultResponse);

  @Mappings({})
  EnclosureResumePageReqDTO convert(EnclosureResumePageDTO enclosureResumePageDTO);

}
