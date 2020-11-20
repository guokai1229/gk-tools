package top.guokaicn.tools.lang.tree;

/**
 * 树形对象的解析接口，通常使用此接口的实现方法来进行节点转换
 * @param <T>
 */
@FunctionalInterface
public interface TreeNodeParser<T>
{
	/**
	 * 解析普通对象到树形对象
	 * @param object 普通对象
	 * @param treeNode 树形对象
	 */
	void parse(T object, TreeNode treeNode);
}
