package se.astrom.springloppis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(scopeName = "prototype")
public class BeanScopesDemo {

    Logger logger = LoggerFactory.getLogger(BeanScopesDemo.class);

    @PostConstruct
    public void OnInitialize() {
        logger.info("BeanScopesDemo bean is alive.");

    }

}
