package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mEditText = findViewById(R.id.editText);
        mButton = findViewById(R.id.saveBtn);

        DisplaySavedText();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = mEditText.getText().toString();

                DisplayAndSaveText(enteredText);

            }
        });

    }

    private void DisplaySavedText() {

        // Retrieving the value from shared pref
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sharedPreferences.getString("name", " ");

        mTextView.setText(s1);

    }

    private void DisplayAndSaveText(String enteredText) {

        // Display the text
        mTextView.setText(enteredText);

        // Saving the text into SharedPref
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        // Writing data to shared pref
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", enteredText);

        editor.commit();

    }
}