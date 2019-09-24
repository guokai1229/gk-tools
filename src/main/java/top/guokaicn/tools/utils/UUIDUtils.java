package top.guokaicn.tools.utils;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * 生成一个唯一的字符串id,提取hibernate的生成方法
 *
 * @author gk
 *
 */
public class UUIDUtils
{
    /**
     * 当前的ip地址数值
     */
    private static final int IP;
    
    /**
     * 把当前ip地址转为数值
     * @param bytes
     * @return 
     */
    private static int IptoInt(byte[] bytes)
    {
        int result = 0;
        for (int i = 0; i < 4; i++)
        {
            result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
        }
        return result;
    }
    
    /**
     * 获取一个UUID
     */
    public static String getUUID()
    {
    	return (String) new UUIDUtils().generate();
    }


    static
    {
        int ipadd;
        try
        {
            ipadd = IptoInt(InetAddress.getLocalHost().getAddress());
        }
        catch (Exception e)
        {
            ipadd = 0;
        }
        IP = ipadd;
    }
    private static short counter = (short) 0;
    private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

    /**
     * Unique across JVMs on this machine (unless they load this class in the
     * same quater second - very unlikely)
     * @return 
     */
    private int getJVM()
    {
        return JVM;
    }

    /**
     * Unique in a millisecond for this JVM instance (unless there are >
     * Short.MAX_VALUE instances created in a millisecond)
     * @return 
     */
    private short getCount()
    {
        synchronized (UUIDUtils.class)
        {
            if (counter < 0)
            {
                counter = 0;
            }
            return counter++;
        }
    }

    /**
     * Unique in a local network
     * @return 
     */
    private int getIP()
    {
        return IP;
    }

    /**
     * Unique down to millisecond
     * @return 
     */
    private short getHiTime()
    {
        return (short) (System.currentTimeMillis() >>> 32);
    }

    private int getLoTime()
    {
        return (int) System.currentTimeMillis();
    }

    private final static String sep = "";

    private String format(int intval)
    {
        String formatted = Integer.toHexString(intval);
        StringBuilder buf = new StringBuilder("00000000");
        buf.replace(8 - formatted.length(), 8, formatted);
        return buf.toString();
    }

    private String format(short shortval)
    {
        String formatted = Integer.toHexString(shortval);
        StringBuilder buf = new StringBuilder("0000");
        buf.replace(4 - formatted.length(), 4, formatted);
        return buf.toString();
    }
    /**
     * 生成一串唯一的标示符
     * @return 
     */
    private Serializable generate()
    {
        return new StringBuffer(36).append(format(getIP())).append(sep).append(format(getJVM())).append(sep).append(format(getHiTime())).append(sep).append(format(getLoTime())).append(sep)
                .append(format(getCount())).toString();
    }

}
