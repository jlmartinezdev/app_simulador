package com.jlmartinez.votos2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class ventana4 extends AppCompatActivity {
    ArrayList<canditados> listacandidatos;
    RecyclerView recyclerView;
    String nombre_candidato, partido_candidato, lista_candidato, partidoabv_candidato;
    int foto_candidato;
    String partido_participante,lista_participante,partidoabv_participante;
    String nombre_consejal,opcion_consejal,modificarintendente;
    int foto_consejal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana4);
        recyclerView= findViewById(R.id.listacanditos);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));

        listacandidatos= new ArrayList<>();
        listacandidatos.add(new canditados("Candidato 1","Partido 1","10A","P1",R.drawable.foto4));
        listacandidatos.add(new canditados("Candidato 2","Partido 2","10B","P1",R.drawable.foto2));
        listacandidatos.add(new canditados("Candidato 3","Partido 3","32","P1",R.drawable.foto3));
        listacandidatos.add(new canditados("Humberto Maidana","Honremos Caazapa","44","HC",R.drawable.hm));
        listacandidatos.add(new canditados("","VOTO EN BLANCO","1","",R.drawable.fotoblanco));

        adapter_listacanditos ad = new adapter_listacanditos(listacandidatos);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getLista()=="44"){
                    if(modificarintendente != null){
                        Bundle extras = new Bundle();
                        extras.putString("canditato_nombre", listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getNombre());
                        extras.putString("candidato_partido", listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getPartido());
                        extras.putString("candidato_partidoabv", listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getPartido_abv());
                        extras.putString("candidato_lista", listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getLista());
                        extras.putInt("candidato_fot", listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getFoto());

                        extras.putString("participante_lista", lista_participante);
                        extras.putString("participante_partido", partido_participante);
                        extras.putString("participante_abv", partidoabv_participante);

                        extras.putString("consejal_lista",opcion_consejal);
                        extras.putString("consejal_nombre",nombre_consejal);
                        extras.putInt("consejal_foto",foto_consejal);
                        Intent intent = new Intent(getApplicationContext(), ventana7.class);
                        intent.putExtras(extras);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0,0);
                    }else{
                        Bundle extras = new Bundle();

                        extras.putString("Candidato",listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getNombre());
                        extras.putString("Partido",listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getPartido());
                        extras.putString("Lista",listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getLista());
                        extras.putString("Partidoabv",listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getPartido_abv());
                        extras.putInt("foto", listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getFoto());

                        Intent intent = new Intent(getApplicationContext(), ventana5.class);
                        intent.putExtras(extras);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0,0);
                    }
                    finish();
                }




            }
        });
        recyclerView.setAdapter(ad);
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){

            partido_participante = parametros.getString("participante_partido");
            lista_participante = parametros.getString("participante_lista");
            partidoabv_participante = parametros.getString("participante_abv");

            nombre_candidato = parametros.getString("canditato_nombre");
            partido_candidato = parametros.getString("candidato_partido");
            partidoabv_candidato = parametros.getString("candidato_partidoabv");
            lista_candidato = parametros.getString("candidato_lista");
            foto_candidato= parametros.getInt("candidato_fot");

            nombre_consejal= parametros.getString("consejal_nombre");
            opcion_consejal= parametros.getString("consejal_lista");
            foto_consejal = parametros.getInt("consejal_foto");

            modificarintendente = parametros.getString("modificar");
        }
    }
}