package top.guokaicn.tools.security;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * des加密工具类
 */
public class DESUtils
{
	/**
	 * 加密字符串
	 * @param datasource 加密源文本
	 * @param password 加密密钥
	 * @return 加密后字符串
	 */
	public static String encryptHexString(String datasource, String password)
	{
		byte[] result = DESUtils.encrypt(datasource.getBytes(), password);

		if (result != null)
		{
			return HexUtils.encode(result);
		}

		return null;
	}

	/**
	 * 解密字符串
	 * @param src 加密字符串
	 * @param password 加密密钥
	 * @return 解密后字符串
	 */
	public static String decryptHexString(String src, String password)
	{
		String result = null;

		try
		{
			byte[] hex_result = HexUtils.decode(src);

			byte[] decryResult = DESUtils.decrypt(hex_result, password);

			if (decryResult != null)
			{
				result = new String(decryResult);
			}
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}

		return result;
	}

	/**
	 * 加密字符串
	 * @param datasource 加密源文本
	 * @param password 加密密钥
	 * @return 加密后字符串
	 */
	public static String encryptString(String datasource, String password)
	{
		byte[] result = DESUtils.encrypt(datasource.getBytes(), password);

		return Base64.getEncoder().encodeToString(result);
	}

	/**
	 * 解密字符串
	 * @param src 加密字符串
	 * @param password 加密密钥
	 * @return 解密后字符串
	 */
	public static String decryptString(String src, String password)
	{
		String result = null;

		byte[] base64_result = Base64.getDecoder().decode(src.getBytes());

		try
		{
			byte[] decryResult = DESUtils.decrypt(base64_result, password);

			if (decryResult != null)
			{
				result = new String(decryResult);
			}
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}

		return result;
	}

	/**
	 * 加密
	 *
	 * @param datasource byte[]
	 * @param password   String
	 * @return byte[]
	 */
	public static byte[] encrypt(byte[] datasource, String password)
	{
		try
		{
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			//创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			//Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			//用密匙初始化Cipher对象,ENCRYPT_MODE用于将 Cipher 初始化为加密模式的常量
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			//现在，获取数据并加密
			//正式执行加密操作
			return cipher.doFinal(datasource); //按单部分操作加密或解密数据，或者结束一个多部分操作
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 *
	 * @param src      byte[]
	 * @param password String
	 * @return byte[]
	 */
	public static byte[] decrypt(byte[] src, String password)
	{
		try
		{
			// DES算法要求有一个可信任的随机数源
			SecureRandom random = new SecureRandom();
			// 创建一个DESKeySpec对象
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");//返回实现指定转换的 Cipher 对象
			// 将DESKeySpec对象转换成SecretKey对象
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成解密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.DECRYPT_MODE, securekey, random);
			// 真正开始解密操作
			return cipher.doFinal(src);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
