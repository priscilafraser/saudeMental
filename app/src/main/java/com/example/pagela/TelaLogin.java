package com.example.pagela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class TelaLogin extends AppCompatActivity {
Button button;
TextView textoCadastre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(TelaLogin.this,Tela_Perfil_Paciente.class);
                startActivity(intent);
                finish();
            }
        });

        TextView textoCadastre = (TextView) findViewById(R.id.textCadastre);
        textoCadastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TelaLogin.this,Tela_Cadastro_Paciente.class);
                startActivity(intent);
            }
        });
    }

    public void entrarLogin(View view) {

    }




}