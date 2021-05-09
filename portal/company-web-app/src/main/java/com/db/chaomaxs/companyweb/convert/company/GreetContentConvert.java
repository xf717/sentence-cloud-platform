package com.db.chaomaxs.companyweb.convert.company;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.GreetContentUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.GreetContentAddDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.GreetContentDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.GreetContentEnableHideDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.GreetContentPageDTO;
import com.db.chaomaxs.companyweb.controller.company.dto.GreetContentUpdateDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.DictionaryItemVO;
import com.db.chaomaxs.companyweb.controller.company.vo.GreetContentVO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换打招呼语
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Mapper
public interface GreetContentConvert {

  GreetContentConvert INSTANCE = Mappers.getMapper(GreetContentConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  GreetContentCreateReqDTO convert(GreetContentAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  GreetContentUpdateReqDTO convert(GreetContentUpdateDTO updateDTO);

  @Mappings({})
  GreetContentListQueryReqDTO convert(GreetContentDTO greetContentDTO);

  /**
   * BO convert VO
   *
   * @param greetContentRespDTO 转换对象
   * @return
   */
  @Mappings({})
  GreetContentVO convert(GreetContentRespDTO greetContentRespDTO);

  @Mappings({})
  List<GreetContentVO> convertList(List<GreetContentRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<GreetContentVO> convert(
      TableResultResponse<GreetContentRespDTO> tableResultResponse);

  @Mappings({})
  GreetContentPageReqDTO convert(GreetContentPageDTO greetContentPageDTO);

  @Mappings({})
  List<DictionaryItemVO> convertToList(List<DataDictionaryItemRespDTO> list);

  /**
   *
   * @param greetContentEnableHideDTO 转换对象
   * @return
   */
  @Mappings({})
  UserExtendUpdateEnableHideReqDTO convert(GreetContentEnableHideDTO greetContentEnableHideDTO);
}
