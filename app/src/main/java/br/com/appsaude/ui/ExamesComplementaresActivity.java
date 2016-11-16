package br.com.appsaude.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import br.com.appsaude.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class ExamesComplementaresActivity extends BackableActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exames_complementares);
        designConfigurations();

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        Context context = getApplicationContext();
        //Toast.makeText(context, message, Toast.LENGTH_LONG).show();

        buttonDiagnostico();
        camposVisible();


    }

    private void camposVisible(){

        LinearLayout t2 = (LinearLayout) findViewById(R.id.linearEdit2);
        t2.setVisibility(View.GONE);
        LinearLayout t3 = (LinearLayout) findViewById(R.id.linearEdit3);
        t3.setVisibility(View.GONE);
        LinearLayout t4 = (LinearLayout) findViewById(R.id.linearEdit4);
        t4.setVisibility(View.GONE);
        LinearLayout t5 = (LinearLayout) findViewById(R.id.linearEdit5);
        t5.setVisibility(View.GONE);
        LinearLayout t6 = (LinearLayout) findViewById(R.id.linearEdit6);
        t6.setVisibility(View.GONE);

        TextView t = (TextView) findViewById(R.id.textView2);
        t.setVisibility(View.GONE);

        ImageView i2 = (ImageView) findViewById(R.id.close2);
        i2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LinearLayout t = (LinearLayout) findViewById(R.id.linearEdit2);
                t.setVisibility(View.GONE);
                Button b = (Button) findViewById(R.id.button);
                b.setVisibility(View.VISIBLE);
                TextView tv = (TextView) findViewById(R.id.textView2);
                tv.setVisibility(View.GONE);
                TextView et = (TextView) findViewById(R.id.editText2);
                et.setText("");
            }
        });

        ImageView i3 = (ImageView) findViewById(R.id.close3);
        i3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LinearLayout t = (LinearLayout) findViewById(R.id.linearEdit3);
                t.setVisibility(View.GONE);
                Button b = (Button) findViewById(R.id.button);
                b.setVisibility(View.VISIBLE);
                TextView tv = (TextView) findViewById(R.id.textView2);
                tv.setVisibility(View.GONE);
                TextView et = (TextView) findViewById(R.id.editText3);
                et.setText("");
            }
        });

        ImageView i4 = (ImageView) findViewById(R.id.close4);
        i4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LinearLayout t = (LinearLayout) findViewById(R.id.linearEdit4);
                t.setVisibility(View.GONE);
                Button b = (Button) findViewById(R.id.button);
                b.setVisibility(View.VISIBLE);
                TextView tv = (TextView) findViewById(R.id.textView2);
                tv.setVisibility(View.GONE);
                TextView et = (TextView) findViewById(R.id.editText4);
                et.setText("");
            }
        });

        ImageView i5 = (ImageView) findViewById(R.id.close5);
        i5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LinearLayout t = (LinearLayout) findViewById(R.id.linearEdit5);
                t.setVisibility(View.GONE);
                Button b = (Button) findViewById(R.id.button);
                b.setVisibility(View.VISIBLE);
                TextView tv = (TextView) findViewById(R.id.textView2);
                tv.setVisibility(View.GONE);
                TextView et = (TextView) findViewById(R.id.editText5);
                et.setText("");
            }
        });

        ImageView i6 = (ImageView) findViewById(R.id.close6);
        i6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LinearLayout t = (LinearLayout) findViewById(R.id.linearEdit6);
                t.setVisibility(View.GONE);
                Button b = (Button) findViewById(R.id.button);
                b.setVisibility(View.VISIBLE);
                TextView tv = (TextView) findViewById(R.id.textView2);
                tv.setVisibility(View.GONE);
                TextView et = (TextView) findViewById(R.id.editText6);
                et.setText("");
            }
        });
        Button add = (Button) findViewById(R.id.button);

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonAdd();
            }
        });
    }

    private void buttonAdd(){
        boolean flag = false;
        for (int i=2; i<=6; i++){
            switch (i) {
                case 2:
                    LinearLayout t2 = (LinearLayout) findViewById(R.id.linearEdit2);
                    if (!t2.isShown()) {
                        t2.setVisibility(View.VISIBLE);
                        flag = true;
                    }
                    break;
                case 3:
                    LinearLayout t3 = (LinearLayout) findViewById(R.id.linearEdit3);
                    if (!t3.isShown()) {
                        t3.setVisibility(View.VISIBLE);
                        flag = true;
                    }
                    break;
                case 4:
                    LinearLayout t4 = (LinearLayout) findViewById(R.id.linearEdit4);
                    if (!t4.isShown()) {
                        t4.setVisibility(View.VISIBLE);
                        flag = true;
                    }
                    break;
                case 5:
                    LinearLayout t5 = (LinearLayout) findViewById(R.id.linearEdit5);
                    if (!t5.isShown()) {
                        t5.setVisibility(View.VISIBLE);
                        flag = true;
                    }
                    break;
                case 6:
                    LinearLayout t6 = (LinearLayout) findViewById(R.id.linearEdit6);
                    if (!t6.isShown()) {
                        t6.setVisibility(View.VISIBLE);
                        Button b = (Button) findViewById(R.id.button);
                        b.setVisibility(View.GONE);
                        TextView t = (TextView) findViewById(R.id.textView2);
                        t.setVisibility(View.VISIBLE);
                        flag = true;
                    }
                    break;
            }
            if (flag)
                break;
        }
    }

    private void buttonDiagnostico(){
        Button diag = (Button) findViewById(R.id.button2);

        diag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean flag = false;
                Context context = getApplicationContext();
                EditText t1 = (EditText) findViewById(R.id.editText1);
                EditText t2 = (EditText) findViewById(R.id.editText2);
                EditText t3 = (EditText) findViewById(R.id.editText3);
                EditText t4 = (EditText) findViewById(R.id.editText4);
                EditText t5 = (EditText) findViewById(R.id.editText5);
                EditText t6 = (EditText) findViewById(R.id.editText6);

                ArrayList<String> campos = new ArrayList<>();
                campos.add(new String(t1.getText().toString()));
                campos.add(new String(t2.getText().toString()));
                campos.add(new String(t3.getText().toString()));
                campos.add(new String(t4.getText().toString()));
                campos.add(new String(t5.getText().toString()));
                campos.add(new String(t6.getText().toString()));

                for (int i=0; i<6; i++)
                    if (!campos.get(i).equals("")) {
                        flag = true;
                        break;
                    }
                if (flag)
                    volleyExames(campos);
                else
                    startDoencas("");

            }
        });
    }

    public void startDoencas(String resposta) {

        Intent secondActivity = new Intent(this, DoencasActivity.class);
        secondActivity.putExtra(EXTRA_MESSAGE, resposta);
        startActivity(secondActivity);
    }

    private void designConfigurations() {
        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(R.layout.actionbar_backbutton);
        ab.setDisplayHomeAsUpEnabled(true);
        TextView actionBar = (TextView) findViewById(R.id.actionBarId);
        actionBar.setText("EXAMES COMPLEMENTARES");
        actionBar.setTextColor(Color.parseColor("#FFFFFF"));
    }



    private void volleyExames(ArrayList<String> campos) {
        final Context context = getApplicationContext();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://web-saude.com/websaude/getExames.php?";
            for (int i = 0; i < campos.size(); i++)
                url += "campo" + i + "=" + campos.get(i) + "&";
            url = url.substring(0, url.length() - 1);
            url = url.replaceAll(" ", "_");

            //Toast.makeText(context, url, Toast.LENGTH_LONG).show();

            JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            String[] splitSinais = response.toString().split(",");
                            String numDoencas = "";
                            ArrayList<String> esp = new ArrayList<>();
                            for (int i = 0; i < splitSinais.length; i++) {
                                String[] splitPoints = splitSinais[i].split(":");
                                if (splitSinais[i].contains("nome")) {
                                    esp.add(splitPoints[splitPoints.length - 1].replaceAll("[\":}]", "").replaceAll("]", ""));
                                } else if (splitSinais[i].contains("Doenca"))
                                    numDoencas = splitPoints[splitPoints.length - 1].replaceAll("[\":}]", "").replaceAll("]", "");
                            }

                            if (!esp.isEmpty()) {
                                ArrayList<String> espDiff = new ArrayList<>();
                                espDiff.add(esp.get(0));
                                for (int i = 0; i < esp.size(); i++)
                                    if (!espDiff.contains(esp.get(i)))
                                        espDiff.add(esp.get(i));

                                int[] counts = new int[espDiff.size()];
                                for (int i = 0; i < counts.length; i++)
                                    counts[i] = 0;
                                for (int i = 0; i < esp.size(); i++)
                                    for (int j = 0; j < espDiff.size(); j++)
                                        if (espDiff.get(j).equals(esp.get(i)))
                                            counts[j]++;

                                int[] percents = new int[counts.length];
                                for (int i = 0; i < percents.length; i++)
                                    percents[i] = counts[i] * 100 / Integer.parseInt(numDoencas);

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
                                    resposta += espDiff.get(index) + ": " + maior + "%\n";
                                }
                                //Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
                                startDoencas(resposta);
                            } else
                                Toast.makeText(context, "Os campos não possuem valores válidos.", Toast.LENGTH_SHORT).show();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });

            queue.add(req);
    }

}
