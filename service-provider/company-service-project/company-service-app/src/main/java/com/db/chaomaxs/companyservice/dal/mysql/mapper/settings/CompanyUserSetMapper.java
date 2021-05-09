package com.db.chaomaxs.companyservice.dal.mysql.mapper.settings;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.settings.CompanyUserSetDO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetPageReqDTO;
import com.db.chaomaxs.mybatis.core.query.QueryWrapperX;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 企业我的设置
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Repository
public interface CompanyUserSetMapper extends BaseMapper<CompanyUserSetDO> {

    /**
     * 根据参数查询数据
     *
     * @param listReqDTO
     * @return
     */
    default List<CompanyUserSetDO> selectList(CompanyUserSetListQueryReqDTO listReqDTO) {
        return selectList(new QueryWrapperX<CompanyUserSetDO>());
    }

    /**
     * 查询分页
     *
     * @param pageReqDTO
     * @return
     */
    default IPage<CompanyUserSetDO> selectPage(CompanyUserSetPageReqDTO pageReqDTO) {
        return selectPage(new Page<>(pageReqDTO.getPageNo(), pageReqDTO.getPageSize()), new QueryWrapperX<CompanyUserSetDO>());
    }

    CompanyUserSetDO getUserSetByCompanyUserIdAndUserId(CompanyUserSetDO companyUserSetDO);
}
