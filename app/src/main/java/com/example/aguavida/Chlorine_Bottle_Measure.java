package com.example.aguavida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Chlorine_Bottle_Measure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chlorine__bottle__measure);

        Button c_bottle_calculate_b = (Button) findViewById(R.id.c_bottle_calculate_b);
        c_bottle_calculate_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText gr_clorob_den_EditText = (EditText) findViewById(R.id.gr_clorob_den_EditText);
                EditText gr_clorob_bt_EditText = (EditText) findViewById(R.id.gr_clorob_bt_EditText);
                TextView gr_clorob_1_TextView = (TextView) findViewById(R.id.gr_clorob_1_TextView);
                TextView gr_clorob_2_TextView = (TextView) findViewById(R.id.gr_clorob_2_TextView);
                TextView gr_clorob_3_TextView = (TextView) findViewById(R.id.gr_clorob_3_TextView);

                double d = Double.parseDouble(gr_clorob_den_EditText.getText().toString());
                //edd
                double b = Double.parseDouble(gr_clorob_bt_EditText.getText().toString());

                double quarter_b = ( d * b * 1000 )/4;
                double half_b = ( d * b * 1000)/2;
                double full_b =  d * b * 1000;

                gr_clorob_1_TextView.setText("Una botella de " + b + " litros tiene " + full_b + " gramos de cloro cuando esta llena.");
                gr_clorob_2_TextView.setText("Hasta la mitad, es " + half_b);
                gr_clorob_3_TextView.setText("Con solo un cuarto, es " + quarter_b);



            }
        });
    }
}
