package top.guokaicn.tools.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * IO工具类，输入流与输出流的工具类方法
 */
public class IOUtils
{
	public static byte[] toByteArray(InputStream stream) throws IOException
	{
		return toByteArray(stream, 2147483647);
	}

	public static byte[] toByteArray(InputStream stream, int length) throws IOException
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream(length == 2147483647 ? 4096 : length);
		byte[] buffer = new byte[4096];
		int totalBytes = 0;

		int readBytes;
		do
		{
			readBytes = stream.read(buffer, 0, Math.min(buffer.length, length - totalBytes));
			totalBytes += Math.max(readBytes, 0);
			if (readBytes > 0)
			{
				baos.write(buffer, 0, readBytes);
			}
		}
		while (totalBytes < length && readBytes > -1);

		if (length != 2147483647 && totalBytes < length)
		{
			throw new IOException("unexpected EOF");
		}
		else
		{
			return baos.toByteArray();
		}
	}

	public static byte[] toByteArray(ByteBuffer buffer, int length)
	{
		if (buffer.hasArray() && buffer.arrayOffset() == 0)
		{
			return buffer.array();
		}
		else
		{
			byte[] data = new byte[length];
			buffer.get(data);
			return data;
		}
	}

	public static void copy(InputStream inp, OutputStream out) throws IOException
	{
		byte[] buff = new byte[4096];

		int count;
		while ((count = inp.read(buff)) != -1)
		{
			if (count > 0)
			{
				out.write(buff, 0, count);
			}
		}
	}
}
