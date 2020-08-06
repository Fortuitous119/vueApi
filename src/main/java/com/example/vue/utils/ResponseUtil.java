package com.example.vue.utils;

import com.example.vue.constant.ResponseContant;
import com.example.vue.response.BaseResponse;

/**
 * 
 * @author huxuelin
 *
 */
public class ResponseUtil {
    @SuppressWarnings({ "rawtypes" })
    public static BaseResponse success(Object object) {
        return success(1, ResponseContant.OPERATION_SUCCESS, object);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static BaseResponse success(int code, String message, Object object) {
        BaseResponse resp = new BaseResponse();
        resp.setCode(code);
        resp.setMsg(message);
        resp.setData(object);
        return resp;
    }

    @SuppressWarnings("rawtypes")
    public static BaseResponse error(Integer code, String msg) {
        BaseResponse resp = new BaseResponse();
        resp.setCode(code);
        resp.setMsg(msg);
        return resp;
    }
}
