package com.phonglt.demope.student;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Student student);
    @Update
    void update(Student student);
    @Delete
    void delete(Student student);

    @Query("SELECT * FROM student  ORDER BY id DESC")
    List<Student> getAll();
    @Query("Select * FROM student WHERE id IN (:id)")
    Student getById (int id);
}
