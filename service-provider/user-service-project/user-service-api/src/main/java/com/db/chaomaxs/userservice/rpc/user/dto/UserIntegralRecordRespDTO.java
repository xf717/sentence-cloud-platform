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
 * 记录用户签到记录信息
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserIntegralRecordRespDTO implements Serializable {

                      /**
           * 系统id
           */
          @NotEmpty(message = "系统id")
          private Long id;
        
                      /**
           * 用户id
           */
          private Long userId;
        
                      /**
           * 手机号码
           */
          private String mobile;
        
                      /**
           * 连续签到天数
           */
          private Integer checkDay;
        
                      /**
           * 签到时间
           */
          private Date signInTime;
        
                      /**
           * 积分说明,字典表id
           */
          private Long integralExplanationDictionaryId;
        
                      /**
           * 积分类型:关联字典表id
           */
          private Long integralTypeDictionaryId;
        
                      /**
           * 积分值
           */
          private Integer integralValue;
        
                      /**
           * 是否删除 1:是 0否  默认：0
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
