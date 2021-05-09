package com.db.chaomaxs.userservice.rpc.user.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryRespDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserDeliveryPageReqDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 企业投递表
 *
 * @author momo
 * @date 2021-04-08 14:18:28
 */
public interface UserDeliveryApi {

    /**
     * 添加数据
     *
     * @param createReqDTO 添加参数
     * @return
     */
    @PostMapping("/facade/userDelivery/save")
    BaseResponse save(@RequestBody UserDeliveryCreateReqDTO createReqDTO);


    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    @PostMapping("/facade/userDelivery/page")
    TableResultResponse<UserDeliveryRespDTO> page(@RequestBody UserDeliveryPageReqDTO pageReqDTO);

}
