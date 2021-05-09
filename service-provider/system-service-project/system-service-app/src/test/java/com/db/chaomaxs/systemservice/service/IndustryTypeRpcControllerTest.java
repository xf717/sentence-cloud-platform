package com.db.chaomaxs.systemservice.service;


import com.alibaba.fastjson.JSON;
import com.db.chaomaxs.systemservice.rpc.content.IndustryTypeRpcImpl;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeUpdateReqDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class IndustryTypeRpcControllerTest {

  @Autowired
  private IndustryTypeRpcImpl industryTypeRpc;

  @Test
  public void listIndustryTypes() {
    IndustryTypeListQueryReqDTO industryTypeListQueryReqDTO = new IndustryTypeListQueryReqDTO();

    System.out.println(JSON.toJSON(industryTypeRpc
        .listIndustryTypes(industryTypeListQueryReqDTO)));
  }

  @Test
  public void page() {
  }

  @Test
  public void getDisplayIndustry() {
    IndustryTypeListQueryReqDTO industryTypeListQueryReqDTO = new IndustryTypeListQueryReqDTO();
//    industryTypeListQueryReqDTO.setTypeName("一");

    System.out.println(JSON.toJSON(industryTypeRpc
        .listDisplayIndustry(industryTypeListQueryReqDTO)));

  }


  @Test
  public void getIndustryByNameAndParentId() {
    IndustryTypeRespDTO respDTO = industryTypeRpc
        .getIndustryByNameAndParentId("一", 0L);
    System.out.println(JSON.toJSON(respDTO));
  }

  @Test
  public void save() {
    IndustryTypeCreateReqDTO reqDTO = new IndustryTypeCreateReqDTO();
    reqDTO.setTypeName("三级分类B-1-1");
    reqDTO.setParentId(3L);
    industryTypeRpc.save(reqDTO);
  }

  @Test
  public void update() {
    IndustryTypeUpdateReqDTO reqDTO = new IndustryTypeUpdateReqDTO();
    reqDTO.setTypeName("三级分类B-1-1");
    reqDTO.setParentId(4L);
    reqDTO.setId(6L);
    industryTypeRpc.update(reqDTO);
  }

  @Test
  public void getIndustryByParentId() {
    System.out.println(industryTypeRpc.listIndustryByParentId(1L));
  }

  @Test
  public void delete() {
    System.out.println(industryTypeRpc.remove(1L));
  }
}
