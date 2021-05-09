package com.github.xf717.searchservice.dal.es.repository.position;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.util.StringUtils;
import com.github.xf717.searchservice.dal.es.dataobject.position.PositionEsDO;
import com.github.xf717.searchservice.rpc.position.dto.SearchPositionPageReqDTO;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 职位ES
 *
 * @author momo, xianfeng
 * @date 2021-04-22 14:37
 */
@Repository
public interface PositionEsRepository extends ElasticsearchRepository<PositionEsDO, Long> {

  /**
   * 搜索分页
   *
   * @param pageReqDTO
   * @return
   */
  default Page<PositionEsDO> search(SearchPositionPageReqDTO pageReqDTO) {

    NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withPageable(
        PageRequest.of(pageReqDTO.getPageNo() - 1, pageReqDTO.getPageSize()));

    if (StringUtils.hasText(pageReqDTO.getSearchKeyWord())) {
      // TODO 属性需要在定义
      FunctionScoreQueryBuilder.FilterFunctionBuilder[] functions = {
          new FunctionScoreQueryBuilder.FilterFunctionBuilder(
              matchQuery("positionName", pageReqDTO.getSearchKeyWord()),
              ScoreFunctionBuilders.weightFactorFunction(10)),
      };

      // TODO 需要考虑score
      FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders
          .functionScoreQuery(functions).scoreMode(
              FunctionScoreQuery.ScoreMode.SUM).setMinScore(2F);
      nativeSearchQueryBuilder.withQuery(functionScoreQueryBuilder);
    } else {
      nativeSearchQueryBuilder.withQuery(QueryBuilders.matchAllQuery());
    }

    // 排序
    if (!CollectionUtils.isEmpty(pageReqDTO.getSorts())) {
      pageReqDTO.getSorts().forEach(sortField -> nativeSearchQueryBuilder
          .withSort(SortBuilders.fieldSort(sortField.getField())
              .order(SortOrder.fromString(sortField.getOrder()))));
    } else if (StringUtils.hasText(pageReqDTO.getSearchKeyWord())) {
      nativeSearchQueryBuilder.withSort(SortBuilders.scoreSort().order(SortOrder.DESC));
    } else {
      nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("sort").order(SortOrder.DESC));
    }
    // 执行查询
    return search(nativeSearchQueryBuilder.build());
  }
}
