package io.devzonecodez.mt.controller;

import io.devzonecodez.mt.config.web.TenantContextHolder;
import io.devzonecodez.mt.job.JobService;
import io.devzonecodez.mt.model.Scheduler;
import io.devzonecodez.mt.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private SchedulerService schedulerService;

    @Autowired
    private JobService jobService;

    @GetMapping(path = "/startAll")
    public String startAll() {
        String message = "Oops! Something went wrong!!!";
        List<Scheduler> schedulers = schedulerService.findAllActiveSchedulers();
        try {
            jobService.startAll(schedulers, TenantContextHolder.getTenantId());
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
            return message;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return message;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return message;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return message;
        }
        return "Schedulers are started!!!";
    }

    @GetMapping(path = "/stopAll")
    public String stopAll() {
        String message = "Oops! Something went wrong!!!";
        List<Scheduler> schedulers = schedulerService.findAllActiveSchedulers();
        jobService.stopAll(schedulers, TenantContextHolder.getTenantId());
        return "Schedulers are started!!!";
    }
}
