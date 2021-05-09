package com.db.chaomaxs.logservice.rpc.login.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;





/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 比如：create_time、update_time、create_by、update_by 就可以去掉,
 * 验证添加要自行调整@NotEmpty 自行配置
 * 用户_登录日志
 * @author xiaofeng
 * @date 2021-04-06 17:48:03
 */
@Data
@Accessors(chain = true)
public class UserLoginLogPageReqDTO extends PageParam implements Serializable {

                      /**
           * 系统id
           */
          @NotEmpty(message = "系统id")
          private Long id;
        
                      /**
           * app应用市场信息id
           */
          private Integer sysAppMarketId;
        
                      /**
           * 终端类型(字典:1android手机、2android平板、3pc、4ios手机、5ios平板、6web)
           */
          private Integer terminalType;
        
                      /**
           * 终端唯一
           */
          private String terminalSn;
        
                      /**
           * 终端名称
           */
          private String terminalName;
        
                      /**
           * app版本号
           */
          private Integer appVersionNo;
        
                      /**
           * app版本名称
           */
          private String appVersionName;
        
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
