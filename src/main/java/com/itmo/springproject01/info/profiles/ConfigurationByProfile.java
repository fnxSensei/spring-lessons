package com.itmo.springproject01.info.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// аннотация @Configuration обычно используется, если в классе есть методы,
// создающие Bean объекты и помещающие их в контекст spring
@Configuration // объект ConfigurationByProfile будет создан и помещён в контекст spring
public class ConfigurationByProfile {

    @Profile("prod")
    @Bean
    public Runnable runnable01(){
        System.out.println("prod");
        return ()-> System.out.println("runnable01");
    }

    @Profile("dev")
    @Bean
    public Runnable runnable02(){
        return ()-> System.out.println("runnable02");
    }
}