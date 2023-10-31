package com.phonglt.demope.subject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.phonglt.demope.student.Student;

import java.util.List;

@Dao
public interface SubjectDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Subject subject);
    @Update
    void update(Subject subject);
    @Delete
    void delete(Subject subject);

    @Query("SELECT * FROM subject")
    List<Subject> getAll();
    @Query("Select * FROM subject WHERE idNganh IN (:id)")
    Subject getById (int id);
}
