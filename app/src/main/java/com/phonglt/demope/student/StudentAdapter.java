package com.phonglt.demope.student;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phonglt.demope.R;
import com.squareup.picasso.Picasso;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Student> students;

    @Override
    public int getCount() {
        return students.size();
    }
    public StudentAdapter(Context context, int layout, List<Student> students) {
        this.context = context;
        this.layout = layout;
        this.students = students;
    }
    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
         return students.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtName = (TextView) view.findViewById(R.id.stu_name);
        TextView txtDob = (TextView) view.findViewById(R.id.dob);
        TextView txtGender = (TextView) view.findViewById(R.id.stu_gender);
        TextView txtSalary = (TextView) view.findViewById(R.id.stu_salary);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        Student student = students.get(position);
        txtName.setText(student.getName());
        txtGender.setText(student.isGender() ? "Male": "Female");
        txtGender.setText(String.valueOf(student.getSalary()));
        txtDob.setText(LocalDateTime.ofEpochSecond(student.getDate()/1000, 0, ZoneOffset.UTC)
                                    .format(DateTimeFormatter.ISO_LOCAL_DATE));
        String imageUrl = "https://images.unsplash.com/photo-1697197850355-c70e8ea18394?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxfDB8MXxyYW5kb218MHx8fHx8fHx8MTY5ODYwMDE2OQ&ixlib=rb-4.0.3&q=80&w=1080";
        Picasso.get().load(imageUrl).into(imageView);
//        imageView.setImageURI(Uri.parse("https://source.unsplash.com/random"));
        return view;
    }
}
