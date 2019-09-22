package com.example.retrofit.context;

import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-09-22 16:41
 */
@Component
public class CustomCallAdapterFactory extends CallAdapter.Factory {
    @Override
    public CallAdapter<?, ?> get(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type instanceof ParameterizedType) {
            Class cla = getRawType(type);
            if (cla == Call.class) {
                return null;
            }
        }
        return new CallAdapterCore(type);
    }

    public static class CallAdapterCore<R> implements CallAdapter<R, R> {

        private Type type;

        public CallAdapterCore(Type type) {
            this.type = type;
        }

        @Override
        public Type responseType() {
            return type;
        }

        @Override
        public R adapt(Call<R> call) {
            try {
                Response<R> response = call.execute();
                if (response.code() != 200) {
                    throw new IllegalStateException("response code != 200,code=" + response.code() + ",msg=" + response.message());
                }
                return response.body();
            } catch (Exception e) {
                // TODO 可以自定义retrofit异常返回
                return null;
            }

        }
    }
}
