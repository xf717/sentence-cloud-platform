package com.db.chaomaxs.managementweb.manager.content;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.util.TreeUtil;
import com.db.chaomaxs.common.framework.vo.TreeNode;
import com.db.chaomaxs.systemservice.constant.CommonConstant;
import com.db.chaomaxs.managementweb.controller.content.dto.IndustryTypeAddDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.IndustryTypeDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.IndustryTypePageDTO;
import com.db.chaomaxs.managementweb.controller.content.dto.IndustryTypeUpdateDTO;
import com.db.chaomaxs.managementweb.controller.content.vo.IndustryTypeTreeVO;
import com.db.chaomaxs.managementweb.controller.content.vo.IndustryTypeVO;
import com.db.chaomaxs.managementweb.convert.content.IndustryTypeConvert;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.dto.IndustryTypeTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.content.facade.IndustryTypeRpcFacade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * IndustryTypeManager
 *
 * @author xiaofeng
 * @date 2021-03-29 18:03:04
 */
@Service
@Validated
public class IndustryTypeManager {

  @Autowired
  private IndustryTypeRpcFacade industryTypeRpcFacade;

  /**
   * 添加数据
   *
   * @param industryTypeAddDTO 添加参数
   * @return
   */
  public int save(IndustryTypeAddDTO industryTypeAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = industryTypeRpcFacade
        .save(IndustryTypeConvert.INSTANCE.convert(industryTypeAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param industryTypeUpdateDTO 更新参数
   * @return
   */
  public int update(IndustryTypeUpdateDTO industryTypeUpdateDTO) {
    BaseResponse baseResponse = industryTypeRpcFacade
        .update(IndustryTypeConvert.INSTANCE.convert(industryTypeUpdateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = industryTypeRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public IndustryTypeVO getIndustryTypeById(Long id) {
    ObjectRestResponse<IndustryTypeRespDTO> objectRestResponse = industryTypeRpcFacade
        .getIndustryTypeById(
            id);
    objectRestResponse.checkError();
    return IndustryTypeConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param industryTypeDTO 查询参数
   * @return
   */
  public List<IndustryTypeTreeVO> listIndustryTypes(IndustryTypeDTO industryTypeDTO) {
    ObjectRestResponse<List<IndustryTypeRespDTO>> objectRestResponse = industryTypeRpcFacade
        .listIndustryTypes(
            IndustryTypeConvert.INSTANCE.convert(industryTypeDTO));
    objectRestResponse.checkError();
    List<IndustryTypeTreeRespDTO> industryTypeTreeRespDTOS = initTree(objectRestResponse.getData());
    return convertTree(industryTypeTreeRespDTOS);
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<IndustryTypeVO> pageIndustryType(IndustryTypePageDTO pageReqDTO) {
    TableResultResponse<IndustryTypeRespDTO> tableResultResponse = industryTypeRpcFacade
        .page(IndustryTypeConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return IndustryTypeConvert.INSTANCE.convert(tableResultResponse);
  }




  /**
   * 初始化树
   *
   * @param list
   * @return
   */
  public List<IndustryTypeTreeRespDTO> initTree(List<IndustryTypeRespDTO> list) {
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    List<IndustryTypeTreeRespDTO> industryTypeTreeRespDTOS = new ArrayList<>();
    IndustryTypeTreeRespDTO node = null;
    for (IndustryTypeRespDTO respDTO : list) {
      node = new IndustryTypeTreeRespDTO();
      node.setId(respDTO.getId());
      node.setParentId(respDTO.getParentId());
      node.setTypeName(respDTO.getTypeName());
      industryTypeTreeRespDTOS.add(node);
    }

    return TreeUtil
        .buildByRecursive(industryTypeTreeRespDTOS,
            CommonConstant.INDUSTRY_TYPE_TREE_TOP_PARENT_ID);
  }

  /**
   * 转换树对象
   *
   * @param list
   * @return
   */
  public List<IndustryTypeTreeVO> convertTree(List<IndustryTypeTreeRespDTO> list) {
    List<IndustryTypeTreeVO> trees = new ArrayList<>();
    for (IndustryTypeTreeRespDTO treeNode : list) {
      trees.add(convertChildren(treeNode));
    }
    return trees;
  }

  /**
   * 转换子类对象
   *
   * @param treeNode
   * @return
   */
  public IndustryTypeTreeVO convertChildren(IndustryTypeTreeRespDTO treeNode) {
    IndustryTypeTreeVO industryTypeTreeVO = new IndustryTypeTreeVO();
    industryTypeTreeVO.setId(treeNode.getId());
    industryTypeTreeVO.setParentId(treeNode.getParentId());
    industryTypeTreeVO.setTypeName(treeNode.getTypeName());
    List<IndustryTypeTreeVO> children = industryTypeTreeVO.getChildren();
    if (!CollectionUtils.isEmpty(treeNode.getChildren())) {
      for (TreeNode node : treeNode.getChildren()) {
        IndustryTypeTreeRespDTO industryTypeTreeRespDTO = (IndustryTypeTreeRespDTO) node;
        if (null == children) {
          children = new ArrayList<>();
        }
        children.add(convertChildren(industryTypeTreeRespDTO));
      }
    } else {
      children = new ArrayList<>();
    }
    industryTypeTreeVO.setChildren(children);
    return industryTypeTreeVO;
  }


}
