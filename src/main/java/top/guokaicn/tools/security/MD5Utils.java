package top.guokaicn.tools.security;

import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;

/**
 * md5加密工具类
 */
public class MD5Utils
{

	private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

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

				result = byteArrayToHexString(md.digest(plainText.getBytes()));

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

	private static String byteArrayToHexString(byte[] b)
	{
		StringBuilder resultSb = new StringBuilder();

		for (byte value : b)
		{
			resultSb.append(byteToHexString(value));
		}

		return resultSb.toString();
	}


	private static String byteToHexString(byte b)
	{
		int n = b;

		if (n < 0)
		{
			n += 256;
		}

		int d1 = n / 16;
		int d2 = n % 16;

		return hexDigits[d1] + hexDigits[d2];
	}
}
