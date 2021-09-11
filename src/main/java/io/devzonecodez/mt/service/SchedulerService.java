package io.devzonecodez.mt.service;

import io.devzonecodez.mt.model.Scheduler;

import java.util.List;

public interface SchedulerService {

    List<Scheduler> findAll();

    List<Scheduler> findAllActiveSchedulers();

}
