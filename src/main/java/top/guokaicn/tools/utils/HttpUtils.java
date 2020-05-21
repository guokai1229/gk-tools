package top.guokaicn.tools.utils;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 处理关于http的通用方法，get,post,put,delete
 */
public class HttpUtils
{
	/**
	 * http请求类型
	 */
	public enum Method {
		GET,
		POST,
		PUT,
		DELETE
	}

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
	 * @param param 请求参数
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param)
	{
		String result;

		if(url.contains(","))
		{
			List<String> url_list = Arrays.asList(url.split(","));

			result = sendBalanceRequest(url_list,Method.GET,param);
		}
		else
		{
			result = sendRequest(url,Method.GET,param);
		}

		return result;
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
	 * @param param 请求参数
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param)
	{
		String result;

		if(url.contains(","))
		{
			List<String> url_list = Arrays.asList(url.split(","));

			result = sendBalanceRequest(url_list,Method.POST,param);
		}
		else
		{
			result = sendRequest(url,Method.POST,param);
		}

		return result;
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
		String result;

		if(url.contains(","))
		{
			List<String> url_list = Arrays.asList(url.split(","));

			result = sendBalanceRequest(url_list,Method.PUT,param);
		}
		else
		{
			result = sendRequest(url,Method.PUT,param);
		}

		return result;
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
		String result;

		if(url.contains(","))
		{
			List<String> url_list = Arrays.asList(url.split(","));

			result = sendBalanceRequest(url_list,Method.DELETE,param);
		}
		else
		{
			result = sendRequest(url,Method.DELETE,param);
		}

		return result;
	}

	/**
	 * 发送负载均衡请求
	 * @param url_list 发送请求的URL列表
	 * @param method 方法名称
	 * @param param 请求参数
	 * @return 结果
	 */
	private static String sendBalanceRequest(List<String> url_list,Method method, String param)
	{
		String result = null;

		if(url_list != null && url_list.size()>0)
		{
			int index = ThreadLocalRandom.current().nextInt(url_list.size());

			String url = url_list.get(index);

			result = sendRequest(url,method,param);

			if(result == null)
			{
				for(String url_item : url_list)
				{
					if(!url_item.equals(url))
					{
						result = sendRequest(url_item,method,param);

						if(result != null)
						{
							break;
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * 根据方法去自动获取请求数据
	 * @param url 请求url地址链接
	 * @param method 方法类型
	 * @param param 请求参数
	 * @return 请求结果
	 */
	private static String sendRequest(String url,Method method, String param)
	{
		String result = null;

		switch (method)
		{
			case GET:
				result = requestGet(url, param);
				break;
			case POST:
				result = requestPost(url, param);
				break;
			case PUT:
				result = requestPut(url, param);
				break;
			case DELETE:
				result = requestDelete(url, param);
				break;
		}

		return result;
	}

	/**
	 * 向指定URL发送GET方法的请求
	 *
	 * @param url 发送请求的URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	private static String requestGet(String url, String param)
	{
		String result = null;

		BufferedReader in = null;
		try
		{
			String urlNameString = url + "?" + param;

			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			HttpURLConnection connection  = (HttpURLConnection)realUrl.openConnection();

			connection.setRequestMethod("GET");
			// 设置通用的请求属性
			setCommonRequestHeader(connection);
			// 建立实际的连接
			connection.connect();
			//获取响应状态
			int state = connection.getResponseCode();

			if(state == 200)
			{
				// 定义 BufferedReader输入流来读取URL的响应
				in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

				result = IOUtils.toString(in);
			}
		}
		catch (Exception ignored)
		{

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
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url 发送请求的 URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	private static String requestPost(String url, String param)
	{
		String result = null;

		BufferedReader in = null;

		try
		{
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			HttpURLConnection connection  = (HttpURLConnection)realUrl.openConnection();
			// 设置通用的请求属性
			setCommonRequestHeader(connection);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			connection.setRequestProperty("contentType", "UTF-8");
			// 发送POST请求必须设置如下两行
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.connect();
			// 获取URLConnection对象对应的输出流
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8);
			// 发送请求参数
			out.write(param);
			// flush输出流的缓冲
			out.flush();
			out.close();
			// 定义BufferedReader输入流来读取URL的响应
			//获取响应状态
			int state = connection.getResponseCode();

			if(state == 200)
			{
				// 定义 BufferedReader输入流来读取URL的响应
				in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

				result = IOUtils.toString(in);
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
				if (in != null)
				{
					in.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送Put方法的请求
	 *
	 * @param url 发送请求的 URL
	 * @param param 请求参数，
	 * @return 所代表远程资源的响应结果
	 */
	private static String requestPut(String url, String param)
	{
		String result = null;

		BufferedReader in = null;

		try
		{
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			setCommonRequestHeader(conn);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("contentType", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
			// 发送请求参数
			out.write(param);
			// flush输出流的缓冲
			out.flush();
			out.close();
			//获取响应状态
			int state = conn.getResponseCode();

			if(state == 200)
			{
				// 定义 BufferedReader输入流来读取URL的响应
				in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

				result = IOUtils.toString(in);
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
		
		return result;
	}

	/**
	 * 向指定 URL 发送Put方法的请求
	 *
	 * @param url 发送请求的 URL
	 * @param param 请求参数，
	 * @return 所代表远程资源的响应结果
	 */
	private static String requestDelete(String url, String param)
	{
		String result = null;

		BufferedReader in = null;

		try
		{
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			setCommonRequestHeader(connection);
			connection.setRequestMethod("DELETE");
			// 建立实际的连接
			connection.connect();
			//获取响应状态
			int state = connection.getResponseCode();

			if(state == 200)
			{
				// 定义 BufferedReader输入流来读取URL的响应
				in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

				result = IOUtils.toString(in);
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
		return result;
	}

	/**
	 * 设置通用请求属性
	 * @param connection 连接对象
	 */
	private static void setCommonRequestHeader(URLConnection connection)
	{
		if(connection != null)
		{
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		}
	}

	/**
	 * 把map变成url参数串
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
