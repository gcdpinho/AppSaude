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

public class EspecialistasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialistas);
        designConfigurations();

        ListView listView = (ListView)findViewById(R.id.listView);
        List<Especialista> zombies = gerarZombies();

        final EspecialistasAdapter zombiesAdapter = new EspecialistasAdapter(this,  zombies);
        listView.setAdapter(zombiesAdapter);
    }

    private List<Especialista> gerarZombies() {
        List<Especialista> zombies = new ArrayList<Especialista>();
        zombies.add(criarZombie("Shane", 23, R.drawable.ic_exclude));
        zombies.add(criarZombie("Hershel", 23, R.drawable.ic_exclude));
        zombies.add(criarZombie("Glen", 23, R.drawable.ic_exclude));

        return zombies;
    }

    private Especialista criarZombie(String nome, int idade, int image) {
        Especialista especialista = new Especialista(nome, idade, image);
        return especialista;
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
