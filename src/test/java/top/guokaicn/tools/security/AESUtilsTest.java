package top.guokaicn.tools.security;

import org.junit.Test;

import static org.junit.Assert.*;

public class AESUtilsTest
{

	@Test
	public void encrypt()
	{
		String adminPwd = AESUtils.encrypt("account4a11!!","4abomc");

		System.out.println(adminPwd);
	}

	@Test
	public void decrypt()
	{
		String result = AESUtils.decrypt("40EC779EEB4454955881D35EBA0A1502","4abomc");

		System.out.println(result);
	}
}