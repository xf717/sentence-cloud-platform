package com.db.chaomaxs.positionservice.rpc.positiontype.rest;


import com.alibaba.fastjson.JSON;
import com.db.chaomaxs.positionservice.rpc.positiontype.PositionTypeRpcImpl;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeUpdateReqDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PositionTypeRpcControllerTest {
  @Autowired
  private PositionTypeRpcImpl positionTypeRpc;


  @Test
  void save() {
    PositionTypeCreateReqDTO createReqDTO = new PositionTypeCreateReqDTO();
    createReqDTO.setTypeName("四级C-1-1-1");
    createReqDTO.setSortOrder(1);
    createReqDTO.setParentId(10L);
    positionTypeRpc.save(createReqDTO);
  }

  @Test
  void update() {
    PositionTypeUpdateReqDTO updateReqDTO = new PositionTypeUpdateReqDTO();
    updateReqDTO.setTypeName("三级c");
    updateReqDTO.setDisplayStatus(1);
    updateReqDTO.setId(8L);
    updateReqDTO.setParentId(4L);
    positionTypeRpc.update(updateReqDTO);
  }

  @Test
  void remove() {
    positionTypeRpc.remove(8L);
  }

  @Test
  public void getPositionTypeById() {
    System.out.println(JSON.toJSON(positionTypeRpc.getPositionTypeById(3L)));
  }

  @Test
  void listPositionTypes() {
    PositionTypeListQueryReqDTO queryReqDTO = new PositionTypeListQueryReqDTO();
    queryReqDTO.setTypeName("c");
    System.out.println(JSON.toJSON(positionTypeRpc.listPositionTypes(queryReqDTO)));
  }

  @Test
  void page() {
  }

  @Test
  void listDisplayPositionType() {
    PositionTypeListQueryReqDTO queryReqDTO = new PositionTypeListQueryReqDTO();
    queryReqDTO.setTypeName("二");
    System.out.println(JSON.toJSON(positionTypeRpc.listDisplayPositionType(queryReqDTO)));
  }

  @Test
  void listPositionTypeByParentId() {
    System.out.println(JSON.toJSON(positionTypeRpc.listPositionTypeByParentId(3L)));
  }
}