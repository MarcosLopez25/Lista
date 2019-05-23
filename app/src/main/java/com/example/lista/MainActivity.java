package com.example.lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView listaItem;
    public Adaptador adaptador;
    public Button agregar;
    public static ImageButton btnActualizar;
    public static EditText palabra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final ArrayList<Entidad> lista = new ArrayList<>();
        listaItem = findViewById(R.id.listaItem);
        adaptador = new Adaptador(this,lista);

        lista.add(new Entidad("India", R.drawable.editar, R.drawable.borrar));
        lista.add(new Entidad("México", R.drawable.editar, R.drawable.borrar));
        lista.add(new Entidad("Puerto Rico", R.drawable.editar, R.drawable.borrar));
        lista.add(new Entidad("Alemania", R.drawable.editar, R.drawable.borrar));
        lista.add(new Entidad("Italia", R.drawable.editar, R.drawable.borrar));
        lista.add(new Entidad("Uruguay", R.drawable.editar, R.drawable.borrar));
        lista.add(new Entidad("Chile", R.drawable.editar, R.drawable.borrar));
        lista.add(new Entidad("Rusia", R.drawable.editar, R.drawable.borrar));
        lista.add(new Entidad("Argentina", R.drawable.editar, R.drawable.borrar));

        listaItem.setAdapter(adaptador);
        agregar = findViewById(R.id.btnAgregar);
        palabra =  findViewById(R.id.edText);
        btnActualizar = findViewById(R.id.btnUpdate);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor = palabra.getText().toString();
                lista.add(new Entidad(valor, R.drawable.editar, R.drawable.borrar));
                adaptador.notifyDataSetChanged();
            }
        });
        adaptador.notifyDataSetChanged();

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.set(Adaptador.pos, new Entidad(palabra.getText().toString(),R.drawable.editar, R.drawable.borrar));
                adaptador.notifyDataSetChanged();
                btnActualizar.setVisibility(View.INVISIBLE);
            }
        });
    }

}
