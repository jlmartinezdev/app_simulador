package com.jlmartinez.votos2021;


import android.content.ClipData;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_listaconsejales extends RecyclerView.Adapter<adapter_listaconsejales.ViewHolderDatos> implements View.OnClickListener {
    private ArrayList<canditados> listacandidatos;
    int row_index=0;
    View.OnClickListener listener;
    public adapter_listaconsejales(ArrayList<canditados> cand){
        this.listacandidatos= cand;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_consejales,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(listacandidatos.get(position));
        //holder.button.setSelected(holder.button.isSelected()?true:false);
    }

    @Override
    public int getItemCount() {
        return listacandidatos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener= listener;
    }
    @Override
    public void onClick(View v) {
        if(this.listener!=null){

            this.listener.onClick(v);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder  {

        public View button;
        TextView candidato_opcion;
        ImageView candidato_foto;
        TextView candidato_nombre;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            candidato_opcion= itemView.findViewById(R.id.consejal_opcion);
            candidato_foto= itemView.findViewById(R.id.consejal_foto);
            candidato_nombre = itemView.findViewById(R.id.consejal__nombre);

        }

        public void asignarDatos(canditados canditados) {
                candidato_opcion.setText(canditados.getLista());
                candidato_nombre.setText(canditados.getNombre());
                candidato_foto.setImageResource(canditados.getFoto());

        }

    }
}
