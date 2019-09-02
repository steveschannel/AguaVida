package com.example.aguavida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.icu.lang.UProperty.MATH;

public class R_Cylindrical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r__cylindrical);

        Button cyl_vol__b = (Button) findViewById(R.id.cyl_vol__b);
        cyl_vol__b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText cyl_vol_radio_EditText = (EditText) findViewById(R.id.cyl_vol_radio_EditText);
                EditText cyl_vol_altura_EditText = (EditText) findViewById(R.id.cyl_vol_altura_EditText);
                TextView cyl_vol_res_TextView = (TextView) findViewById(R.id.cyl_vol_res_TextView);
                TextView cyl_vol_res2_TextView = (TextView) findViewById(R.id.cyl_vol_res2_TextView);

                int cr = Integer.parseInt(cyl_vol_radio_EditText.getText().toString());
                int ca = Integer.parseInt(cyl_vol_altura_EditText.getText().toString());
                double pi = Math.PI;

                double rc = ca * cr * cr * pi;
                double rc2 = rc * 1000;

                cyl_vol_res_TextView.setText(rc + " metros cubicos (m^3).");
                cyl_vol_res2_TextView.setText("Tiene " + rc2 + " litros de capacidad.");

            }
        });
    }
}
