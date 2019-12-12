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

public class R_Cubic extends AppCompatActivity {

    EditText v_r_ancho_EditText;
    EditText v_r_largo_EditText;
    EditText v_r_Altura_EditText;
    TextView v_c_results_TextView;
    TextView v_c_results2_TextView;

    int ancho;
    int largo;
    int altura;

    public int result;
    public int vol;

    boolean check = true;

    public void cubic_input ( View view ) {

        Context context = getApplicationContext();

        String eM1 = "";
        String eM2 = "";
        String eM3 = "";

        boolean a = false;
        boolean b = false;
        boolean c = false;

        try {
            v_r_ancho_EditText = (EditText) findViewById(R.id.v_r_ancho_EditText);
            ancho = Integer.parseInt(v_r_ancho_EditText.getText().toString());
        } catch (NumberFormatException e) {
            eM1 = "Ancho";
            a = true;
        }

        try {
            v_r_largo_EditText = (EditText) findViewById(R.id.v_r_largo_EditText);
            largo = Integer.parseInt(v_r_largo_EditText.getText().toString());
        } catch ( NumberFormatException e ) {
            eM2 = "Largo";
            b = true;
        }

        try {
            v_r_Altura_EditText = (EditText) findViewById(R.id.v_r_Altura_EditText);
            altura = Integer.parseInt(v_r_Altura_EditText.getText().toString());
        } catch ( NumberFormatException e) {
            eM3 = "Altura";
            c = true;
        }

        if ( a || b || c ){
            Toast.makeText(this, "Please add value in: " + eM1 + " " + eM2 + " " + eM3, Toast.LENGTH_LONG).show();
        } else {
            check = false;
        }

    }

    public float calculate_volume () {

        result = ancho * largo * altura;

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r__cubic);

        Button r_c_calcular_b = (Button) findViewById(R.id.r_c_calcular_b);
        r_c_calcular_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cubic_input(null);
                calculate_volume();

                if ( check ) {
                    v_c_results2_TextView = (TextView) findViewById(R.id.v_c_results2_TextView);
                    v_c_results2_TextView.setText("Más información necesario.");
                } else {
                    v_c_results_TextView = (TextView) findViewById(R.id.v_c_results_TextView);
                    v_c_results2_TextView = (TextView) findViewById(R.id.v_c_results2_TextView);
                    v_c_results_TextView.setText(result + " metros cubicos (m^3).");
                    v_c_results2_TextView.setText("Tiene " + result * 1000 + " litros de capacidad.");
                    check = true;
                }

            }
        });
    }



}
