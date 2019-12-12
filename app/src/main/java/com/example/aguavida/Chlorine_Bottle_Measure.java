package com.example.aguavida;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Chlorine_Bottle_Measure extends AppCompatActivity {

    EditText gr_clorob_den_EditText;
    EditText gr_clorob_bt_EditText;
    TextView gr_clorob_1_TextView;
    TextView gr_clorob_2_TextView;
    TextView gr_clorob_3_TextView;

    double density;
    double bottle;

    double result;

    boolean check = true;

    public void measure_input( View view) {

        Context context = getApplicationContext();

        String eM1 = "";
        String eM2 = "";

        boolean a = false;
        boolean b = false;

        try {
            gr_clorob_den_EditText = (EditText) findViewById(R.id.gr_clorob_den_EditText);
            density = Double.parseDouble(gr_clorob_den_EditText.getText().toString());
        } catch (NumberFormatException e) {
            eM1 = "Densidad";
            a = true;
        }

        try {
            gr_clorob_bt_EditText = (EditText) findViewById(R.id.gr_clorob_bt_EditText);
            bottle = Double.parseDouble(gr_clorob_bt_EditText.getText().toString());
        } catch ( NumberFormatException e ) {
            eM2 = "Litros de Botella";
            b = true;
        }

        if ( a || b ){
            Toast.makeText(this, "Please add value in: " + eM1 + " " + eM2, Toast.LENGTH_LONG).show();
        } else {
            check = false;
        }

    }

    public double calculate_measure () {

        result =  density * bottle * 1000;

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chlorine__bottle__measure);

        Button c_bottle_calculate_b = (Button) findViewById(R.id.c_bottle_calculate_b);
        c_bottle_calculate_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                measure_input(null);
                calculate_measure();

                if ( check ) {
                    gr_clorob_1_TextView = (TextView) findViewById(R.id.gr_clorob_1_TextView);
                    gr_clorob_2_TextView = (TextView) findViewById(R.id.gr_clorob_2_TextView);
                    gr_clorob_3_TextView = (TextView) findViewById(R.id.gr_clorob_3_TextView);
                    gr_clorob_1_TextView.setText("Resultados:");
                    gr_clorob_2_TextView.setText("Más información necesario.");
                    gr_clorob_3_TextView.setText(" ");
                } else {
                    gr_clorob_1_TextView = (TextView) findViewById(R.id.gr_clorob_1_TextView);
                    gr_clorob_2_TextView = (TextView) findViewById(R.id.gr_clorob_2_TextView);
                    gr_clorob_3_TextView = (TextView) findViewById(R.id.gr_clorob_3_TextView);
                    gr_clorob_1_TextView.setText("Una botella de " + bottle + " litros tiene " + result + " gramos de cloro cuando esta llena.");
                    gr_clorob_2_TextView.setText("Hasta la mitad, es " + result/2);
                    gr_clorob_3_TextView.setText("Con solo un cuarto, es " + result/4);
                    check = true;
                }

            }
        });
    }
}
