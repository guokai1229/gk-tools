package top.guokaicn.tools.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class HttpUtilsTest
{

	@Test
	public void sendGet()
	{
		String url = "http://localhost:8080/,http://localhost:8081/,https://www.baidu.com/s";

		Map<String, String> param_map = new HashMap<>();

		param_map.put("wd","123");

		System.out.println(HttpUtils.sendGet(url,param_map));
	}

	@Test
	public void sendGetTest()
	{
		String url = "http://localhost:8080/,http://localhost:8081/,https://www.baidu.com/s";

		Map<String, String> param_map = new HashMap<>();

		param_map.put("id","122");
		param_map.put("name","222");
		param_map.put("pwd","333");

		System.out.println(HttpUtils.sendGet(url,HttpUtils.parseParams(param_map)));
	}

	@Test
	public void sendPost()
	{
		String url = "https://www.baidu.com/";

		Map<String, String> param_map = new HashMap<>();

		param_map.put("id","122");
		param_map.put("name","222");
		param_map.put("pwd","333");

		System.out.println(HttpUtils.sendPost(url,param_map));
	}

	@Test
	public void sendPostTest()
	{
		String url = "https://www.baidu.com/";

		Map<String, String> param_map = new HashMap<>();

		param_map.put("id","122");
		param_map.put("name","222");
		param_map.put("pwd","333");

		System.out.println(HttpUtils.sendPost(url,HttpUtils.parseParams(param_map)));
	}

	@Test
	public void sendPut()
	{
		String url = "https://www.baidu.com/";

		Map<String, String> param_map = new HashMap<>();

		param_map.put("id","122");
		param_map.put("name","222");
		param_map.put("pwd","333");

		System.out.println(HttpUtils.sendPut(url,param_map));
	}

	@Test
	public void sendPutTest()
	{
		String url = "https://www.baidu.com/";

		Map<String, String> param_map = new HashMap<>();

		param_map.put("id","122");
		param_map.put("name","222");
		param_map.put("pwd","333");

		System.out.println(HttpUtils.sendPut(url,HttpUtils.parseParams(param_map)));
	}

	@Test
	public void sendDelete()
	{
		String url = "https://www.baidu.com/";

		Map<String, String> param_map = new HashMap<>();

		param_map.put("id","122");
		param_map.put("name","222");
		param_map.put("pwd","333");

		System.out.println(HttpUtils.sendDelete(url,param_map));
	}

	@Test
	public void sendDeleteTest()
	{
		String url = "https://www.baidu.com/";

		Map<String, String> param_map = new HashMap<>();

		param_map.put("id","122");
		param_map.put("name","222");
		param_map.put("pwd","333");

		System.out.println(HttpUtils.sendDelete(url,HttpUtils.parseParams(param_map)));
	}

	@Test
	public void parseParams()
	{
		Map<String, String> param_map = new HashMap<>();

		param_map.put("id","122");
		param_map.put("name","222");
		param_map.put("pwd","333");

		System.out.println(HttpUtils.parseParams(param_map));
	}
}