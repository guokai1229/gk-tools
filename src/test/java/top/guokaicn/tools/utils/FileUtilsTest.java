package top.guokaicn.tools.utils;

import org.junit.Test;

import java.io.*;
import java.util.List;


public class FileUtilsTest
{

	@Test
	public void createFolder()
	{
		String path = this.getClass().getResource("/").getFile();

		boolean folderPath = FileUtils.createFolder(path+"\\test\\测试\\11\\xcf");

		System.out.println(folderPath);
	}

	@Test
	public void createFile()
	{
		String path = this.getClass().getResource("/").getFile();

		File file = FileUtils.createFile(path+"\\test\\测试\\11\\xcf.txt");

		System.out.println(file.getName());
	}

	@Test
	public void testCreateFile()
	{
		String path = this.getClass().getResource("/").getFile();

		File file = FileUtils.createFile(path+"\\test\\测试\\11\\xcf.txt","tsetsetsetstsaetasetaset中文中文");

		System.out.println(file.getName());
	}

	@Test
	public void testCreateFile1()
	{
		String path = this.getClass().getResource("/").getFile();

		File file = FileUtils.createFile(path+"\\test\\测试\\11\\xcf.txt","tsetsetsetstsaetasetaset中文中文","GBK");

		System.out.println(file.getName());
	}

	@Test
	public void getFileWriter()
	{
		String path = this.getClass().getResource("/").getFile();

		Writer writer = FileUtils.getFileWriter(path+"\\testwriter.txt",true);

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
		String path = this.getClass().getResource("/").getFile();

		BufferedReader reader = FileUtils.getFileReader(path+"\\test.txt");

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
		String path = this.getClass().getResource("/").getFile();

		BufferedReader reader = FileUtils.getFileReader(path+"\\test.txt","gbk");

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
		String path = this.getClass().getResource("/").getFile();

		File file = new File(path+"\\test.txt");

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
		String path = this.getClass().getResource("/").getFile();

		List<File> file_list = FileUtils.getFileList(path);

		System.out.println(file_list);
	}

	@Test
	public void testGetFileList()
	{
		String path = this.getClass().getResource("/").getFile();

		File file = new File(path);

		List<File> file_list = FileUtils.getFileList(file);

		System.out.println(file_list);
	}

	@Test
	public void delFile()
	{
		String path = this.getClass().getResource("/").getFile();

		boolean folderPath = FileUtils.deleteFile(path+"\\test\\测试\\11\\xcf.txt");

		System.out.println(folderPath);
	}

	@Test
	public void delFolder()
	{
		String path = this.getClass().getResource("/").getFile();

		boolean folderPath = FileUtils.deleteFolder(path+"\\test\\测试\\11");

		System.out.println(folderPath);
	}

	@Test
	public void delAllFile()
	{
		String path = this.getClass().getResource("/").getFile();

		boolean folderPath = FileUtils.deleteAllFile(path+ "\\test");

		System.out.println(folderPath);
	}

	@Test
	public void copyFile()
	{
		String path = this.getClass().getResource("/").getFile();

		FileUtils.copyFile(path+"\\copy.txt",path+"\\copy1.txt");

		FileUtils.deleteFile(path+"\\copy1.txt");
	}

	@Test
	public void copyFolder()
	{
		String path = this.getClass().getResource("/").getFile();

		FileUtils.copyFolder(path+"\\copy",path+"\\copy1");

		FileUtils.deleteFolder(path+"\\copy1");
	}

	@Test
	public void moveFile()
	{
		String path = this.getClass().getResource("/").getFile();

		FileUtils.moveFile(path+"\\move.txt",path+"\\move1.txt");

		FileUtils.moveFile(path+"\\move1.txt",path+"\\move.txt");
	}

	@Test
	public void moveFolder()
	{
		String path = this.getClass().getResource("/").getFile();

		FileUtils.moveFolder(path+"\\move",path+"\\move1");

		FileUtils.moveFolder(path+"\\move1",path+"\\move");
	}

	@Test
	public void renameFile()
	{
		String path = this.getClass().getResource("/").getFile();

		boolean result = FileUtils.renameFile(path+"\\rename.txt","rename1.txt");

		System.out.println(result);

		FileUtils.renameFile(path+"\\rename1.txt","rename.txt");
	}


	@Test
	public void getRelativeRootPath()
	{
		String path = this.getClass().getResource("/").getFile();

		String result = FileUtils.getRelativeRootPath(path+"\\test\\测试\\11\\xcf1.txt",path);

		System.out.println(result);
	}

	@Test
	public void readBytes()
	{
		String path = this.getClass().getResource("/").getFile();

		byte[] data = FileUtils.getFileBytes(path+"\\test.txt");

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