package top.guokaicn.tools.security;

public class HexUtils
{
	/**
	 * 字节流转成十六进制表示
	 * @param src 参数
	 * @return 结果
	 */
	public static String encode(byte[] src)
	{
		String strHex;
		StringBuilder sb = new StringBuilder();
		for (byte b : src)
		{
			strHex = Integer.toHexString(b & 0xFF);
			sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
		}
		return sb.toString().trim();
	}

	/**
	 * 字符串转成字节流
	 * @param src 参数
	 * @return 结果
	 */
	public static byte[] decode(String src)
	{
		int m, n;
		int byteLen = src.length() / 2; // 每两个字符描述一个字节
		byte[] ret = new byte[byteLen];
		for (int i = 0; i < byteLen; i++)
		{
			m = i * 2 + 1;
			n = m + 1;
			int intVal = Integer.decode("0x" + src.substring(i * 2, m) + src.substring(m, n));
			ret[i] = (byte) intVal;
		}
		return ret;
	}
}
