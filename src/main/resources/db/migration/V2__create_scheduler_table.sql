CREATE TABLE APP_SCHEDULER (
    record_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    scheduler_id    INT,
    is_active   INT
);

insert into APP_SCHEDULER(scheduler_id,is_active) values (1,1);
insert into APP_SCHEDULER(scheduler_id,is_active) values (2,1);

commit;
