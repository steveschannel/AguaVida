package com.example.aguavida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class G_Inflow_Rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g__inflow__rate);

        Button gcc_button = (Button) findViewById(R.id.gcc_button);
        gcc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText medidoreditText = (EditText) findViewById(R.id.medidoreditText);
                EditText T1editText = (EditText) findViewById(R.id.t1editText);
                EditText T2editText = (EditText) findViewById(R.id.t2editText);
                EditText T3editText = (EditText) findViewById(R.id.t3editText);
                TextView gcc_result_textView = (TextView) findViewById(R.id.g_result_textView);

                int m = Integer.parseInt(medidoreditText.getText().toString());
                int t1 = Integer.parseInt(T1editText.getText().toString());
                int t2 = Integer.parseInt(T2editText.getText().toString());
                int t3 = Integer.parseInt(T3editText.getText().toString());
                double a = (t1 + t2 + t3)/3;
                double result = m / a;

                gcc_result_textView.setText(result + "");

            }
        });
    }
}
