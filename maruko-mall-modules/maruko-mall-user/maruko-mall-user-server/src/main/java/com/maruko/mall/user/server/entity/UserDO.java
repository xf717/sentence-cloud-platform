package com.maruko.mall.user.server.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Table;

/**
 * UserDO
 * @author xiaofeng
 * @date 2019/06/23 21:44
 * @version 1.0
 */
@Table(name = "user")
@Data
@Accessors(chain = true)
public class UserDO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
}
