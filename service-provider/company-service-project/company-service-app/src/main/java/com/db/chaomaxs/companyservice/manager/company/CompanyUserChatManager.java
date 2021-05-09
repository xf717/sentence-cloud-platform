package com.db.chaomaxs.companyservice.manager.company;

import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatStatisticRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.PositionIdsReqDTO;
import com.db.chaomaxs.companyservice.service.company.CompanyUserChatService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * CompanyUserChatManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyUserChatManager {

    @Autowired
    private CompanyUserChatService companyUserChatService;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveCompanyUserChat(CompanyUserChatCreateReqDTO createReqDTO) {
        return companyUserChatService.saveCompanyUserChat(createReqDTO);
    }


    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public CompanyUserChatRespDTO getCompanyUserChatById(Long id) {
        return companyUserChatService.getCompanyUserChatById(id);
    }

    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<CompanyUserChatRespDTO> pageCompanyUserChat(CompanyUserChatPageReqDTO page) {
        return companyUserChatService.pageCompanyUserChat(page);
    }


    public Map<Long, CompanyUserChatStatisticRespDTO> getStatisticByPositionIds(PositionIdsReqDTO positionIdsReqDTO) {
        List<CompanyUserChatStatisticRespDTO> list = companyUserChatService.getStatisticByPositionIds(positionIdsReqDTO);
        if (CollectionUtils.isEmpty(list)) {
            return Maps.newHashMap();
        }
        return list.stream().collect(Collectors.toMap(CompanyUserChatStatisticRespDTO::getPositionId, a -> a, (k1, k2) -> k2));
    }
}
