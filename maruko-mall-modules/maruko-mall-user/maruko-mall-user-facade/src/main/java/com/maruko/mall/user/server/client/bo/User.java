package com.maruko.mall.user.server.client.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * User
 * @author xiaofeng
 * @date 2019/06/23 21:42
 * @version 1.0
 */
@Data
@Accessors(chain = true)
public class User implements java.io.Serializable {

//	private static final long serialVersionUID = 1L;

	private String name;

}
