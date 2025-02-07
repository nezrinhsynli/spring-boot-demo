package com.nezrinhuseynli.spring_data_jpa.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.nezrinhuseynli.spring_data_jpa"})
@ComponentScan(basePackages = {"com.nezrinhuseynli.spring_data_jpa"})
@EnableJpaRepositories(basePackages = {"com.nezrinhuseynli.spring_data_jpa"})
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

}
