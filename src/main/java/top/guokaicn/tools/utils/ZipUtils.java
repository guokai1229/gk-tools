package top.guokaicn.tools.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{
	/**
	 * 将sourceFilePath源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
	 *
	 * @param sourceFilePath 待压缩的文件路径
	 * @param zipFilePath    压缩后存放路径
	 * @param fileName       压缩后文件的名称
	 * @return 压缩后文件路径
	 * @throws Exception 错误
	 */
	public static String zip(String sourceFilePath, String zipFilePath, String fileName) throws Exception
	{
		File sourceFile = new File(sourceFilePath);

		File zipFile = new File(zipFilePath + SystemUtils.getFileSeparator() + fileName + ".zip");

		if (zipFile.exists())
		{
			if(!zipFile.delete())
			{
				throw new Exception("删除原有文件失败");
			}
		}

		zip(sourceFile,new FileOutputStream(zipFile));

		return zipFile.getPath();
	}

	/**
	 * 将流的内容打包成fileName名称的zip文件，并存放到zipFilePath路径下
	 *
	 * @param inputStream :待压缩的输入流
	 * @param name        :待压缩的名称
	 * @param zipFilePath :压缩后存放路径
	 * @param fileName    :压缩后文件的名称
	 * @return 结果
	 * @throws Exception 错误
	 */
	public static String zip(InputStream inputStream, String name, String zipFilePath, String fileName) throws Exception
	{
		File zipFile = new File(zipFilePath + SystemUtils.getFileSeparator() + fileName + ".zip");

		if (zipFile.exists())
		{
			if(!zipFile.delete())
			{
				throw new Exception("删除原有文件失败");
			}
		}

		zip(inputStream,name,new FileOutputStream(zipFile));

		return zipFile.getPath();
	}

	/**
	 * 将源文件，打包为zip数据输出到流中
	 * @param sourceFile 源文件
	 * @param out 输出
	 * @throws Exception 错误
	 */
	public static void zip(File sourceFile,OutputStream out) throws Exception
	{
		if (!sourceFile.exists())
		{
			throw new Exception(String.format("待压缩的文件目录:%s不存在",sourceFile.getPath()));
		}
		else
		{
			ZipOutputStream zos = new ZipOutputStream(out);

			//如果是目录的话，压缩目录
			if(sourceFile.isDirectory())
			{
				compressDirectory(sourceFile,zos,null);
			}
			else
			{
				FileInputStream file_in = new FileInputStream(sourceFile);

				compressStream(file_in,sourceFile.getName(),zos);
			}

			zos.close();
		}
	}

	/**
	 * 将流集合的内容打包为zip数据输出到流中
	 * @param streamMap 流集合的内容
	 * @param out 输出
	 * @throws Exception 错误
	 */
	public static void zip(Map<String, InputStream> streamMap, OutputStream out) throws Exception
	{
		if(streamMap != null && !streamMap.isEmpty())
		{
			ZipOutputStream zos = new ZipOutputStream(out);

			for(Map.Entry<String,InputStream> entry : streamMap.entrySet())
			{
				compressStream(entry.getValue(),entry.getKey(),zos);
			}

			zos.close();
		}
	}

	/**
	 * 将流的内容打包为zip数据输出到流中
	 * @param inputStream 输入流
	 * @param name 待压缩的名称
	 * @param out 输出流
	 * @throws Exception 错误
	 */
	public static void zip(InputStream inputStream, String name, OutputStream out) throws Exception
	{
		ZipOutputStream zos = new ZipOutputStream(out);

		compressStream(inputStream,name,zos);

		zos.close();
	}



	/**
	 * 压缩目录文件
	 * @param directory 目录路径
	 * @param basePath 根目类
	 * @param out zip输出
	 * @throws IOException 错误
	 */
	private static void compressDirectory(File directory, ZipOutputStream out,String basePath) throws IOException
	{
		List<File> contents = FileUtils.getFileList(directory);

		basePath = StringUtils.defaultIfBlank(basePath,directory.getPath());

		for(File file : contents)
		{
			String entry_name = getZipEntryName(basePath,file);

			if(file.isDirectory())
			{
				//添加空目录
				out.putNextEntry(new ZipEntry(entry_name));

				out.closeEntry();

				compressDirectory(file,out,basePath);
			}
			else
			{
				FileInputStream file_in = new FileInputStream(file);

				compressStream(file_in,entry_name,out);
			}
		}
	}

	/**
	 * 压缩流数据
	 * @param inputStream 输入流
	 * @param streamName 流名称
	 * @param out 压缩输出
	 * @throws IOException 错误
	 */
	private static void compressStream(InputStream inputStream, String streamName, ZipOutputStream out) throws IOException
	{
		out.putNextEntry(new ZipEntry(streamName));

		IOUtils.copy(inputStream,out);

		out.flush();

		out.closeEntry();

		inputStream.close();
	}

	/**
	 * 获取压缩文件名字
	 * @param basePath 根目类路径
	 * @param file 文件
	 * @return 数据
	 */
	private static String getZipEntryName(String basePath, File file)
	{
		if (!basePath.endsWith(SystemUtils.getFileSeparator()))
		{
			basePath += SystemUtils.getFileSeparator();
		}

		String filePath = FileUtils.getRelativeRootPath(file.getPath(),basePath);

		// 对于目录，必须在entry名字后面加上"/"，表示它将以目录项存储。
		if (file.isDirectory())
		{
			filePath += "/";
		}

		return filePath;
	}

}
