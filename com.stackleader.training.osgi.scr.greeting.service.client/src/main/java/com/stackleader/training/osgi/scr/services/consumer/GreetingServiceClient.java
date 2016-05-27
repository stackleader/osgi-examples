package com.stackleader.training.osgi.scr.services.consumer;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import aQute.bnd.annotation.component.Reference;
import com.stackleader.training.osgi.scr.greeting.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * This annotation declares the class as an SCR component and specifies
 * that it should be immediately activated once its dependencies have been
 * satisfied. In this instance, the component will be activated after the
 * GreetingService has been injected.
 *
 */
@Component(immediate = true)
public class GreetingServiceClient {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingServiceClient.class);
    private GreetingService greetingService;

    public GreetingServiceClient() {
        LOG.info("GreetingServiceClient instantiated");
    }

    @Activate
    private void activate() {
        LOG.info("GreetingServiceClient component activated");
        greetingService.sayHello("Greeting Service Client");
    }

    /**
     * This annotation is the declaration to SCR that this is the location to
     * inject the GreetingService implementation. We have also included a
     * non-default
     * unbind method reference to indicate the "removeGreetingService" should be
     * called
     * if the GreetingService is no longer available. The default would have
     * been to call
     * a method by the same name as our injection method name prefixed by "un".
     * In
     * this case that would have been "unsetGreetingService".
     */
    @Reference(unbind = "removeGreetingService")
    public void setGreetingService(GreetingService greetingService) {
        LOG.info("GreetingService injection");
        this.greetingService = greetingService;
    }

    /**
     * This method demonstrates the unbind life-cycle hook. 
     */
    public void removeGreetingService(GreetingService greetingService) {
        LOG.info("GreetingService removed");
    }

    @Deactivate
    public void deactivate() {
        LOG.info("GreetingServiceClient deactivated");
    }
}
