package com.db.chaomaxs.companyservice.manager.company;

import com.db.chaomaxs.companyservice.convert.company.CompanyInfoConvert;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyFullNameRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoDetailRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareRespDTO;
import com.db.chaomaxs.companyservice.service.company.CompanyInfoService;
import com.db.chaomaxs.companyservice.service.company.CompanyPhotoService;
import com.db.chaomaxs.companyservice.service.company.CompanyProductService;
import com.db.chaomaxs.companyservice.service.company.CompanyWelfareService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyInfoManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyInfoManager {

  @Autowired
  private CompanyInfoService companyInfoService;

  @Autowired
  private CompanyPhotoService companyPhotoService;

  @Autowired
  private CompanyProductService companyProductService;

  @Autowired
  private CompanyWelfareService companyWelfareService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public Long saveCompanyInfo(CompanyInfoCreateReqDTO createReqDTO) {
    return companyInfoService.saveCompanyInfo(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateCompanyInfo(CompanyInfoUpdateReqDTO updateReqDTO) {
    return companyInfoService.updateCompanyInfo(updateReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyInfoRespDTO getCompanyInfoById(Long id) {
    return companyInfoService.getCompanyInfoById(id);
  }

  public List<CompanyInfoListRespDTO> listCompanyInfoByIds(
      CompanyInfoListReqDTO companyInfoListReqDTO) {
    return companyInfoService.listCompanyInfoByIds(companyInfoListReqDTO);
  }

  public CompanyInfoRespDTO getCompanyInfoByCompanyName(String company) {
    return companyInfoService.getCompanyInfoByCompanyName(company);
  }

  /**
   * 获取公司详细信息
   *
   * @param id
   * @author xiaofeng
   */
  public CompanyInfoDetailRespDTO getCompanyInfoDetail(Long id) {
    CompanyInfoRespDTO companyInfo = companyInfoService.getCompanyInfoById(id);
    List<CompanyWelfareRespDTO> companyWelfareRespDTOList = companyWelfareService
        .listWelfareTypes(id);
    List<CompanyPhotoRespDTO> companyPhotoRespDTOList = companyPhotoService.getByCompanyId(id);
    List<CompanyProductRespDTO> companyProductRespDTOList = companyProductService.listProducts(id);

    CompanyInfoDetailRespDTO companyInfoDetail = CompanyInfoConvert.INSTANCE.convert(companyInfo);
    companyInfoDetail.setCompanyWelfareList(companyWelfareRespDTOList);
    companyInfoDetail.setCompanyPhotoList(companyPhotoRespDTOList);
    companyInfoDetail.setCompanyProductList(companyProductRespDTOList);
    return companyInfoDetail;
  }

  /**
   * 根据公司名称模糊搜索
   * @param company
   * @return
   */
  public List<CompanyFullNameRespDTO> listCompanyName(String company){
    return companyInfoService.listCompanyName(company);
  }


}
