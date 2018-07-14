package com.example.limsungwoo.minimaltodo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floating;
    ListView list;

    ArrayList memoData = new ArrayList<Data>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floating = findViewById(R.id.floating);
        list = findViewById(R.id.list);

        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTextActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        list.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                System.out.println("응");
                return false;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK) {

            list = findViewById(R.id.list);

            String newMemo = data.getStringExtra("newMemo");

            memoData.add(new Data(newMemo));

            CustomAdapter adapter = new CustomAdapter(memoData, this);
            list.setAdapter(adapter);
        }
    }
}
