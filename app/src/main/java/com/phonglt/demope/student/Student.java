package com.phonglt.demope.student;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.phonglt.demope.subject.Subject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity(tableName = "student")
public class Student implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String name;
    private long date;
    private boolean gender;
    private double salary;
    private String address;
    private int idNganh;

    @Ignore
    private Subject subject;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(int idNganh) {
        this.idNganh = idNganh;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }



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
