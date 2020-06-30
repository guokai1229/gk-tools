package top.guokaicn.tools.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils
{
    /**
     * map转换为bean对象
     * @param map 数据
     * @param clazz class名称
     * @param <T> 对象
     * @return 数据
     */
    public static <T> T mapToBean(Map<String,Object> map, Class<T> clazz)
    {
        AssertUtils.notNull(map, "map is null");

        AssertUtils.notNull(clazz, "class is null");

        T bean = null;

        try
        {
            bean = clazz.newInstance();

            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors)
            {
                String propertyName = property.getName();

                Object value = map.get(propertyName);

                if(value != null)
                {
                    Method setter = property.getWriteMethod();

                    Class<?> paramtypes = setter.getParameterTypes()[0];

                    if(value.getClass().equals(paramtypes))
                    {
                        setter.invoke(bean, value);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return bean;
    }

    /**
     * bean转换为map对象
     * @param obj 对象
     * @param <T> 对象
     * @return map对象
     */
    public static <T> Map<String,Object> beanToMap(T obj)
    {
        AssertUtils.notNull(obj, "bean is null");

        Map<String,Object> result = new HashMap<>();

        try
        {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());

            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors)
            {
                String propertyName = property.getName();

                if (!propertyName.equals("class"))
                {
                    Method getter = property.getReadMethod();

                    Object value = getter.invoke(obj);

                    result.put(propertyName,value);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }
}
