package com.example.villacristian;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import org.kxml2.io.KXmlSerializer;
public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText password;
    Button btnLogin;
    String usuario;
    String contrasenha;
    String usuarioPrueba = "a";
    String contrasenhaPrueba = "b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               System.out.println("POR AQUI PASO");

               final String NAMESPACE = "LoginFeature";final String URL="http://80.29.62.72/LoginFeature?wsdl";
               final String METHOD_NAME = "accessUser";final String SOAP_ACTION = "http://interfaces/accessUser";

               SoapObject so = new SoapObject(NAMESPACE,METHOD_NAME);

               so.addProperty("arg0",usuario = user.getText().toString());
               so.addProperty( "arg1", contrasenha = password.getText().toString());

                System.out.println(so.getProperty("arg0"));
                System.out.println(so.getProperty("arg1"));

               SoapSerializationEnvelope sse = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                //response = (SoapObject) envelope.bodyIn;
                sse.setOutputSoapObject(so);

                HttpTransportSE htse = new HttpTransportSE(URL);
                System.out.println(htse +  "!");
                try {
                    htse.call(SOAP_ACTION,sse);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                 SoapPrimitive response = null;

                    response = (SoapPrimitive)sse.bodyIn;
                    System.out.println(sse.bodyIn +  "resultado1");


                String resultado=response.toString();
                System.out.println("ResultadoOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO: " + resultado);
                Intent intent = new Intent(getApplicationContext(), MenuFeatures.class);
                startActivity(intent);

               /* usuario = user.getText().toString();
                 contrasenha = password.getText().toString();
                    System.out.println("aqui estoy recogiendo los datos itnroducidos");
                if(usuario.equals(usuarioPrueba) && contrasenha.equals(contrasenhaPrueba)){
                    System.out.println("okay los valido, si apso por auqi estan bien");
                Intent intent = new Intent(getApplicationContext(), MenuFeatures.class);
                startActivity(intent);
                }
*/
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
