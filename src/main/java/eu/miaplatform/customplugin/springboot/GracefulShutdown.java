package eu.miaplatform.customplugin.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class GracefulShutdown implements ApplicationListener<ContextClosedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(GracefulShutdown.class);

    @Value("${delay.shutdown.seconds:0}")
    private Long delayShutdownSeconds;

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        try {
            logger.info("Start GracefulShutdown in {} seconds", delayShutdownSeconds);
            Thread.sleep(delayShutdownSeconds * 1000);
            logger.info("Completed GracefulShutdown");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
