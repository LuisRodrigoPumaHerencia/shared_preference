package com.rodrigo.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //OBTENIENDO COMPONENTES
        TextInputEditText txt_id = findViewById(R.id.id_sh_pr);
        TextInputEditText contenido = findViewById(R.id.persona);
        MaterialButton btn_escribir = findViewById(R.id.btn_escribir);
        MaterialButton btn_leer = findViewById(R.id.btn_ver_contenido);
        TextView txv_contenido_preference = findViewById(R.id.contenido_preference);

        btn_escribir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("LLAVES", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString( String.valueOf(txt_id.getText()), String.valueOf(contenido.getText()));
                editor.commit();
            }
        });

        btn_leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("LLAVES", Context.MODE_PRIVATE);
                txv_contenido_preference.setText(preferences.getString(String.valueOf(txt_id.getText()),"NO LO ENCONTRO"));
            }
        });


    }
}