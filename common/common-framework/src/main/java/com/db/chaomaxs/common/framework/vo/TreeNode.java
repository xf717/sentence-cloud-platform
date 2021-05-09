package com.db.chaomaxs.common.framework.vo;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author xiaofeng
 * @date 2017/6/12
 */
@Data
public class TreeNode {
	protected Long id;
	protected Long parentId;

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	List<TreeNode> children = new ArrayList<TreeNode>();



	public void add(TreeNode node) {
		children.add(node);
	}
}
