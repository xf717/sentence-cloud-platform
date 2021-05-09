package com.github.xf717.userservice.rpc.user.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectRespDTO;
import com.github.xf717.userservice.rpc.user.dto.UserPositionCollectPageReqDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_职位_收藏
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
public interface UserPositionCollectApi {

    /**
     * 添加数据
     *
     * @param createReqDTO 添加参数
     * @return
     */
    @PostMapping("/facade/userPositionCollect/save")
    BaseResponse save(@RequestBody UserPositionCollectCreateReqDTO createReqDTO);


    /**
     * 根据ID删除数据
     *
     * @param id id
     * @return
     */
    @DeleteMapping("/facade/userPositionCollect/remove/{id}")
    BaseResponse remove(@PathVariable("id") Long id);

    /**
     * 根据Id查找
     *
     * @param id id
     * @return
     */
    @GetMapping("/facade/userPositionCollect/get/{id}")
    ObjectRestResponse<UserPositionCollectRespDTO> getUserPositionCollectById(@PathVariable("id") Long id);


    /**
     * 查找数据显示分页
     *
     * @param pageReqDTO 分页参数
     * @return
     */
    @PostMapping("/facade/userPositionCollect/page")
    TableResultResponse<UserPositionCollectRespDTO> page(@RequestBody UserPositionCollectPageReqDTO pageReqDTO);

}
