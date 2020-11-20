package top.guokaicn.tools.lang.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 树形对象操作工具类
 */
public class TreeUtils
{
	/**
	 * 转换TreeNode的数据为树形结构并且排序
	 * @param source 源数据
	 * @param rootId 根节点值
	 * @return 转换完成的结构
	 */
	public static List<TreeNode> build(List<? extends TreeNode> source,String rootId)
	{
		List<TreeNode> result = new ArrayList<>();

		//先查找到根节点,然后添加根节点的子节点
		for(TreeNode node : source)
		{
			if(node.getParentId().equals(rootId))
			{
				result.add(node);
				addChild(source,node);
				if(node.getChildren() != null)
				{
					Collections.sort(node.getChildren());
				}
			}
		}

		return result;
	}

	/**
	 * 通过节点解析器来进行普通对象转换操作
	 * @param source 源数据
	 * @param rootId 根节点值
	 * @param nodeParser 节点解析器
	 * @param <T> 普通对象
	 * @return 转换完成的结构
	 */
	public static <T> List<TreeNode> build(List<T> source,String rootId,TreeNodeParser<T> nodeParser)
	{
		List<TreeNode> result = new ArrayList<>();

		for (T obj : source)
		{
			Tree<T> tree = new Tree<>();

			nodeParser.parse(obj,tree);

			tree.setData(obj);

			result.add(tree);
		}

		return build(result,rootId);
	}

	/**
	 * 遍历并添加子节点
	 * @param source 原始数据
	 * @param parent 父节点对象
	 */
	private static void addChild(List<? extends TreeNode> source,TreeNode parent)
	{
		for(TreeNode node : source)
		{
			if(node.getParentId().equals(parent.getId()))
			{
				parent.addChild(node);
				addChild(source, node);
				if(node.getChildren() != null)
				{
					Collections.sort(node.getChildren());
				}
			}
		}
	}
}
