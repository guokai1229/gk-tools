package top.guokaicn.tools.utils;

import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.junit.Assert.*;

public class FileUtilsTest
{

	@Test
	public void createFolder()
	{
		boolean folderPath = FileUtils.createFolder("d:\\test\\测试\\11\\xcf");

		System.out.println(folderPath);
	}

	@Test
	public void createFile()
	{
		File file = FileUtils.createFile("d:\\test\\测试\\11\\xcf.txt");

		System.out.println(file.getName());
	}

	@Test
	public void testCreateFile()
	{
		File file = FileUtils.createFile("d:\\test\\测试\\11\\xcf.txt","tsetsetsetstsaetasetaset中文中文");

		System.out.println(file.getName());
	}

	@Test
	public void testCreateFile1()
	{
		File file = FileUtils.createFile("d:\\test\\测试\\11\\xcf.txt","tsetsetsetstsaetasetaset中文中文","GBK");

		System.out.println(file.getName());
	}

	@Test
	public void getFileWriter()
	{
		Writer writer = FileUtils.getFileWriter("d:\\test\\测试\\11\\xcf.txt",true);

		try
		{
			writer.write("中文中文");
			writer.flush();
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	@Test
	public void getReader()
	{
		BufferedReader reader = FileUtils.getFileReader("d:\\test\\测试\\11\\xcf.txt");

		while(true)
		{
			try
			{
				String line  = reader.readLine();

				if (line == null) break;

				System.out.println(line);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}

	}

	@Test
	public void getTestReader()
	{
		BufferedReader reader = FileUtils.getFileReader("d:\\test\\测试\\11\\xcf.txt","gbk");

		while(true)
		{
			try
			{
				String line  = reader.readLine();

				if (line == null) break;

				System.out.println(line);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}
	}

	@Test
	public void getTestReader1()
	{
		File file = new File("d:\\test\\测试\\11\\xcf.txt");

		BufferedReader reader = FileUtils.getFileReader(file,"gbk");

		while(true)
		{
			try
			{
				String line  = reader.readLine();

				if (line == null) break;

				System.out.println(line);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}
	}

	@Test
	public void getFileList()
	{
		List<File> file_list = FileUtils.getFileList("d:\\test\\测试\\11");

		System.out.println(file_list);
	}

	@Test
	public void delFile()
	{
		boolean folderPath = FileUtils.deleteFile("d:\\test\\测试\\11\\xcf");

		System.out.println(folderPath);
	}

	@Test
	public void delFolder()
	{
		boolean folderPath = FileUtils.deleteFolder("d:\\test\\测试\\11");

		System.out.println(folderPath);
	}

	@Test
	public void delAllFile()
	{
		boolean folderPath = FileUtils.deleteAllFile("d:\\test\\测试");

		System.out.println(folderPath);
	}

	@Test
	public void copyFile()
	{
		FileUtils.copyFile("d:\\test\\测试\\11\\xcf.txt","d:\\test\\测试\\11\\xcf1.txt");
	}

	@Test
	public void copyFolder()
	{
		FileUtils.copyFolder("d:\\test\\测试\\11","d:\\test\\测试\\22");
	}

	@Test
	public void moveFile()
	{
		FileUtils.moveFile("d:\\test\\测试\\11\\xcf1.txt","d:\\test\\测试\\11\\xcf2.txt");
	}

	@Test
	public void moveFolder()
	{
		FileUtils.moveFolder("d:\\test\\测试\\11","d:\\test\\测试\\33");
	}

	@Test
	public void renameFile()
	{
		boolean result = FileUtils.renameFile("d:\\test\\测试\\11\\xcf1.txt","xcf4.txt");

		System.out.println(result);
	}


	@Test
	public void getRelativeRootPath()
	{
		String result = FileUtils.getRelativeRootPath("d:\\test\\测试\\11\\xcf1.txt","d:\\test");

		System.out.println(result);
	}

	@Test
	public void readBytes()
	{
		byte[] data = FileUtils.getFileBytes("d:\\test\\测试\\11\\xcf1.txt");

		System.out.println(new String(data));
	}


	@Test
	public void getFilePrefix()
	{
		String result = FileUtils.getFilePrefix("123123.xcvxv.txt");

		System.out.println(result);
	}

	@Test
	public void getFilePostfix()
	{
		String result = FileUtils.getFilePostfix("123123.xcvxv.txt");

		System.out.println(result);
	}

	@Test
	public void removePrefix()
	{
		String result = FileUtils.removePrefix("123123.xcvxv.txt","123");

		System.out.println(result);
	}
}