package com.example.syamiyer.arrayadapterdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data
        Student syam = new Student("Syam", "Information Systems");
        Student john = new Student("John", "Informatics");
        Student mark = new Student("Mark", "Arts");
        Student luke = new Student("Luke", "Law");
        final Student[] students = {syam, john, mark, luke};

        // Make array of student names
        String[] studentNames = new String[students.length];
        for (int i = 0; i < students.length; i++) {
            studentNames[i] = students[i].getName();
        }

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentNames);
        listView = findViewById(R.id.listview);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String name = students[i].getName();
                String degree = students[i].getDegree();
                startDetailActivity(name, degree);
            }
        });
    }

    private void startDetailActivity(String name, String degree) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("NAME", name);
        intent.putExtra("DEGREE", degree);

        startActivity(intent);
    }



}
