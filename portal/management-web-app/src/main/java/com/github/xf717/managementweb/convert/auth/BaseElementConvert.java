package com.github.xf717.managementweb.convert.auth;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementAddDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementPageDTO;
import com.github.xf717.managementweb.controller.auth.dto.BaseElementUpdateDTO;
import com.github.xf717.managementweb.controller.auth.vo.BaseElementVO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementUpdateReqDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 应用层实体对象转换
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Mapper
public interface BaseElementConvert {

  BaseElementConvert INSTANCE = Mappers.getMapper(
      BaseElementConvert.class);

  /**
   * AddDTO convert AddBO
   *
   * @param addDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseElementCreateReqDTO convert(BaseElementAddDTO addDTO);

  /**
   * UpdateDTO convert UpdateBO
   *
   * @param updateDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseElementUpdateReqDTO convert(BaseElementUpdateDTO updateDTO);

  @Mappings({})
  BaseElementListQueryReqDTO convert(BaseElementDTO baseElementDTO);

  /**
   * BO convert VO
   *
   * @param baseElementRespDTO 转换对象
   * @return
   */
  @Mappings({})
  BaseElementVO convert(BaseElementRespDTO baseElementRespDTO);

  @Mappings({})
  List<BaseElementVO> convertList(List<BaseElementRespDTO> listResp);

  /**
   * 分页转换
   *
   * @param tableResultResponse 转换对象
   * @return
   */
  @Mappings({})
  TableResultResponse<BaseElementVO> convert(
      TableResultResponse<BaseElementRespDTO> tableResultResponse);

  @Mappings({})
  BaseElementPageReqDTO convert(BaseElementPageDTO baseElementPageDTO);

}
