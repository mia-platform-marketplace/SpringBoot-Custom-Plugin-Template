package eu.miaplatform.customplugin.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class GracefulShutdown implements ApplicationListener<ContextClosedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(GracefulShutdown.class);

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        try {
            logger.info("START GracefulShutdown...");
            Thread.sleep(10000);
            logger.info("COMPLETED GracefulShutdown");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
