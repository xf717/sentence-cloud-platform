package com.db.chaomaxs.searchservice.convert.position;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.searchservice.dal.es.dataobject.position.PositionEsDO;
import com.db.chaomaxs.searchservice.rpc.position.dto.SearchPositionRespDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

/**
 * 搜索职位Convert
 *
 * @author xiaofeng
 */
@Mapper
public interface SearchPositionConvert {

  SearchPositionConvert INSTANCE = Mappers.getMapper(SearchPositionConvert.class);

  /**
   * list 转换
   *
   * @param list
   * @return
   */
  List<SearchPositionRespDTO> convertList(List<PositionEsDO> list);


  default PageResult<SearchPositionRespDTO> convertPage(Page<PositionEsDO> page) {
    return new PageResult<SearchPositionRespDTO>().setList(convertList(page.getContent()))
        .setTotal(page.getTotalElements());
  }

}
