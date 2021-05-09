package com.db.chaomaxs.companyservice.rpc.collect.dto;
import com.db.chaomaxs.common.framework.vo.PageParam;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 企业_用户_收藏
 *
 * @author momo
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
public class CompanyUserCollectPageReqDTO extends PageParam implements Serializable {
    /**
     * 企业用户id
     */
    private Long companyUserId;
}
