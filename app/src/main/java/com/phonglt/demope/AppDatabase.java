package com.phonglt.demope;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.phonglt.demope.student.Student;
import com.phonglt.demope.student.StudentDao;
import com.phonglt.demope.subject.Subject;
import com.phonglt.demope.subject.SubjectDao;

@Database(entities = {Student.class, Subject.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();
    public abstract SubjectDao subjectDao();
}