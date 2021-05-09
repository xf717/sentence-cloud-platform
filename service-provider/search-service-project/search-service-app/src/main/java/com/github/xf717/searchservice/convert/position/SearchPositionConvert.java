package com.github.xf717.searchservice.convert.position;

import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.searchservice.dal.es.dataobject.position.PositionEsDO;
import com.github.xf717.searchservice.rpc.position.dto.SearchPositionRespDTO;
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
