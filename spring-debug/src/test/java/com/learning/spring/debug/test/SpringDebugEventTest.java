package com.learning.spring.debug.test;

import com.learning.spring.debug.custom.event.CustomApplicationEvent;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:spring-custom-event.xml")
public class SpringDebugEventTest extends SpringDebugTest{

    @Test
    void testEvent(){
        applicationContext.publishEvent(new CustomApplicationEvent("自定义事件"));
    }

}
