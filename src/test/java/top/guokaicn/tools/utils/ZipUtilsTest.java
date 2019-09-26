package top.guokaicn.tools.utils;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ZipUtilsTest
{

	@Test
	public void fileToZip()
	{
		try
		{
			ZipUtils.fileToZip("d:\\test","d:\\","11");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void fileToZipStream()
	{
		
	}

	@Test
	public void streamToZip()
	{
	}

	@Test
	public void streamMapToZip()
	{
	}

	@Test
	public void streamToZipStream()
	{
	}
}