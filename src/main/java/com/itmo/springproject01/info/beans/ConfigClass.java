package com.itmo.springproject01.info.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// аннотация @Configuration обычно используется, если в классе есть методы,
// создающие Bean объекты и помещающие их в контекст spring
@Configuration // объект ConfigClass будет создан и помещён в контекст spring
public class ConfigClass {

    @Primary
    @Bean
    public Runnable runnable01(){
        return ()-> System.out.println("runnable01");
    }

    @Bean("task02")
    public Runnable runnable02(){
        return ()-> System.out.println("runnable02");
    }
}