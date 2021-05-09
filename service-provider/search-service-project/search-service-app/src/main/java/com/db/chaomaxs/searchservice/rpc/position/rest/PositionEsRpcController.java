package com.db.chaomaxs.searchservice.rpc.position.rest;


import com.db.chaomaxs.searchservice.rpc.position.PositionEsRpcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.db.chaomaxs.searchservice.rpc.position.dto.PositionEsCreateReqDTO;
import com.db.chaomaxs.searchservice.rpc.position.dto.PositionEsQueryReqDTO;
import com.db.chaomaxs.searchservice.rpc.position.dto.PositionEsRespDTO;
import com.db.chaomaxs.searchservice.rpc.position.facade.api.PositionEsApi;
import java.util.List;

/**
 * @author momo
 * @date 2021-04-22 13:59
 */
@RestController
public class PositionEsRpcController implements PositionEsApi {
    @Autowired
    private PositionEsRpcImpl positionEsRpc;

    @Override
    public void save(@RequestBody PositionEsCreateReqDTO createReqDTO) {
        positionEsRpc.save(createReqDTO);

    }

    @Override
    public void deleteById(@PathVariable("id")Long id) {
        positionEsRpc.deleteById(id);
    }


    @Override
    public List<PositionEsRespDTO> searchAll(PositionEsQueryReqDTO queryReqDTO) {
        return positionEsRpc.searchAll(queryReqDTO);
    }
}
