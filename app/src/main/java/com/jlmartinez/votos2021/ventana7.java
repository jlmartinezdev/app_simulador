package com.jlmartinez.votos2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ventana7 extends AppCompatActivity {
    TextView nombreintente,nombreconsejal,partidointendente,partidoconsejal,listaintendente,listaconsejal;
    ImageView fotointendete, fotoconsejal;
    Button btnmodificarIntentente, btnmodificarConsejal, btnreiciar, btnimprimir;

    String nombre_candidato, partido_candidato, lista_candidato, partidoabv_candidato;
    int foto_candidato;
    String partido_participante,lista_participante,partidoabv_participante;
    String nombre_consejal,opcion_consejal;
    int foto_consejal;
    TextView sel_lista,sel_partido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana7);
        nombreintente= findViewById(R.id.v7nombre_intendente);
        nombreconsejal= findViewById(R.id.v7_nombreconsejal);
        partidointendente= findViewById(R.id.v7_partidointendente);
        partidoconsejal= findViewById(R.id.v7_partidoconsejal);
        listaintendente= findViewById(R.id.v7_listaintendente);
        listaconsejal = findViewById(R.id.v7_listaconsejal);
        fotointendete= findViewById(R.id.v7_fotointendente);
        fotoconsejal = findViewById(R.id.v7_fotoconsejal);
        btnimprimir= findViewById(R.id.btnimprimir);
        btnmodificarConsejal= findViewById(R.id.btnmodificar_consejal);
        btnmodificarIntentente = findViewById(R.id.btnmodificar_intendente);
        btnreiciar = findViewById(R.id.btnreinciar);

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
        }
        if(lista_candidato.equals("1")){
            nombreintente.setText("");
            partidointendente.setText("");
            listaintendente.setText("VOTO EN BLANCO");

        }else{
            nombreintente.setText(nombre_candidato);
            partidointendente.setText(partido_candidato);
            listaintendente.setText("LISTA "+lista_candidato);
        }
        fotointendete.setImageResource(foto_candidato);
        if(lista_participante.equals("1")){
            nombreconsejal.setText(" ");
            partidoconsejal.setText(" ");
            listaconsejal.setText("VOTO EN BLANCO");
        }else{
            nombreconsejal.setText(nombre_consejal);
            partidoconsejal.setText(partido_participante);
            listaconsejal.setText(lista_participante);
        }

        fotoconsejal.setImageResource(foto_consejal);
        btnmodificarIntentente.setOnClickListener(new View.OnClickListener() {
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

                extras.putString("consejal_lista",opcion_consejal);
                extras.putString("consejal_nombre",nombre_consejal);
                extras.putInt("consejal_foto",foto_consejal);

                extras.putString("modificar","V7");
                Intent intent = new Intent(getApplicationContext(), ventana4.class);
                intent.putExtras(extras);

                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
                overridePendingTransition(0, 0);
                finish();
            }
        });
        btnreiciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ventana4.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
                overridePendingTransition(0, 0);
                finish();
            }
        });
        btnmodificarConsejal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = new Bundle();
                extras.putString("Candidato", nombre_candidato);
                extras.putString("Partido", partido_candidato);
                extras.putString("Partidoabv", partidoabv_candidato);
                extras.putString("Lista", lista_candidato);
                extras.putInt("foto", foto_candidato);

                Intent intent = new Intent(getApplicationContext(), ventana5.class);
                intent.putExtras(extras);

                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
                overridePendingTransition(0, 0);
                finish();
            }
        });
        btnimprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ventana8.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivityForResult(intent, 0);
                overridePendingTransition(0, 0);

                finish();
            }
        });
    }
}