package com.example.aguavida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import javax.microedition.khronos.egl.EGLDisplay;

public class Disinfection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disinfection);

        Button des_cal_b = (Button) findViewById(R.id.des_cal_b);
        des_cal_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText des_vol_EditText = (EditText) findViewById(R.id.des_vol_EditText);
                EditText des_con_r_EditText = (EditText) findViewById(R.id.des_con_r_EditText);
                EditText des_con_EditText = (EditText) findViewById(R.id.des_con_EditText);
                TextView des_res_TextView = (TextView) findViewById(R.id.des_res_TextView);

                int vol = Integer.parseInt(des_vol_EditText.getText().toString());
                float conr = Float.parseFloat(des_con_r_EditText.getText().toString());
                float conc = Float.parseFloat(des_con_EditText.getText().toString());

                float r = (vol * conr)/(conc * 1000);

                des_res_TextView.setText(r + " gramos.");



            }
        });
    }
}
