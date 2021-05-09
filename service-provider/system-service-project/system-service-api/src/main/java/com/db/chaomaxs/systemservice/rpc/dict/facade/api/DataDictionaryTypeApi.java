package com.db.chaomaxs.systemservice.rpc.dict.facade.api;

import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.dict.dto.DataDictionaryTypeRespDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 字典分类信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 17:42:11
 */
public interface DataDictionaryTypeApi {

	/**
	 * 查找数据显示分页
	 * @param pageReqDTO  分页参数
	 * @return
	 */
	@PostMapping("/facade/dataDictionaryType/page")
	TableResultResponse<DataDictionaryTypeRespDTO> page(
      @RequestBody DataDictionaryTypePageReqDTO pageReqDTO);

}
