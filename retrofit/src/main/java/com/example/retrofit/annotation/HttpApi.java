package com.example.retrofit.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 限定某个自定义注解能够被应用在哪些Java元素上
// 类，接口（包括注解类型）或枚举的声明--TYPE,
// 属性的声明--FIELD,
// 方法的声明--METHOD,
@Target(ElementType.TYPE)
/*
 *注解的生命周期有三个阶段：
 * SOURCE 1、Java源文件阶段；
 * CLASS  2、编译到class文件阶段；
 * RUNTIME 3、运行期阶段。
 */
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface HttpApi {

    String value() default "default";

    String desc() default "";
}
