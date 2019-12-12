package com.example.aguavida;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class G_Drip_Rate extends AppCompatActivity {

    EditText g_drip_litros_EditText;
    EditText g_drip_dias_EditText;
    TextView g_drip_results_TextView;

    int liters;
    int days;

    public int ml;
    public int h;
    public float result;

    boolean check = true;

    public void drip_input ( View view) {

        Context context = getApplicationContext();

        String eM1 = "";
        String eM2 = "";

        boolean a = false;
        boolean b = false;

        try {
            g_drip_litros_EditText = (EditText) findViewById(R.id.g_drip_litros_EditText);
            liters = Integer.parseInt(g_drip_litros_EditText.getText().toString());
        } catch (NumberFormatException e) {
            eM1 = "Litros";
            a = true;
        }

        try {
            g_drip_dias_EditText = (EditText) findViewById(R.id.g_drip_dias_EditText);
            days = Integer.parseInt(g_drip_dias_EditText.getText().toString());
        } catch ( NumberFormatException e ) {
            eM2 = "Dias";
            b = true;
        }

        if ( a || b ){
            Toast.makeText(this, "Please add value in: " + eM1 + " " + eM2, Toast.LENGTH_LONG).show();
        } else {
            check = false;
        }
    }

    public float calculate_drip () {

        ml = liters * 1000;
        h = days * 24;
        result = ml/h/60;

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g__drip__rate);

        Button g_drip_c = (Button) findViewById(R.id.g_drip_c);
        g_drip_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drip_input(null);
                calculate_drip();

                if ( check ) {
                    g_drip_results_TextView = (TextView) findViewById(R.id.g_drip_results_TextView);
                    g_drip_results_TextView.setText("Más información necesario.");

                } else {
                    g_drip_results_TextView = (TextView) findViewById(R.id.g_drip_results_TextView);
                    g_drip_results_TextView.setText(result + " ml/min");
                    check = true;
                }



            }
        });
    }
}
