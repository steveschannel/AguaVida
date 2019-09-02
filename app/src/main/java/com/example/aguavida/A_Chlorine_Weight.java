package com.example.aguavida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.microedition.khronos.egl.EGLDisplay;

public class A_Chlorine_Weight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__chlorine__weight);

        Button b_calcular_ap = (Button) findViewById(R.id.b_calcular_ap);
        b_calcular_ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText a_tanque_editText = (EditText) findViewById(R.id.a_tanque_editText);
                EditText ap_caudal_editText = (EditText) findViewById(R.id.ap_caudal_editText);
                EditText ap_con_editText = (EditText) findViewById(R.id.ap_con_editText);
                EditText ap_porcentaje_editText = (EditText) findViewById(R.id.ap_porcentaje_editText);
                TextView R_ap_textView = (TextView) findViewById(R.id.R_ap_textView);

                double tank = Double.parseDouble(a_tanque_editText.getText().toString());
                double caudal = Double.parseDouble(ap_caudal_editText.getText().toString());
                double con = Double.parseDouble(ap_con_editText.getText().toString());
                double per = Double.parseDouble(ap_porcentaje_editText.getText().toString());

                double g;

                if (caudal < 1.38) {
                    g = 1;
                } else if (caudal < 2.75) {
                    g = 2;
                } else if (caudal < 5.50 ) {
                    g = 4;
                } else {
                    g = 5;
                }

                double r = .36 * (tank * caudal * con )/(g * (per*100));
                double d = tank / ( g * 24);
                //dammit edd

                R_ap_textView.setText(r * 1000 + " gramos cada " + d + " día(s).");


            }
        });
    }
}
