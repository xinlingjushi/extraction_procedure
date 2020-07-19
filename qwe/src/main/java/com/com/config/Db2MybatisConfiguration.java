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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.com.properties.Db2MybatisProperties;
import com.github.pagehelper.PageInterceptor;
@Configuration
@MapperScan(basePackages = { "com.com.db2.mapper" },sqlSessionFactoryRef="db2SqlSessionFactory")
public class Db2MybatisConfiguration {
	private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Db2MybatisProperties property;

    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource dataSource() {
    	log.info("config db2DataSource success.");
    	return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
    		@Qualifier("db2DataSource") DataSource dataSource) {
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
			
            
            log.info("config db2SqlSessionFactory success.");
            return sessionFactory.getObject();
        } catch (Exception e) {
            log.error("config db2SqlSessionFactory failure.", e);
            return null;
        }
    }
    
    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
    		@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager transactionManager(
    		@Qualifier("db2DataSource") DataSource dataSource) {
    	return new DataSourceTransactionManager(dataSource);
    }
}
