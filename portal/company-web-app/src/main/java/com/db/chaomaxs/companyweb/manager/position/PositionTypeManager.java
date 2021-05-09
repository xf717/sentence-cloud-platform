package com.db.chaomaxs.companyweb.manager.position;


import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.common.framework.util.TreeUtil;
import com.db.chaomaxs.common.framework.vo.TreeNode;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypeAddDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypeDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypePageDTO;
import com.db.chaomaxs.companyweb.controller.position.dto.PositionTypeUpdateDTO;
import com.db.chaomaxs.companyweb.controller.position.vo.PositionTypeTreeVO;
import com.db.chaomaxs.companyweb.controller.position.vo.PositionTypeVO;
import com.db.chaomaxs.companyweb.convert.position.PositionTypeConvert;
import com.db.chaomaxs.positionservice.constant.CommonConstants;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.dto.PositionTypeTreeRespDTO;
import com.db.chaomaxs.positionservice.rpc.positiontype.facade.PositionTypeRpcFacade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PositionTypeManager
 *
 * @author ding
 * @date 2021-04-06 17:45:09
 */
@Service
@Validated
public class PositionTypeManager {

  @Autowired
  private PositionTypeRpcFacade positionTypeRpcFacade;

  /**
   * 添加数据
   *
   * @param positionTypeAddDTO 添加参数
   * @return
   */
  public int save(PositionTypeAddDTO positionTypeAddDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = positionTypeRpcFacade
        .save(PositionTypeConvert.INSTANCE.convert(positionTypeAddDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param positionTypeUpdateDTO 更新参数
   * @return
   */
  public int update(PositionTypeUpdateDTO positionTypeUpdateDTO) {
    BaseResponse baseResponse = positionTypeRpcFacade
        .update(PositionTypeConvert.INSTANCE.convert(positionTypeUpdateDTO));
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
    BaseResponse baseResponse = positionTypeRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public PositionTypeVO getPositionTypeById(Long id) {
    ObjectRestResponse<PositionTypeRespDTO> objectRestResponse = positionTypeRpcFacade
        .getPositionTypeById(
            id);
    objectRestResponse.checkError();
    return PositionTypeConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param positionTypeDTO 查询参数
   * @return
   */
  public List<PositionTypeTreeVO> listPositionTypes(PositionTypeDTO positionTypeDTO) {
    ObjectRestResponse<List<PositionTypeRespDTO>> objectRestResponse = positionTypeRpcFacade
        .listPositionTypes(
            PositionTypeConvert.INSTANCE.convert(positionTypeDTO));
    objectRestResponse.checkError();
    List<PositionTypeTreeRespDTO> positionTypeTreeRespDTOS = initTree(objectRestResponse.getData());
    return convertTree(positionTypeTreeRespDTOS);
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<PositionTypeVO> pagePositionType(PositionTypePageDTO pageReqDTO) {
    TableResultResponse<PositionTypeRespDTO> tableResultResponse = positionTypeRpcFacade
        .page(PositionTypeConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return PositionTypeConvert.INSTANCE.convert(tableResultResponse);
  }

  /**
   * 根据参数查询所有可显示分类（树型）
   *
   * @param positionTypeDTO 查询参数
   * @return
   */
  public List<PositionTypeTreeVO> listDisplayPositionType(PositionTypeDTO positionTypeDTO) {
    ObjectRestResponse<List<PositionTypeRespDTO>> objectRestResponse = positionTypeRpcFacade
        .listDisplayPositionType(
            PositionTypeConvert.INSTANCE.convert(positionTypeDTO));
    objectRestResponse.checkError();
    List<PositionTypeTreeRespDTO> positionTypeTreeRespDTOS = initTree(objectRestResponse.getData());
    return convertTree(positionTypeTreeRespDTOS);

  }


  /**
   * 根据parentId查询数据,不分页
   *
   * @param parentId 查询参数
   * @return
   */
  public List<PositionTypeVO> listPositionTypeByParentId(Long parentId) {
    ObjectRestResponse<List<PositionTypeRespDTO>> objectRestResponse = positionTypeRpcFacade
        .listPositionTypeByParentId(parentId);
    objectRestResponse.checkError();
    return PositionTypeConvert.INSTANCE.convertList(objectRestResponse.getData());
  }


  /**
   * 初始化树
   *
   * @param list
   * @return
   */
  public List<PositionTypeTreeRespDTO> initTree(List<PositionTypeRespDTO> list) {
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }

    List<PositionTypeTreeRespDTO> positionTypeTreeRespDTOS = new ArrayList<>();
    PositionTypeTreeRespDTO node = null;
    for (PositionTypeRespDTO respDTO : list) {
      node = new PositionTypeTreeRespDTO();
      node.setId(respDTO.getId());
      node.setParentId(respDTO.getParentId());
      node.setTypeName(respDTO.getTypeName());
      positionTypeTreeRespDTOS.add(node);
    }
    return TreeUtil
        .buildByRecursive(positionTypeTreeRespDTOS, CommonConstants.TREE_TOP_PARENT_ID);
  }

  /**
   * 转换树对象
   *
   * @param list
   * @return
   */
  public List<PositionTypeTreeVO> convertTree(List<PositionTypeTreeRespDTO> list) {
    List<PositionTypeTreeVO> trees = new ArrayList<>();
    for (PositionTypeTreeRespDTO treeNode : list) {
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
  public PositionTypeTreeVO convertChildren(PositionTypeTreeRespDTO treeNode) {
    PositionTypeTreeVO positionTypeTreeVO = new PositionTypeTreeVO();
    positionTypeTreeVO.setId(treeNode.getId());
    positionTypeTreeVO.setParentId(treeNode.getParentId());
    positionTypeTreeVO.setTypeName(treeNode.getTypeName());
    List<PositionTypeTreeVO> children = positionTypeTreeVO.getChildren();
    if (!CollectionUtils.isEmpty(treeNode.getChildren())) {
      for (TreeNode node : treeNode.getChildren()) {
        PositionTypeTreeRespDTO positionTypeTreeRespDTO = (PositionTypeTreeRespDTO) node;
        if (null == children) {
          children = new ArrayList<>();
        }
        children.add(convertChildren(positionTypeTreeRespDTO));
      }
    } else {
      children = new ArrayList<>();
    }
    positionTypeTreeVO.setChildren(children);
    return positionTypeTreeVO;
  }
}
