package com.stackleader.training.osgi.scr;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dcnorris
 */
@Component(immediate = true)
public class HelloScrWorld {

    private static final Logger LOG = LoggerFactory.getLogger(HelloScrWorld.class);

    public HelloScrWorld() {
        LOG.info("HelloScrWorld constructor called");
    }

    @Activate
    public void activate() {
        LOG.info("HelloScrWorld component activated");
    }

}
