package io.devzonecodez.mt.job;

import io.devzonecodez.mt.model.Scheduler;

import java.util.List;

public interface JobService {

    void startAll(List<Scheduler> schedulers, String tenant);

    void start(Scheduler scheduler, String tenant);

    void stopAll(List<Scheduler> schedulers, String tenant);

    void stop(Scheduler scheduler, String tenant);
}
