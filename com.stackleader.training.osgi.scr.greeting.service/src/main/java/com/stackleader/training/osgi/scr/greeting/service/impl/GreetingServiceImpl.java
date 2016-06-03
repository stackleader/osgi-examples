package com.stackleader.training.osgi.scr.greeting.service.impl;

import com.stackleader.training.osgi.scr.greeting.service.GreetingService;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * This annotation declares the class as an SCR component and specifies
 * that it should be immediately activated once its dependencies have been
 * satisfied. Additionally, because this class implements an interface, it will 
 * automatically be registered as a provider of the GreetingService interface.
 * 
 * Alternatively, if we could have explicitly declared the provided interface using
 * the 'provide' annotation parameter (e.g. @Component(immediate = true, provide = GreetingService.class))
 */
@Component(immediate = true)
public class GreetingServiceImpl implements GreetingService {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingServiceImpl.class);

    public void sayHello(String name) {
        if (!(name == null || name.isEmpty())) {
            LOG.info("Hello " + name);
        } else {
            LOG.error("This service cannot greet the nameless");
        }
    }
}
