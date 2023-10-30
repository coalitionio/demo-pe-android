package com.phonglt.demope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.phonglt.demope.student.Student;
import com.phonglt.demope.student.StudentAdapter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvStudent;
    StudentAdapter studentAdapter;
    List<Student> studentList;

    FloatingActionButton btnAdd;
    private AppDatabase mDB;
    private void mapping(){
        lvStudent = findViewById(R.id.lvStudent);
        btnAdd = findViewById(R.id.btnAdd);
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Thanh Phong", LocalDateTime.now(),true, 20000000 ));
        studentList.add(new Student(2, "WyvernP", LocalDateTime.now(),true, 15000000 ));
        studentAdapter = new StudentAdapter(this, R.layout.student_view, studentList);
        lvStudent.setAdapter(studentAdapter);
        mDB = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "db").build();
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDB.studentDao().insert(new Student(3, "long", LocalDateTime.now(),true, 200000 ));
                mDB.studentDao().insert(new Student(4, "su", LocalDateTime.now(),true, 7000000 ));
            }
        });
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                studentList.addAll(mDB.studentDao().getAll());
            }
        });
    }
    int curPos = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
    }
}