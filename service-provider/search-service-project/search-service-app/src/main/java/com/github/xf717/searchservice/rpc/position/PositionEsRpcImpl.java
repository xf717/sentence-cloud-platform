package com.github.xf717.searchservice.rpc.position;


import com.github.xf717.searchservice.manager.position.PositionEsManager;
import com.github.xf717.searchservice.rpc.position.dto.PositionEsCreateReqDTO;
import com.github.xf717.searchservice.rpc.position.dto.PositionEsQueryReqDTO;
import com.github.xf717.searchservice.rpc.position.dto.PositionEsRespDTO;
import com.github.xf717.searchservice.rpc.position.facade.PositionEsRpcFacade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author momo
 * @date 2021-04-22 13:59
 */
@Service
public class PositionEsRpcImpl implements PositionEsRpcFacade {

  @Autowired
  private PositionEsManager positionEsManager;

  @Override
  public void save(PositionEsCreateReqDTO createReqDTO) {
    positionEsManager.save(createReqDTO);
  }

  @Override
  public void deleteById(Long id) {
    positionEsManager.deleteById(id);
  }


  @Override
  public List<PositionEsRespDTO> searchAll(PositionEsQueryReqDTO queryReqDTO) {
    return positionEsManager.searchAll(queryReqDTO);
  }
}
