package com.example.limsungwoo.minimaltodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTextActivity extends AppCompatActivity {

    Button next;
    EditText memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_text);

        next = findViewById(R.id.next);
        memo = findViewById(R.id.memo);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newMemo = memo.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("newMemo", newMemo);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

}
