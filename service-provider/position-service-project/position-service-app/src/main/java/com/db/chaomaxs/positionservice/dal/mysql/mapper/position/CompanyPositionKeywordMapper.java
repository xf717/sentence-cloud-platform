package com.db.chaomaxs.positionservice.dal.mysql.mapper.position;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.CompanyPositionKeywordDO;
import com.db.chaomaxs.positionservice.dal.mysql.dataobject.position.GetCompanyPositionKeywordDO;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 职位_关键词_管理
 *
 * @author momo
 * @date 2021-04-20 11:16:23
 */
@Repository
public interface CompanyPositionKeywordMapper extends BaseMapper<CompanyPositionKeywordDO> {

    List<GetCompanyPositionKeywordDO> getIdsByCompanyPositionId(@Param("companyPositionId") Long companyPositionId);

    List<GetCompanyPositionKeywordDO> getIdsByCompanyPositionIds(@Param("ids") Set<Long> ids);

    void batchInsert(@Param("items") List<CompanyPositionKeywordDO> companyPositionKeywordDOList);

    void deleteByCompanyPositionId(@Param("companyPositionId") Long companyPositionId);

    void softDeleteByCompanyPositionId(@Param("companyPositionId") Long companyPositionId);
}
