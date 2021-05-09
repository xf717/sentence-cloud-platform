package com.github.xf717.searchservice.rpc.position.facade.api;

import com.github.xf717.searchservice.rpc.position.dto.PositionEsCreateReqDTO;
import com.github.xf717.searchservice.rpc.position.dto.PositionEsQueryReqDTO;
import com.github.xf717.searchservice.rpc.position.dto.PositionEsRespDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author momo
 * @date 2021-04-22 14:04
 */
public interface PositionEsApi {

  @PostMapping("/facade/position/es/save")
  public void save(@RequestBody PositionEsCreateReqDTO createReqDTO);

  @DeleteMapping("/facade/position/es/remove/{id}")
  public void deleteById(@PathVariable("id") Long id);

  @PostMapping("/facade/position/es/all")
  public List<PositionEsRespDTO> searchAll(@RequestBody PositionEsQueryReqDTO queryReqDTO);

}
