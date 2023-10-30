package com.phonglt.demope;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.phonglt.demope.student.Student;
import com.phonglt.demope.student.StudentDao;

@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();
}
