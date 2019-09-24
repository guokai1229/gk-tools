package top.guokaicn.tools.utils;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class IOUtilsTest
{

	@Test
	public void toByteArray() throws Exception
	{
		InputStream in = new FileInputStream("E:\\work\\filterID.properties");

		byte[] data = IOUtils.toByteArray(in);

		System.out.println(new String(data));
	}


	@Test
	public void copy() throws Exception
	{
		InputStream in = new FileInputStream("E:\\work\\filterID.properties");

		OutputStream out = new FileOutputStream("E:\\work\\filterID2.properties");

		IOUtils.copy(in,out);
	}
}