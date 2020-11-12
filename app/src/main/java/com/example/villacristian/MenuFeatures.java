package com.example.villacristian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Date;

public class MenuFeatures extends AppCompatActivity {
    EditText e;
    Button btnCodificacion;
    Button btn_inventario;
    Button btn_auditoria;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_features);
        btnCodificacion = (Button)findViewById(R.id.btn_codificacion) ;
        btn_inventario = (Button)findViewById(R.id.btn_inventario);
        btn_auditoria = (Button)findViewById(R.id.btn_auditoria);
        e = (EditText)findViewById(R.id.editText);

        /*---------------------------TODOS LOS LISTENERS------------------------------*/
        //listenerCodificiacion
        btnCodificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                e.setText(currentDateTimeString);
            }
        });
        //listenerInventario
        btn_inventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Inventario.class);
                startActivity(intent);
            }
        });
        //listenerAuditoria
        btn_auditoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Auditoria.class);
                startActivity(intent);
            }
        });
    };
}
