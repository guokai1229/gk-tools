package top.guokaicn.tools.lang.page;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guokai
 * @date 2021/9/2 14:41
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
}
