package top.guokaicn.tools.utils;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class IOUtilsTest
{

	@Test
	public void toByteArray() throws Exception
	{
		String path = this.getClass().getResource("/config.properties").getFile();

		InputStream in = new FileInputStream(path);

		byte[] data = IOUtils.toByteArray(in);

		System.out.println(new String(data));
	}


	@Test
	public void copy() throws Exception
	{
		String path = this.getClass().getResource("/config.properties").getFile();

		String copy_path = this.getClass().getResource("/").getFile()+"/"+"configcopy.properties";

		InputStream in = new FileInputStream(path);

		OutputStream out = new FileOutputStream(copy_path);

		IOUtils.copy(in,out);

		in.close();

		out.close();

		File copy_file = new File(copy_path);

		if(copy_file.exists())
		{
			copy_file.delete();
		}
		else
		{
			fail("copy失败");
		}
	}
}