package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    // define the global variable

    // variable number1, number2 for input input number
    // Add_button, result textView

    EditText editText;
    Button button;
    TextView result;
    int ans = 0;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // by ID we can use each component
        // whose id is assigned in the XML file

        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        result = (TextView)findViewById(R.id.textView);

        // set clickListener on button
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId()) {

            case R.id.button:
                StringBuffer buffer = new StringBuffer();
                int res;

                // get the input number from editText
                String fs = editText.getText().toString();

                // convert it to integer
                int n = Integer.parseInt(fs);

                // build the logic for table
                for (int i = 1; i <= 10; i++) {
                    ans = (i * n);
                    buffer.append(n + " X " + i
                            + " = " + ans + "\n\n");
                }

                // set the buffer textview
                result.setText(buffer);
                break;
        }
    }
}