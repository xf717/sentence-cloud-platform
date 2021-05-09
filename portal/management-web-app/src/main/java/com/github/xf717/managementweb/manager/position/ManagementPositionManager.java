package com.github.xf717.managementweb.manager.position;

import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.util.CollectionUtils;
import com.github.xf717.managementweb.controller.position.dto.ManagementPositionAuditDTO;
import com.github.xf717.managementweb.controller.position.dto.ManagementPositionPageDTO;
import com.github.xf717.managementweb.controller.position.dto.ManagementPositionUpdateDTO;
import com.github.xf717.managementweb.controller.position.vo.ManagementPositionPageVO;
import com.github.xf717.managementweb.controller.position.vo.ManagementPositionVO;
import com.github.xf717.managementweb.convert.position.ManagementPositionConvert;
import com.github.xf717.managementweb.service.compnay.CompanyService;
import com.github.xf717.managementweb.service.dictionary.DictionaryService;
import com.github.xf717.managementweb.service.user.UserService;
import com.github.xf717.positionservice.rpc.position.dto.CompanyPositionAuditReqDTO;
import com.github.xf717.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.github.xf717.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;
import com.github.xf717.positionservice.rpc.position.dto.ManagementPositionPageRespDTO;
import com.github.xf717.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import com.github.xf717.userservice.rpc.user.dto.UserExtendDetailRespDTO;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Map;
import java.util.Set;

/**
 * CompanyPositionManager
 *
 * @author momo
 * @date 2021-03-29 16:36:57
 */
@Service
@Validated
public class ManagementPositionManager {

    @Autowired
    private CompanyPositionRpcFacade companyPositionRpcFacade;

    @Autowired
    private UserService userService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private CompanyService companyService;

    /**
     * 更新数据
     *
     * @param companyPositionUpdateDTO 更新参数
     * @return
     */
    public int update(ManagementPositionUpdateDTO companyPositionUpdateDTO) {
        CompanyPositionUpdateReqDTO companyPositionUpdateReqDTO = ManagementPositionConvert.INSTANCE.convert(companyPositionUpdateDTO);
        companyPositionUpdateReqDTO.setCompanyUserId(BaseContextHandler.getUserId());
        BaseResponse baseResponse = companyPositionRpcFacade.update(companyPositionUpdateReqDTO);
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
        BaseResponse baseResponse = companyPositionRpcFacade.remove(id);
        baseResponse.checkError();
        return baseResponse.isSuccess() ? 1 : 0;
    }

    /**
     * 根据Id查找
     *
     * @param id
     * @return
     */
    public ManagementPositionVO getCompanyPositionById(Long id) {
        ObjectRestResponse<CompanyPositionDetailRespDTO> objectRestResponse = companyPositionRpcFacade.getCompanyPositionById(id);
        objectRestResponse.checkError();
        return ManagementPositionConvert.INSTANCE.convert(objectRestResponse.getData());
    }


    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    public TableResultResponse<ManagementPositionPageVO> pageCompanyPosition(ManagementPositionPageDTO pageReqDTO) {
        TableResultResponse<ManagementPositionPageRespDTO> tableResultResponse = companyPositionRpcFacade
                .managementPage(ManagementPositionConvert.INSTANCE.convert(pageReqDTO));
        tableResultResponse.checkError();

        if (CollectionUtils.isEmpty(tableResultResponse.getData().getRows())) {
            return new TableResultResponse<>();
        }
        buildManagementPositionPageRespDTO(tableResultResponse);
        return ManagementPositionConvert.INSTANCE.convert(tableResultResponse);
    }

    private void buildManagementPositionPageRespDTO(TableResultResponse<ManagementPositionPageRespDTO> tableResultResponse) {
        Set<Long> dictionaryIds = Sets.newHashSet();
        Set<Long> userIds = Sets.newHashSet();
        for (ManagementPositionPageRespDTO respDTO : tableResultResponse.getData().getRows()) {
            dictionaryIds.add(respDTO.getExperienceId());
            dictionaryIds.add(respDTO.getEducationId());
            userIds.add(respDTO.getCompanyUserId());
        }
        Map<String, Object> map = userService.getByIds(userIds);
        Map<Long, UserExtendDetailRespDTO> userMap = (Map<Long, UserExtendDetailRespDTO>) map.get("userMap");
        Set<Long> companyIds = (Set<Long>) map.get("companyIds");
        Map<Long, String> companyMap = companyService.getByIds(companyIds);
        Map<Long, String> dictionaryMap = dictionaryService.getByIds(dictionaryIds);
        for (ManagementPositionPageRespDTO respDTO : tableResultResponse.getData().getRows()) {
            UserExtendDetailRespDTO userExtendDetailRespDTO = userMap.get(respDTO.getCompanyUserId());
            respDTO.setRealName(userExtendDetailRespDTO == null ? "" : userExtendDetailRespDTO.getRealName());
            respDTO.setEducation(dictionaryMap.get(respDTO.getEducationId()));
            respDTO.setExperience(dictionaryMap.get(respDTO.getExperienceId()));
            respDTO.setFullName(companyMap.get(userExtendDetailRespDTO.getCompanyId()));
        }
    }


    public int updateCompanyPositionStatus(ManagementPositionAuditDTO companyPositionAuditDTO) {
        CompanyPositionAuditReqDTO auditReqDTO = ManagementPositionConvert.INSTANCE.convert(companyPositionAuditDTO);
        auditReqDTO.setAuditUserId(BaseContextHandler.getUserId());
        BaseResponse baseResponse = companyPositionRpcFacade.updateCompanyPositionStatus(auditReqDTO);
        baseResponse.checkError();
        return baseResponse.isSuccess() ? 1 : 0;
    }
}
