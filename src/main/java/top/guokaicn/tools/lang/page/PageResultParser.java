package top.guokaicn.tools.lang.page;

/**
 * 分页数据解析接口
 * @param <E> 源数据
 * @param <T> 目标数据
 */
@FunctionalInterface
public interface PageResultParser<E,T>
{
	void parse(E e, T t);
}
