package com.jlmartinez.votos2021;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_listaparticipantes extends RecyclerView.Adapter<adapter_listaparticipantes.ViewHolderDatos> implements View.OnClickListener {
    private ArrayList<canditados> listacandidatos;
    View.OnClickListener listener;
    public adapter_listaparticipantes(ArrayList<canditados> cand){
        this.listacandidatos= cand;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_partocipantes,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(listacandidatos.get(position));
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
        TextView candidato_lista;
        TextView candidato_partido;
        TextView candidato_partido_abv;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            candidato_lista= itemView.findViewById(R.id.participante_lista);
            candidato_partido= itemView.findViewById(R.id.participante_partido);
            candidato_partido_abv = itemView.findViewById(R.id.participante_partidoabv);

        }

        public void asignarDatos(canditados canditados) {

            if(canditados.getLista()=="1") {
                candidato_partido.setText(canditados.getPartido());
                candidato_lista.setText("");
                candidato_partido_abv.setText("");

            }else{
                candidato_partido.setText(canditados.getPartido());
                candidato_lista.setText(canditados.getLista());
                candidato_partido_abv.setText(canditados.getPartido_abv());

            }


        }

    }
}
