package com.example.aguavida;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class G_Concentration extends AppCompatActivity {

    EditText g_con_gc_EditText;
    EditText g_con_sol_EditText;
    EditText g_con_per_EditText;
    TextView g_con_results_TextView;

    int g;
    int t;

    public float p;
    public float r1;
    public float r2;

    boolean check = true;

    public void concentration_input ( View view ) {

        Context context = getApplicationContext();

        String eM1 = "";
        String eM2 = "";
        String eM3 = "";

        boolean a = false;
        boolean b = false;
        boolean c = false;

        try {
            g_con_gc_EditText = (EditText) findViewById(R.id.g_con_gc_EditText);
            g = Integer.parseInt(g_con_gc_EditText.getText().toString());
        } catch (NumberFormatException e) {
            eM1 = "Tanque";
            a = true;
        }

        try {
            g_con_sol_EditText = (EditText) findViewById(R.id.g_con_sol_EditText);
            t = Integer.parseInt(g_con_sol_EditText.getText().toString());
        } catch ( NumberFormatException e ) {
            eM2 = "Caudal";
            b = true;
        }

        try {
            g_con_per_EditText = (EditText) findViewById(R.id.g_con_per_EditText);
            p = Float.parseFloat(g_con_per_EditText.getText().toString());
        } catch ( NumberFormatException e) {
            eM3 = "Concentración";
            c = true;
        }

        if ( a || b || c ){
            Toast.makeText(this, "Please add value in: " + eM1 + " " + eM2 + " " + eM3, Toast.LENGTH_LONG).show();
        } else {
            check = false;
        }

    }

    public float calculate_concentration () {

        r1 = (g * p)/t;
        r2 = (r1 * 1000);

        return r2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g__concentration);

        Button g_con_b = (Button) findViewById(R.id.g_con_b);
        g_con_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                concentration_input(null);
                calculate_concentration();


                if ( check ) {
                    g_con_results_TextView = (TextView) findViewById(R.id.g_con_results_TextView);
                    g_con_results_TextView.setText("Más información necesario.");
                } else {
                    g_con_results_TextView = (TextView) findViewById(R.id.g_con_results_TextView);
                    g_con_results_TextView.setText(r2 + " mg/L - ppm.");
                    check = true;
                }



            }
        });
    }
}
