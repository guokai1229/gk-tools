package top.guokaicn.tools.lang.page;

@FunctionalInterface
public interface PageResultParser<E,T>
{
	void parse(E e, T t);
}
