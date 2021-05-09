package com.github.xf717.searchservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import java.util.List;

/**
 * @author momo
 * @date 2021-04-23 10:50
 */
public class EsJacksonUtils {

    private static ObjectMapper objectMapper = null;


    public static <T> List<T> transform(SearchResponse search, Class<T> from) {
        objectMapper = new ObjectMapper();
        assert search != null;
        SearchHit[] hits = search.getHits().getHits();
        List<T> list = Lists.newArrayList();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            T t = transformJson(sourceAsString, from);
            list.add(t);

        }
        return list;
    }

    public static <T> T transformJson(String json, Class<T> clazz) {
        objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
