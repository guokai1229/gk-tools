package top.guokaicn.tools.security;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAUtils
{
	/**
	 * 生成秘钥对
	 *
	 * @return 秘钥对
	 * @throws Exception 错误
	 */
	public static KeyPair getKeyPair() throws Exception
	{
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		return keyPairGenerator.generateKeyPair();
	}

	/**
	 * 获取公钥(Base64编码)
	 *
	 * @param keyPair 秘钥对
	 * @return 公钥
	 */
	public static String getPublicKey(KeyPair keyPair)
	{
		PublicKey publicKey = keyPair.getPublic();
		byte[] bytes = publicKey.getEncoded();
		return Base64.getEncoder().encodeToString(bytes);
	}

	/**
	 * 获取私钥(Base64编码)
	 *
	 * @param keyPair 秘钥对
	 * @return 私钥
	 */
	public static String getPrivateKey(KeyPair keyPair)
	{
		PrivateKey privateKey = keyPair.getPrivate();
		byte[] bytes = privateKey.getEncoded();
		return Base64.getEncoder().encodeToString(bytes);
	}

	/**
	 * 将Base64编码后的公钥转换成PublicKey对象
	 *
	 * @param pubStr 公钥字符串
	 * @return 公钥对象
	 * @throws Exception 错误
	 */
	public static PublicKey string2PublicKey(String pubStr) throws Exception
	{
		byte[] keyBytes = Base64.getDecoder().decode(pubStr);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(keySpec);
	}

	/**
	 * 将Base64编码后的私钥转换成PrivateKey对象
	 *
	 * @param priStr 私钥串
	 * @return 私钥对象
	 * @throws Exception 错误
	 */
	public static PrivateKey string2PrivateKey(String priStr) throws Exception
	{
		byte[] keyBytes = Base64.getDecoder().decode(priStr);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePrivate(keySpec);
	}

	/**
	 * 公钥加密
	 * @param content 内容
	 * @param publicKey 公钥
	 * @return 加密内容
	 * @throws Exception 错误
	 */
	public static byte[] publicEncrypt(byte[] content, PublicKey publicKey) throws Exception
	{
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(content);
	}

	/**
	 * 公钥加密转化为base64字符串
	 * @param content 内容字符串
	 * @param publicKey 公钥
	 * @return 加密结果
	 * @throws Exception 错误
	 */
	public static String publicEncryptBase64(String content,PublicKey publicKey) throws Exception
	{
		byte[] encryptContent = publicEncrypt(content.getBytes(StandardCharsets.UTF_8),publicKey);

		return Base64.getEncoder().encodeToString(encryptContent);
	}

	/**
	 * 公钥字符串加密转化为base64字符串
	 * @param content 内容
	 * @param publicKeyStr 公钥字符串
	 * @return 结果
	 * @throws Exception 错误
	 */
	public static String publicEncryptBase64(String content,String publicKeyStr) throws Exception
	{
		PublicKey publicKey = string2PublicKey(publicKeyStr);

		return publicEncryptBase64(content,publicKey);
	}

	/**
	 * 私钥解密
	 * @param content 加密内容
	 * @param privateKey 私钥
	 * @return 解密内容
	 * @throws Exception 错误
	 */
	public static byte[] privateDecrypt(byte[] content, PrivateKey privateKey) throws Exception
	{
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(content);
	}

	/**
	 * 私钥解密
	 * @param content 内容
	 * @param privateKey 私钥
	 * @return 解密后的内容
	 * @throws Exception 错误
	 */
	public static String privateDecryptBase64(String content,PrivateKey privateKey) throws Exception
	{
		byte[] decryptContent = privateDecrypt(Base64.getDecoder().decode(content),privateKey);

		return new String(decryptContent, StandardCharsets.UTF_8);
	}

	/**
	 * 私钥解密
	 * @param content 内容
	 * @param privateKeyStr 私钥文本
	 * @return 解密后的内容
	 * @throws Exception 错误
	 */
	public static String privateDecryptBase64(String content,String privateKeyStr) throws Exception
	{
		PrivateKey privateKey = string2PrivateKey(privateKeyStr);

		byte[] decryptContent = privateDecrypt(Base64.getDecoder().decode(content),privateKey);

		return new String(decryptContent, StandardCharsets.UTF_8);
	}
}
