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

import javax.microedition.khronos.egl.EGLDisplay;

public class Disinfection extends AppCompatActivity {

    EditText des_vol_EditText;
    EditText des_con_r_EditText;
    EditText des_con_EditText;
    TextView des_res_TextView;

    int vol;
    float conr;
    float conc;

    public float p1;
    public float p2;
    public float result;

    boolean check = true;

    public void dis_input ( View view ) {

        Context context = getApplicationContext();

        String eM1 = "";
        String eM2 = "";
        String eM3 = "";

        boolean a = false;
        boolean b = false;
        boolean c = false;

        try {
            des_vol_EditText = (EditText) findViewById(R.id.des_vol_EditText);
            vol = Integer.parseInt(des_vol_EditText.getText().toString());
        } catch (NumberFormatException e) {
            eM1 = "Volumen";
            a = true;
        }

        try {
            des_con_r_EditText = (EditText) findViewById(R.id.des_con_r_EditText);
            conr = Float.parseFloat(des_con_r_EditText.getText().toString());
        } catch ( NumberFormatException e ) {
            eM2 = "Concentración/Reservorio";
            b = true;
        }

        try {
            des_con_EditText = (EditText) findViewById(R.id.des_con_EditText);
            conc = Float.parseFloat(des_con_EditText.getText().toString());
        } catch ( NumberFormatException e) {
            eM3 = "Concentración/Cloro";
            c = true;
        }

        if ( a || b || c ){
            Toast.makeText(this, "Please add value in: " + eM1 + " " + eM2 + " " + eM3, Toast.LENGTH_LONG).show();
        } else {
            check = false;
        }

    }

    public float calculate_concentration () {

        p1 = vol * conr;
        p2 = conc * 1000;
        result = p1/p2;

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disinfection);

        Button des_cal_b = (Button) findViewById(R.id.des_cal_b);
        des_cal_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dis_input(null);
                calculate_concentration();

                if ( check ) {
                    des_res_TextView = (TextView) findViewById(R.id.des_res_TextView);
                    des_res_TextView.setText("Más información necesario.");
                } else {
                    des_res_TextView = (TextView) findViewById(R.id.des_res_TextView);
                    des_res_TextView.setText(result + " gramos.");
                    check = true;
                }


            }
        });
    }
}
