package com.example.a171y025.lesson20;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.
        OnClickListener {
    public static final int CALL_RESULT_CODE = 100;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        findViewById(R.id.buttonEdit).setOnClickListener(this);
        findViewById(R.id.buttonFortune).setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CALL_RESULT_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                String text = data.getStringExtra("text");
                mTextView.setText(text);

            }

        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonEdit) {
            Intent intent = new Intent(this, EditActivity.class);
            intent.putExtra("text", mTextView.getText());
            startActivityForResult(intent, CALL_RESULT_CODE);
        } else {
            Intent intent = new Intent(this, FortuneActivity.class);
            intent.putExtra("user_name", mTextView.getText());
            startActivity(intent);
        }
    }
}
