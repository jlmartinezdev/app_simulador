package com.jlmartinez.votos2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ventana6 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<canditados> listacandidatos;
    String nombre_candidato, partido_candidato, lista_candidato, partidoabv_candidato;
    int foto_candidato;
    String partido_participante,lista_participante,partidoabv_participante;
    TextView sel_lista,sel_partido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana6);
        recyclerView= findViewById(R.id.listaconsejales);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        sel_lista= findViewById(R.id.v6_lista);
        sel_partido = findViewById(R.id.v6_partido);

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
        }
        sel_lista.setText(lista_participante);
        sel_partido.setText(partido_participante);
        listacandidatos= new ArrayList<>();
        if(lista_participante.equals("LISTA 44")){
            listacandidatos.add(new canditados("OSMAR DUARTE","","1","P1",R.drawable.c1));
            listacandidatos.add(new canditados("CAROLINA AQUINO","","2","P1",R.drawable.c2));
            listacandidatos.add(new canditados("MIGUEL BAEZ","","3","P1",R.drawable.c3));
            listacandidatos.add(new canditados("OSCAR ROLON","","4","P1",R.drawable.c4));
            listacandidatos.add(new canditados("JORGE MENDOZA","","5","P1",R.drawable.c5));
            listacandidatos.add(new canditados("PEDRO CORONEL","","6","P1",R.drawable.c6));
            listacandidatos.add(new canditados("MIGUEL BAREIRO","","7","P1",R.drawable.c7));
            listacandidatos.add(new canditados("ROMINA IRALA","","8","P1",R.drawable.c8));
            listacandidatos.add(new canditados("NOELIA GONZALEZ","","9","P1",R.drawable.c9));
        }else{
            listacandidatos.add(new canditados("Candidato 1","","1","P1",R.drawable.foto10));
            listacandidatos.add(new canditados("Candidato 2","","2","P1",R.drawable.foto6));
            listacandidatos.add(new canditados("Candidato 3","","3","P1",R.drawable.foto3));
            listacandidatos.add(new canditados("Candidato 4","","4","P1",R.drawable.foto2));
            listacandidatos.add(new canditados("Candidato 5","","5","P1",R.drawable.foto5));
            listacandidatos.add(new canditados("Candidato 6","","6","P1",R.drawable.fot7));
            listacandidatos.add(new canditados("Candidato 7","","7","P1",R.drawable.foto9));
            listacandidatos.add(new canditados("Candidato 8","","8","P1",R.drawable.foto8));
            listacandidatos.add(new canditados("Candidato 9","","9","P1",R.drawable.user1));
        }



        adapter_listaconsejales ad = new adapter_listaconsejales(listacandidatos);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = new Bundle();
                extras.putString("canditato_nombre", nombre_candidato);
                extras.putString("candidato_partido", partido_candidato);
                extras.putString("candidato_partidoabv", partidoabv_candidato);
                extras.putString("candidato_lista", lista_candidato);
                extras.putInt("candidato_fot", foto_candidato);

                extras.putString("participante_lista", lista_participante);
                extras.putString("participante_partido", partido_participante);
                extras.putString("participante_abv", partidoabv_participante);

                extras.putString("consejal_lista",listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getLista());
                extras.putString("consejal_nombre",listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getNombre());
                extras.putInt("consejal_foto",listacandidatos.get(recyclerView.getChildAdapterPosition(v)).getFoto());

                Intent intent = new Intent(getApplicationContext(), ventana7.class);
                intent.putExtras(extras);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
                overridePendingTransition(0,0);
                finish();
            }
        });
        recyclerView.setAdapter(ad);


    }
}
