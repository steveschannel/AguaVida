package com.example.aguavida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class G_Chlorine_Weight extends AppCompatActivity {

    EditText caudaleditText;
    EditText concentrationeditText;
    EditText percenteditText;
    TextView resultadotextView_g;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g__chlorine__weight);

        final Button b_calcular_g = (Button) findViewById(R.id.b_calcular_g);
        b_calcular_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText caudaleditText = (EditText) findViewById(R.id.caudaleditText);
                EditText concentrationeditText = (EditText) findViewById(R.id.concentrationeditText);
                EditText percenteditText = (EditText) findViewById(R.id.percenteditText);
                TextView resultadotextView_g = (TextView) findViewById(R.id.resultadotextView_g);

                double cau = Double.parseDouble(caudaleditText.getText().toString());
                double con = Double.parseDouble(concentrationeditText.getText().toString());
                double per = Double.parseDouble(percenteditText.getText().toString());

                double r = (cau * 86400 * con)/(per * 1000);

                resultadotextView_g.setText(r + " gramos cada dia.");

            }
        });
    }
}
