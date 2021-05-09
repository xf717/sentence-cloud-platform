package com.github.xf717.managementweb.manager.dict;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemAddDTO;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemDTO;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemPageDTO;
import com.github.xf717.managementweb.controller.dict.dto.DataDictionaryItemUpdateDTO;
import com.github.xf717.managementweb.controller.dict.vo.DataDictionaryItemVO;
import com.github.xf717.managementweb.convert.dict.DataDictionaryItemConvert;
import com.github.xf717.managementweb.util.PinyinUtil;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.github.xf717.systemservice.rpc.dict.facade.DataDictionaryItemRpcFacade;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * DataDictionaryItemManager
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@Service
@Validated
public class DataDictionaryItemManager {

  @Autowired
  private DataDictionaryItemRpcFacade dataDictionaryItemRpcFacade;

  /**
   * 添加数据
   *
   * @param dataDictionaryItemAddDTO 添加参数
   * @return
   */
  public int save(DataDictionaryItemAddDTO dataDictionaryItemAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = dataDictionaryItemRpcFacade
        .save(DataDictionaryItemConvert.INSTANCE.convert(dataDictionaryItemAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param dataDictionaryItemUpdateDTO 更新参数
   * @return
   */
  public int update(DataDictionaryItemUpdateDTO dataDictionaryItemUpdateDTO) {
    BaseResponse baseResponse = dataDictionaryItemRpcFacade
        .update(DataDictionaryItemConvert.INSTANCE.convert(dataDictionaryItemUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = dataDictionaryItemRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public DataDictionaryItemVO getDataDictionaryItemById(Long id) {
    ObjectRestResponse<DataDictionaryItemRespDTO> objectRestResponse = dataDictionaryItemRpcFacade
        .getDataDictionaryItemById(
            id);
    objectRestResponse.checkError();
    return DataDictionaryItemConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param dataDictionaryItemDTO 查询参数
   * @return
   */
  public List<DataDictionaryItemVO> listDataDictionaryItems(
      DataDictionaryItemDTO dataDictionaryItemDTO) {
    ObjectRestResponse<List<DataDictionaryItemRespDTO>> objectRestResponse = dataDictionaryItemRpcFacade
        .listDataDictionaryItems(
            DataDictionaryItemConvert.INSTANCE.convert(dataDictionaryItemDTO));
    objectRestResponse.checkError();
    return DataDictionaryItemConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<DataDictionaryItemVO> pageDataDictionaryItem(
      DataDictionaryItemPageDTO pageReqDTO) {
    TableResultResponse<DataDictionaryItemRespDTO> tableResultResponse = dataDictionaryItemRpcFacade
        .page(DataDictionaryItemConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return DataDictionaryItemConvert.INSTANCE.convert(tableResultResponse);
  }


  /**
   * 获取汉字拼音首字母并转大写
   *
   * @param name
   * @return
   */
  public ObjectRestResponse getInitials(String name) {
    if (StringUtils.isBlank(name)) {
      return null;
    }
    return new ObjectRestResponse().data(PinyinUtil.getFirstPinYin(name));
  }


}
