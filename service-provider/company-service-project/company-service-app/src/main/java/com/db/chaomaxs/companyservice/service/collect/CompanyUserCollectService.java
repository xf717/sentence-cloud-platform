package com.db.chaomaxs.companyservice.service.collect;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.collect.CompanyUserCollectConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.collect.CompanyUserCollectDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.collect.CompanyUserCollectMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.collect.dto.*;
import com.db.chaomaxs.companyservice.rpc.statistic.dto.CompanyUserStatisticReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserCollectService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyUserCollectService {

    @Autowired
    private CompanyUserCollectMapper companyUserCollectMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveCompanyUserCollect(CompanyUserCollectCreateReqDTO createReqDTO) {
        CompanyUserCollectDO companyUserCollectDO = CompanyUserCollectConvert.INSTANCE.convert(createReqDTO);
        CompanyUserCollectDO getCompanyUserCollectDO = companyUserCollectMapper.getByUserIdAndCompanyUserId(companyUserCollectDO);
        if (getCompanyUserCollectDO != null) {
            return 1;
        }
        return companyUserCollectMapper.insert(companyUserCollectDO);
    }


    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    public int deleteCompanyUserCollect(Long id) {
        if (companyUserCollectMapper.selectById(id) == null) {
            throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
        }
        int result = companyUserCollectMapper.deleteById(id);
        return result;
    }

    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    public CompanyUserCollectRespDTO getCompanyUserCollectById(Long id) {
        CompanyUserCollectDO CompanyUserCollectDO = companyUserCollectMapper.selectById(id);
        if (CompanyUserCollectDO == null) {
            throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.NOT_EXISTS.getCode());
        }
        return CompanyUserCollectConvert.INSTANCE.convert(CompanyUserCollectDO);
    }

    /**
     * 分类
     *
     * @param pageReqDTO
     * @return
     */
    public PageResult<CompanyUserCollectRespDTO> pageCompanyUserCollect(CompanyUserCollectPageReqDTO pageReqDTO) {
        IPage<CompanyUserCollectDO> companyUserCollectPage = companyUserCollectMapper.selectPage(pageReqDTO);
        return CompanyUserCollectConvert.INSTANCE.convertPage(companyUserCollectPage);
    }

    public PageResult<UserCollectRespDTO> pageUserCollect(UserCollectPageReqDTO pageReqDTO) {
        IPage<CompanyUserCollectDO> userCollectPage = companyUserCollectMapper.selectUserPage(pageReqDTO);
        return CompanyUserCollectConvert.INSTANCE.convertUserPage(userCollectPage);
    }

    public Integer count(CompanyUserStatisticReqDTO companyUserStatisticReqDTO) {
        return companyUserCollectMapper.selectCount(companyUserStatisticReqDTO);
    }
}
