package top.guokaicn.tools.security;

import junit.framework.TestCase;

import java.util.Arrays;

public class HexUtilsTest extends TestCase
{

	public void testEncode()
	{
		byte[] test = {1,2,3,4,11};

		System.out.println(HexUtils.encode(test));
	}

	public void testDecode()
	{
		String test = "010203040b";

		System.out.println(Arrays.toString(HexUtils.decode(test)));
	}
}