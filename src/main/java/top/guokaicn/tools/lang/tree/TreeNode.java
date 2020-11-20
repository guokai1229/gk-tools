package top.guokaicn.tools.lang.tree;

import java.io.Serializable;
import java.util.List;

/**
 * 树形数据节点类型接口
 */
public interface TreeNode extends Comparable<TreeNode>, Serializable
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

    @Override
    default int compareTo(TreeNode node)
    {
        final Integer weight = this.getSort() == null ? 0:this.getSort();

        final Integer weightOther = node.getSort() == null ? 0:node.getSort();

        return weight.compareTo(weightOther);
    }
}
