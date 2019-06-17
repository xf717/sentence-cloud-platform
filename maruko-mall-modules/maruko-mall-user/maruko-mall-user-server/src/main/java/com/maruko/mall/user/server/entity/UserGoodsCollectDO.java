package com.maruko.mall.user.server.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_商品收藏表
 *
 * @author xiaofeng
 * @date 2019-06-17 20:31:49
 */
@Table(name = "user_goods_collect")
@Data
@Accessors(chain = true)
public class UserGoodsCollectDO implements Serializable {
	private static final long serialVersionUID = 1L;

	    /**
     * 系统id
     */
    @Id
    private Integer userListCollectId;
	
	    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;
	
	    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    private Integer goodsId;
	
	    /**
     * 是否收藏(1:是,0:否,默认为1)
     */
    @Column(name = "is_collect")
    private Integer isCollect;
	
	    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;
	
	    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Integer createBy;
	
	    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Long modifyTime;
	
	    /**
     * 修改人
     */
    @Column(name = "modify_by")
    private Integer modifyBy;
	

}
