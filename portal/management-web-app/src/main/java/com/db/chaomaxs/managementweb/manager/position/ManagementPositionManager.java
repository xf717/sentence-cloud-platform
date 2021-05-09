package com.db.chaomaxs.managementweb.manager.position;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.managementweb.controller.position.dto.ManagementPositionAuditDTO;
import com.db.chaomaxs.managementweb.controller.position.dto.ManagementPositionPageDTO;
import com.db.chaomaxs.managementweb.controller.position.dto.ManagementPositionUpdateDTO;
import com.db.chaomaxs.managementweb.controller.position.vo.ManagementPositionPageVO;
import com.db.chaomaxs.managementweb.controller.position.vo.ManagementPositionVO;
import com.db.chaomaxs.managementweb.convert.position.ManagementPositionConvert;
import com.db.chaomaxs.managementweb.service.compnay.CompanyService;
import com.db.chaomaxs.managementweb.service.dictionary.DictionaryService;
import com.db.chaomaxs.managementweb.service.user.UserService;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionAuditReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.ManagementPositionPageRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendDetailRespDTO;
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
