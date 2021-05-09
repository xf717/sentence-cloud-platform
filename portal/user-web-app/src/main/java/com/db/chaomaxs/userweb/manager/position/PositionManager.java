package com.db.chaomaxs.userweb.manager.position;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableData;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoDetailRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyInfoRpcFacade;
import com.db.chaomaxs.positionservice.enums.position.PositionStatusEnum;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import com.db.chaomaxs.positionservice.rpc.positiontype.facade.PositionKeywordRpcFacade;
import com.db.chaomaxs.searchservice.rpc.position.dto.SearchPositionRespDTO;
import com.db.chaomaxs.searchservice.rpc.position.facade.SearchPositionRpcFacade;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryItemRespDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypeListIdsReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.facade.DataDictionaryItemRpcFacade;
import com.db.chaomaxs.userweb.controller.position.dto.SearchPositionPageReqDTO;
import com.db.chaomaxs.userweb.controller.position.vo.CompanyInfoDetailVO;
import com.db.chaomaxs.userweb.controller.position.vo.CompanyPositionVO;
import com.db.chaomaxs.userweb.controller.position.vo.SearchPositionVO;
import com.db.chaomaxs.userweb.convert.position.CompanyConvert;
import com.db.chaomaxs.userweb.convert.position.PositionConvert;
import com.db.chaomaxs.userweb.service.postition.PositionService;
import com.db.chaomaxs.userweb.service.postition.bo.UserPositionBO;
import com.db.chaomaxs.userweb.service.postition.vo.PositionDetailVO;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionManager
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/28 15:56
 */
@Service
@Validated
public class PositionManager {

  @Autowired
  private SearchPositionRpcFacade searchPositionRpcFacade;

  @Autowired
  private CompanyInfoRpcFacade companyInfoRpcFacade;

  @Autowired
  private CompanyPositionRpcFacade companyPositionRpcFacade;

  @Autowired
  private PositionKeywordRpcFacade positionKeywordRpcFacade;

  @Autowired
  private DataDictionaryItemRpcFacade dataDictionaryItemRpcFacade;

  @Autowired
  private PositionService positionService;


  /**
   * 搜索职位并分页
   *
   * @param positionSearchReq
   * @return
   */
  public TableData<SearchPositionVO> pageSearchPosition(
      SearchPositionPageReqDTO positionSearchReq) {
    TableResultResponse<SearchPositionRespDTO> tableResultResponse = searchPositionRpcFacade
        .pageSearchPosition(PositionConvert.INSTANCE.convert(positionSearchReq));
    tableResultResponse.checkError();
    return PositionConvert.INSTANCE.convert(tableResultResponse.getData());
  }

  /**
   * 根据职id 查看详情
   *
   * @param positionId
   * @return
   */
  public PositionDetailVO getPositionDetail(Long positionId) {
    UserPositionBO userPositionBO = new UserPositionBO();
    userPositionBO.setPositionId(positionId);
    PositionDetailVO positionDetail = positionService.getPositionDetail(userPositionBO);
    return positionDetail;
  }

  /**
   * 获取公司详情
   *
   * @param id
   * @return
   */
  public CompanyInfoDetailVO getCompanyInfoDetailById(Long id) {
    ObjectRestResponse<CompanyInfoDetailRespDTO> objectRestResponse = this.companyInfoRpcFacade
        .getCompanyInfoDetailById(id);
    objectRestResponse.checkError();

    CompanyInfoDetailRespDTO companyInfo = objectRestResponse.getData();

    final List<Long> dicTypeIds = Lists
        .newArrayList(companyInfo.getScopeDictionaryId(),
            companyInfo.getDevelopmentStageDictionaryId(),
            companyInfo.getRestTimeDictionaryId(),
            companyInfo.getWorkOvertimeDictionaryId());

    // 根据字典ids 批量查询字典名称
    DataDictionaryTypeListIdsReqDTO dataDictionaryTypeListIdsReqDTO = new DataDictionaryTypeListIdsReqDTO()
        .setIds(dicTypeIds);
    ObjectRestResponse<List<DataDictionaryItemRespDTO>> listObjectRestResponse = this.dataDictionaryItemRpcFacade
        .listDataDictionaryItemByIds(dataDictionaryTypeListIdsReqDTO);
    listObjectRestResponse.checkError();

    CompanyInfoDetailVO companyInfoDetail = CompanyConvert.INSTANCE
        .convert(objectRestResponse.getData());

    // 将list 转成map
    Map<Long, DataDictionaryItemRespDTO> dictionaryItemRespDtoMap = listObjectRestResponse.getData()
        .stream()
        .collect(Collectors.toMap(DataDictionaryItemRespDTO::getId, a -> a, (k1, k2) -> k2));
    // 发展阶段
    companyInfoDetail.setDevelopmentStageDictionaryName(
        dictionaryItemRespDtoMap.get(companyInfo.getDevelopmentStageDictionaryId()).getDictText());
    // 公司规模
    companyInfoDetail.setScopeDictionaryName(
        dictionaryItemRespDtoMap.get(companyInfo.getScopeDictionaryId()).getDictText());
    // 休息时间
    companyInfoDetail.setRestTimeDictionaryName(
        dictionaryItemRespDtoMap.get(companyInfo.getRestTimeDictionaryId()).getDictText());
    // 加班情况
    companyInfoDetail.setWorkOvertimeDictionaryName(
        dictionaryItemRespDtoMap.get(companyInfo.getWorkOvertimeDictionaryId()).getDictText());
    return companyInfoDetail;
  }

  /**
   * 根据企业用户id查找职位并分页
   *
   * @param companyPositionPage
   * @return
   */
  public TableData<CompanyPositionVO> pageByCompanyUserId(
      com.db.chaomaxs.userweb.controller.position.dto.CompanyPositionPageReqDTO companyPositionPage) {
    CompanyPositionPageReqDTO pageReqDTO = PositionConvert.INSTANCE.convert(companyPositionPage);
    pageReqDTO.setStatus(PositionStatusEnum.AUDIT_PASSED_POSITION.getCode());
    TableResultResponse<CompanyPositionPageRespDTO> tableResultResponse = companyPositionRpcFacade
        .page(pageReqDTO);
    tableResultResponse.checkError();
    return PositionConvert.INSTANCE.convertCompanyPosition(tableResultResponse.getData());
  }
}
