package top.guokaicn.tools.lang.rest;

import java.util.Optional;

/**
 * RestResult使用工具类
 * @author guokai
 * @date 2021/11/6 9:20
 */
public class RestResultUtils
{
    /**
     * 编码枚举对象
     */
    private enum CODE
    {
        SUCCESS_CODE(200, "成功"),
        ERROR_CODE(500, "错误");

        private final int code;
        private final String description;

        CODE(int code, String message)
        {
            this.code = code;
            this.description = message;
        }

        public int getCode()
        {
            return code;
        }

        public String getDescription()
        {
            return description;
        }
    }
    /**
     * 获取正确的结果对象
     * @param <T> 类型
     * @return 结果
     */
    public static <T> RestResult<T> ok()
    {
        return ok(CODE.SUCCESS_CODE.getCode(), CODE.SUCCESS_CODE.getDescription());
    }

    /**
     * 获取正确的结果对象
     * @param data 数据
     * @param <T> 类型
     * @return 结果
     */
    public static <T> RestResult<T> ok(T data)
    {
        return ok(CODE.SUCCESS_CODE.getCode(), CODE.SUCCESS_CODE.getDescription(), data);
    }

    /**
     * 自定义返回结果文本描述
     * @param message 文本
     * @param <T> 类型
     * @return 结果
     */
    public static <T> RestResult<T> ok(String message)
    {
        return ok(CODE.SUCCESS_CODE.getCode(), message);
    }

    /**
     * 获取正确的结果对象
     * @param message 文本
     * @param data 数据
     * @param <T> 类型
     * @return 结果
     */
    public static <T> RestResult<T> ok(String message,T data)
    {
        return ok(CODE.SUCCESS_CODE.getCode(), message, data);
    }

    /**
     * 自定义返回结果文本描述
     * @param code 编码
     * @param message 文本描述
     * @return 对象
     */
    public static <T> RestResult<T> ok(int code,String message)
    {
        return ok(code, message,null);
    }

    /**
     * 返回成功结果
     * @param code 编码
     * @param message 文本描述
     * @param data 数据
     * @param <T> 类型
     * @return 对象
     */
    public static <T> RestResult<T> ok(int code,String message,T data)
    {
        RestResult<T> restResult = new RestResult<>();

        restResult.setSuccess(true);

        restResult.setMessage(message);

        restResult.setCode(code);

        restResult.setData(data);

        return restResult;
    }

    /**
     * 获取错误的结果对象
     * @param <T> 类型
     * @return 对象
     */
    public static <T> RestResult<T> error()
    {
        return error(CODE.ERROR_CODE.getCode(), CODE.ERROR_CODE.getDescription());
    }

    /**
     * 获取错误的结果对象
     * @param data 数据
     * @param <T> 类型
     * @return 结果
     */
    public static <T> RestResult<T> error(T data)
    {
        return error(CODE.ERROR_CODE.getCode(), CODE.ERROR_CODE.getDescription(), data);
    }

    /**
     * 自定义返回结果文本描述
     * @param message 文本描述
     * @param <T> 类型
     * @return 对象
     */
    public static <T> RestResult<T> error(String message)
    {
        return error(CODE.ERROR_CODE.getCode(), message);
    }

    /**
     * 自定义返回结果文本描述
     * @param message 文本描述
     * @param data 数据
     * @param <T> 类型
     * @return 结果
     */
    public static <T> RestResult<T> error(String message,T data)
    {
        return error(CODE.ERROR_CODE.getCode(), message, data);
    }

    /**
     * 根据Exception来返回结果对象
     * @param e 错误对象
     * @param <T> 类型
     * @return 对象
     */
    public static <T> RestResult<T> error(Exception e)
    {
        return error(CODE.ERROR_CODE.getCode(), e.getMessage());
    }

    /**
     * 自定义返回结果文本描述
     * @param code 错误编码
     * @param message 文本描述
     * @param <T> 类型
     * @return 对象
     */
    public static <T> RestResult<T> error(int code,String message)
    {
        return error(code, message,null);
    }

    /**
     * 自定义返回结果文本描述
     * @param code 编码
     * @param message 文本描述
     * @param data 数据
     * @param <T> 类型
     * @return 结果
     */
    public static <T> RestResult<T> error(int code,String message,T data)
    {
        RestResult<T> restResult = new RestResult<>();

        restResult.setSuccess(false);

        restResult.setMessage(message);

        restResult.setCode(code);

        restResult.setData(data);

        return restResult;
    }
    /**
     * 获取RestResult的数据，并且进行校验
     * @param restResult 对象
     * @param <T> 类型
     * @return 结果
     */
    public static <T> T getData(RestResult<T> restResult)
    {
        restResult = Optional.ofNullable(restResult).orElseThrow(()->new RestResultAccessException("result is null , access is fail!"));

        if(restResult.getSuccess())
        {
            return restResult.getData();
        }
        else
        {
            String message = Optional.ofNullable(restResult.getMessage()).orElseGet(() -> "access is not success");

            throw new RestResultAccessException(message);
        }
    }
}
