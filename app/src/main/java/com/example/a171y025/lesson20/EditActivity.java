package com.example.a171y025.lesson20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.
        OnClickListener {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        mEditText = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        if( intent != null && intent.hasExtra("text")) {
            mEditText.setText(intent.getStringExtra("text"));
        }
            mEditText.selectAll();
            findViewById(R.id.buttonUpdate).setOnClickListener(this);
            findViewById(R.id.buttonCanel).setOnClickListener(this);

    }

        @Override
        public void onClick(View v){

        if(R.id.buttonUpdate == v.getId()) {
            Intent data = new Intent();
            data.putExtra("text", mEditText.getText().toString());
            setResult(RESULT_OK,data);
        }
        finish();
        }
    }

