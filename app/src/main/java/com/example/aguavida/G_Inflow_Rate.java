package com.example.aguavida;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

public class G_Inflow_Rate extends AppCompatActivity {

    EditText medidoreditText;
    EditText T1editText;
    EditText T2editText;
    EditText T3editText;

    int m;
    int t1;
    int t2;
    int t3;

    public double a;
    public double result;

    public void caudalinput(View view) {

        Context context_caudal = getApplicationContext();
        String exceptionMessage = "";
        String exceptionMessage1 = "";
        String exceptionMessage2 = "";
        String exceptionMessage3 = "";

        try{
            medidoreditText = (EditText) findViewById(R.id.medidoreditText);
            m = Integer.parseInt(medidoreditText.getText().toString());
        } catch (NumberFormatException e) {
            exceptionMessage = "Balde";
        }

        try{
            T1editText = (EditText) findViewById(R.id.t1editText);
            t1 = Integer.parseInt(T1editText.getText().toString());
        } catch (NumberFormatException e) {
            exceptionMessage1 = "time 1";
        }

        try{
            T2editText = (EditText) findViewById(R.id.t2editText);
            t2 = Integer.parseInt(T2editText.getText().toString());
        } catch (NumberFormatException e) {
            exceptionMessage2 = "time 2";
        }

        try{
            T3editText = (EditText) findViewById(R.id.t3editText);
            t3 = Integer.parseInt(T3editText.getText().toString());
        } catch (NumberFormatException e) {
            exceptionMessage3 = "time 3";
        }

        Toast.makeText(this, exceptionMessage + " " + exceptionMessage1 + " " + exceptionMessage2 + "" + exceptionMessage3, Toast.LENGTH_LONG).show();

        a = (t1 + t2 + t3)/3;
        result = m / a;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g__inflow__rate);

        Button gcc_button = (Button) findViewById(R.id.gcc_button);
        gcc_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TextView gcc_result_textView = (TextView) findViewById(R.id.g_result_textView);
                gcc_result_textView.setText(result + " ");

            }
        });
    }
}
