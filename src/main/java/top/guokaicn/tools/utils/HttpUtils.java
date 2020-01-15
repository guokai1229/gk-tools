package top.guokaicn.tools.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 处理关于http的方法，get,post,put,delete
 */
public class HttpUtils
{

	/**
	 * 向指定URL发送GET方法的请求
	 * @param url 发送请求的URL
	 * @param params 请求参数，map形式
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendGet(String url,Map<String, String> params)
	{
		String params_value = parseParams(params);

		return sendGet(url, params_value);
	}

	/**
	 * 向指定URL发送GET方法的请求
	 *
	 * @param url 发送请求的URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param)
	{
		StringBuilder result = new StringBuilder();
		BufferedReader in = null;
		try
		{
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

			String line;

			while ((line = in.readLine()) != null)
			{
				result.append(line);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally
		{
			try
			{
				if (in != null)
				{
					in.close();
				}
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return result.toString();
	}

	/**
	 * 向指定URL发送POST方法的请求
	 * @param url 发送请求的URL
	 * @param params 请求参数，map形式
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url,Map<String, String> params)
	{
		String params_value = parseParams(params);

		return sendPost(url, params_value);
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url 发送请求的 URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param)
	{
		OutputStreamWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		try
		{
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("contentType", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
			// 发送请求参数
			out.write(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

			String line;

			while ((line = in.readLine()) != null)
			{
				result.append(line);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally
		{
			try
			{
				if (out != null)
				{
					out.close();
				}
				if (in != null)
				{
					in.close();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	/**
	 * 向指定URL发送PUT方法的请求
	 * @param url 发送请求的URL
	 * @param params 请求参数，map形式
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPut(String url,Map<String, String> params)
	{
		String params_value = parseParams(params);

		return sendPut(url, params_value);
	}

	/**
	 * 向指定 URL 发送Put方法的请求
	 *
	 * @param url 发送请求的 URL
	 * @param param 请求参数，
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPut(String url, String param)
	{
		OutputStreamWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		try
		{
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("contentType", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
			// 发送请求参数
			out.write(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
			String line;
			while ((line = in.readLine()) != null)
			{
				result.append(line);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally
		{
			try
			{
				if (out != null)
				{
					out.close();
				}
				if (in != null)
				{
					in.close();
				}
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	/**
	 * 向指定URL发送PUT方法的请求
	 * @param url 发送请求的URL
	 * @param params 请求参数，map形式
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendDelete(String url,Map<String, String> params)
	{
		String params_value = parseParams(params);

		return sendDelete(url, params_value);
	}

	/**
	 * 向指定 URL 发送Put方法的请求
	 *
	 * @param url 发送请求的 URL
	 * @param param 请求参数，
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendDelete(String url, String param)
	{
		StringBuilder result = new StringBuilder();
		BufferedReader in = null;
		try
		{
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestMethod("DELETE");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			//			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			//			for (String key : map.keySet())
			//			{
			//				logger.info(key + "--->" + map.get(key));
			//			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
			String line;
			while ((line = in.readLine()) != null)
			{
				result.append(line);
			}
		}
		catch (Exception e)
		{
			// logger.info("发送DELETE请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally
		{
			try
			{
				if (in != null)
				{
					in.close();
				}
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return result.toString();
	}

	/**
	 * 把map变成url参数串 例如：key=value&year=2014
	 *
	 * @param map 参数
	 * @return 拼接完成的参数
	 */
	public static String parseParams(Map<String, String> map)
	{
		StringBuilder sb = new StringBuilder();

		if (map != null && map.size()>0)
		{
			for (Map.Entry<String, String> e : map.entrySet())
			{
				sb.append(e.getKey()).append("=").append(e.getValue()).append("&");
			}
		}

		return sb.substring(0, sb.length() - 1);
	}
}
