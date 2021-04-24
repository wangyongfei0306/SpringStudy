package com.itheima.config;

import org.springframework.context.annotation.*;

//标志该类是Spring的核心配置类
@Configuration
//<!--配置组件扫描-->
//<context:component-scan base-package="com.itheima"/>
@ComponentScan("com.itheima")
//import
@Import(DataResourceConfiguration.class)
public class SpringConfiguration {
}
