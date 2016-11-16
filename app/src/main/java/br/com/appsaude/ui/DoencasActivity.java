package br.com.appsaude.ui;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.appsaude.R;

public class DoencasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doencas);
        designConfigurations();

        ListView listView = (ListView)findViewById(R.id.listView);
        List<Doenca> doencas = geraLista();

        final DoencasAdapter doencasAdapter = new DoencasAdapter(this, doencas);
        listView.setAdapter(doencasAdapter);
    }

    private List<Doenca> geraLista(){
        List<Doenca> doencasList = new ArrayList<>();
        String texto = "";
        //texto = "<html><body><p align=\"justify\">";
        texto+= "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        //texto+= "</p></body></html>";
        doencasList.add(criaDoenca("teste", texto, "80%" ));
        doencasList.add(criaDoenca("teste", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "80%" ));
        return doencasList;
    }

    private Doenca criaDoenca(String nome, String desc, String porc){
        Doenca doenca = new Doenca(nome, desc, porc);

        return doenca;
    }

    private void designConfigurations(){
        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(R.layout.actionbar_backbutton);
        ab.setDisplayHomeAsUpEnabled(true);
        TextView actionBar = (TextView) findViewById(R.id.actionBarId);
        actionBar.setText("DIAGNÓSTICO");
        actionBar.setTextColor(Color.parseColor("#FFFFFF"));
    }
}
