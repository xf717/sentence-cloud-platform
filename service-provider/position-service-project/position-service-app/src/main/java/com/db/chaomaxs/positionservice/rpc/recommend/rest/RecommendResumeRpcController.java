package com.db.chaomaxs.positionservice.rpc.recommend.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.positionservice.rpc.recommend.RecommendResumeRpcImpl;
import com.db.chaomaxs.positionservice.rpc.recommend.facade.api.RecommendResumeApi;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeCreateReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeRespDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeUpdateReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumeListQueryReqDTO;
import com.db.chaomaxs.positionservice.rpc.recommend.dto.RecommendResumePageReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 推荐人才简历
 *
 * @author xiaofeng
 * @date 2021-03-29 17:09:31
 */
@RestController
public class RecommendResumeRpcController implements RecommendResumeApi {

	@Autowired
	private RecommendResumeRpcImpl recommendResumeRpc;

	@Override
	public BaseResponse save(@RequestBody RecommendResumeCreateReqDTO createReqDTO) {
		return recommendResumeRpc.save(createReqDTO);
	}

	@Override
	public BaseResponse update(@RequestBody RecommendResumeUpdateReqDTO updateReqDTO) {
		return recommendResumeRpc.update(updateReqDTO);
	}

	@Override
	public BaseResponse remove(@PathVariable("id") Long id) {
		return recommendResumeRpc.remove(id);
	}

	@Override
	public ObjectRestResponse<RecommendResumeRespDTO> getRecommendResumeById(@PathVariable("id") Long id) {
		return recommendResumeRpc.getRecommendResumeById(id);
	}

	@Override
	public ObjectRestResponse<List<RecommendResumeRespDTO>> listRecommendResumes(@RequestBody RecommendResumeListQueryReqDTO listQuery) {
		return recommendResumeRpc.listRecommendResumes(listQuery);
	}

	@Override
	public TableResultResponse<RecommendResumeRespDTO> page(@RequestBody RecommendResumePageReqDTO pageReqDTO) {
		return recommendResumeRpc.page(pageReqDTO);
	}
}
