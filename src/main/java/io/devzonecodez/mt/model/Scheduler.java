package io.devzonecodez.mt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "APP_SCHEDULER")
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedQuery(name = "Scheduler.findAll",
        query = "SELECT scheduler FROM Scheduler scheduler")
@NamedQuery(name = "Scheduler.findAllActiveSchedulers",
        query = "SELECT scheduler FROM Scheduler scheduler WHERE scheduler.active = 1")

public class Scheduler implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECORD_ID")
    private Long recordId;

    @Column(name = "ID")
    private Integer schedulerId;

    @Column(name = "NAME")
    private String schedulerName;

    @Column(name = "CLASS")
    private String schedulerClass;

    @Column(name = "IS_ACTIVE")
    private Integer active;

}