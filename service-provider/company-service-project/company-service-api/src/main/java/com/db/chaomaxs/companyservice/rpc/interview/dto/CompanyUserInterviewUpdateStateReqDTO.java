package com.db.chaomaxs.companyservice.rpc.interview.dto;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


/**
 * 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyUserInterviewUpdateStateReqDTO implements Serializable {


    /**
     * 主键id
     */
    @NotEmpty(message = "主键id")
    private Long id;

    /**
     * 状态 0 -  待接受面试 1 -  待面试 2 -  拒绝面试 3 - 通过面试 4 - 拒绝录用 5-  接受录用 6 - 已取消
     */
    private Integer status;
}
