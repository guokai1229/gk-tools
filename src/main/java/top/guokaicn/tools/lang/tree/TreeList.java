package top.guokaicn.tools.lang.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 树形列表对象，根据TreeNode接口数据，生成根节点的TreeNode列表数据
 */
public class TreeList
{
    private final List<TreeNode> data;

    /**
     * 构造函数默认根节点id为0
     * @param source 原始数据
     */
    public TreeList(List<? extends TreeNode> source)
    {
        this(source,"0");
    }

    /**
     * 构造函数
     * @param source 原始数据
     * @param parentId 根节点id
     */
    public TreeList(List<? extends TreeNode> source,String parentId)
    {
        data = new ArrayList<>();

        //先查找到根节点,然后添加根节点的子节点
        for(TreeNode node : source)
        {
            if(node.getParentId().equals(parentId))
            {
                data.add(node);
                addChlid(source,node);
                sortList(node.getChildren());
            }
        }

        sortList(data);
    }

    /**
     * 遍历并添加子节点
     * @param source 原始数据
     * @param parent 父节点对象
     */
    private void addChlid(List<? extends TreeNode> source,TreeNode parent)
    {
        for(TreeNode node : source)
        {
            if(node.getParentId().equals(parent.getId()))
            {
                parent.addChild(node);
                addChlid(source, node);
                sortList(node.getChildren());
            }
        }
    }

    /**
     * 进行数据的排序
     * @param list 数据
     */
    private void sortList(List<TreeNode> list)
    {
        if(list != null)
        {
            Collections.sort(list,new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode o1, TreeNode o2)
                {
                    int o1n = o1.getSort() == null ? 0 : o1.getSort();
                    int o2n = o2.getSort() == null ? 0 : o2.getSort();

                    return o1n - o2n;
                }
            });
        }
    }

    public List<TreeNode> getData()
    {
        return data;
    }
}
