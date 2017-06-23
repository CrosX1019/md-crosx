package com.root.crosx.network.exception;

/**
 * Created by CrosX on 2017/6/23.
 */

public class HttpTimeException extends RuntimeException {
    public static final int NO_DATA = 0x2;

    public HttpTimeException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public HttpTimeException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 转换错误数据
     *
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code) {
        String message = "";
        switch (code) {
            case NO_DATA:
                message = "无数据";
                break;
            default:
                message = "请求失败";
                break;
        }
        return message;
    }
}
