package com.github.xf717.systemservice.rpc.content;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.content.ReleasePlatformManager;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformCreateReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformListQueryReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformPageReqDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformRespDTO;
import com.github.xf717.systemservice.rpc.content.dto.ReleasePlatformUpdateReqDTO;
import com.github.xf717.systemservice.rpc.content.facade.ReleasePlatformRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Slf4j
@Service
public class ReleasePlatformRpcImpl implements ReleasePlatformRpcFacade {

  @Autowired
  private ReleasePlatformManager releasePlatformManager;

  @Override
  public BaseResponse save(ReleasePlatformCreateReqDTO createReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    releasePlatformManager.saveReleasePlatform(createReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(ReleasePlatformUpdateReqDTO updateReqDTO) {
      releasePlatformManager.updateReleasePlatform(updateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
      releasePlatformManager.deleteReleasePlatform(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<ReleasePlatformRespDTO> getReleasePlatformById(Long id) {
      ReleasePlatformRespDTO releasePlatform = releasePlatformManager.getReleasePlatformById(id);
    return new ObjectRestResponse<>().data(releasePlatform);
  }

  @Override
  public ObjectRestResponse<List<ReleasePlatformRespDTO>> listReleasePlatforms(ReleasePlatformListQueryReqDTO listQuery) {
    List<ReleasePlatformRespDTO> list = releasePlatformManager.listReleasePlatforms(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<ReleasePlatformRespDTO> page(ReleasePlatformPageReqDTO pageReqDTO) {
    PageResult<ReleasePlatformRespDTO> pageResult = releasePlatformManager.pageReleasePlatform(pageReqDTO);
    TableResultResponse<ReleasePlatformRespDTO> tableResultResponse = new TableResultResponse(pageResult.getTotal(),pageResult.getList());
    return tableResultResponse;
  }

}
