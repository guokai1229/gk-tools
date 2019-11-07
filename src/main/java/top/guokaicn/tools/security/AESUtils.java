package top.guokaicn.tools.security;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * AES加密工具类
 */
public class AESUtils
{
	/**
	 * 加密
	 *
	 * @param content 待加密内容
	 * @param key     加密的密钥
	 * @return 结果
	 */
	public static String encrypt(String content, String key)
	{
		try
		{
			SecretKeySpec secretKeySpec = new SecretKeySpec(getEncoded(key), "AES");

			Cipher cipher = Cipher.getInstance("AES");

			byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);

			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

			byte[] byteRresult = cipher.doFinal(byteContent);

			StringBuilder sb = new StringBuilder();

			for (byte b : byteRresult)
			{
				String hex = Integer.toHexString(b & 0xFF);
				if (hex.length() == 1)
				{
					hex = '0' + hex;
				}
				sb.append(hex.toUpperCase());
			}

			return sb.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 解密
	 *
	 * @param content 待解密内容
	 * @param key     解密的密钥
	 * @return 结果
	 */
	public static String decrypt(String content, String key)
	{
		if (content.length() < 1) return null;

		byte[] byteRresult = new byte[content.length() / 2];

		for (int i = 0; i < content.length() / 2; i++)
		{
			int high = Integer.parseInt(content.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(content.substring(i * 2 + 1, i * 2 + 2), 16);
			byteRresult[i] = (byte) (high * 16 + low);
		}
		try
		{
			SecretKeySpec secretKeySpec = new SecretKeySpec(getEncoded(key), "AES");

			Cipher cipher = Cipher.getInstance("AES");

			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

			byte[] result = cipher.doFinal(byteRresult);

			return new String(result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	private static byte[] getEncoded(String key) throws Exception
	{
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

		secureRandom.setSeed(key.getBytes());

		keyGenerator.init(128, secureRandom);

		SecretKey secretKey = keyGenerator.generateKey();

		return secretKey.getEncoded();
	}
}
