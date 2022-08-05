package com.xdl;

import com.xdl.bean.Pet;
import com.xdl.bean.User;
import com.xdl.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 * @SpringBootApplication：表示这是一个SpringBoot应用
 */
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        // 1、启动程序，并返回IOC容器
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootDemoApplication.class, args);
        // 2、查看容器里面的组件
//        String[] names = ctx.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//        // 3、从容器中获取组件
//        Pet tom01 = ctx.getBean("tom1", Pet.class);
//        Pet tom02 = ctx.getBean("tom1", Pet.class);
//        System.out.println("tom01 == tom02? " + tom01.equals(tom02));
//
//        // com.xdl.config.MyConfig$$EnhancerBySpringCGLIB$$aae35120@516ebdf8
//        MyConfig myConfig = ctx.getBean(MyConfig.class);
//        System.out.println(myConfig);
//
//        // 如果@Configuration(proxyBeanMethods = true)代理对象对用方法，SpringBoot总会检查这个组件是否在容器中
//        // 保存组件单实例
//        User user= myConfig.user01();
//        User user1 = myConfig.user01();
//        System.out.println(user.equals(user1));
//
//        User user01 = ctx.getBean("user01", User.class);
//        Pet tom = ctx.getBean("tom1", Pet.class);
//        System.out.println("用户的宠物："+ (user01.getPet() == tom));
//
//        // 获取组件
//        System.out.println("----------------@Import---------------------");
//        String[] beanNamesForType = ctx.getBeanNamesForType(User.class);
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }

//        boolean tom = ctx.containsBean("tom1");
//        System.out.println("容器中是否有tom组件" + tom);
//        boolean user01 = ctx.containsBean("user01");
//        System.out.println("容器中是否包含user01组件" + user01);
        // -------------------@ImportResource-------------------------------
        boolean cat = ctx.containsBean("cat");
        System.out.println("容器中是否有cat组件" + cat);


    }

}
