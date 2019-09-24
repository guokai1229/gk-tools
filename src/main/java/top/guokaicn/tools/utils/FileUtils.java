package top.guokaicn.tools.utils;

import java.io.*;

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
	public static String createFolder(String folderPath)
	{
		try
		{
			File myFilePath = new File(folderPath);

			if (!myFilePath.exists())
			{
				myFilePath.mkdir();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return folderPath;
	}

	/**
	 * 创建filePathAndName文件
	 *
	 * @param filePathAndName
	 *            文件路径及名称例如：D:\\xxx.txt"
	 */
	public static FileWriter createFile(String filePathAndName)
	{
		try
		{
			String filePath = filePathAndName;

			File myFilePath = new File(filePath);

			if (!myFilePath.exists())
			{
				myFilePath.createNewFile();
			}

			FileWriter resultFile = new FileWriter(myFilePath);

			return resultFile;
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
	 * @param filePathAndName
	 *            文件路径及名称例如：D:\\xxx.txt"
	 * @param encoding
	 *            文件编码
	 */
	public static Writer createFile(String filePathAndName, String encoding)
	{
		try
		{
			String filePath = filePathAndName;

			File myFilePath = new File(filePath);

			if (!myFilePath.exists())
			{
				myFilePath.createNewFile();
			}

			Writer resultFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(myFilePath), encoding));

			return resultFile;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 创建filePathAndName文件，并且用encoding字符格式写入fileContent内容
	 *
	 * @param filePathAndName
	 *            文件路径及名称
	 * @param fileContent
	 *            文件内容
	 * @param encoding
	 *            编码格式：例如：GBK 或 UTF-8
	 */
	public static void createFile(String filePathAndName, String fileContent, String encoding)
	{
		try
		{
			String filePath = filePathAndName;
			File myFilePath = new File(filePath);
			if (!myFilePath.exists())
			{
				myFilePath.createNewFile();
			}
			PrintWriter myFile = new PrintWriter(myFilePath, encoding);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 创建filePathAndName文件并且父路径如果不存在，也一起创建
	 *
	 */
	public static void createFileAlways(String filePathAndName)
	{
		try
		{
			String filePath = filePathAndName;
			File myFilePath = new File(filePath);

			if (!myFilePath.getParentFile().exists())
			{
				// 如果目标文件所在的目录不存在，则创建父目录
				if (!myFilePath.getParentFile().mkdirs())
				{
					throw new IllegalArgumentException("父目录不存在");
				}
			}

			if (!myFilePath.exists())
			{
				myFilePath.createNewFile();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 返回路径下的所有文件列表
	 *
	 * @param filepath
	 * @return File[]
	 */
	public static File[] getFileList(String filepath)
	{
		File list[] = null;
		File d = new File(filepath);
		if (d.exists())
		{
			list = d.listFiles();
		}
		return list;
	}

	/**
	 * 删除文件
	 *
	 * @param filePathAndName
	 *            文件路径及名称
	 * @return Boolean
	 */
	public static boolean delFile(String filePathAndName)
	{
		boolean bea = false;
		try
		{
			String filePath = filePathAndName;

			File myDelFile = new File(filePath);

			if (myDelFile.exists())
			{
				myDelFile.delete();

				bea = true;
			}
			else
			{
				bea = false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bea;
	}

	/**
	 * 删除文件夹
	 *
	 * @param folderPath
	 *            文件路径
	 */
	public static void delFolder(String folderPath)
	{
		try
		{
			delAllFile(folderPath);
			String filePath = folderPath;
			File myFilePath = new File(filePath);
			myFilePath.delete();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 删除所有文件
	 *
	 * @param path
	 *            路径
	 * @return
	 */
	public static boolean delAllFile(String path)
	{
		boolean bea = false;

		File file = new File(path);

		if (!file.exists())
		{
			return bea;
		}
		if (!file.isDirectory())
		{
			return bea;
		}

		String[] tempList = file.list();

		File temp;

		for (String tempString : tempList)
		{
			if (path.endsWith(File.separator))
			{
				temp = new File(path + tempString);
			}
			else
			{
				temp = new File(path + File.separator + tempString);
			}
			if (temp.isFile())
			{
				temp.delete();
			}
			if (temp.isDirectory())
			{
				delAllFile(path + "/" + tempString);
				delFolder(path + "/" + tempString);
				bea = true;
			}
		}
		return bea;
	}

	/**
	 * 文件复制
	 *
	 * @param oldPathFile
	 * @param newPathFile
	 * @throws IOException
	 */
	public static void copyFile(String oldPathFile, String newPathFile) throws IOException
	{
		FileOutputStream fs = null;
		InputStream inStream = null;
		try
		{
			int byteread;
			File oldfile = new File(oldPathFile);
			if (oldfile.exists())
			{
				inStream = new FileInputStream(oldPathFile);
				fs = new FileOutputStream(newPathFile);
				byte[] buffer = new byte[1024];
				while ((byteread = inStream.read(buffer)) != -1)
				{
					fs.write(buffer, 0, byteread);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (inStream != null)
			{
				inStream.close();
			}
			if (fs != null)
			{
				fs.close();
			}
		}
	}

	/**
	 * 文件夹复制
	 *
	 * @param oldPath
	 * @param newPath
	 */
	public static void copyFolder(String oldPath, String newPath)
	{
		try
		{
			new File(newPath).mkdirs();
			File a = new File(oldPath);
			String[] file = a.list();
			File temp;
			for (String file_name : file)
			{
				if (oldPath.endsWith(File.separator))
				{
					temp = new File(oldPath + file_name);
				}
				else
				{
					temp = new File(oldPath + File.separator + file_name);
				}
				if (temp.isFile())
				{
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()));
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1)
					{
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory())
				{
					copyFolder(oldPath + "/" + file_name, newPath + "/" + file_name);
				}
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
	 * @param oldPath
	 * @param newPath
	 * @throws IOException
	 */
	public static void moveFile(String oldPath, String newPath) throws IOException
	{
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}

	/**
	 * 文件夹移动
	 *
	 * @param oldPath
	 * @param newPath
	 */
	public static void moveFolder(String oldPath, String newPath)
	{
		copyFolder(oldPath, newPath);
		delFolder(oldPath);
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
		String newFilePath = formatPath(getParentPath(resFilePath) + "/" + newFileName);
		File resFile = new File(resFilePath);
		File newFile = new File(newFilePath);
		return resFile.renameTo(newFile);
	}

	/**
	 * 文件路径添加，通过参数来构建文件路径
	 *
	 * @param pathElements
	 * @return
	 */
	public static String pathJoin(final String... pathElements)
	{
		final String path;

		if (pathElements == null || pathElements.length == 0)
		{
			path = File.separator;
		}
		else
		{
			final StringBuffer sb = new StringBuffer();

			for (final String pathElement : pathElements)
			{
				if (pathElement.length() > 0)
				{
					sb.append(pathElement);
					sb.append(File.separator);
				}
			}

			if (sb.length() > 0)
			{
				sb.deleteCharAt(sb.length() - 1);
			}
			path = sb.toString();
		}

		return (path);
	}

	/**
	 * 判断一个文件是否存在
	 *
	 * @param filePath
	 *            文件路径
	 * @return 存在返回true，否则返回false
	 */
	public static boolean isExist(String filePath)
	{
		return new File(filePath).exists();
	}

	/**
	 * 为fileDir目录下fileName文件，返回写入管道对象（BufferedWriter）
	 *
	 * @param fileDir
	 * @param fileName
	 * @return BufferedWriter
	 */
	public static BufferedWriter getWriter(String fileDir, String fileName)
	{
		try
		{
			File f1 = new File(fileDir);
			if (!f1.exists())
			{
				f1.mkdirs();
			}
			f1 = new File(fileDir, fileName);
			if (!f1.exists())
			{
				f1.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(f1.getPath(), true));
			return bw;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 为fileDir目录下fileName文件，返回写入管道对象（BufferedWriter）
	 *
	 * @param fileDir
	 * @param fileName
	 * @return FileOutputStream
	 */
	public static FileOutputStream getOutputStream(String fileDir, String fileName)
	{
		try
		{
			File f1 = new File(fileDir);
			if (!f1.exists())
			{
				f1.mkdirs();
			}
			f1 = new File(fileDir, fileName);
			if (!f1.exists())
			{
				f1.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f1.getPath());
			return fos;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 用encoding字符格式读取fileDir目录下fileName文件，返回读取文件管道对象（BufferedReader）
	 *
	 * @param fileDir
	 * @param fileName
	 * @param encoding
	 * @return
	 */
	public static BufferedReader getReader(String fileDir, String fileName, String encoding)
	{
		try
		{
			File file = new File(fileDir, fileName);
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
			BufferedReader br = new BufferedReader(read);
			return br;
		}
		catch (FileNotFoundException ex)
		{
			return null;
		}
		catch (IOException e)
		{
			return null;
		}
	}

	/**
	 * 获取文件父路径
	 *
	 * @param path
	 *            文件路径
	 * @return 文件父路径
	 */
	public static String getParentPath(String path)
	{
		return new File(path).getParent();
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
		String relativeRootPath = null;
		String _fullPath = formatPath(fullPath);
		String _rootPath = formatPath(rootPath);

		if (_fullPath.startsWith(_rootPath))
		{
			relativeRootPath = fullPath.substring(_rootPath.length());
		}
		else
		{
			throw new RuntimeException("要处理的两个字符串没有包含关系，处理失败！");
		}
		if (relativeRootPath == null)
		{
			return null;
		}
		else
		{
			return formatPath(relativeRootPath);
		}
	}

	/**
	 * 格式化文件路径，将其中不规范的分隔转换为标准的分隔符,并且去掉末尾的"/"符号。
	 *
	 * @param path
	 * @return 格式化后的文件路径
	 */
	public static String formatPath(String path)
	{
		String reg0 = "////＋";
		String reg = "////＋|/＋";
		String temp = path.trim().replaceAll(reg0, "/");
		temp = temp.replaceAll(reg, "/");
		if (temp.endsWith("/"))
		{
			temp = temp.substring(0, temp.length() - 1);
		}
		if (System.getProperty("file.separator").equals("//"))
		{
			temp = temp.replace("/", "//");
		}
		return temp;
	}

	/**
	 * 输入流转换成字节数组
	 *
	 * @param in
	 *            ：输入流
	 * @return byte[] 字节
	 * @throws IOException
	 */
	public static byte[] readBytes(InputStream in) throws IOException
	{
		BufferedInputStream bufin = new BufferedInputStream(in);
		int buffSize = 1024;
		ByteArrayOutputStream out = new ByteArrayOutputStream(buffSize);
		System.out.println("按照文件大小为bytes:" + in.available());
		byte[] temp = new byte[buffSize];
		int size;
		while ((size = bufin.read(temp)) != -1)
		{
			out.write(temp, 0, size);
		}
		bufin.close();
		byte[] content = out.toByteArray();
		return content;
	}

	/**
	 * 获取当前工作目录的路径
	 * 
	 * @return
	 */
	public static String getCurrentPath()
	{
		return System.getProperty("user.dir");
	}
	
	
	/**
	 * 获取当前的文件的后缀
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFilePrefix(String fileName)
	{
		String fileType = fileName.substring(0, fileName.lastIndexOf("."));
		return fileType;
	}

	/**
	 * 获取当前的文件的后缀
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFilePostfix(String fileName)
	{
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		return fileType;
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
