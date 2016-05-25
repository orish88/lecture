package com.example.studentaveragemvc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Student> studentList;
    TextView tvShowAvg;
    Button btCalculateAvg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//NOt MVC:
        setContentView(R.layout.dynamic_activity_main);

        btCalculateAvg = (Button) findViewById(R.id.bt_calculate_avg);
        tvShowAvg = (TextView) findViewById(R.id.tv_show_avg);

        btCalculateAvg.setText("Calculate average");
        tvShowAvg.setText("--average--");
        tvShowAvg.setTextColor(Color.RED);
        tvShowAvg.setTextSize(25);
        tvShowAvg.setGravity(Gravity.CENTER);


        studentList = initializeStudentList();

        btCalculateAvg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double sum = 0;
                int counter = 0;
                for (Student student : studentList) {
                    if (student.gradeAvg > 60) {
                        sum += student.gradeAvg;
                        counter++;
                    }
                }
                tvShowAvg.setText("The average is:\n " + sum / counter);
            }

        });


//MVC:
//        setContentView(R.layout.activity_main);
//
//        btCalculateAvg = (Button) findViewById(R.id.bt_calculate_avg);
//        tvShowAvg = (TextView) findViewById(R.id.tv_show_avg);
//
//        studentList = initializeStudentList();
//
//        btCalculateAvg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                double sum = 0;
//                int counter = 0;
//                for(Student student: studentList){
//                    if(student.gradeAvg > 60) {
//                        sum += student.gradeAvg;
//                        counter++;
//                    }
//                }
//                tvShowAvg.setText("The average is:\n "+sum/counter);
//            }
//
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //The model, along with the Student object
    private ArrayList<Student> initializeStudentList(){
        ArrayList<Student> studentListTmp = new ArrayList<Student>();
        studentListTmp.add(new Student("Tal",26,100));
        studentListTmp.add(new Student("Iddo",25,89.8));
        studentListTmp.add(new Student("Ori",27,49.5));
        studentListTmp.add(new Student("Bibi",66,84.7));
        studentListTmp.add(new Student("Bogie",65,84.7));
        return studentListTmp;
    }

}
