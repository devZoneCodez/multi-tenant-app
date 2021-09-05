package io.devzonecodez.mt.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class EmailOutboundJob implements AppJob {

    @Override
    public void execute(String tenant) {
        log.info("EmailOutboundJob: " + tenant +" - " + "Start");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        log.info("EmailOutboundJob: " + tenant +" - " + "End");
    }
}
