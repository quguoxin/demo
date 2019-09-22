package com.example.retrofit.intercepts;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-09-22 16:46
 */
public class RetrofitRequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request().newBuilder()
                .addHeader("app_key", "myAppKey")
                .addHeader("sign", "12345678")
                .addHeader("times_tamp", "2019-06-01 13:47:45")
                .build();
        // 开始请求
        return chain.proceed(request);
    }
}
