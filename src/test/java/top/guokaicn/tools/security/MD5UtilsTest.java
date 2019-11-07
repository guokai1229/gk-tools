package top.guokaicn.tools.security;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilsTest
{

	@Test
	public void encrypt()
	{
		String result = MD5Utils.encrypt("BomcAccountQuery2019-11-07 15:06:434abomc",16);

		System.out.println(result);
	}
}