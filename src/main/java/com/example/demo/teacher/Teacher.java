package com.example.demo.teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.demo.model.*;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    @Column(name= "school")
    @NotNull
    private String school;

    @Column(name = "grade_level")
    @NotNull
    private String gradeLevel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Task> tasks;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    protected Set<Task> getTasksInternal() {
        if (this.tasks == null) {
            this.tasks = new HashSet<>();
        }
        return this.tasks;
    }

    protected void setTasksInternal(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        List<Task> sortedTasks = new ArrayList<>(getTasksInternal());
        PropertyComparator.sort(sortedTasks, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedTasks);
    }

    @Override
    public String toString() {
        return "Teacher [gradeLevel=" + gradeLevel + ", school=" + school + ", tasks=" + tasks + "]";
    }



}
