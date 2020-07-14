package top.guokaicn.tools.lang.tree;

import java.util.List;

/**
 * 树形数据节点类型接口
 */
public interface TreeNode
{
    String getId();

    void setId(String id);

    String getParentId();

    void setParentId(String parentId);

    String getName();

    void setName(String name);

    Integer getSort();

    void setSort(Integer sort);

    List<TreeNode> getChildren();

    void setChildren(List<TreeNode> children);

    void addChild(TreeNode child);

    TreeNode findChildById(String id);
}
