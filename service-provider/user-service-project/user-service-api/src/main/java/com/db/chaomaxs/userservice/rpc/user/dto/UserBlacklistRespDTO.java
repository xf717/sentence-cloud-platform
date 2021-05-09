package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;





/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 比如：create_time、update_time、create_by、update_by 就可以去掉,
 * 验证添加要自行调整@NotEmpty 自行配置
 * 用户_黑名单
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserBlacklistRespDTO implements Serializable {

                      /**
           * 
           */
          @NotEmpty(message = "")
          private Long id;
        
                      /**
           * 用户id
           */
          private Long userId;
        
                      /**
           * 企业用户
           */
          private Long companyUserId;
        
                      /**
           * 状态0 - 否1 -是
           */
          private Integer status;
        
                      /**
           * 是否删除 1:是 0否  默认：0
           */
          private Integer isDeleted;
        
                      /**
           * 创建人
           */
          private Long createBy;
        
                      /**
           * 创建时间
           */
          private Date createTime;
        
                      /**
           * 修改人
           */
          private Long updateBy;
        
                      /**
           * 修改时间
           */
          private Date updateTime;
        
    
}
