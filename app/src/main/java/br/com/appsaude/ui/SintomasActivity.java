package br.com.appsaude.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.appsaude.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class SintomasActivity extends BackableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);
        designConfigurations();

        Diagnosticar();
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

    private void Diagnosticar(){
        Button diag = (Button) findViewById(R.id.button2);

        //final Context context = getApplicationContext();
        //Toast.makeText(context, teste, Toast.LENGTH_LONG).show();

        diag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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

                //postDignosticos(campos);
                goEspecialistas();

            }
        });
    }

    public void goEspecialistas() {

        Intent secondActivity = new Intent(this, EspecialistasActivity.class);
        startActivity(secondActivity);
    }

    private void callVolley() {
        final TextView mTextView = (TextView) findViewById(R.id.text);
        final Context context = getApplicationContext();
// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://appsaude.pe.hu/android/teste.php";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        String output = "";
                        try {
                            output = new String(response.getBytes("ISO-8859-1"), "UTF-8");

                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(context, output, Toast.LENGTH_LONG).show();
                    //    mTextView.setText("Response is: " + response.substring(0, 300));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Erro na requisão do banco.", Toast.LENGTH_LONG).show();
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void designConfigurations() {
        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(R.layout.actionbar_backbutton);
        ab.setDisplayHomeAsUpEnabled(true);
        TextView actionBar = (TextView) findViewById(R.id.actionBarId);
        actionBar.setText("Sinais e Sintomas");
        actionBar.setTextColor(Color.parseColor("#FFFFFF"));
    }



    private void postDignosticos(ArrayList<String> campos) {
        final Context context = getApplicationContext();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://appsaude.pe.hu/android/teste2.php?";

        for (int i=0; i<campos.size(); i++)
            url += "campo"+ i + "=" + campos.get(i) + "&";
        url = url.substring(0, url.length()-1);
        url = url.replaceAll(" ", "_");

        //Toast.makeText(context, url, Toast.LENGTH_LONG).show();

        JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String[] splitSinais = response.toString().split(",");
                        ArrayList<String> esp = new ArrayList<>();
                        for (int i=0; i<splitSinais.length; i++){
                            if (splitSinais[i].contains("nome")){
                                String[] splitPoints = splitSinais[i].split(":");
                                esp.add(splitPoints[splitPoints.length-1].replaceAll("[\":}]", "").replaceAll("]", ""));
                            }
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

                            float[] percents = new float[counts.length];
                            for (int i = 0; i < percents.length; i++)
                                percents[i] = counts[i] * 100 * 2 / esp.size();

                            String resposta = "";
                            ArrayList<Integer> maiorPai = new ArrayList<>();
                            for (int j = 0; j < percents.length; j++) {
                                float maior = 0;
                                int index = 0;
                                for (int i = 0; i < percents.length; i++)
                                    if (!maiorPai.contains(i) && maior < percents[i]) {
                                        maior = percents[i];
                                        index = i;
                                    }
                                maiorPai.add(index);
                                resposta += espDiff.get(index) + ": " + maior + "%\n";
                            }
                            Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
                        }

                        Toast.makeText(context, "Os campos não possuem valores válidos.", Toast.LENGTH_LONG).show();

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
