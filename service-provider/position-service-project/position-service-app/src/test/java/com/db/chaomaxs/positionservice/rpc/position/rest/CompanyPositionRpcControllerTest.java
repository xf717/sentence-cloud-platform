package com.db.chaomaxs.positionservice.rpc.position.rest;

import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionAuditReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionHandoverReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.IdsReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import com.google.common.collect.Sets;
import java.math.BigDecimal;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author momo
 * @date 2021-04-14 18:06
 */
@Ignore
public class CompanyPositionRpcControllerTest extends MySpringBootTest {

    @Autowired
    private CompanyPositionRpcFacade companyPositionRpcFacade;

    @Test
    public void testSave() {
        CompanyPositionCreateReqDTO companyPositionCreateReqDTO = new CompanyPositionCreateReqDTO();
        companyPositionCreateReqDTO.setCompanyUserId(1L);
        companyPositionCreateReqDTO.setPositionTypeId(1L);
        companyPositionCreateReqDTO.setPositionName("YY1123");
        companyPositionCreateReqDTO.setExperienceId(1L);
        companyPositionCreateReqDTO.setExperience("3-5");
        companyPositionCreateReqDTO.setEducationId(1L);
        companyPositionCreateReqDTO.setEducation("本科233");
        companyPositionCreateReqDTO.setStartSalary(12);
        companyPositionCreateReqDTO.setEndSalary(20);
        companyPositionCreateReqDTO.setContent("asdd1233");
        companyPositionCreateReqDTO.setAddress("福建省厦门市思明区观日路34号楼之一304");
        companyPositionCreateReqDTO.setProvinceCode("1001");
        companyPositionCreateReqDTO.setCityCode("1001");
        companyPositionCreateReqDTO.setAreaCode("1001");
        companyPositionCreateReqDTO.setStreet("aa");
        companyPositionCreateReqDTO.setMapAddress("");
        companyPositionCreateReqDTO.setLatitude(new BigDecimal(0));
        companyPositionCreateReqDTO.setLongitude(new BigDecimal(0));
        companyPositionCreateReqDTO.setBusinessDistrict("");
        companyPositionCreateReqDTO.setKeywordIds(Sets.newHashSet(4L,5L));
        companyPositionRpcFacade.save(companyPositionCreateReqDTO);
    }

    @Test
    public void testUpdate() {
        CompanyPositionUpdateReqDTO companyPositionCreateReqDTO = new CompanyPositionUpdateReqDTO();
        companyPositionCreateReqDTO.setId(28L);
        companyPositionCreateReqDTO.setCompanyUserId(1L);
        companyPositionCreateReqDTO.setPositionTypeId(1L);
        companyPositionCreateReqDTO.setPositionName("JAVA-23333");
        companyPositionCreateReqDTO.setExperienceId(1L);
        companyPositionCreateReqDTO.setExperience("3-5");
        companyPositionCreateReqDTO.setEducationId(1L);
        companyPositionCreateReqDTO.setEducation("本科11");
        companyPositionCreateReqDTO.setStartSalary(12);
        companyPositionCreateReqDTO.setEndSalary(20);
        companyPositionCreateReqDTO.setContent("反清复明");
        companyPositionCreateReqDTO.setAddress("福建省厦门市思明区观日路34号楼之一304");
        companyPositionCreateReqDTO.setProvinceCode("1001");
        companyPositionCreateReqDTO.setCityCode("1001");
        companyPositionCreateReqDTO.setAreaCode("1001");
        companyPositionCreateReqDTO.setStreet("aa344");
        companyPositionCreateReqDTO.setMapAddress("");
        companyPositionCreateReqDTO.setLatitude(new BigDecimal(0));
        companyPositionCreateReqDTO.setLongitude(new BigDecimal(0));
        companyPositionCreateReqDTO.setBusinessDistrict("");
        companyPositionCreateReqDTO.setKeywordIds(Sets.newHashSet(00L,11L));
        companyPositionRpcFacade.update(companyPositionCreateReqDTO);
    }

    @Test
    public void testRemove() {
        companyPositionRpcFacade.remove(28L);
    }
    @Test
    public void testGetCompanyPositionById() {
        companyPositionRpcFacade.getCompanyPositionById(28L);
    }
    @Test
    public void testPage() {
        CompanyPositionPageReqDTO pageReqDTO=new CompanyPositionPageReqDTO();
        pageReqDTO.setCompanyUserId(1L);
        pageReqDTO.setPageNo(1);
        pageReqDTO.setPageSize(10);
        companyPositionRpcFacade.page(pageReqDTO);
    }
    @Test
    public void testList() {
        IdsReqDTO idsReqDTO=new IdsReqDTO();
        idsReqDTO.setIds(Sets.newHashSet(29L));
        companyPositionRpcFacade.getCompanyPositionsByIds(idsReqDTO);
    }

    @Test
    public void updateCompanyPositionState() {
        CompanyPositionAuditReqDTO companyPositionAuditReqDTO=new CompanyPositionAuditReqDTO();
        companyPositionAuditReqDTO.setId(1L);
        companyPositionAuditReqDTO.setStatus(2);
        companyPositionAuditReqDTO.setReason("审核不通过");
        companyPositionAuditReqDTO.setAuditUserId(22L);
        companyPositionRpcFacade.updateCompanyPositionStatus(companyPositionAuditReqDTO);
    }


    @Test
    public void testManagementPage() {
        CompanyPositionPageReqDTO pageReqDTO=new CompanyPositionPageReqDTO();
//        pageReqDTO.setCompanyUserId(1L);
        pageReqDTO.setPageNo(1);
        pageReqDTO.setPageSize(10);
        companyPositionRpcFacade.managementPage(pageReqDTO);
    }

    @Test
    public void handover() {
        CompanyPositionHandoverReqDTO companyPositionHandoverReqDTO = new CompanyPositionHandoverReqDTO();
        companyPositionHandoverReqDTO.setUserId(1L);
        companyPositionHandoverReqDTO.setHandoverUserId(2L);
        companyPositionRpcFacade.handover(companyPositionHandoverReqDTO);
    }
}