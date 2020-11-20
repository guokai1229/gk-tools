package top.guokaicn.tools.security;

import junit.framework.TestCase;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAUtilsTest extends TestCase
{

	public void testPublicEncrypt() throws Exception
	{
		//生成RSA公钥和私钥
		KeyPair keyPair = RSAUtils.getKeyPair();

		String publicKeyStr = RSAUtils.getPublicKey(keyPair);
		String privateKeyStr = RSAUtils.getPrivateKey(keyPair);
		System.out.println("RSA公钥Base64编码:" + publicKeyStr);
		System.out.println("RSA私钥Base64编码:" + privateKeyStr);

		String message = "hello, hello!";
		PublicKey publicKey = RSAUtils.string2PublicKey(publicKeyStr);

		PrivateKey privateKey = RSAUtils.string2PrivateKey(privateKeyStr);
		//用公钥加密
		byte[] publicEncrypt = RSAUtils.publicEncrypt(message.getBytes(), publicKey);

		System.out.println(Base64.getEncoder().encodeToString(publicEncrypt));

		System.out.println(new String(RSAUtils.privateDecrypt(publicEncrypt,privateKey)));

		String encryptContent = RSAUtils.publicEncryptBase64(message,publicKey);

		System.out.println(encryptContent);

		System.out.println(RSAUtils.privateDecryptBase64(encryptContent,privateKey));

		encryptContent = RSAUtils.publicEncryptBase64(message,publicKeyStr);

		System.out.println(encryptContent);

		System.out.println(RSAUtils.privateDecryptBase64(encryptContent,privateKeyStr));
	}
}