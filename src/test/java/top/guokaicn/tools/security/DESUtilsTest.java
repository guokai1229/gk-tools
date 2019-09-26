package top.guokaicn.tools.security;

import org.junit.Test;


public class DESUtilsTest
{
	private String key = "bea65bf559f7c0f4eebccbf07685ee7c";

	@Test
	public void encryptHexString()
	{
		String result = DESUtils.encryptHexString("test",key);

		System.out.println(result);
	}

	@Test
	public void decryptHexString()
	{
		System.out.println(DESUtils.decryptHexString("db4eeed9d4651e52",key));
	}

	@Test
	public void encryptString()
	{
		String result =  DESUtils.encryptString("test",key);

		System.out.println(result);
	}

	@Test
	public void decryptString()
	{
		System.out.println(DESUtils.decryptString("207u2dRlHlI=",key));
	}

	@Test
	public void encrypt()
	{
		byte[] result = DESUtils.encrypt("test".getBytes(),key);

		System.out.println(new String(result));
	}

	@Test
	public void decrypt()
	{
		byte[] result = DESUtils.encrypt("test".getBytes(),key);

		result = DESUtils.decrypt(result,key);

		System.out.println(new String(result));
	}
}