package com.xdl.config;

import com.xdl.bean.Car;
import com.xdl.bean.Pet;
import com.xdl.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods: 代理bean的方法
 *      Full（proxyBeanMethods = true）， Lite（proxyBeanMethods = false）
 *      组件依赖
 * 4、@Import({User.class})
 *      给容器中自动创建user对象， 默认组件的名称就是全类名
 * 5、@ImportResource("classpath:beans.xml")：
 *      加载beans.xml配置文件，等效于new ClassPathXmlApplicationContext("spring.xml");
 */
@Import({User.class})
@Configuration(proxyBeanMethods = true) //告诉springboot这是一个配置类，等价与配置文件（beans.xml）
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class) // 开启Car配置绑定功能；把Car组件自动注册到容器中
public class MyConfig {
    @Bean("tom1") // 执行组件的ID为tom1
    public Pet tomcatPet() {
        return new Pet("tomecat");
    }
    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
    @ConditionalOnBean(name = "tom1") // 如果容器中有tom1组件时，才会注册user01组件， 需要配置@Bean注解使用。tom1有先后顺序。
    @Bean // 给容器中添加组件，默认以方法名作为组件的id。返回类型就是组件类型，返回的值就是组件在容器中的实例
    public User user01() {
        User user = new User("zhangsan", 18);
        // user组件依赖了pet组件
        user.setPet(this.tomcatPet());
        return user;
    }

}
