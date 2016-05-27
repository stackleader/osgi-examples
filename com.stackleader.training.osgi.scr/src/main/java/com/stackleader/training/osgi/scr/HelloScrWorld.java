package com.stackleader.training.osgi.scr;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * This annotation declares the class as an SCR component and specifies
 * that it should be immediately activated once its dependencies have been
 * satisfied.
 */
@Component(immediate = true)
public class HelloScrWorld {

    private static final Logger LOG = LoggerFactory.getLogger(HelloScrWorld.class);

    public HelloScrWorld() {
        //The constructor will be called first by SCR
        LOG.info("constructor called");
    }

    /*
     * This annotation indicates to our annotation processor that this is the
     * method we would like to have called when our component is activated. In
     * this instance it was optional since SCR will default to calling a void
     * method named activate if it exist; however, if we had wanted to use a
     * non-default name, the annotation would be necessary.
     */
    @Activate
    public void activate() {
        /*
         * The Activate method will be called after any required dependencies
         * have been injected.
         *
         */
        LOG.info("component activated");
    }

    @Deactivate
    public void deactivate() {
        /*
         * The deactivate lifecycle hook will fire only when an activated
         * component component becomes disabled, the component configuration
         * becomes unsatisfied, or the component configuration is no longer
         * needed.
         *
         */
        LOG.info("component deactivated");
    }

}
