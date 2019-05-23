package com.example.lista;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Entidad> lista ;
    public  static int pos =0;

    public Adaptador(Context context, ArrayList<Entidad> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Entidad item = (Entidad) getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_listview,null);
        final TextView txtVal = convertView.findViewById(R.id.txtValor);
        ImageButton imgEditar = convertView.findViewById(R.id.imgEdit);
        ImageButton imgBorrar = convertView.findViewById(R.id.imgErase);


        txtVal.setText(item.getTxtValor());
        imgEditar.setImageResource(item.getImgEdit());
        imgBorrar.setImageResource(item.getImgErase());

        imgEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtVal.getText().toString();
                MainActivity.palabra.setText(name);
                MainActivity.btnActualizar.setVisibility(View.VISIBLE);
                pos = position;
            }
        });

        imgBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
