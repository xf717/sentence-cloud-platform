package com.github.xf717.searchservice.service.position;

import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.common.framework.util.StringUtils;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.common.framework.vo.SortingField;
import com.github.xf717.searchservice.convert.position.SearchPositionConvert;
import com.github.xf717.searchservice.dal.es.dataobject.position.PositionEsDO;
import com.github.xf717.searchservice.dal.es.repository.position.PositionEsRepository;
import com.github.xf717.searchservice.enums.position.SearchPositionPageQuerySortFieldEnum;
import com.github.xf717.searchservice.rpc.position.dto.SearchPositionPageReqDTO;
import com.github.xf717.searchservice.rpc.position.dto.SearchPositionRespDTO;
import com.github.xf717.searchservice.util.EsJacksonUtils;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * SearchPositionService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/28 16:48
 */
@Service
@Slf4j
public class SearchPositionService {

  @Autowired
  private PositionEsRepository positionEsRepository;

  @Autowired
  private RestHighLevelClient restHighLevelClient;

  public PageResult<SearchPositionRespDTO> pageSearchPosition(
      SearchPositionPageReqDTO pageReqDTO) {
    this.checkSortFieldInvalid(pageReqDTO.getSorts());

    Page<PositionEsDO> searchPage = positionEsRepository.search(pageReqDTO);
    return SearchPositionConvert.INSTANCE.convertPage(searchPage);

  }

  // TODO 还要在优化，里面的搜索条件随便写
  public PageResult<SearchPositionRespDTO> pageSearchPositionHighLevel(
      SearchPositionPageReqDTO pageReqDTO) {
    this.checkSortFieldInvalid(pageReqDTO.getSorts());

    SearchRequest searchRequest = new SearchRequest();
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

    if (StringUtils.hasText(pageReqDTO.getSearchKeyWord())) {
      boolQueryBuilder
          .must(QueryBuilders.matchQuery("positionName", pageReqDTO.getSearchKeyWord()));
    }

    if (!CollectionUtils.isEmpty(pageReqDTO.getKeywordIds())) {
      boolQueryBuilder.must(
          //一次匹配多个值
          QueryBuilders
              .termsQuery("keyWordIds", pageReqDTO.getKeywordIds().stream().toArray(Long[]::new)));
    }

    if (!CollectionUtils.isEmpty(pageReqDTO.getEducationIds())) {
      boolQueryBuilder.must(QueryBuilders
          .termsQuery("educationId", pageReqDTO.getEducationIds().stream().toArray(Long[]::new)));
    }

    if (!CollectionUtils.isEmpty(pageReqDTO.getExperienceIds())) {
      boolQueryBuilder.must(QueryBuilders
          .termsQuery("experienceIds", pageReqDTO.getEducationIds().stream().toArray(Long[]::new)));
    }

    if (!CollectionUtils.isEmpty(pageReqDTO.getIndustryIds())) {
      boolQueryBuilder.must(QueryBuilders
          .termsQuery("industryIds", pageReqDTO.getEducationIds().stream().toArray(Long[]::new)));
    }

    if (!CollectionUtils.isEmpty(pageReqDTO.getEducationIds())) {
      boolQueryBuilder.must(QueryBuilders
          .termsQuery("scopeIds", pageReqDTO.getEducationIds().stream().toArray(Long[]::new)));
    }

    if (!CollectionUtils.isEmpty(pageReqDTO.getEducationIds())) {
      boolQueryBuilder.must(QueryBuilders
          .termsQuery("developmentStageId",
              pageReqDTO.getEducationIds().stream().toArray(Long[]::new)));
    }

    if (pageReqDTO.getSalaryId() != null && pageReqDTO.getSalaryId() > 0) {
      boolQueryBuilder.must(QueryBuilders.matchQuery("salaryId", pageReqDTO.getSalaryId()));
    }

    // TODO
//    {
//      boolQueryBuilder.must(QueryBuilders.termQuery("k"))
//          .mustNot(QueryBuilders.matchPhraseQuery("idCardNo", ""))
//          .filter(QueryBuilders.fuzzyQuery("name", ""))
//          .filter(QueryBuilders.wildcardQuery("name", ""));
//    }
    sourceBuilder.query(boolQueryBuilder);
    // 包含字段和忽略字段
//    sourceBuilder.fetchSource(new String[]{"name", "age"}, new String[]{"id"});

    sourceBuilder.trackTotalHits(true);
    // 分页
    sourceBuilder.from(pageReqDTO.getPageNo());
    sourceBuilder.size(pageReqDTO.getPageSize());
    sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
    // 聚合函数
//    sourceBuilder.aggregation(AggregationBuilders.sum("age"));
    // 排序
    sourceBuilder.sort("positionName", SortOrder.DESC);
    searchRequest.source(sourceBuilder);

    // 查询
    SearchResponse response = null;
    try {
      response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    } catch (IOException e) {
      log.error("职位搜索分页失败：{}", e);
      e.printStackTrace();
    }
    // 处理查询结果
    List<PositionEsDO> positionEsDOList = EsJacksonUtils.transform(response, PositionEsDO.class);
    long total = response.getHits().getTotalHits().value;
    PageResult<SearchPositionRespDTO> pageResult = new PageResult<SearchPositionRespDTO>()
        .setList(SearchPositionConvert.INSTANCE.convertList(positionEsDOList))
        .setTotal(total);
    return pageResult;
  }

  private void checkSortFieldInvalid(List<SortingField> sorts) {
    if (CollectionUtils.isEmpty(sorts)) {
      return;
    }
    sorts.forEach(sortingField -> Assert
        .isTrue(SearchPositionPageQuerySortFieldEnum.contains(sortingField.getField()),
            String.format("排序字段(%s) 不在允许范围内", sortingField.getField())));
  }

}
