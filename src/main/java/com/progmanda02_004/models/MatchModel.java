package com.progmanda02_004.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name="matches")
@Entity
public class MatchModel {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long duration;

    @Column
    private String name;

    @Column
    private Date date;
}
