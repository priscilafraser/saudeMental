package com.example.pagela;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.pagela.DAO.Connection;
import com.example.pagela.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Tela_Perfil_Paciente extends AppCompatActivity {
    ListView listView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil_paciente);
        Button button = (Button) findViewById(R.id.imageButton);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);

        //buscar dados
        Connection dao = new Connection(getApplicationContext());
        List<Pessoa> pessoas = dao.getPessoa();

        List<String> nomes = new ArrayList<String>();
        for (Pessoa nomeBuscado : pessoas) {
            nomes.add(nomeBuscado.getNome());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, nomes);
        listView.setAdapter(adapter);

    }
}