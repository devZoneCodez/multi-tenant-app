package io.devzonecodez.mt.config.scheduler;

import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public StorageProvider storageProvider(JobMapper jobMapper) {
        InMemoryStorageProvider imStorageProvider = new InMemoryStorageProvider();
        imStorageProvider.setJobMapper(jobMapper);
        return imStorageProvider;
    }
}
