package com.db.chaomaxs.searchservice.service.position;

import com.db.chaomaxs.searchservice.convert.position.PositionConvert;
import com.db.chaomaxs.searchservice.dal.es.dataobject.position.PositionEsDO;
import com.db.chaomaxs.searchservice.dal.es.repository.position.PositionEsRepository;
import com.db.chaomaxs.searchservice.util.EsJacksonUtils;
import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.chaomaxs.searchservice.rpc.position.dto.PositionEsCreateReqDTO;
import com.db.chaomaxs.searchservice.rpc.position.dto.PositionEsQueryReqDTO;
import com.db.chaomaxs.searchservice.rpc.position.dto.PositionEsRespDTO;

/**
 * @author momo
 * @date 2021-04-22 14:40
 */
@Service
public class PositionEsService {

  @Autowired
  private PositionEsRepository positionEsRepository;

  @Autowired
  private RestHighLevelClient restHighLevelClient;


  public void save(PositionEsCreateReqDTO createReqDTO) {
    PositionEsDO positionEsDO = PositionConvert.INSTANCE.convert(createReqDTO);
    positionEsRepository.save(positionEsDO);
    positionEsRepository.findAll();
  }

  public void deleteById(Long id) {
    positionEsRepository.deleteById(id);
  }


  /**
   * 构造查询
   *
   * @param queryReqDTO
   * @return
   */
  public List<PositionEsRespDTO> searchAll(PositionEsQueryReqDTO queryReqDTO) {
    SearchRequest searchRequest = new SearchRequest("position_index");
    SearchSourceBuilder builder = new SearchSourceBuilder();
    BoolQueryBuilder boolQueryBuilder = queryBuilder(queryReqDTO);
    builder.query(boolQueryBuilder);
    searchRequest.source(builder);
    SearchResponse search = null;
    try {
      search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    } catch (IOException e) {
      e.printStackTrace();
    }
    List<PositionEsDO> positionEsDOList = EsJacksonUtils.transform(search, PositionEsDO.class);
    return PositionConvert.INSTANCE.convertList(positionEsDOList);
  }


  /**
   * 构造查询条件
   *
   * @param queryReqDTO
   * @return
   */
  private BoolQueryBuilder queryBuilder(PositionEsQueryReqDTO queryReqDTO) {
    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
    if (StringUtils.isNotBlank(queryReqDTO.getProvinceCode())) {
      boolQueryBuilder
          .filter(QueryBuilders.termQuery("provinceCode.keyword", queryReqDTO.getCityCode()));
    }
    if (StringUtils.isNotBlank(queryReqDTO.getCityCode())) {
      boolQueryBuilder
          .filter(QueryBuilders.termQuery("cityCode.keyword", queryReqDTO.getCityCode()));
    }
    if (queryReqDTO.getStartSalary() != null && queryReqDTO.getStartSalary() != -1) {
      boolQueryBuilder
          .filter(QueryBuilders.rangeQuery("startSalary").gte(queryReqDTO.getStartSalary()));
    }
    if (queryReqDTO.getEndSalary() != null && queryReqDTO.getEndSalary() != -1) {
      boolQueryBuilder
          .filter(QueryBuilders.rangeQuery("endSalary").lte(queryReqDTO.getStartSalary()));
    }
    if (StringUtils.isNotBlank(queryReqDTO.getPositionName())) {
      boolQueryBuilder
          .filter(QueryBuilders.matchQuery("positionName", queryReqDTO.getPositionName()));
    }
    if (StringUtils.isNotBlank(queryReqDTO.getKeyword())) {
      boolQueryBuilder
          .filter(QueryBuilders.multiMatchQuery(queryReqDTO.getKeyword(), "positionName"));
    }
    return boolQueryBuilder;
  }
}
