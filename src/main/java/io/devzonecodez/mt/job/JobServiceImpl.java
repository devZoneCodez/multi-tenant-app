package io.devzonecodez.mt.job;

import io.devzonecodez.mt.config.web.TenantContextHolder;
import io.devzonecodez.mt.model.Scheduler;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Slf4j
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private JobScheduler jobScheduler;


    @Override
    public void startAll(List<Scheduler> schedulers, String tenant) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        schedulers.stream().forEach(scheduler -> {
            String jobId = scheduler.getSchedulerId() + "_"
                    + tenant + "_" + scheduler.getSchedulerName();
            jobScheduler.scheduleRecurrently(jobId, Cron.minutely(),
                    () -> {
                        TenantContextHolder.setTenantId(tenant);
                        start(scheduler, TenantContextHolder.getTenantId());
                    });
        });
    }

    @Override
    public void start(Scheduler scheduler, String tenant) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String jobId = scheduler.getSchedulerId() + "_"
                + tenant + "_" + scheduler.getSchedulerName();
        TenantContextHolder.setTenantId(tenant);
        jobScheduler.scheduleRecurrently(jobId, Cron.minutely(),
                () -> startJob(scheduler, tenant));
    }

    @Override
    public void stopAll(List<Scheduler> schedulers, String tenant) {
        schedulers.stream().forEach(scheduler -> {
            String jobId = scheduler.getSchedulerId() + "_"
                    + tenant + "_" + scheduler.getSchedulerName();
            TenantContextHolder.setTenantId(tenant);
            stop(scheduler, tenant);
        });
    }

    @Override
    public void stop(Scheduler scheduler, String tenant) {
        String jobId = scheduler.getSchedulerId() + "_"
                + tenant + "_" + scheduler.getSchedulerName();
        TenantContextHolder.setTenantId(tenant);
        jobScheduler.delete(jobId);
    }

    public void startJob(Scheduler scheduler, String tenant) throws InvocationTargetException,
            IllegalAccessException, ClassNotFoundException,
            NoSuchMethodException, InstantiationException {
        log.info("TenantContextHolder.getTenantId() = " + tenant);
        log.info("startJob - " + scheduler.getSchedulerClass());
        Class aClass = Class.forName(scheduler.getSchedulerClass());
        AppJob appJob = (AppJob) applicationContext.getBean(aClass);
        appJob.execute(tenant);
    }

}
