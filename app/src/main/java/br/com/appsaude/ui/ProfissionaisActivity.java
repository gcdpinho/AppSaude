package br.com.appsaude.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.appsaude.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ProfissionaisActivity extends BackableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissionais);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        designConfigurations(message);

        ListView listView = (ListView)findViewById(R.id.listView);
        List<Profissional> prof = gerarLista(message);

        final ProfissionaisAdapter profAdapter = new ProfissionaisAdapter(this, prof);
        listView.setAdapter(profAdapter);

    }

    private List<Profissional> gerarLista(String message){
        List<Profissional> profList = new ArrayList<>();
        String[] splitLine = message.split("\n");

        for (int i=1; i<splitLine.length; i+=5){
            profList.add(criarProf(splitLine[i], splitLine[i+1], splitLine[i+2], splitLine[i+3], splitLine[i+4], R.drawable.iconesetaverde));
        }

        return profList;
    }

    private Profissional criarProf(String nome, String endereco, String fone, String plano, String email, int image){
        Profissional prof = new Profissional(nome, endereco, fone, plano, email, image);
        return prof;
    }

    private void designConfigurations(String message){
        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(R.layout.actionbar_backbutton);
        ab.setDisplayHomeAsUpEnabled(true);
        TextView actionBar = (TextView) findViewById(R.id.actionBarId);
        actionBar.setText(message.split("\n")[0]);
        actionBar.setTextColor(Color.parseColor("#FFFFFF"));
    }


}
