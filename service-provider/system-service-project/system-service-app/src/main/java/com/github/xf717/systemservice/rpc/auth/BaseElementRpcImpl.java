package com.github.xf717.systemservice.rpc.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.auth.BaseElementManager;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseElementUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseElementRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseElementRpcImpl implements BaseElementRpcFacade {

  @Autowired
  private BaseElementManager baseElementManager;

  @Override
  public BaseResponse save(BaseElementCreateReqDTO baseElementCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    baseElementManager.saveBaseElement(baseElementCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(BaseElementUpdateReqDTO baseElementUpdateReqDTO) {
    baseElementManager.updateBaseElement(baseElementUpdateReqDTO);
    return BaseResponse.success("修改成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    baseElementManager.deleteBaseElement(id);
    return BaseResponse.success("保存成功");
  }

  @Override
  public ObjectRestResponse<BaseElementRespDTO> getBaseElementById(Long id) {
    BaseElementRespDTO elementRespDTO = baseElementManager.getBaseElementById(id);
    return new ObjectRestResponse<>().data(elementRespDTO);
  }

  @Override
  public ObjectRestResponse<List<BaseElementRespDTO>> listBaseElements(
      BaseElementListQueryReqDTO listQuery) {
    List<BaseElementRespDTO> list = baseElementManager.listBaseElements(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<BaseElementRespDTO> page(BaseElementPageReqDTO pageReqDTO) {
    PageResult<BaseElementRespDTO> pageResult = baseElementManager.pageBaseElement(pageReqDTO);
    TableResultResponse<BaseElementRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public ObjectRestResponse<List<BaseElementRespDTO>> getAuthorityMenuElementByUserId(Long userId,
      Long menuId) {
    List<BaseElementRespDTO> list = baseElementManager
        .getAuthorityMenuElementByUserId(userId, menuId);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public ObjectRestResponse<List<BaseElementRespDTO>> getAuthorityElementByUserId(Long userId) {
    List<BaseElementRespDTO> list = baseElementManager.getAuthorityElementByUserId(userId);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public ObjectRestResponse<List<BaseElementRespDTO>> getAllElementPermissions() {
    List<BaseElementRespDTO> list = baseElementManager.getAllElementPermissions();
    return new ObjectRestResponse<>().data(list);
  }

}
