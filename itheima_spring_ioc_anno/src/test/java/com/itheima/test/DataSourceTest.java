package com.itheima.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.config.SpringConfiguration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSourceTest {

    //测试手动创建 c3p0 数据源
    @Test
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://rm-2ze9m82g1200dvx4hvo.mysql.rds.aliyuncs.com:3306/wangyongfeidb?serverTimezone=GMT%2B8");
        dataSource.setUser("wangyongfei");
        dataSource.setPassword("@wyf19980306");

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    //测试手动创建 druid 数据源
    @Test
    public void test2() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://rm-2ze9m82g1200dvx4hvo.mysql.rds.aliyuncs.com:3306/wangyongfeidb?serverTimezone=GMT%2B8");
//        dataSource.setUsername("wangyongfei");
//        dataSource.setPassword("@wyf19980306");

        dataSource.setUrl("jdbc:mysql://localhost:3308/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    //测试手动创建 druid 数据源（加载配置文件形式）
    @Test
    public void test() throws Exception {
        //读取配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        //创建数据源对象，设置连接参数
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    //测试Spring容器产生数据源对象
    @Test
    public void test4() throws Exception {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        DataSource dataSource = app.getBean(DataSource.class);
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
