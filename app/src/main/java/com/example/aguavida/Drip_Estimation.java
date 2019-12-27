package com.example.aguavida;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Drip_Estimation extends AppCompatActivity {

    EditText D_estimate_tamanomL;
    EditText D_estimate_segundos;
    TextView D_estimate_resultados;
    TextView D_estimate_resultados2;

    float ml;
    float segu;

    public float result;

    boolean check = true;

    public void estimate_input ( View view) {

        Context context = getApplicationContext();

        String eM1 = "";
        String eM2 = "";

        boolean a = false;
        boolean b = false;

        try {
            D_estimate_tamanomL = (EditText) findViewById(R.id.D_estimate_tamanomL);
            ml = Float.parseFloat(D_estimate_tamanomL.getText().toString());
        } catch (NumberFormatException e) {
            eM1 = "miliLitros";
            a = true;
        }

        try {
            D_estimate_segundos = (EditText) findViewById(R.id.D_estimate_segundos);
            segu = Float.parseFloat(D_estimate_segundos.getText().toString());
        } catch ( NumberFormatException e ) {
            eM2 = "Segundos";
            b = true;
        }

        if ( a || b ){
            Toast.makeText(this, "Please add value in: " + eM1 + " " + eM2, Toast.LENGTH_LONG).show();
        } else {
            check = false;
        }
    }

    public float estimate_drip () {

        if (ml == 0) {
            result = 0;
        } else {
            result = ml / segu;
        }

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drip__estimation);

        Button b_estimate_calcular = (Button) findViewById(R.id.b_estimate_calcular);
        b_estimate_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                estimate_input(null);
                estimate_drip();

                if ( check ) {
                    D_estimate_resultados = (TextView) findViewById(R.id.D_estimate_resultados);
                    D_estimate_resultados.setText("Más información necesario.");

                } else {

                    D_estimate_resultados = (TextView) findViewById(R.id.D_estimate_resultados);
                    D_estimate_resultados.setText(result * 60 + " ml/min");

                    D_estimate_resultados2 = (TextView) findViewById(R.id.D_estimate_resultados2);
                    D_estimate_resultados2.setText(result * 3600 / 1000 + " L/Hr");
                    check = true;
                }



            }
        });
    }
}
