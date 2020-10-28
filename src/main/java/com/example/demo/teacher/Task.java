package com.example.demo.teacher;

import java.security.acl.Owner;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.example.demo.model.NamedEntity;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tasks")
public class Task extends NamedEntity {

    @Column(name = "deadline_to_complete")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Owner teacher;
}
