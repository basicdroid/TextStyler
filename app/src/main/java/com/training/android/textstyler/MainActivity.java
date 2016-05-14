package com.training.android.textstyler;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    private EditText   mEtInput;
    private TextView   mTvStyledText;
    private CheckBox   mCbBold;
    private CheckBox   mCbItalic;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find all views
        mEtInput = (EditText) findViewById(R.id.etText);
        mTvStyledText = (TextView) findViewById(R.id.tvStyledText);
        mCbBold = (CheckBox) findViewById(R.id.cbBold);
        mCbItalic = (CheckBox) findViewById(R.id.cbItalic);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);

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

        mCbBold.setOnCheckedChangeListener(this);
        mCbItalic.setOnCheckedChangeListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        styleTheText();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        styleTheText();
    }

    private void styleTheText() {
        boolean isBold = mCbBold.isChecked();
        boolean isItalic = mCbItalic.isChecked();

        if (isBold && isItalic) {
            mTvStyledText.setTypeface(null, Typeface.BOLD_ITALIC);
        } else {
            if (isBold) {
                mTvStyledText.setTypeface(null, Typeface.BOLD);
            }
            if (isItalic) {
                mTvStyledText.setTypeface(null, Typeface.ITALIC);
            }
            if (!isBold && !isItalic) {
                mTvStyledText.setTypeface(null, Typeface.NORMAL);
            }
        }

        int id = mRadioGroup.getCheckedRadioButtonId();
        if (id == R.id.rbBlue) {
            mTvStyledText.setTextColor(Color.BLUE);
        } else if (id == R.id.rbGreen) {
            mTvStyledText.setTextColor(Color.GREEN);
        } else if (id == R.id.rbRed) {
            mTvStyledText.setTextColor(Color.RED);
        }
    }
}
