package top.guokaicn.tools.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ZipUtilsTest
{
	private final String testPath = this.getClass().getResource("/").getFile() + File.separator + "ziptest";

	@Before
	public void init()
	{
		FileUtils.createFolder(testPath);
	}

	@After
	public void destory()
	{
		FileUtils.deleteFolder(testPath);
	}

	@Test
	public void zip()
	{
		try
		{
			FileUtils.createFolder(testPath+"\\测试\\11\\xcf");

			String result = ZipUtils.zip(testPath,testPath,"11");

			Assert.assertNotNull(result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void zip1()
	{
		try
		{
			File file = FileUtils.createFile(testPath+"\\测试\\22\\xcf.txt","tsetsetsetstsaetasetaset中文中文");

			FileInputStream file_in = new FileInputStream(file);

			String result = ZipUtils.zip(file_in,"xcf.txt",testPath,"22");

			System.out.println(result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void zip2()
	{
		try
		{
			File file = FileUtils.createFile(testPath+"\\测试\\33\\xcf.txt","tsetsetsetstsaetasetaset中文中文");

			FileInputStream file_in = new FileInputStream(file);

			FileInputStream file_in2 = new FileInputStream(file);

			File zipFile = new File(testPath + File.separator + "33.zip");

			Map<String, InputStream> streamMap = new HashMap<>();

			streamMap.put("1.txt",file_in);

			streamMap.put("2.txt",file_in2);

			FileOutputStream out = new FileOutputStream(zipFile);

			ZipUtils.zip(streamMap,out);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void unZip()
	{
		try
		{
			String path = this.getClass().getResource("/").getFile();

			FileUtils.createFile(testPath+"\\测试\\44\\xcf22.txt","tsetsetsetstsaetasetaset中文中文");

			FileUtils.createFile(testPath+"\\测试\\44\\11\\xcf.txt","tsetsetsetstsaetasetaset中文中文");

			String result = ZipUtils.zip(testPath+"\\测试",path,"44");

			System.out.println(result);

			result = ZipUtils.unZip(result,testPath+"\\unzip");

			System.out.println(result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}