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

@Configuration
@MapperScan(basePackages = {"com.tlf.creator.dao.user"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisDbAConfig {

    private final String MAPPER_LOCATION = "classpath:mapper/user/*.xml";

    @Bean("creatoraccount")
    @ConfigurationProperties(prefix = "spring.datasource.creatoraccount")
    public DataSource dataSource0() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean("sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory1(@Qualifier("creatoraccount") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource); // 使用titan数据源, 连接titan库
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        return factoryBean.getObject();

    }

    @Bean("sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate1(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory1) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1); // 使用上面配置的Factory
        return template;
    }

    @Bean("transactionManager1")
    public PlatformTransactionManager transactionManager1(@Qualifier("creatoraccount") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
