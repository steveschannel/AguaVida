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

public class A_Chlorine_Weight extends AppCompatActivity {

    EditText a_tanque_editText;
    EditText ap_caudal_editText;
    EditText ap_con_editText;
    EditText ap_porcentaje_editText;

    int tank;
    float caudal;
    float con;
    float per;

    public float result;
    public float x;
    public float y;
    public float d;

    boolean check = true;

    public void A_CWeight_Input( View view ) {

        Context context = getApplicationContext();

        String eM1 = "";
        String eM2 = "";
        String eM3 = "";
        String eM4 = "";

        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;

        try {
            a_tanque_editText = (EditText) findViewById(R.id.a_tanque_editText);
            tank = Integer.parseInt(a_tanque_editText.getText().toString());
        } catch (NumberFormatException e) {
            eM1 = "Tanque";
            a = true;
        }

        try {
            ap_caudal_editText = (EditText) findViewById(R.id.ap_caudal_editText);
            caudal = Float.parseFloat(ap_caudal_editText.getText().toString());
        } catch ( NumberFormatException e ) {
            eM2 = "Caudal";
            b = true;
        }

        try {
            ap_con_editText = (EditText) findViewById(R.id.ap_con_editText);
            con = Float.parseFloat(ap_con_editText.getText().toString());
        } catch ( NumberFormatException e) {
            eM3 = "Concentración";
            c = true;
        }

        try {
            ap_porcentaje_editText = (EditText) findViewById(R.id.ap_porcentaje_editText);
            per = Float.parseFloat(ap_porcentaje_editText.getText().toString());
        } catch ( NumberFormatException e){
            eM4 = "%";
            d = true;
        }

        if ( a || b || c || d ){
            Toast.makeText(this, "Please add value in: " + eM1 + " " + eM2 + " " + eM3 + " " + eM4, Toast.LENGTH_LONG).show();
        } else {
            check = false;
        }
    }

    public float calculate_AWeight (){
        int g;

        if (caudal < 1.38) {
            g = 1;
        } else if (caudal < 2.75) {
            g = 2;
        } else if (caudal < 5.50 ) {
            g = 4;
        } else {
            g = 5;
        }

        x = (tank * caudal * con );
        y = (g * (per*100));

        result = x / y;
        d = tank / ( g * 24);
        //dammit edd
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__chlorine__weight);

        Button b_calcular_ap = (Button) findViewById(R.id.b_calcular_ap);
        b_calcular_ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                A_CWeight_Input(null);
                calculate_AWeight();

                if ( check ) {
                    TextView R_ap_textView = (TextView) findViewById(R.id.R_ap_textView);
                    R_ap_textView.setText("Más información necesario.");
                } else {
                    TextView R_ap_textView = (TextView) findViewById(R.id.R_ap_textView);
                    R_ap_textView.setText(result * 1000 * .36 + " gramos cada " + d + " día(s).");
                    check = true;
                }



            }
        });
    }
}
