package top.guokaicn.tools.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

/**
 * md5加密工具类
 */
public class MD5Utils
{
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
				result = DigestUtils.md5Hex(plainText);

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
}
