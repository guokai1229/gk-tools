package top.guokaicn.tools.security;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * md5加密工具类
 */
public class MD5Utils
{
	/**
	 * 对文本进行MD5加密
	 *
	 * @param plainText 要进行加密的文本
	 * @return 加密后的内容
	 */
	public static String encrypt(String plainText)
	{
		return encrypt(plainText, 32);
	}

	/**
	 * 对文本进行MD5加密
	 *
	 * @param plainText 要进行加密的文本
	 * @param param     指定获取16位/32位加密数据
	 * @return 加密后的内容
	 */
	public static String encrypt(String plainText, Integer param)
	{
		String result = null;

		//首先判断是否为空
		if (StringUtils.isNotBlank(plainText))
		{
			try
			{
				MessageDigest md = MessageDigest.getInstance("MD5");

				result = HexUtils.encode(md.digest(plainText.getBytes()));

				if (param == 16)
				{
					result = result.substring(8, 24);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * md5加密文件
	 * @param file 文件对象
	 * @return 加密后的值
	 */
	public static String encrypt(File file)
	{
		String result = null;

		FileInputStream in = null;

		try
		{
			if(file.exists())
			{
				in = new FileInputStream(file);

				MessageDigest md5 = MessageDigest.getInstance("MD5");

				byte[] buffer = new byte[8192];
				int c;

				while ((c = in.read(buffer)) != -1)
				{
					md5.update(buffer, 0, c);
				}

				BigInteger bi = new BigInteger(1, md5.digest());

				result = bi.toString(16).toUpperCase();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (null != in)
			{
				try
				{
					in.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
