package com.db.chaomaxs.positionservice.dal.mysql.mapper.position;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.CompanyPositionExtendDO;
import org.springframework.stereotype.Repository;

/**
 * 企业职位_扩展信息表
 *
 * @author momo
 * @date 2021-04-21 15:17:14
 */
@Repository
public interface CompanyPositionExtendMapper extends BaseMapper<CompanyPositionExtendDO> {


    int updateByCompanyPositionId(CompanyPositionExtendDO companyPositionExtendDO);

    int deleteByCompanyPositionId(Long companyPositionId);
}
