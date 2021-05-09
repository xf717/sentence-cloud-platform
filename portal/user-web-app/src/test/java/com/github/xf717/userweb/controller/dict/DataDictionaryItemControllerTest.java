//package com.github.xf717.userweb.controller.dict;
//
//
//import com.alibaba.fastjson.JSON;
//import com.github.xf717.common.framework.msg.ObjectRestResponse;
//import com.github.xf717.userweb.controller.dict.dto.DataDictionaryItemQueryDTO;
//import com.github.xf717.userweb.manager.dict.DataDictionaryItemManager;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@Ignore
//public class DataDictionaryItemControllerTest {
//
//  @Autowired
//  private DataDictionaryItemManager dataDictionaryItemManager;
//
//  @Test
//  public void getDictItem() {
//    DataDictionaryItemQueryDTO queryRespDTO = new DataDictionaryItemQueryDTO();
//    List<String> list = new ArrayList<>();
//    list.add("10001");
//    list.add("10002");
//    queryRespDTO.setCodes(list);
//    ObjectRestResponse dictItem = dataDictionaryItemManager.getDictItem(queryRespDTO);
//    System.out.println("list::" + JSON.toJSON(dictItem));
//  }
//}
