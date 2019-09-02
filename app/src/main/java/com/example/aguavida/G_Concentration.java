package com.example.aguavida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class G_Concentration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g__concentration);

        Button g_con_b = (Button) findViewById(R.id.g_con_b);
        g_con_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText g_con_gc_EditText = (EditText) findViewById(R.id.g_con_gc_EditText);
                EditText g_con_sol_EditText = (EditText) findViewById(R.id.g_con_sol_EditText);
                EditText g_con_per_EditText = (EditText) findViewById(R.id.g_con_per_EditText);
                TextView g_con_results_TextView = (TextView) findViewById(R.id.g_con_results_TextView);

                int g = Integer.parseInt(g_con_gc_EditText.getText().toString());
                int t = Integer.parseInt(g_con_sol_EditText.getText().toString());
                float p = Float.parseFloat(g_con_per_EditText.getText().toString());

                float r1 = (g * p)/t;
                float r2 = (r1 * 1000);

                g_con_results_TextView.setText(r1 + " g/L o " + r2 + " mg/L - ppm.");

            }
        });
    }
}
