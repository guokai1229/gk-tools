package top.guokaicn.tools.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BeanUtilsTest
{

    @Test
    public void mapToBean()
    {
        Map<String,Object> data = new HashMap<>();

        data.put("test0","123123123");

        data.put("test1","2222222222");

        data.put("test2","3333333333");

        data.put("test3","4444444444");

        data.put("ctest0","4444444444");

        data.put("ctest1","4444444444");

        data.put("ctest2","4444444444");

        data.put("ctest3","4444444444");

        TestRecord alarmRecord= BeanUtils.mapToBean(data, TestRecord.class);

        System.out.println(alarmRecord);
    }

    @Test
    public void beanToMap()
    {
        Map<String,Object> data = new HashMap<>();

        data.put("test0","123123123");

        data.put("test1","2222222222");

        data.put("test2","3333333333");

        data.put("test3","4444444444");

        data.put("ctest0","4444444444");

        data.put("ctest1","4444444444");

        data.put("ctest2","4444444444");

        data.put("ctest3","4444444444");

        TestRecord alarmRecord= BeanUtils.mapToBean(data, TestRecord.class);

        Map<String,Object> result = BeanUtils.beanToMap(alarmRecord);

        System.out.println(result);
    }
}