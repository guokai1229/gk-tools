package top.guokaicn.tools.lang.rest;


/**
 * 通用的返回结果对象
 */
public class RestResult<T>
{
	/**
	 * 是否成功标识
	 */
	private Boolean success;

	/**
	 * 结果编码
	 */
	private Integer code;

	/**
	 * 信息文本
	 */
	private String message;

	/**
	 * 时间戳
	 */
	private final long timestamp = System.currentTimeMillis();

	/**
	 * 携带数据
	 */
	private T data;

	public void setSuccess(Boolean success)
	{
		this.success = success;
	}

	public void setCode(Integer code)
	{
		this.code = code;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Boolean getSuccess()
	{
		return success;
	}

	public Integer getCode()
	{
		return code;
	}

	public String getMessage()
	{
		return message;
	}

	public long getTimestamp()
	{
		return timestamp;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	/**
	 * 获取正确的结果对象
	 * @param <T> 类型
	 * @return 结果
	 */
	@Deprecated
	public static <T> RestResult<T> ok()
	{
		return RestResultUtils.ok();
	}

	/**
	 * 获取正确的结果对象
	 * @param data 数据
	 * @param <T> 类型
	 * @return 结果
	 */
	@Deprecated
	public static <T> RestResult<T> ok(T data)
	{
		return RestResultUtils.ok(data);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本
	 * @param <T> 类型
	 * @return 结果
	 */
	@Deprecated
	public static <T> RestResult<T> ok(String message)
	{
		return RestResultUtils.ok(message);
	}

	/**
	 * 获取正确的结果对象
	 * @param message 文本
	 * @param data 数据
	 * @param <T> 类型
	 * @return 结果
	 */
	@Deprecated
	public static <T> RestResult<T> ok(String message,T data)
	{
		return RestResultUtils.ok(message,data);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param code 编码
	 * @param message 文本描述
	 * @return 对象
	 */
	@Deprecated
	public static <T> RestResult<T> ok(int code,String message)
	{
		return RestResultUtils.ok(code, message);
	}

	/**
	 * 返回成功结果
	 * @param code 编码
	 * @param message 文本描述
	 * @param data 数据
	 * @param <T> 类型
	 * @return 对象
	 */
	@Deprecated
	public static <T> RestResult<T> ok(int code,String message,T data)
	{
		return RestResultUtils.ok(code, message,data);
	}

	/**
	 * 获取错误的结果对象
	 * @param <T> 类型
	 * @return 对象
	 */
	@Deprecated
	public static <T> RestResult<T> error()
	{
		return RestResultUtils.error();
	}

	/**
	 * 获取错误的结果对象
	 * @param data 数据
	 * @param <T> 类型
	 * @return 结果
	 */
	@Deprecated
	public static <T> RestResult<T> error(T data)
	{
		return RestResultUtils.error(data);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @param <T> 类型
	 * @return 对象
	 */
	@Deprecated
	public static <T> RestResult<T> error(String message)
	{
		return RestResultUtils.error(message);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param message 文本描述
	 * @param data 数据
	 * @param <T> 类型
	 * @return 结果
	 */
	@Deprecated
	public static <T> RestResult<T> error(String message,T data)
	{
		return RestResultUtils.error(message,data);
	}

	/**
	 * 根据Exception来返回结果对象
	 * @param e 错误对象
	 * @param <T> 类型
	 * @return 对象
	 */
	@Deprecated
	public static <T> RestResult<T> error(Exception e)
	{
		return RestResultUtils.error(e);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param code 错误编码
	 * @param message 文本描述
	 * @param <T> 类型
	 * @return 对象
	 */
	@Deprecated
	public static <T> RestResult<T> error(int code,String message)
	{
		return RestResultUtils.error(code, message);
	}

	/**
	 * 自定义返回结果文本描述
	 * @param code 编码
	 * @param message 文本描述
	 * @param data 数据
	 * @param <T> 类型
	 * @return 结果
	 */
	@Deprecated
	public static <T> RestResult<T> error(int code,String message,T data)
	{
		return RestResultUtils.error(code,message,data);
	}
}
