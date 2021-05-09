package com.github.xf717.systemservice.rpc.dict.rest;

import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.dict.DataDictionaryTypeRpcImpl;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypePageReqDTO;
import com.github.xf717.systemservice.rpc.dict.dto.DataDictionaryTypeRespDTO;
import com.github.xf717.systemservice.rpc.dict.facade.api.DataDictionaryTypeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
@RestController
public class DataDictionaryTypeRpcController implements DataDictionaryTypeApi {

	@Autowired
	private DataDictionaryTypeRpcImpl dataDictionaryTypeRpc;


	@Override
	public TableResultResponse<DataDictionaryTypeRespDTO> page(@RequestBody DataDictionaryTypePageReqDTO pageReqDTO) {
		return dataDictionaryTypeRpc.page(pageReqDTO);
	}
}
