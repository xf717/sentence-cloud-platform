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
 * 用户消息表
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserMessageRespDTO implements Serializable {

                      /**
           * 
           */
          @NotEmpty(message = "")
          private Long id;
        
                      /**
           * 消息id
           */
          private Long messageId;
        
                      /**
           * 用户ID
           */
          private Long userId;
        
                      /**
           * 修改时间
           */
          private Date readTime;
        
                      /**
           * 0 - 未读
            1 - 已读
           */
          private Integer readStatus;
        
                      /**
           * 是否删除
           */
          private Integer isDeleted;
        
                      /**
           * 创建时间
           */
          private Date createTime;
        
                      /**
           * 创建人
           */
          private Long createBy;
        
                      /**
           * 修改时间
           */
          private Date updateTime;
        
                      /**
           * 修改人
           */
          private Long updateBy;
        
    
}
