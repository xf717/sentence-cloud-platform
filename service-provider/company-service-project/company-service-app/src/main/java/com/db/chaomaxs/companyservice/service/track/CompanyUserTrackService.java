package com.db.chaomaxs.companyservice.service.track;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.convert.track.CompanyUserTrackConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.track.CompanyUserTrackDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.track.CompanyUserTrackMapper;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserTrackService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyUserTrackService {

    @Autowired
    private CompanyUserTrackMapper companyUserTrackMapper;

    /**
     * 保存数据
     *
     * @param createReqDTO
     * @return
     */
    public int saveCompanyUserTrack(CompanyUserTrackCreateReqDTO createReqDTO) {
        CompanyUserTrackDO companyUserTrackDO = CompanyUserTrackConvert.INSTANCE.convert(createReqDTO);
        CompanyUserTrackDO getCompanyUserTrackDO = companyUserTrackMapper.getByUserIdAndCompanyUserId(companyUserTrackDO);
        //判断是否已经有足迹，有足迹修改时间
        if (getCompanyUserTrackDO != null) {
            return companyUserTrackMapper.updateById(getCompanyUserTrackDO.getId());
        }
        return companyUserTrackMapper.insert(companyUserTrackDO);
    }

    /**
     * 分类
     *
     * @param page
     * @return
     */
    public PageResult<CompanyUserTrackRespDTO> pageCompanyUserTrack(CompanyUserTrackPageReqDTO page) {
        IPage<CompanyUserTrackDO> companyUserTrackPage = companyUserTrackMapper.selectPage(page);
        return CompanyUserTrackConvert.INSTANCE.convertPage(companyUserTrackPage);
    }


    public CompanyUserTrackRespDTO getCompanyUserTrackById(Long id) {
        CompanyUserTrackDO companyUserTrackDO = companyUserTrackMapper.selectById(id);
        return CompanyUserTrackConvert.INSTANCE.convert(companyUserTrackDO);
    }
}
