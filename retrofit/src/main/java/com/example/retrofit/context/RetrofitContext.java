package com.example.retrofit.context;

import com.example.retrofit.annotation.HttpApi;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-09-22 16:41
 */
@Component
public class RetrofitContext extends ConcurrentHashMap<String, Retrofit> {

    public Retrofit setRetrofit(String identity, Retrofit retrofit) {
        return put(identity, retrofit);
    }

    public Optional<Retrofit> getRetrofit(String identity) {
        return Optional.ofNullable(get(identity));
    }

    private <T> T creatService(Class<T> serviceClass) {
        HttpApi config = serviceClass.getAnnotation(HttpApi.class);
        Optional<Retrofit> optional = getRetrofit(config.value());
        if (optional.isPresent()) {
            return optional.get().create(serviceClass);
        }
        throw new IllegalArgumentException(serviceClass.getName() + "RetrofitConfig baseUrl not found config");
    }

}
