package io.devzonecodez.mt.job;

import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailOutboundJob implements AppJob {

    @Override
    public void execute(String tenant) {
        System.out.println(tenant +" - " + "EmailOutboundJob");
    }
}
