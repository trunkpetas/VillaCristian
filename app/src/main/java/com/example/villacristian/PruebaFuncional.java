package com.example.villacristian;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Date;


public class PruebaFuncional extends AppCompatActivity {
EditText e;
Button btnCodificacion;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prueba);
        btnCodificacion = (Button)findViewById(R.id.button17) ;
        e = (EditText)findViewById(R.id.editText);
        btnCodificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                e.setText(currentDateTimeString);
            }
        });

    };
}
