package com.db.chaomaxs.companyservice.service.company;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.chat.CompanyUserChatConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.chat.CompanyUserChatDO;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.chat.CompanyUserChatStatisticsDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.chat.CompanyUserChatMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.CompanyUserChatStatisticRespDTO;
import com.db.chaomaxs.companyservice.rpc.chat.dto.PositionIdsReqDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * CompanyUserChatService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyUserChatService {

    @Autowired
    private CompanyUserChatMapper companyUserChatMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveCompanyUserChat(CompanyUserChatCreateReqDTO createReqDTO) {
        CompanyUserChatDO companyUserChatDO = CompanyUserChatConvert.INSTANCE.convert(createReqDTO);
        CompanyUserChatDO getCompanyUserChatDO = companyUserChatMapper.getByUserIdAndCompanyUserId(companyUserChatDO);
        if (getCompanyUserChatDO != null) {
            companyUserChatMapper.updateById(getCompanyUserChatDO);
            return 1;
        } else {
            return companyUserChatMapper.insert(companyUserChatDO);
        }
    }


    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public CompanyUserChatRespDTO getCompanyUserChatById(Long id) {
        CompanyUserChatDO companyUserChatDO = companyUserChatMapper.selectById(id);
        if (companyUserChatDO == null) {
            throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
        }
        return CompanyUserChatConvert.INSTANCE.convert(companyUserChatDO);
    }

    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<CompanyUserChatRespDTO> pageCompanyUserChat(CompanyUserChatPageReqDTO page) {
        IPage<CompanyUserChatDO> companyUserChatPage = companyUserChatMapper.selectPage(page);
        return CompanyUserChatConvert.INSTANCE.convertPage(companyUserChatPage);
    }

    public Integer count(CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
        return companyUserChatMapper.selectCount(companyUserStatisticReqDTO);
    }

    public List<CompanyUserChatStatisticRespDTO> getStatisticByPositionIds(PositionIdsReqDTO positionIdsReqDTO) {
        List<CompanyUserChatStatisticsDO> companyUserChatStatisticsDOList=companyUserChatMapper.getStatisticByPositionIds(positionIdsReqDTO.getIds());
        return CompanyUserChatConvert.INSTANCE.convertStatistic(companyUserChatStatisticsDOList);
    }
}
