package com.example.retrofit.config;

import com.example.retrofit.context.CustomCallAdapterFactory;
import com.example.retrofit.context.RetrofitContext;
import com.example.retrofit.intercepts.RetrofitRequestInterceptor;
import com.example.retrofit.intercepts.RetryInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MINUTES;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class RetrofitConfiguration {

    private final RetrofitProperties retrofitProperties;

    private final RetrofitContext context;

    @Autowired
    public RetrofitConfiguration(RetrofitProperties retrofitProperties, RetrofitContext context) {
        this.retrofitProperties = retrofitProperties;
        this.context = context;
        checkConfiguredUrl(this.retrofitProperties);
    }

    @Bean
    OkHttpClient initClient() {
        RetrofitProperties.Connection connection = retrofitProperties.getConnection();
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(new RetrofitRequestInterceptor())
                .addInterceptor(new RetryInterceptor(retrofitProperties.getConnection().getRetryTimes()))
                .addInterceptor(loggingInterceptor())
                .readTimeout(connection.getReadTimeout(), TimeUnit.MILLISECONDS)
                .writeTimeout(connection.getWriteTimeout(), TimeUnit.MILLISECONDS)
                .connectTimeout(connection.getConnectTimeout(), TimeUnit.MILLISECONDS)
                .connectionPool(new ConnectionPool(connection.getMaxIdleConnections(), connection.getKeepAliveDuration(), MINUTES));

        return client.build();
    }

    @Bean
    void initRetrofit() {
        List<RetrofitProperties.EndPoint> endPoints = retrofitProperties.getEndpoints();
        endPoints.forEach(endPoint -> {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(endPoint.getBaseUrl())
                    .client(initClient())
                    .addCallAdapterFactory(new CustomCallAdapterFactory())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    String 转换器
//                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).build();
            context.setRetrofit(endPoint.getIdentity(), retrofit);
        });
    }

    @Bean
    HttpLoggingInterceptor loggingInterceptor() {
        RetrofitProperties.Log logConf = retrofitProperties.getLog();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(innerLogger(logConf.getLevel(), RetrofitConfiguration.log));
        interceptor.setLevel(logConf.getContent());
        return interceptor;
    }

    private HttpLoggingInterceptor.Logger innerLogger(Level level, Logger logger) {
        if (level == Level.DEBUG) {
            return logger::debug;
        } else if (level == Level.ERROR) {
            return logger::error;
        } else if (level == Level.INFO) {
            return logger::info;
        } else if (level == Level.TRACE) {
            return logger::trace;
        } else if (level == Level.WARN) {
            return logger::warn;
        }
        throw new UnsupportedOperationException("We don't support this log level currently.");
    }

    private void checkConfiguredUrl(RetrofitProperties properties) {
        properties.getEndpoints().stream()
                .map(RetrofitProperties.EndPoint::getBaseUrl)
                .forEach(url -> {
                    Assert.isTrue(ResourceUtils.isUrl(url), url + " is not a valid url");
                    if (!url.endsWith("/")) {
                        log.warn("The [{}] didn't end with \"/\". This means a relative base url, end with / would be better.", url);
                    }
                });
    }
}
