CREATE TABLE APP_SCHEDULER (
    record_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    id    INT,
    name  VARCHAR(255),
    class  VARCHAR(255),
    is_active   INT
);

insert into APP_SCHEDULER(id, name, class, is_active)
    values (1,'EmailInboundJob','io.devzonecodez.mt.job.EmailInboundJob',1);

insert into APP_SCHEDULER(id, name, class, is_active)
    values (2,'EmailOutboundJob','io.devzonecodez.mt.job.EmailOutboundJob',1);

