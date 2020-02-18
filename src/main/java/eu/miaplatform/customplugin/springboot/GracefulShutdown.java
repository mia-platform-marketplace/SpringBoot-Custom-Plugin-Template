package eu.miaplatform.customplugin.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class GracefulShutdown implements ApplicationListener<ContextClosedEvent> {

    @Value("${delay.shutdown.seconds:10}")
    private Long delayShutdownSeconds;

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        try {
            Thread.sleep(delayShutdownSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
