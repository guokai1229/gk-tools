package top.guokaicn.tools.lang.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现树形接口的通用对象，可以进行普通使用
 */
public class Tree<T> implements TreeNode
{
    private String id;

    private String parentId;

    private String name;

    private Integer sort;

    private List<TreeNode> children;

    private T data;

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String getParentId()
    {
        return parentId;
    }

    @Override
    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public Integer getSort()
    {
        return sort;
    }

    @Override
    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    @Override
    public List<TreeNode> getChildren()
    {
        return children;
    }

    @Override
    public void setChildren(List<TreeNode> children)
    {
        this.children = children;
    }

    @Override
    public void addChild(TreeNode child)
    {
        if(children == null)
        {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    @Override
    public TreeNode findChildById(String id)
    {
        TreeNode treeNode = null;

        if(children != null)
        {
            for (TreeNode node : children)
            {
                if(node.getId().equals(id))
                {
                    treeNode = node;
                    break;
                }
            }
        }

        return treeNode;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
}
