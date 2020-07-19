package com.com;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 微服务应用服务启动类 
 * @author Windows10
 *
 */
@SpringBootApplication(scanBasePackages={"com.com","com.sgcc.uap.rest.annotation","com.sgcc.uap.mdd.runtime"},exclude = { DataSourceAutoConfiguration.class,MybatisAutoConfiguration.class, PageHelperAutoConfiguration.class })
@EnableScheduling
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
