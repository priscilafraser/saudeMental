package com.example.pagela.DAO;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.pagela.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class Connection extends SQLiteOpenHelper {
    public Connection(Context context) {
        super(context, "banco", null, 1);
        Log.i("debug", "connection");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {  //vai criar o banco na primeira vez que usar
        String sql = "CREATE TABLE pessoa('nome' TEXT, 'cpf'  TEXT, 'email' TEXT)";
        db.execSQL(sql);
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS pessoa";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Pessoa pessoa) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();

        dados.put("nome", pessoa.getNome());
        dados.put("cpf", pessoa.getCpf());
        dados.put("email", pessoa.getEmail());

        db.insert("pessoa", null, dados);
        Log.i("debug", "inseriu...");
    }

    @SuppressLint("Range")
    public List<Pessoa> getPessoa() {
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM pessoa";

        Cursor c = db.rawQuery(sql, null);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (c.moveToNext()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(c.getString(c.getColumnIndex("nome")));
            pessoa.setCpf(c.getString(c.getColumnIndex("cpf")));
            pessoa.setEmail(c.getString(c.getColumnIndex("email")));

            pessoas.add(pessoa);
        }

        return  pessoas;

    }

}
