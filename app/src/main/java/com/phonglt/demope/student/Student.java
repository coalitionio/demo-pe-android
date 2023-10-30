package com.phonglt.demope.student;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String name;
    private long date;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    private boolean gender;
    private double salary;

    public Student() {
    }

    public Student(int id, String name, LocalDateTime date, boolean gender, double salary) {
        this.id = id;
        this.name = name;
        this.date = date.toEpochSecond(ZoneOffset.UTC) * 1000;;
        this.gender = gender;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public LocalDateTime getDate() {
//        return LocalDateTime.ofEpochSecond(date / 1000, 0, ZoneOffset.UTC);
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date.toEpochSecond(ZoneOffset.UTC) * 1000;
//    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
