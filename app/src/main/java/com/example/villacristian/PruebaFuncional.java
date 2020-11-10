package com.example.villacristian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class PruebaFuncional extends AppCompatActivity {
    Button btnFuncional;
    TextView txtView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prueba);
        txtView = (TextView) findViewById(R.id.textview_first);
        btnFuncional = (Button) findViewById(R.id.button_first);
        btnFuncional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView.setText("MAGICAMENTE HA CAMBIADO EL TEXTO XD");
            }
        });
    }
}
