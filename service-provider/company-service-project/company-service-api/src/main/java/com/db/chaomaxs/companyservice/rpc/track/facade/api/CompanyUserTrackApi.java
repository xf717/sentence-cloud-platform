package com.db.chaomaxs.companyservice.rpc.track.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.track.dto.CompanyUserTrackRespDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 企业我的足迹
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
public interface CompanyUserTrackApi {

    /**
     * 添加数据
     *
     * @param createReqDTO 添加参数
     * @return
     */
    @PostMapping("/facade/companyUserTrack/save")
    BaseResponse save(@RequestBody CompanyUserTrackCreateReqDTO createReqDTO);

    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    @PostMapping("/facade/companyUserTrack/page")
    TableResultResponse<CompanyUserTrackRespDTO> page(@RequestBody CompanyUserTrackPageReqDTO pageReqDTO);


    /**
     * 根据Id查找
     *
     * @param  id
     * @return
     */
    @GetMapping("/facade/companyUserTrack/get/{id}")
    ObjectRestResponse<CompanyUserTrackRespDTO> getCompanyUserTrackById(@PathVariable("id") Long id);

}
