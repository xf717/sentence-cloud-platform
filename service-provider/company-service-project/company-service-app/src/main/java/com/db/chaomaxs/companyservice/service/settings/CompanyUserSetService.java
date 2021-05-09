package com.db.chaomaxs.companyservice.service.settings;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.companyservice.convert.settings.CompanyUserSetConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.settings.CompanyUserSetDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.settings.CompanyUserSetMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetRespDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetUpdateReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserSetService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyUserSetService {

    @Autowired
    private CompanyUserSetMapper companyUserSetMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveCompanyUserSet(CompanyUserSetCreateReqDTO createReqDTO) {
        return companyUserSetMapper.insert(CompanyUserSetConvert.INSTANCE.convert(createReqDTO));
    }

    /**
     * 更新数据
     *
     * @param updateReqDTO
     * @return
     */
    public int updateCompanyUserSet(CompanyUserSetUpdateReqDTO updateReqDTO) {
        CompanyUserSetDO companyUserSetDO = companyUserSetMapper.selectById(updateReqDTO.getId());
        if (companyUserSetDO == null) {
            throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
        }
        companyUserSetDO = CompanyUserSetConvert.INSTANCE.convert(updateReqDTO);
        int result = companyUserSetMapper.updateById(companyUserSetDO);
        return result;
    }


    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public CompanyUserSetRespDTO getCompanyUserSetById(Long id) {
        CompanyUserSetDO companyUserSetDO = companyUserSetMapper.selectById(id);
        if (companyUserSetDO == null) {
            throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
        }
        return CompanyUserSetConvert.INSTANCE.convert(companyUserSetDO);
    }


    public CompanyUserSetRespDTO getUserSetByCompanyUserIdAndUserId(CompanyUserSetQueryReqDTO companyUserSetQueryReqDTO) {
        CompanyUserSetDO companyUserSetDO = CompanyUserSetConvert.INSTANCE.convert(companyUserSetQueryReqDTO);
        companyUserSetDO = companyUserSetMapper.getUserSetByCompanyUserIdAndUserId(companyUserSetDO);
        return CompanyUserSetConvert.INSTANCE.convert(companyUserSetDO);
    }
}
