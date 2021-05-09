package com.github.xf717.userservice.rpc.user.dto;

import com.github.xf717.common.framework.vo.PageParam;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 比如：create_time、update_time、create_by、update_by 就可以去掉,
 * 验证添加要自行调整@NotEmpty 自行配置
 * 用户面试表
 *
 * @author momo
 * @date 2021-04-02 13:58:28
 */
@Data
@Accessors(chain = true)
public class UserInterviewPageReqDTO extends PageParam implements Serializable {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 状态
     * 0 -  待接受面试
     * 1 -  待面试
     * 2 -  拒绝面试
     * 3 - 通过面试
     * 4 - 拒绝录用
     * 5-  接受录用
     * 6 - 企业已取消
     * 7 - 用户已取消
     */
    private Integer status;
}
