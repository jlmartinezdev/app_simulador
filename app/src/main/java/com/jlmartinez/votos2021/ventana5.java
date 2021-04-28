package com.jlmartinez.votos2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ventana5 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<canditados> listacandidatos;
    String nombre_candidato, partido_candidato, lista_candidato, partidoabv_candidato;
    int foto_candidato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana5);
        nombre_candidato = "";
        partido_candidato = "";
        lista_candidato = "";
        partidoabv_candidato = "";
        foto_candidato = 0;

        recyclerView = findViewById(R.id.listaparticipantes);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        listacandidatos = new ArrayList<>();
        listacandidatos.add(new canditados("Candidato 1", "Partido Democracia", "LISTA 10A", "P1", R.drawable.user1));
        listacandidatos.add(new canditados("Candidato 2", "Alianza  Constitucional", "LISTA 10B", "P1", R.drawable.foto5));
        listacandidatos.add(new canditados("Candidato 3", "Movimiento 2", "LISTA 32", "P1", R.drawable.user1));
        listacandidatos.add(new canditados("Humerto Maidana", "Honremos Caazapa", "LISTA 44", "HC", R.drawable.user1));
        listacandidatos.add(new canditados("", "VOTO EN BLANCO", "1", "", R.drawable.fotoblanco));

        adapter_listaparticipantes ad = new adapter_listaparticipantes(listacandidatos);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getLista()=="LISTA 44") {
                    Bundle extras = new Bundle();
                    extras.putString("canditato_nombre", nombre_candidato);
                    extras.putString("candidato_partido", partido_candidato);
                    extras.putString("candidato_partidoabv", partidoabv_candidato);
                    extras.putString("candidato_lista", lista_candidato);
                    extras.putInt("candidato_fot", foto_candidato);

                    extras.putString("participante_lista", listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getLista());
                    extras.putString("participante_partido", listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getPartido());
                    extras.putString("participante_abv", listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getPartido_abv());

                    if (listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getLista().equals("1")) {
                        Intent intent = new Intent(getApplicationContext(), ventana7.class);
                        intent.putExtras(extras);

                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0, 0);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), ventana6.class);
                        intent.putExtras(extras);

                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0, 0);
                    }
                    finish();
                }



            }
        });
        recyclerView.setAdapter(ad);


        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
            nombre_candidato = parametros.getString("Candidato");
            partido_candidato = parametros.getString("Partido");
            partidoabv_candidato = parametros.getString("Partidoabv");
            lista_candidato = parametros.getString("Lista");
            foto_candidato = parametros.getInt("foto");
        }

    }
}