package com.phonglt.demope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.phonglt.demope.student.Student;
import com.phonglt.demope.student.StudentAdapter;
import com.phonglt.demope.subject.Subject;

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
    //        studentList.add(new Student(1, "Thanh Phong", LocalDateTime.now(),true, 20000000 ));
    //        studentList.add(new Student(2, "WyvernP", LocalDateTime.now(),true, 15000000 ));
        studentAdapter = new StudentAdapter(this, R.layout.student_view, studentList);
        lvStudent.setAdapter(studentAdapter);
        AppExecutors.getInstance().getDiskIO().execute(()->{
                studentList.addAll(mDB.studentDao().getAll());
                List<Subject> subjects =  mDB.subjectDao().getAll();
                studentAdapter.notifyDataSetChanged();
        }
        );
    }
    int curPos = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mapping();
    }
    private void initData(){
        mDB = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "db").build();
        AppExecutors.getInstance().getDiskIO().execute(()->{
                mDB.studentDao().insert(new Student(3, "long", LocalDateTime.now(),true, 200000 ));
                mDB.studentDao().insert(new Student(4, "su", LocalDateTime.now(),true, 7000000 ));
                mDB.subjectDao().insert(new Subject("Mobile Android"));
                mDB.subjectDao().insert(new Subject(".NET Basic"));
                mDB.subjectDao().insert(new Subject(".NET Advanced"));
                mDB.subjectDao().insert(new Subject("Game Unity"));
                mDB.subjectDao().insert(new Subject("System Design"));
        });
    }
}