package br.com.appsaude.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.appsaude.R;
import br.com.appsaude.util.Util;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DoencasActivity extends BackableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doencas);
        loader.show();
        designConfigurations();

        String message = getIntent().getStringExtra(EXTRA_MESSAGE);

        ListView listView = (ListView)findViewById(R.id.listView);
        List<Doenca> doencas = geraLista(message);

        final DoencasAdapter doencasAdapter = new DoencasAdapter(this, doencas);
        listView.setAdapter(doencasAdapter);

        loader.dismiss();
    }

    private List<Doenca> geraLista(String message){
        List<Doenca> doencasList = new ArrayList<>();
        /*
        String texto = "";
        //texto = "<html><body><p text-align='justify '>";
        texto+= "\tLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        texto+= "\t\t\t\t\t\t\t\t\t\t";
        String textos = "\tNão há descrição da doença.\t\t\t\t\t\t\t\t\t\t\t";
        doencasList.add(criaDoenca("teste", textos, "80%" ));
        doencasList.add(criaDoenca("teste", texto, "80%" ));
        */
        final Context context = getApplicationContext();

        if (message == null)
            Util.errorToast("Nenhuma doença encontrada.", getApplicationContext()).show();
            //Toast.makeText(context, "Nenhuma doença encontrada.", Toast.LENGTH_SHORT).show();
        else
            if (!message.isEmpty()) {
                String[] splitNewLine = message.split("\n");

                ArrayList<String> espDiff = new ArrayList<>();
                ArrayList<String> desc = new ArrayList<>();
                espDiff.add(splitNewLine[0]);
                desc.add(splitNewLine[1]);
                for (int i = 0; i < splitNewLine.length; i += 2)
                    if (!espDiff.contains(splitNewLine[i])) {
                        espDiff.add(splitNewLine[i]);
                        desc.add(splitNewLine[i + 1]);
                    }


                int[] counts = new int[espDiff.size()];
                for (int i = 0; i < counts.length; i++)
                    counts[i] = 0;
                for (int i = 0; i < splitNewLine.length; i += 2)
                    for (int j = 0; j < espDiff.size(); j++)
                        if (espDiff.get(j).equals(splitNewLine[i]))
                            counts[j]++;

                int[] percents = new int[counts.length];
                for (int i = 0; i < percents.length; i++)
                    percents[i] = counts[i] * 100 / (splitNewLine.length / 2);

                String resposta = "";
                ArrayList<Integer> maiorPai = new ArrayList<>();
                for (int j = 0; j < percents.length; j++) {
                    int maior = 0;
                    int index = 0;
                    for (int i = 0; i < percents.length; i++)
                        if (!maiorPai.contains(i) && maior < percents[i]) {
                            maior = percents[i];
                            index = i;
                        }
                    maiorPai.add(index);
                    String aux;
                    if (desc.get(index).contains("null"))
                        aux = "\tNão há nenhuma descrição sobre a doença.";
                    else
                        aux = "\t"+desc.get(index);

                    doencasList.add(criaDoenca(espDiff.get(index), aux, maior + "%"));
                    //resposta += espDiff.get(index) + ": " + maior + "%\n";
                }
            }
            else
               Util.errorToast("Nenhuma doença encontrada.", getApplicationContext()).show();
                //Toast.makeText(context, "Nenhuma doença encontrada.", Toast.LENGTH_SHORT).show();

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
