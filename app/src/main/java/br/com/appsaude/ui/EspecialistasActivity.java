package br.com.appsaude.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.appsaude.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class EspecialistasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialistas);
        designConfigurations();

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        //Context context = getApplicationContext();
        //Toast.makeText(context, message, Toast.LENGTH_LONG).show();

        ListView listView = (ListView)findViewById(R.id.listView);
        List<Especialista> esp = gerarLista(message);

        final EspecialistasAdapter espAdapter = new EspecialistasAdapter(this, esp);
        listView.setAdapter(espAdapter);
    }

    private List<Especialista> gerarLista(String message) {
        List<Especialista> espList = new ArrayList<>();
        String[] splitLine = message.split("\n");

        for (int i=0; i<splitLine.length; i++){
            String[] aux = splitLine[i].split(":");
            espList.add(criarZombie(aux[0], aux[1], R.drawable.iconesetaverde));
        }

        return espList;
    }

    private Especialista criarZombie(String nome, String percent, int image) {
        Especialista esp = new Especialista(nome, percent, image);
        return esp;
    }

    private void designConfigurations() {
        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(R.layout.actionbar_backbutton);
        ab.setDisplayHomeAsUpEnabled(true);
        TextView actionBar = (TextView) findViewById(R.id.actionBarId);
        actionBar.setText("Especialistas");
        actionBar.setTextColor(Color.parseColor("#FFFFFF"));
    }
}
