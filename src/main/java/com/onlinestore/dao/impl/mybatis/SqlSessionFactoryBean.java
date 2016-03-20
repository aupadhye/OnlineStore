package com.onlinestore.dao.impl.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import javax.sql.DataSource;

public class SqlSessionFactoryBean extends AbstractFactoryBean {

    // String resource = "mybatis/mybatis-config.xml";
    private String configLocation;
    private DataSource dataSource;

    @Override
    public Class<?> getObjectType() {
        return SqlSessionFactory.class;
    }

    @Override
    protected Object createInstance() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream(configLocation);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        Environment environment = configuration.getEnvironment();
        configuration.setEnvironment(new Environment("Default", environment.getTransactionFactory(), dataSource));
        return sqlSessionFactory;
    }

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
