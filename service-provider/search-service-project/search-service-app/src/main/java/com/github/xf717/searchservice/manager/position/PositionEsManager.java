package com.github.xf717.searchservice.manager.position;


import com.github.xf717.searchservice.service.position.PositionEsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.xf717.searchservice.rpc.position.dto.PositionEsCreateReqDTO;
import com.github.xf717.searchservice.rpc.position.dto.PositionEsQueryReqDTO;
import com.github.xf717.searchservice.rpc.position.dto.PositionEsRespDTO;

/**
 * @author momo
 * @date 2021-04-22 14:19
 */
@Service
public class PositionEsManager {

  @Autowired
  private PositionEsService positionEsService;

  public void save(PositionEsCreateReqDTO createReqDTO) {
    positionEsService.save(createReqDTO);
  }

  public void deleteById(Long id) {
    positionEsService.deleteById(id);
  }

  public List<PositionEsRespDTO> searchAll(PositionEsQueryReqDTO queryReqDTO) {
    return positionEsService.searchAll(queryReqDTO);
  }
}
