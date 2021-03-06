package com.example.villacristian;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Auditoria extends AppCompatActivity {
    Button btnInventario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auditoria_layout);
        //SE CONECTE AQUI AL WEB SERVICE PILLE LOS DATOS Y LOS PARSEAMOS Y LOS METEMOS EN UN ARRAYLIST LOS METEMOS EN EL SPINNER Y A RAIZ DE LOS DATOS ABRIMOS INVENTARIO WORKORDERS
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 Toast.makeText(getBaseContext(), parent.getItemAtPosition(position).toString() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    };
}
