package top.guokaicn.tools.lang.page;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果的使用的工具类
 * @author guokai
 */
public class PageResultUtils
{
    /**
     * 创建page对象
     * @param page jpa对象
     * @param tClass 要转换的类型
     * @param <T> jpa类型
     * @param <E> 要转换的类型
     * @return 结果
     */
    public static <T, E> PageResult<T> createPage(Page<E> page, Class<T> tClass)
    {
        return createPage(page,tClass,null);
    }

    /**
     *
     * 创建page对象
     * @param page jpa对象
     * @param tClass 要转换的类型
     * @param parser 转换对象
     * @param <T> jpa类型
     * @param <E> 要转换的类型
     * @return 结果
     */
    public static <T, E> PageResult<T> createPage(Page<E> page, Class<T> tClass, PageResultParser<E,T> parser)
    {
        PageResult<T> result = new PageResult<T>();

        try
        {
            List<T> rows = new ArrayList<>();

            result.setTotal(page.getTotalElements());

            result.setTotalPage(page.getTotalPages());

            result.setPageSize(page.getNumber() + 1);

            result.setPageSize(page.getSize());

            for(E o : page.getContent())
            {
                T t = tClass.newInstance();

                BeanUtils.copyProperties(o, t);

                if(parser != null)
                {
                    parser.parse(o,t);
                }

                rows.add(t);
            }

            result.setRows(rows);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 创建一个空数据对象
     * @param <T> 类型
     * @return 结果
     */
    public static <T> PageResult<T> emptyData()
    {
        PageResult<T> result = new PageResult<>();

        result.setRows(new ArrayList<>());

        result.setTotal(0);

        result.setTotalPage(0);

        result.setPageIndex(0);

        result.setPageSize(10);

        return result;
    }

    /**
     * 创建一个空数据对象
     * @param data 数据
     * @param total 总条数
     * @param pageIndex 当前页
     * @param pageSize 每页数量
     * @param <T> 类型
     * @return 结果
     */
    public static <T> PageResult<T> createPage(List<T> data, long total, int pageIndex, int pageSize)
    {
        PageResult<T> result = new PageResult<>();

        result.setRows(data);

        result.setTotal(total);

        result.setPageIndex(pageIndex);

        result.setPageSize(pageSize);

        return result;
    }
}
