package top.guokaicn.tools.utils;

import org.junit.Test;
import top.guokaicn.tools.handler.ConfigHandler;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassUtilsTest
{
	static class AlarmRecord{
		
		private String fp0;

		
		private String fp1;

		
		private String fp2;

		
		private String fp3;

		
		private String c_fp0;

		
		private String c_fp1;

		
		private String c_fp2;

		
		private String c_fp3;

		
		private String active_status;

		
		private String event_time;

		
		private String cancel_time;

		
		private String standard_alarm_id;

		
		private String business_msg;

		
		private String city_name;

		
		private String region_name;

		
		private String rru_nums;

		
		private String power_off_info;

		
		private String ol_no;

		public String getFp0()
		{
			return fp0;
		}

		public void setFp0(String fp0)
		{
			this.fp0 = fp0;
		}

		public String getFp1()
		{
			return fp1;
		}

		public void setFp1(String fp1)
		{
			this.fp1 = fp1;
		}

		public String getFp2()
		{
			return fp2;
		}

		public void setFp2(String fp2)
		{
			this.fp2 = fp2;
		}

		public String getFp3()
		{
			return fp3;
		}

		public void setFp3(String fp3)
		{
			this.fp3 = fp3;
		}

		public String getC_fp0()
		{
			return c_fp0;
		}

		public void setC_fp0(String c_fp0)
		{
			this.c_fp0 = c_fp0;
		}

		public String getC_fp1()
		{
			return c_fp1;
		}

		public void setC_fp1(String c_fp1)
		{
			this.c_fp1 = c_fp1;
		}

		public String getC_fp2()
		{
			return c_fp2;
		}

		public void setC_fp2(String c_fp2)
		{
			this.c_fp2 = c_fp2;
		}

		public String getC_fp3()
		{
			return c_fp3;
		}

		public void setC_fp3(String c_fp3)
		{
			this.c_fp3 = c_fp3;
		}

		public String getActive_status()
		{
			return active_status;
		}

		public void setActive_status(String active_status)
		{
			this.active_status = active_status;
		}

		public String getEvent_time()
		{
			return event_time;
		}

		public void setEvent_time(String event_time)
		{
			this.event_time = event_time;
		}

		public String getCancel_time()
		{
			return cancel_time;
		}

		public void setCancel_time(String cancel_time)
		{
			this.cancel_time = cancel_time;
		}

		public String getStandard_alarm_id()
		{
			return standard_alarm_id;
		}

		public void setStandard_alarm_id(String standard_alarm_id)
		{
			this.standard_alarm_id = standard_alarm_id;
		}

		public String getBusiness_msg()
		{
			return business_msg;
		}

		public void setBusiness_msg(String business_msg)
		{
			this.business_msg = business_msg;
		}

		public String getCity_name()
		{
			return city_name;
		}

		public void setCity_name(String city_name)
		{
			this.city_name = city_name;
		}

		public String getRegion_name()
		{
			return region_name;
		}

		public void setRegion_name(String region_name)
		{
			this.region_name = region_name;
		}

		public String getRru_nums()
		{
			return rru_nums;
		}

		public void setRru_nums(String rru_nums)
		{
			this.rru_nums = rru_nums;
		}

		public String getPower_off_info()
		{
			return power_off_info;
		}

		public void setPower_off_info(String power_off_info)
		{
			this.power_off_info = power_off_info;
		}

		public String getOl_no()
		{
			return ol_no;
		}

		public void setOl_no(String ol_no)
		{
			this.ol_no = ol_no;
		}
	}

	@Test
	public void mapToBean()
	{
		Map<String,Object> data = new HashMap<>();

		data.put("fp0","123123123");

		data.put("fp1","2222222222");

		data.put("fp2","3333333333");

		data.put("fp3","4444444444");

		data.put("c_fp0","4444444444");

		data.put("c_fp1","4444444444");

		data.put("c_fp2","4444444444");

		data.put("c_fp3","4444444444");

		AlarmRecord alarmRecord= ClassUtils.mapToBean(data,AlarmRecord.class);

		System.out.println(alarmRecord);
	}

	@Test
	public void newInstance()
	{
		ClassUtils classa = ClassUtils.newInstance("top.guokaicn.tools.utils.ClassUtils");

		System.out.println(classa);
	}

	@Test
	public void testNewInstance()
	{
		ClassUtils classa = ClassUtils.newInstance(ClassUtils.class);

		System.out.println(classa);
	}

	@Test
	public void testNewInstance1()
	{
		String path = this.getClass().getResource("/").getFile();

		ConfigHandler config = ClassUtils.newInstance(ConfigHandler.class,path+"\\config.properties");

		System.out.println(config);
	}

	@Test
	public void findMethod()
	{
		Method me = ClassUtils.findMethod(ConfigHandler.class,"getString",String.class);

		System.out.println(me);
	}


	@Test
	public void loadClass()
	{
		Class classa = ClassUtils.loadClass("top.guokaicn.tools.utils.ClassUtils");

		System.out.println(classa);
	}

	@Test
	public void testLoadClass()
	{
		Class classa = ClassUtils.loadClass("top.guokaicn.tools.utils.ClassUtils",false);

		System.out.println(classa);
	}

	@Test
	public void getClasses()
	{
		ClassUtils a1 = new ClassUtils();

		FileUtils a2 = new FileUtils();

		Class[] result = ClassUtils.getClasses(a1,a2);

		System.out.println(result);
	}

}