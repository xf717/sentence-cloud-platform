package com.db.chaomaxs.companyweb.manager.position;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatStatisticRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.PositionIdsReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.facade.CompanyUserChatRpcFacade;
import com.db.chaomaxs.companyweb.controller.position.vo.CompanyPositionBasePageVO;
import com.db.chaomaxs.companyweb.controller.position.vo.CompanyPositionPageVO;
import com.db.chaomaxs.companyweb.service.dictionary.DictionaryService;
import com.db.chaomaxs.companyweb.service.position.PositionService;
import com.db.chaomaxs.companyweb.service.position.vo.PositionDetailVO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionDetailRespDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionPageRespDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionAddDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionUpdateDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.CompanyPositionPageDTO;
import com.db.chaomaxs.companyweb.controller.position.vo.CompanyPositionVO;
import com.db.chaomaxs.companyweb.convert.position.CompanyPositionConvert;
import com.db.chaomaxs.positionservice.rpc.position.dto.CompanyPositionUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.position.facade.CompanyPositionRpcFacade;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.resume.dto.IdsReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserTrackStatisticRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserStatisticRpcFacade;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
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
public class CompanyPositionManager {

    @Autowired
    private CompanyPositionRpcFacade companyPositionRpcFacade;

    @Autowired
    private UserStatisticRpcFacade userStatisticRpcFacade;

    @Autowired
    private CompanyUserChatRpcFacade companyUserChatRpcFacade;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private PositionService positionService;

    /**
     * 添加数据
     *
     * @param companyPositionAddDTO 添加参数
     * @return
     */
    public int save(CompanyPositionAddDTO companyPositionAddDTO) {
        CompanyPositionCreateReqDTO companyPositionCreateReqDTO = CompanyPositionConvert.INSTANCE.convert(companyPositionAddDTO);
        companyPositionCreateReqDTO.setCompanyUserId(BaseContextHandler.getUserId());
        BaseResponse baseResponse = companyPositionRpcFacade.save(companyPositionCreateReqDTO);
        baseResponse.checkError();
        return baseResponse.isSuccess() ? 1 : 0;
    }

    /**
     * 更新数据
     *
     * @param companyPositionUpdateDTO 更新参数
     * @return
     */
    public int update(CompanyPositionUpdateDTO companyPositionUpdateDTO) {
        CompanyPositionUpdateReqDTO companyPositionUpdateReqDTO = CompanyPositionConvert.INSTANCE.convert(companyPositionUpdateDTO);
        companyPositionUpdateReqDTO.setCompanyUserId(BaseContextHandler.getUserId());
        BaseResponse baseResponse = companyPositionRpcFacade.update(companyPositionUpdateReqDTO);
        baseResponse.checkError();
        return baseResponse.isSuccess() ? 1 : 0;
    }

    /**
     * 根据ID删除数据
     *
     * @param id
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
    public CompanyPositionVO getCompanyPositionById(Long id) {
        ObjectRestResponse<CompanyPositionDetailRespDTO> objectRestResponse = companyPositionRpcFacade.getCompanyPositionById(id);
        objectRestResponse.checkError();
        return CompanyPositionConvert.INSTANCE.convert(objectRestResponse.getData());
    }


    public PositionDetailVO getCompanyPositionDetailById(Long id) {
        return positionService.getPositionDetail(id);
    }


    public TableResultResponse<CompanyPositionBasePageVO> basePageCompanyPosition(CompanyPositionPageDTO pageReqDTO) {
        TableResultResponse<CompanyPositionPageRespDTO> tableResultResponse = dealPageCompanyPosition(pageReqDTO, Boolean.FALSE);
        return CompanyPositionConvert.INSTANCE.convertBasePage(tableResultResponse);
    }

    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    public TableResultResponse<CompanyPositionPageVO> pageCompanyPosition(CompanyPositionPageDTO pageReqDTO) {
        TableResultResponse<CompanyPositionPageRespDTO> tableResultResponse = dealPageCompanyPosition(pageReqDTO, Boolean.TRUE);
        return CompanyPositionConvert.INSTANCE.convertPage(tableResultResponse);
    }

    /**
     * @param pageReqDTO
     * @param hasStatistics pc端的面试管理有统计数据，手机端的面试管理没有
     * @return
     */
    TableResultResponse<CompanyPositionPageRespDTO> dealPageCompanyPosition(CompanyPositionPageDTO pageReqDTO, Boolean hasStatistics) {
        CompanyPositionPageReqDTO companyPositionPageReqDTO = CompanyPositionConvert.INSTANCE.convert(pageReqDTO);
        companyPositionPageReqDTO.setCompanyUserId(BaseContextHandler.getUserId());
        TableResultResponse<CompanyPositionPageRespDTO> tableResultResponse = companyPositionRpcFacade
                .page(companyPositionPageReqDTO);
        tableResultResponse.checkError();
        buildCompanyPositionPage(tableResultResponse.getData().getRows(), hasStatistics);
        return tableResultResponse;
    }

    /**
     * 教育经验需要去字典表转换
     *
     * @param rows
     */
    private void buildCompanyPositionPage(List<CompanyPositionPageRespDTO> rows, Boolean hasStatistics) {
        if (CollectionUtils.isEmpty(rows)) {
            return;
        }
        Set<Long> positionIds = Sets.newHashSet();
        Set<Long> dictionaryIds = Sets.newHashSet();
        for (CompanyPositionPageRespDTO row : rows) {
            dictionaryIds.add(row.getEducationId());
            dictionaryIds.add(row.getExperienceId());
            positionIds.add(row.getId());
        }
        Map<Long, String> map = dictionaryService.getByIds(dictionaryIds);
        Map<Long, UserTrackStatisticRespDTO> UserTrackStatisticMap = Maps.newHashMap();
        Map<Long, CompanyUserChatStatisticRespDTO> CompanyUserChatStatisticMap = Maps.newHashMap();
        //统计查看职位人的总数和该职位沟通的总数
        if (hasStatistics) {
            IdsReqDTO idsReqDTO = new IdsReqDTO();
            idsReqDTO.setIds(positionIds);
            UserTrackStatisticMap = userStatisticRpcFacade.getStatisticByPositionIds(idsReqDTO);
            PositionIdsReqDTO positionIdsReqDTO = new PositionIdsReqDTO();
            positionIdsReqDTO.setIds(positionIds);
            CompanyUserChatStatisticMap = companyUserChatRpcFacade.getStatisticByPositionIds(positionIdsReqDTO);
        }
        for (CompanyPositionPageRespDTO row : rows) {
            row.setEducation(map.get(row.getEducationId()));
            row.setExperience(map.get(row.getExperienceId()));
            if (hasStatistics) {
                UserTrackStatisticRespDTO userTrackStatisticRespDTO = UserTrackStatisticMap.get(row.getId());
                CompanyUserChatStatisticRespDTO companyUserChatStatisticRespDTO = CompanyUserChatStatisticMap.get(row.getId());
                row.setTractCount(userTrackStatisticRespDTO == null ? 0 : userTrackStatisticRespDTO.getCount());
                row.setChatCount(companyUserChatStatisticRespDTO == null ? 0 : companyUserChatStatisticRespDTO.getCount());
            }
        }
    }
}
