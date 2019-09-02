package com.example.aguavida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class G_Drip_Rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g__drip__rate);

        Button g_drip_c = (Button) findViewById(R.id.g_drip_c);
        g_drip_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText g_drip_litros_EditText = (EditText) findViewById(R.id.g_drip_litros_EditText);
                EditText g_drip_dias_EditText = (EditText) findViewById(R.id.g_drip_dias_EditText);
                TextView g_drip_results_TextView = (TextView) findViewById(R.id.g_drip_results_TextView);

                int l = Integer.parseInt(g_drip_litros_EditText.getText().toString());
                int d = Integer.parseInt(g_drip_dias_EditText.getText().toString());

                int ml = l * 1000;
                int h = d * 24;

                int rt = ml/h/60;

                g_drip_results_TextView.setText("Rapidez de Goteo necesario es " + rt + " mL/m.");

            }
        });
    }
}
