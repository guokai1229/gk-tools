package top.guokaicn.tools.lang.page;

@FunctionalInterface
public interface PageResultItemParser<E,T>
{
	void parse(E e, T t);
}
