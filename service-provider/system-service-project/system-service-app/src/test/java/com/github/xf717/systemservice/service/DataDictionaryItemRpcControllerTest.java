package com.github.xf717.systemservice.service;


import com.alibaba.fastjson.JSON;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.dict.DataDictionaryItemRpcImpl;
import com.github.xf717.systemservice.rpc.dict.DataDictionaryTypeRpcImpl;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemCreateReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemPageReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemQueryReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypePageReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeRespDTO;
import java.util.Arrays;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@SpringBootTest
@RunWith(SpringRunner.class)
//@WebMvcTest(DataDictionaryItemRpcController.class)
public class DataDictionaryItemRpcControllerTest {
  @Autowired
  DataDictionaryItemRpcImpl dataDictionaryItemRpc;
  @MockBean
  DataDictionaryTypeRpcImpl dataDictionaryTypeRpc;

//  @Autowired
//  private MockMvc mockMvc;



  @Test
  public void save() throws Exception {
    DataDictionaryItemCreateReqDTO createReqDTO = new DataDictionaryItemCreateReqDTO();
    createReqDTO.setDictionaryTypeId(1L);
    createReqDTO.setDictText("一般");
    createReqDTO.setDictValue("YB");
    createReqDTO.setSort(2);
    createReqDTO.setEnabled(1);
    dataDictionaryItemRpc.save(createReqDTO);
//    when( dataDictionaryItemRpc.save(createReqDTO)).thenReturn(BaseResponse.success("保存成功"));

//    mockMvc.perform(post("/facade/dataDictionaryItem/save").contentType("application/json")
//        .content(JSONObject.toJSONString(createReqDTO)))
//        .andExpect(content().string("true"));
  }
  @Test
  public void itemPage(){
    DataDictionaryItemPageReqDTO page = new DataDictionaryItemPageReqDTO();
    page.setDictionaryTypeId(1L);
//    page.setKey("s");
    page.setPageNo(1);
    page.setPageSize(10);
    TableResultResponse<DataDictionaryItemRespDTO> response = dataDictionaryItemRpc.page(page);
    System.out.println(JSON.toJSON(response));
  }


  @Test
  public void typePage(){
    DataDictionaryTypePageReqDTO page = new DataDictionaryTypePageReqDTO();
    page.setKey("s");
    page.setPageNo(1);
    page.setPageSize(10);
    TableResultResponse<DataDictionaryTypeRespDTO> response = dataDictionaryTypeRpc.page(page);
    System.out.println(JSON.toJSON(response));
  }
  @Test
  public void testGetItem(){
    DataDictionaryItemQueryReqDTO queryReqDTO = new DataDictionaryItemQueryReqDTO();
    queryReqDTO.setCodes(Arrays.asList("10001","10002"));
//    queryReqDTO.setCodes(Arrays.asList("10011","10012"));
    ObjectRestResponse dictItem = dataDictionaryItemRpc.getDictItem(queryReqDTO);
    System.out.println("dictItem:" + JSON.toJSON(dictItem));
  }




}
