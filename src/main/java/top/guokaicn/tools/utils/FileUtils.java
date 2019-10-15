package top.guokaicn.tools.utils;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 文件相关工具类
 *
 * @author gk
 *
 */
public class FileUtils
{
	/**
	 * 创建名称为 folderPath的文件夹
	 *
	 * @param folderPath 文件夹路径
	 * @return String
	 */
	public static boolean createFolder(String folderPath)
	{
		boolean result = true;

		try
		{
			File myFilePath = new File(folderPath);

			if (!myFilePath.exists())
			{
				org.apache.commons.io.FileUtils.forceMkdir(myFilePath);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();

			result = false;
		}

		return result;
	}

	/**
	 * 创建filePathAndName文件
	 * @param filePathAndName 文件路径及名称例如：D:\\xxx.txt"
	 * @return 文件
	 */
	public static File createFile(String filePathAndName)
	{
		File result = null;

		try
		{
			File myFilePath = new File(filePathAndName);

			boolean created = true;

			if(!myFilePath.getParentFile().exists())
			{
				created = createFolder(myFilePath.getParentFile().getPath());
			}

			if(created)
			{
				if (!myFilePath.exists())
				{
					if(myFilePath.createNewFile())
					{
						result = myFilePath;
					}
				}
				else
				{
					result = myFilePath;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 根据内容创建文件
	 * @param filePathAndName 文件路径
	 * @param content 内容
	 * @return 文件对象
	 */
	public static File createFile(String filePathAndName,String content)
	{
		return createFile(filePathAndName, content,SystemUtils.getSystemCharset());
	}

	/**
	 * 根据内容创建文件
	 * @param filePathAndName 文件路径
	 * @param content 内容
	 * @param encoding 编码
	 * @return 文件对象
	 */
	public static File createFile(String filePathAndName,String content,String encoding)
	{
		File file  = createFile(filePathAndName);

		if(file != null)
		{
			Writer writer = getFileWriter(file, encoding,false);

			if(writer != null)
			{
				try
				{
					writer.write(content);
					writer.flush();
					writer.close();

					return file;
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	/**
	 * 创建filePathAndName文件
	 *
	 * @param filePathAndName
	 *            文件路径及名称例如：D:\\xxx.txt"
	 * @param append
	 *            是否追加
	 * @return 结果
	 */
	public static BufferedWriter getFileWriter(String filePathAndName,boolean append)
	{
		try
		{
			File file = createFile(filePathAndName);

			if(file != null)
			{
				return getFileWriter(file,SystemUtils.getSystemCharset(),append);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 创建filePathAndName文件
	 *
	 * @param file
	 *            文件
	 * @param encoding
	 *            文件编码
	 * @param append
	 *            是否追加
	 * @return 结果
	 */
	public static BufferedWriter getFileWriter(File file, String encoding,boolean append)
	{
		try
		{
			if(file != null && file.exists())
			{
				return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,append), encoding));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 读取文件，返回读取文件管道对象
	 * @param filePathAndName 文件路径
	 * @return 数据
	 */
	public static BufferedReader getFileReader(String filePathAndName)
	{
		return getFileReader(filePathAndName,SystemUtils.getSystemCharset());
	}

	/**
	 * 用encoding字符格式读取文件，返回读取文件管道对象
	 * @param filePathAndName 文件路径
	 * @param encoding 编码
	 * @return 数据
	 */
	public static BufferedReader getFileReader(String filePathAndName, String encoding)
	{
		try
		{
			File file = new File(filePathAndName);

			return getFileReader(file,encoding);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用encoding字符格式读取文件，返回读取文件管道对象
	 * @param file 文件
	 * @param encoding 编码
	 * @return 结果
	 */
	public static BufferedReader getFileReader(File file, String encoding)
	{
		try
		{
			if(file != null && file.exists())
			{
				return new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 读取文件作为字节数组
	 * @param filePathAndName 文件路径
	 * @return 数据
	 */
	public static byte[] getFileBytes(String filePathAndName)
	{
		byte[] result = new byte[0];

		File file = new File(filePathAndName);

		try
		{
			if(file.exists())
			{
				result = org.apache.commons.io.FileUtils.readFileToByteArray(file);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 读取文件作为字符串
	 * @param filePathAndName 文件路径
	 * @return 数据
	 */
	public static String getFileString(String filePathAndName)
	{
		String result = null;

		File file = new File(filePathAndName);

		try
		{
			if(file.exists())
			{
				result = org.apache.commons.io.FileUtils.readFileToString(file,SystemUtils.getSystemCharset());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 读取文件作为字符串
	 * @param filePathAndName 文件路径
	 * @param encoding 字符串编码
	 * @return 数据
	 */
	public static String getFileString(String filePathAndName,String encoding)
	{
		String result = null;

		File file = new File(filePathAndName);

		try
		{
			if(file.exists())
			{
				result = org.apache.commons.io.FileUtils.readFileToString(file,encoding);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}
	/**
	 * 返回路径下的所有文件列表
	 *
	 * @param filePath 文件路径
	 * @return 结果
	 */
	public static List<File> getFileList(String filePath)
	{
		File d = new File(filePath);

		return getFileList(d);
	}

	/**
	 * 返回路径下的所有文件列表
	 *
	 * @param file 文件对象
	 * @return 结果
	 */
	public static List<File> getFileList(File file)
	{
		List<File> result = new ArrayList<>();

		if (file!= null &&file.exists())
		{
			File[] list = file.listFiles();

			if(list != null)
			{
				result = Arrays.asList(list);
			}
		}

		return result;
	}

	/**
	 * 删除文件
	 *
	 * @param filePathAndName
	 *            文件路径及名称
	 * @return Boolean
	 */
	public static boolean deleteFile(String filePathAndName)
	{
		boolean result = false;

		try
		{
			File myDelFile = new File(filePathAndName);

			if (myDelFile.exists())
			{
				result = myDelFile.delete();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 删除所有文件
	 *
	 * @param folderPath
	 *            路径
	 * @return 是否成功
	 */
	public static boolean deleteAllFile(String folderPath)
	{
		boolean result = false;

		File myDelFile = new File(folderPath);

		try
		{
			if(myDelFile.exists())
			{
				org.apache.commons.io.FileUtils.cleanDirectory(myDelFile);

				result = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 删除文件夹
	 *
	 * @param folderPath
	 *            文件路径
	 * @return Boolean
	 */
	public static boolean deleteFolder(String folderPath)
	{
		boolean result = false;

		try
		{
			File myDelFile = new File(folderPath);

			if(myDelFile.exists())
			{
				org.apache.commons.io.FileUtils.forceDelete(myDelFile);
			}
			else
			{
				result = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 文件复制
	 *
	 * @param oldPathFile 旧的文件路径
	 * @param newPathFile 新的文件路径
	 */
	public static void copyFile(String oldPathFile, String newPathFile)
	{
		try
		{
			File old_file = new File(oldPathFile);

			File new_File = new File(newPathFile);

			if (old_file.exists())
			{
				org.apache.commons.io.FileUtils.copyFile(old_file,new_File);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 文件夹复制
	 *
	 * @param oldPath 旧文件路径
	 * @param newPath 新的文件路径
	 */
	public static void copyFolder(String oldPath, String newPath)
	{
		try
		{
			File old_path = new File(oldPath);

			File new_path = new File(newPath);

			if(old_path.exists())
			{
				org.apache.commons.io.FileUtils.copyDirectory(old_path,new_path);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 文件移动
	 *
	 * @param oldPath 旧文件路径
	 * @param newPath 新的文件路径
	 */
	public static void moveFile(String oldPath, String newPath)
	{
		try
		{
			File old_path = new File(oldPath);

			File new_path = new File(newPath);

			if(old_path.exists())
			{
				org.apache.commons.io.FileUtils.moveFile(old_path,new_path);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 文件夹移动
	 *
	 * @param oldPath 旧文件路径
	 * @param newPath 新的文件路径
	 */
	public static void moveFolder(String oldPath, String newPath)
	{
		try
		{
			File old_path = new File(oldPath);

			File new_path = new File(newPath);

			if(old_path.exists())
			{
				org.apache.commons.io.FileUtils.moveDirectory(old_path,new_path);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 重命名文件或文件夹
	 *
	 * @param resFilePath
	 *            源文件路径
	 * @param newFileName
	 *            重命名
	 * @return 操作成功标识
	 */
	public static boolean renameFile(String resFilePath, String newFileName)
	{
		File resFile = new File(resFilePath);

		String newFilePath = resFile.getParentFile().getPath() + SystemUtils.getFileSeparator() + newFileName;

		File newFile = new File(newFilePath);

		return resFile.renameTo(newFile);
	}

	/**
	 * 获取相对路径
	 *
	 * @param fullPath
	 *            全路径
	 * @param rootPath
	 *            根路径
	 * @return 相对根路径的相对路径
	 */
	public static String getRelativeRootPath(String fullPath, String rootPath)
	{
		String relativeRootPath = "";

		File full_path = new File(fullPath);

		File root_path = new File(rootPath);

		if (full_path.getPath().startsWith(root_path.getPath()))
		{
			relativeRootPath = full_path.getPath().substring(root_path.getPath().length());
		}

		return relativeRootPath;
	}

	/**
	 * 获取当前的文件前缀
	 * 
	 * @param fileName 文件名称
	 * @return 文件前缀
	 */
	public static String getFilePrefix(String fileName)
	{
		return  FilenameUtils.getBaseName(fileName);
	}

	/**
	 * 获取当前的文件的后缀
	 * 
	 * @param fileName 文件名称
	 * @return 文件后缀
	 */
	public static String getFilePostfix(String fileName)
	{
		return FilenameUtils.getExtension(fileName);
	}

	/**
	 * 去掉指定前缀
	 * 
	 * @param str
	 *            字符串
	 * @param prefix
	 *            前缀
	 * @return 切掉后的字符串，若前缀不是 preffix， 返回原字符串
	 */
	public static String removePrefix(String str, String prefix)
	{
		if (str.startsWith(prefix))
		{
			return str.substring(prefix.length());
		}

		return str;
	}
}
