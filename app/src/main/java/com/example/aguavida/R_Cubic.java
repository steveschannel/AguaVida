package com.example.aguavida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class R_Cubic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r__cubic);

        Button r_c_calcular_b = (Button) findViewById(R.id.r_c_calcular_b);
        r_c_calcular_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText v_r_ancho_EditText = (EditText) findViewById(R.id.v_r_ancho_EditText);
                EditText v_r_largo_EditText = (EditText) findViewById(R.id.v_r_largo_EditText);
                EditText v_r_Altura_EditText = (EditText) findViewById(R.id.v_r_Altura_EditText);
                TextView v_c_results_TextView = (TextView) findViewById(R.id.v_c_results_TextView);
                TextView v_c_results2_TextView = (TextView) findViewById(R.id.v_c_results2_TextView);

                int a = Integer.parseInt(v_r_ancho_EditText.getText().toString());
                int l = Integer.parseInt(v_r_largo_EditText.getText().toString());
                int al = Integer.parseInt(v_r_Altura_EditText.getText().toString());

                int r = a * l * al;
                int vol = r * 1000;

                v_c_results_TextView.setText(r + " metros cubicos (m^3).");
                v_c_results2_TextView.setText("Tiene " + vol + " litros de capacidad.");
            }
        });
    }



}
