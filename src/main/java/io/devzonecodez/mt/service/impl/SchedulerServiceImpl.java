package io.devzonecodez.mt.service.impl;

import io.devzonecodez.mt.model.Scheduler;
import io.devzonecodez.mt.repo.SchedulerRepo;
import io.devzonecodez.mt.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private SchedulerRepo schedulerRepo;

    @Override
    public List<Scheduler> findAll() {
        List<Scheduler> schedulers = new ArrayList<>();
        Iterable<Scheduler> schedulerIterable = schedulerRepo.findAll();
        schedulerIterable.forEach(schedulers::add);
        return schedulers;
    }

    @Override
    public List<Scheduler> findAllActiveSchedulers() {
        return schedulerRepo.findAllActiveSchedulers();
    }
}
