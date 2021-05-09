package com.db.chaomaxs.userweb.controller.content;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.security.auth.client.annotation.IgnoreUserToken;
import com.db.chaomaxs.systemservice.constant.CommonConstant;
import com.db.chaomaxs.userweb.controller.content.vo.IndustryTypeVO;
import com.db.chaomaxs.userweb.manager.content.IndustryTypeManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 行业分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Api(value = "行业分类信息表", description = "行业分类信息表", tags = "行业分类信息")
@RestController
@RequestMapping("/rest/industryType")
public class IndustryTypeController {

	@Autowired
	private IndustryTypeManager industryTypeManager;




	@ApiOperation(value = "根据parentId查询数据,不分页,parentId不传默认获取顶级分类", nickname = "listIndustry")
	@GetMapping("/list")
	@IgnoreUserToken
	public ObjectRestResponse<List<IndustryTypeVO>> listIndustry(@RequestParam(value = "parentId",required = false) Long parentId ) {
		if(null == parentId){
			parentId = CommonConstant.INDUSTRY_TYPE_TREE_TOP_PARENT_ID;
		}
		List<IndustryTypeVO> list = industryTypeManager.listIndustryByParentId(parentId);
		return ObjectRestResponse.success(list);
	}

}
