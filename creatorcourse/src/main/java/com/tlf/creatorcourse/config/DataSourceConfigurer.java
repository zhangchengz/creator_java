package com.tlf.creatorcourse.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = {"com.tlf.creatorcourse.dao"})
public class DataSourceConfigurer {

    private final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    // ------------------------------ 数据源配置 ------------------------------
    @Bean("creatorcourse")
    @ConfigurationProperties(prefix = "spring.datasource.creatorcourse")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /*@Bean("creatorcourse1")
    @ConfigurationProperties(prefix = "spring.datasource.creatorcourse1")
    public DataSource dataSource1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("creatorcourse2")
    @ConfigurationProperties(prefix = "spring.datasource.creatorcourse2")
    public DataSource dataSource2() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("creatorcourse3")
    @ConfigurationProperties(prefix = "spring.datasource.creatorcourse3")
    public DataSource dataSource3() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("creatorcourse4")
    @ConfigurationProperties(prefix = "spring.datasource.creatorcourse4")
    public DataSource dataSource4() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("creatorcourse5")
    @ConfigurationProperties(prefix = "spring.datasource.creatorcourse5")
    public DataSource dataSource5() {
        return DruidDataSourceBuilder.create().build();
    }*/

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicRoutingDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("creatorcourse", dataSource());
        //dataSourceMap.put("creatorcourse1", orderRead()1);
        //dataSourceMap.put("creatorcourse2", orderRead()2);
        //dataSourceMap.put("creatorcourse3", orderRead()3);
        //dataSourceMap.put("creatorcourse4", orderRead()4);
        //dataSourceMap.put("creatorcourse5", orderRead()5);

        // 将 driverOrderRecordMaster 数据源作为默认指定的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(dataSource());
        // 指定使用到的所有数据源
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);

        // 将数据源的 key 放到数据源上下文的 key 集合中，用于切换时判断数据源是否有效
        DataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());

        return dynamicRoutingDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    // 注入 DataSourceTransactionManager 事务
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }
}
