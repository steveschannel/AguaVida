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

import static android.icu.lang.UProperty.MATH;

public class R_Cylindrical extends AppCompatActivity {

    EditText cyl_vol_radio_EditText;
    EditText cyl_vol_altura_EditText;
    TextView cyl_vol_res_TextView;
    TextView cyl_vol_res2_TextView;

    int cr;
    int ca;
    double pi = Math.PI;

    public double result;

    boolean check = true;

    public void cyl_input (View view) {

        Context context = getApplicationContext();

        String eM1 = "";
        String eM2 = "";

        boolean a = false;
        boolean b = false;

        try {
            cyl_vol_radio_EditText = (EditText) findViewById(R.id.cyl_vol_radio_EditText);
            cr = Integer.parseInt(cyl_vol_radio_EditText.getText().toString());
        } catch (NumberFormatException e) {
            eM1 = "Radio";
            a = true;
        }

        try {
            cyl_vol_altura_EditText = (EditText) findViewById(R.id.cyl_vol_altura_EditText);
            ca = Integer.parseInt(cyl_vol_altura_EditText.getText().toString());
        } catch ( NumberFormatException e ) {
            eM2 = "Altura";
            b = true;
        }

        if ( a || b ){
            Toast.makeText(this, "Please add value in: " + eM1 + " " + eM2, Toast.LENGTH_LONG).show();
        } else {
            check = false;
        }

    }

    public double calculate_cyl () {

        result = ca * cr * cr * pi;

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r__cylindrical);

        Button cyl_vol__b = (Button) findViewById(R.id.cyl_vol__b);
        cyl_vol__b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cyl_input(null);
                calculate_cyl();

                if ( check ) {
                    cyl_vol_res2_TextView = (TextView) findViewById(R.id.cyl_vol_res2_TextView);
                    cyl_vol_res2_TextView.setText("Más información necesario.");
                } else {
                    cyl_vol_res_TextView = (TextView) findViewById(R.id.cyl_vol_res_TextView);
                    cyl_vol_res2_TextView = (TextView) findViewById(R.id.cyl_vol_res2_TextView);
                    cyl_vol_res_TextView.setText(result + " metros cubicos (m^3).");
                    cyl_vol_res2_TextView.setText("Tiene " + result * 1000 + " litros de capacidad.");
                    check = true;
                }

            }
        });
    }
}
