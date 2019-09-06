package com.tlf.creator.config;

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

/**
 * 配置数据源类
 *
 * @author zhangc
 * @date 2019/9/6
 */
@Configuration
@MapperScan(basePackages = {"com.tlf.creator.dao.curriculum"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfigurer {

    private final String MAPPER_LOCATION = "classpath:mapper/curriculum/*.xml";

    /**
     * 数据源配置
     * @return
     */
    @Bean("course_dj")
    @ConfigurationProperties(prefix = "spring.datasource.course-dj")
    public DataSource dataSourceDJ() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("course_cp")
    @ConfigurationProperties(prefix = "spring.datasource.course-cp")
    public DataSource dataSourceCP() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicRoutingDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("course_dj", dataSourceDJ());
        dataSourceMap.put("course_cp", dataSourceCP());
        // 将 driverOrderRecordMaster 数据源作为默认指定的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(dataSourceDJ());
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

    /**
     * 注入 DataSourceTransactionManager 事务
     */
    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }
}
