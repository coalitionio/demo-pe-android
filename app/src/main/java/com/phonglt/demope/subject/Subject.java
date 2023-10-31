package com.phonglt.demope.subject;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "subject")
public class Subject implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int idNganh;

    private String nameNganh;

    public int getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(int idNganh) {
        this.idNganh = idNganh;
    }

    public String getNameNganh() {
        return nameNganh;
    }

    public void setNameNganh(String nameNganh) {
        this.nameNganh = nameNganh;
    }

    @Ignore
    public Subject(int idNganh, String nameNganh) {
        this.idNganh = idNganh;
        this.nameNganh = nameNganh;
    }
    @Ignore

    public Subject( String nameNganh) {
        this.nameNganh = nameNganh;
    }

    public Subject() {
    }
}
