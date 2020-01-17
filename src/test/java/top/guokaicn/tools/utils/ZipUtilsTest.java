package top.guokaicn.tools.utils;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ZipUtilsTest
{

	@Test
	public void zip()
	{
		try
		{
			String path = this.getClass().getResource("/").getFile();

			FileUtils.createFolder(path+"\\test\\测试\\11\\xcf");

			String result = ZipUtils.zip(path+"\\test",path,"11");

			System.out.println(result);
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
			String path = this.getClass().getResource("/").getFile();

			File file = FileUtils.createFile(path+"\\test\\测试\\11\\xcf.txt","tsetsetsetstsaetasetaset中文中文");

			FileInputStream file_in = new FileInputStream(file);

			String result = ZipUtils.zip(file_in,"xcf.txt",path,"11");

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
			String path = this.getClass().getResource("/").getFile();

			File file = FileUtils.createFile(path+"\\test\\测试\\11\\xcf.txt","tsetsetsetstsaetasetaset中文中文");

			FileInputStream file_in = new FileInputStream(file);

			FileInputStream file_in2 = new FileInputStream(file);

			File zipFile = new File(path + SystemUtils.getFileSeparator() + "11.zip");

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

			FileUtils.createFile(path+"\\test\\测试\\xcf22.txt","tsetsetsetstsaetasetaset中文中文");

			FileUtils.createFile(path+"\\test\\测试\\11\\xcf.txt","tsetsetsetstsaetasetaset中文中文");

			String result = ZipUtils.zip(path+"\\test",path,"11");

			System.out.println(result);

			result = ZipUtils.unZip(result,path+"\\unzip");

			System.out.println(result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}