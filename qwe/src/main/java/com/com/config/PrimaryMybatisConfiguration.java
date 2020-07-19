package com.com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.com.properties.PrimaryMybatisProperties;
import com.github.pagehelper.PageInterceptor;

@Configuration
@MapperScan(basePackages = { "com.com.db1.mapper" },sqlSessionFactoryRef="primarySqlSessionFactory")
public class PrimaryMybatisConfiguration {
	private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PrimaryMybatisProperties property;

    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    @Primary
    public DataSource dataSource() {
    	log.info("config primaryDataSource success.");
    	return DataSourceBuilder.create().build();
    }

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(
    		@Qualifier("primaryDataSource") DataSource dataSource) {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources(this.property.getMybatisMapperLocations()));
            
            //分页插件
			Interceptor interceptor = new PageInterceptor();
			Properties properties = new Properties();
			properties.setProperty("helperDialect", this.property.getPagehelperDialect());
			properties.setProperty("reasonable", this.property.getPagehelperReasonable());
			properties.setProperty("supportMethodsArguments",this.property.getPagehelperSupportMethodsArguments());
			properties.setProperty("params",this.property.getPagehelperParams());
			interceptor.setProperties(properties);
			sessionFactory.setPlugins(new Interceptor[] {interceptor});
            
            
            log.info("config primarySqlSessionFactory success.");
            return sessionFactory.getObject();
        } catch (Exception e) {
            log.error("config primarySqlSessionFactory failure.", e);
            return null;
        }
    }
    
    @Bean(name = "primarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(
    		@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(
    		@Qualifier("primaryDataSource") DataSource dataSource) {
    	return new DataSourceTransactionManager(dataSource);
    }
}
