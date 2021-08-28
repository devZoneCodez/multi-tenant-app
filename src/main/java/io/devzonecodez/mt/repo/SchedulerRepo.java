package io.devzonecodez.mt.repo;

import io.devzonecodez.mt.model.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulerRepo extends JpaRepository<Scheduler, Long> {

    @Query(value = "SELECT scheduler FROM Scheduler scheduler WHERE scheduler.active = 1")
    List<Scheduler> findAllActiveSchedulers();

}
