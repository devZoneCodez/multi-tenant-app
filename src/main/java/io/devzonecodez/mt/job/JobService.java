package io.devzonecodez.mt.job;

import io.devzonecodez.mt.model.Scheduler;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface JobService {

    void startAll(List<Scheduler> schedulers, String tenant) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    void start(Scheduler scheduler, String tenant) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    void stopAll(List<Scheduler> schedulers, String tenant);

    void stop(Scheduler scheduler, String tenant);
}
