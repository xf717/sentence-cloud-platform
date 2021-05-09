package com.db.chaomaxs.companyservice.service.delivery;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.delivery.CompanyDeliveryConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.delivery.CompanyDeliveryDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.delivery.CompanyDeliveryMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryRespDTO;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyDeliveryService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyDeliveryService {

    @Autowired
    private CompanyDeliveryMapper companyDeliveryMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveCompanyDelivery(CompanyDeliveryCreateReqDTO createReqDTO) {
        CompanyDeliveryDO companyDeliveryDO = CompanyDeliveryConvert.INSTANCE.convert(createReqDTO);
        CompanyDeliveryDO getCompanyDeliveryDO = companyDeliveryMapper.getByUserIdAndCompanyUserId(companyDeliveryDO);
        if (getCompanyDeliveryDO != null) {
            return 1;
        }
        return companyDeliveryMapper.insert(companyDeliveryDO);
    }


    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public CompanyDeliveryRespDTO getCompanyDeliveryById(Long id) {
        CompanyDeliveryDO companyDeliveryDO = companyDeliveryMapper.selectById(id);
        if (companyDeliveryDO == null) {
            throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
        }
        return CompanyDeliveryConvert.INSTANCE.convert(companyDeliveryDO);
    }

    /**
     * 分类
     *
     * @param pageReqDTO
     * @return
     */
    public PageResult<CompanyDeliveryRespDTO> pageCompanyDelivery(CompanyDeliveryPageReqDTO pageReqDTO) {
        IPage<CompanyDeliveryDO> companyDeliveryPage = companyDeliveryMapper.selectPage(pageReqDTO);
        return CompanyDeliveryConvert.INSTANCE.convertPage(companyDeliveryPage);
    }


    public Integer count(CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
        return companyDeliveryMapper.selectCount(companyUserStatisticReqDTO);
    }
}
