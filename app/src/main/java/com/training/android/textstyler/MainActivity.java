package com.training.android.textstyler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEtInput;
    private TextView mTvStyledText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtInput = (EditText) findViewById(R.id.etText);
        mTvStyledText = (TextView) findViewById(R.id.tvStyledText);

        // Set appropriate listeners or watchers..
        mEtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing..
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Do nothing..
            }

            @Override
            public void afterTextChanged(Editable s) {
                mTvStyledText.setText(s);
            }
        });
    }
}
