package com.learning.spring.debug.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 扩展ClassPathXmlApplicationContext
 *
 * @author lifang
 * @since 2021/4/10
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    private static final Logger logger = LogManager.getLogger(MyClassPathXmlApplicationContext.class);


    public MyClassPathXmlApplicationContext(String configLocation) throws BeansException {
        super(configLocation);
    }

    /**
     * 子类扩展实现
     * 控制是否允许覆盖同名称的不同对象以及是否允许循环依赖。
     */
    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        setAllowBeanDefinitionOverriding(true);
        setAllowCircularReferences(true);
    }

    /**
     * 子类扩展实现，
     * 可以用来校验Environment必须包含的参数，无没有该参数，会导致项目无法启动。
     */
    @Override
    protected void initPropertySources() {

        logger.info("执行MyClassPathXmlApplicationContext#initPropertySources方法");


        // 检测系统是否存在对应的的环境变量，否则就抛出异常
        getEnvironment().getRequiredProperty("flag");

    }
}
