package com.db.chaomaxs.companyweb.convert.recommend;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumePageReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeRespDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeUpdateReqDTO;
import com.db.chaomaxs.companyweb.controller.recommend.dto.RecommendResumeAddDTO;
import com.db.chaomaxs.companyweb.controller.recommend.dto.RecommendResumeDTO;
import com.db.chaomaxs.companyweb.controller.recommend.dto.RecommendResumePageDTO;
import com.db.chaomaxs.companyweb.controller.recommend.dto.RecommendResumeUpdateDTO;
import com.db.chaomaxs.companyweb.controller.recommend.vo.RecommendResumeVO;


/**
 * 应用层实体对象转换推荐人才简历
 * @author xiaofeng
 * @date 2021-03-29 17:09:31
 */
@Mapper
public interface RecommendResumeConvert {

        RecommendResumeConvert INSTANCE = Mappers.getMapper(RecommendResumeConvert.class);

  /**
* AddDTO convert AddBO
*
* @param addDTO 转换对象
* @return
*/
  @Mappings({})
      RecommendResumeCreateReqDTO convert(RecommendResumeAddDTO addDTO);

  /**
* UpdateDTO convert UpdateBO
*
* @param updateDTO 转换对象
* @return
*/
  @Mappings({})
      RecommendResumeUpdateReqDTO convert(RecommendResumeUpdateDTO updateDTO);

  /**
   *  对象转换
   * @param recommendResumeDTO 查询参数对象
   * @return
   */
  @Mappings({})
      RecommendResumeListQueryReqDTO convert(RecommendResumeDTO recommendResumeDTO);

  /**
   *  对象转成VO
   *
   * @param respDTO 转换对象
   * @return
   */
  @Mappings({})
      RecommendResumeVO convert(RecommendResumeRespDTO respDTO);

  /**
  * list 转换成 VO list
* @param listResp
* @return
*/
  @Mappings({})
  List<RecommendResumeVO> convertList(List<RecommendResumeRespDTO> listResp);

  /**
* 分页转换
*
* @param tableResultResponse 转换对象
* @return
*/
  @Mappings({})
  TableResultResponse<RecommendResumeVO> convert(
      TableResultResponse<RecommendResumeRespDTO> tableResultResponse);

  /**
  *  分页对象转换
* @param pageDTO
* @return
*/
  @Mappings({})
      RecommendResumePageReqDTO convert(RecommendResumePageDTO pageDTO);

}
