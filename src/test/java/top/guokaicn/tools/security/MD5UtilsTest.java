package top.guokaicn.tools.security;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilsTest
{

	@Test
	public void encrypt()
	{
		String result = MD5Utils.encrypt("Bqwesafasf2019-11-07 15:06:43",16);

		System.out.println(result);
	}

	@Test
	public void encrypttest()
	{
		String result = MD5Utils.encrypt("Bqwesafasf2019-11-07 15:06:43");

		System.out.println(result);
	}
}