package com.example.aguavida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_information = (Button)findViewById(R.id.b_information);
        b_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startInformation = new Intent(getApplicationContext(), Information.class);
                startActivity(startInformation);
            }
            //information
        });

        Button b_caudal = (Button)findViewById(R.id.b_caudal);
        b_caudal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startCaudal = new Intent(getApplicationContext(), G_Inflow_Rate.class);
                startActivity(startCaudal);
            }
            //caudal
        });

        Button b_peso_g = (Button)findViewById(R.id.b_peso_g);
        b_peso_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startPesog = new Intent(getApplicationContext(), G_Chlorine_Weight.class);
                startActivity(startPesog);
            }
            //Peso por goteo
        });

        Button b_peso_a = (Button)findViewById(R.id.b_peso_a);
        b_peso_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startPesoa = new Intent(getApplicationContext(), A_Chlorine_Weight.class);
                startActivity(startPesoa);
            }
            //Peso Autocompensante
        });

        Button b_rapidezg = (Button)findViewById(R.id.b_rapidez_g);
        b_rapidezg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startRapidezg = new Intent(getApplicationContext(), G_Drip_Rate.class);
                startActivity(startRapidezg);
            }
            //Rapidez G
        });

        Button b_rapideza = (Button)findViewById(R.id.b_rapidez_a);
        b_rapideza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startRapideza = new Intent(getApplicationContext(), A_Drip_Rate.class);
                startActivity(startRapideza);
            }
            //Rapidez A
        });

        Button b_disinfection = (Button)findViewById(R.id.b_desinfeccion);
        b_disinfection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startDisinfection = new Intent(getApplicationContext(), Disinfection.class);
                startActivity(startDisinfection);
            }
            //Disinfections
        });

        Button b_vol_c = (Button)findViewById(R.id.b_volumen_cube);
        b_vol_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startVolc = new Intent(getApplicationContext(), R_Cubic.class);
                startActivity(startVolc);
            }
            //Cubic Volume
        });

        Button b_vol_cy = (Button)findViewById(R.id.b_volumen_cylinder);
        b_vol_cy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startVolcy = new Intent(getApplicationContext(), R_Cylindrical.class);
                startActivity(startVolcy);
            }
            //Cylindrical Volume
        });

        Button b_con_g = (Button)findViewById(R.id.b_con_g);
        b_con_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startCong = new Intent(getApplicationContext(), G_Concentration.class);
                startActivity(startCong);
            }
            //Concentration systems with goteos
        });

        Button b_cloro_botella = (Button)findViewById(R.id.b_cloro_botella);
        b_cloro_botella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startClorobo = new Intent(getApplicationContext(), Chlorine_Bottle_Measure.class);
                startActivity(startClorobo);
            }
            //Chlorine measurements using bottles
        });
    }
}
