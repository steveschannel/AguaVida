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

public class G_Chlorine_Weight extends AppCompatActivity {

    EditText caudaleditText;
    EditText concentrationeditText;
    EditText percenteditText;
    TextView resultadotextView_g;

    float con;
    float cau;
    float per;

    public float result;

    boolean nok = true;

    public void G_CWeight_Input (View view){

        Context context_g_chlorine_weight = getApplicationContext();
        String exceptionMessage1 = "";
        String exceptionMessage2 = "";
        String exceptionMessage3 = "";

        boolean a = false;
        boolean b = false;
        boolean c = false;

        try {
            caudaleditText = (EditText) findViewById(R.id.caudaleditText);
            cau = Float.parseFloat(caudaleditText.getText().toString());
        } catch ( NumberFormatException e) {
            exceptionMessage1 = "Caudal";
            a = true;
        }

        try {
            concentrationeditText = (EditText) findViewById(R.id.concentrationeditText);
            con = Float.parseFloat(concentrationeditText.getText().toString());
        } catch ( NumberFormatException e){
            exceptionMessage2 = "Concentración";
            b = true;
        }

        try{
            percenteditText = (EditText) findViewById(R.id.percenteditText);
            per = Float.parseFloat(percenteditText.getText().toString());
        } catch ( NumberFormatException e) {
            exceptionMessage3 = "%";
            c = true;
        }

        if ( a || b || c ){
            Toast.makeText(this, "Please add value in: " + exceptionMessage1 + " " + exceptionMessage2 + " " + exceptionMessage3, Toast.LENGTH_LONG).show();
        } else {
            nok = false;
        }

    }

    public float calculate_G_CWeight(){

        result = (cau * 86400 * con)/(per * 1000);
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g__chlorine__weight);

        final Button b_calcular_g = (Button) findViewById(R.id.b_calcular_g);
        b_calcular_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            G_CWeight_Input(null);
            calculate_G_CWeight();

            if (nok){
                resultadotextView_g = (TextView) findViewById(R.id.resultadotextView_g);
                resultadotextView_g.setText("Más información necesario.");
            } else {
                resultadotextView_g = (TextView) findViewById(R.id.resultadotextView_g);
                resultadotextView_g.setText(result + " gramos cada dia.");
                nok = true;
            }



            }
        });
    }
}
