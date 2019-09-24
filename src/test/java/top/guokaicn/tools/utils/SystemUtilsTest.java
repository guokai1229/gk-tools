package top.guokaicn.tools.utils;


import org.junit.Test;


public class SystemUtilsTest
{
	@Test
	public void getUserDir()
	{
		System.out.println(SystemUtils.getUserDir());
	}

	@Test
	public void getUserName()
	{
		System.out.println(SystemUtils.getUserName());
	}

	@Test
	public void getUserHome()
	{
		System.out.println(SystemUtils.getUserHome());
	}

	@Test
	public void getJavaJreHome()
	{
		System.out.println(SystemUtils.getJavaJreHome());
	}

	@Test
	public void getOsName()
	{
		System.out.println(SystemUtils.getOsName());
	}

	@Test
	public void getOsVersion()
	{
		System.out.println(SystemUtils.getOsVersion());
	}

	@Test
	public void getJavaVersion()
	{
		System.out.println(SystemUtils.getJavaVersion());
	}

	@Test
	public void getClassPath()
	{
		System.out.println(SystemUtils.getClassPath());
	}

	@Test
	public void getPathSeparator()
	{
		System.out.println(SystemUtils.getPathSeparator());
	}

	@Test
	public void getFileSeparator()
	{
		System.out.println(SystemUtils.getFileSeparator());
	}

	@Test
	public void joinFileSeparator()
	{
		String path = SystemUtils.joinFileSeparator("c:","system","windows");

		System.out.println(path);
	}

	@Test
	public void getFileEncoding()
	{
		System.out.println(SystemUtils.getFileEncoding());
	}

	@Test
	public void getSystemLineSeparator()
	{
		System.out.println(SystemUtils.getSystemLineSeparator());
	}

	@Test
	public void getSystemCharset()
	{
		System.out.println(SystemUtils.getSystemCharset());
	}

	@Test
	public void getHostName()
	{
		System.out.println(SystemUtils.getHostName());
	}

	@Test
	public void getHostIP()
	{
		System.out.println(SystemUtils.getHostIP());
	}

}
