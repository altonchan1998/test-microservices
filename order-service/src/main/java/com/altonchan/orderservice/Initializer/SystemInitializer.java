package com.altonchan.orderservice.Initializer;

import com.altonchan.orderservice.Initializer.interfaces.Initializer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemInitializer implements InitializingBean {

    @Autowired
    private List<Initializer> initializerList;

    @Override
    public void afterPropertiesSet() throws Exception {
        initializerList.forEach(Initializer::run);
    }
}
