package com.db.chaomaxs.userweb.controller.content;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.security.auth.client.annotation.IgnoreUserToken;
import com.db.chaomaxs.userweb.controller.content.vo.AgreementInformationVO;
import com.db.chaomaxs.userweb.manager.content.AgreementInformationManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * app端内容管理-协议信息表
 *
 * @author ding
 * @date 2021-03-29 18:03:04
 */
@Api(value = "内容管理-协议信息表", description = "内容管理-协议信息表", tags = "个人协议及隐私政策")
@RestController
@RequestMapping("/rest/agreementInformation")
public class AgreementInformationController {

	@Autowired
	private AgreementInformationManager agreementInformationManager;



	/**
	 * 根据code获取数据
	 * @param
	 * @return
	 */
	@ApiOperation(value = "获取个人协议及隐私政策", nickname = "getAgreementInformationByCode")
	@GetMapping("/get")
	@IgnoreUserToken
	public ObjectRestResponse<AgreementInformationVO> getAgreementInformationByCode() {
		return ObjectRestResponse.success(agreementInformationManager.getAgreementInformationByCode("YSXY"));
	}

}
