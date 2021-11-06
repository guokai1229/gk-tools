package top.guokaicn.tools.lang.rest;

/**
 * RestResult访问错误
 * @author guokai 2021/11/5 18:05
 */
public class RestResultAccessException extends RuntimeException
{
    public RestResultAccessException() {
        super();
    }

    public RestResultAccessException(String s) {
        super(s);
    }

    public RestResultAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestResultAccessException(Throwable cause) {
        super(cause);
    }
}
