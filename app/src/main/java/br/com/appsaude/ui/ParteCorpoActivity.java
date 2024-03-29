package br.com.appsaude.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.appsaude.R;
import br.com.appsaude.service.Services;
import br.com.appsaude.util.Constants;
import br.com.appsaude.util.Utils;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class ParteCorpoActivity extends BackableActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte_corpo);
        loader.show();
        designConfigurations();

        buttonProximo();
        camposVisible();

        Services.volleyAutoComplete(this, Constants.URL+"getAllParteCorpo"+Constants.LANGUAGE, "", createCallbackAutoComplete());
        //volleyAutoCompleteSintomas();

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

    private void buttonProximo(){
        Button diag = (Button) findViewById(R.id.button2);

        diag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loader.show();
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
                    Services.getVolley(campos, getApplicationContext(), Constants.URL + "getParteCorpo" + Constants.LANGUAGE, createCallbackGet());
                else
                    startSintomas("");
            }
        });
    }

    public void startSintomas(String resposta) {
        loader.dismiss();
        Intent secondActivity = new Intent(this, SintomasActivity.class);
        secondActivity.putExtra(EXTRA_MESSAGE, resposta);
        startActivity(secondActivity);
    }

    private void designConfigurations() {
        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(R.layout.actionbar_backbutton);
        ab.setDisplayHomeAsUpEnabled(true);
        TextView actionBar = (TextView) findViewById(R.id.actionBarId);
        actionBar.setText("ESTRUTURAS ANATÔMICAS");
        actionBar.setTextColor(Color.parseColor("#FFFFFF"));
    }

        private Handler.Callback createCallbackAutoComplete(){
            Handler.Callback callback = new Handler.Callback() {
                @Override
                public boolean handleMessage(Message message) {
                    if (message.arg1 == 1)
                        Utils.errorToast(message.obj.toString(), getApplicationContext()).show();
                    else {
                        ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, (String[]) message.obj) {
                            @Override
                            public View getView(int position, View convertView, ViewGroup parent) {
                                View view = super.getView(position, convertView, parent);
                                TextView text = (TextView) view.findViewById(android.R.id.text1);
                                text.setTextColor(Color.BLACK);
                                return view;
                            }
                        };
                        AutoCompleteTextView autoCompleteEditText1 = (AutoCompleteTextView) findViewById(R.id.editText1);
                        autoCompleteEditText1.setAdapter(autoCompleteAdapter);
                        AutoCompleteTextView autoCompleteEditText2 = (AutoCompleteTextView) findViewById(R.id.editText2);
                        autoCompleteEditText2.setAdapter(autoCompleteAdapter);
                        AutoCompleteTextView autoCompleteEditText3 = (AutoCompleteTextView) findViewById(R.id.editText3);
                        autoCompleteEditText3.setAdapter(autoCompleteAdapter);
                        AutoCompleteTextView autoCompleteEditText4 = (AutoCompleteTextView) findViewById(R.id.editText4);
                        autoCompleteEditText4.setAdapter(autoCompleteAdapter);
                        AutoCompleteTextView autoCompleteEditText5 = (AutoCompleteTextView) findViewById(R.id.editText5);
                        autoCompleteEditText5.setAdapter(autoCompleteAdapter);
                        AutoCompleteTextView autoCompleteEditText6 = (AutoCompleteTextView) findViewById(R.id.editText6);
                        autoCompleteEditText6.setAdapter(autoCompleteAdapter);
                    }
                    loader.dismiss();
                    return true;
                }
            };
            return callback;
        }
    private Handler.Callback createCallbackGet() {
        Handler.Callback callback = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                if (message.arg1 == 1)
                    Utils.errorToast(message.obj.toString(), getApplicationContext()).show();
                else
                    startSintomas((String) message.obj);
                loader.dismiss();
                return true;
            }
        };

        return callback;
    }
    /*
    private void volleyAutoCompleteSintomas(){
        final Context context = getApplicationContext();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://web-saude.com/websaude/getAllSintomas.php";

        JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String[] splitSinais = response.toString().split(",");
                        ArrayList<String> esp = new ArrayList<>();
                        for (int i = 0; i < splitSinais.length; i++) {
                            String[] splitPoints = splitSinais[i].split(":");
                            if (splitSinais[i].contains("nome"))
                                esp.add(splitPoints[splitPoints.length - 1].replaceAll("[\":}]", "").replaceAll("]", ""));
                            else
                            if (splitSinais[i].contains("desc"))
                                esp.add(splitPoints[splitPoints.length - 1].replaceAll("[\":}]", "").replaceAll("]", ""));
                        }

                        String[] allSintomas = new String[esp.size()];
                        for (int i = 0; i < esp.size(); i++)
                            allSintomas[i] = esp.get(i);


                        ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, allSintomas){
                            @Override
                            public View getView(int position, View convertView, ViewGroup parent) {
                                View view = super.getView(position, convertView, parent);
                                TextView text = (TextView) view.findViewById(android.R.id.text1);
                                text.setTextColor(Color.BLACK);
                                return view;
                            }
                        };
                        AutoCompleteTextView autoCompleteEditText1 = (AutoCompleteTextView) findViewById(R.id.editText1);
                        autoCompleteEditText1.setAdapter(autoCompleteAdapter);
                        AutoCompleteTextView autoCompleteEditText2 = (AutoCompleteTextView) findViewById(R.id.editText2);
                        autoCompleteEditText2.setAdapter(autoCompleteAdapter);
                        AutoCompleteTextView autoCompleteEditText3 = (AutoCompleteTextView) findViewById(R.id.editText3);
                        autoCompleteEditText3.setAdapter(autoCompleteAdapter);
                        AutoCompleteTextView autoCompleteEditText4 = (AutoCompleteTextView) findViewById(R.id.editText4);
                        autoCompleteEditText4.setAdapter(autoCompleteAdapter);
                        AutoCompleteTextView autoCompleteEditText5 = (AutoCompleteTextView) findViewById(R.id.editText5);
                        autoCompleteEditText5.setAdapter(autoCompleteAdapter);
                        AutoCompleteTextView autoCompleteEditText6 = (AutoCompleteTextView) findViewById(R.id.editText6);
                        autoCompleteEditText6.setAdapter(autoCompleteAdapter);
                        loader.dismiss();
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loader.dismiss();
                        Utils.errorToast("Falha na conexão com o servidor. Tente novamente mais tarde.", getApplicationContext()).show();
                    }
                });

        queue.add(req);
        //return resposta;
    }

    private void volleySintomas(ArrayList<String> campos) {
        final Context context = getApplicationContext();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://web-saude.com/websaude/getSintomas.php?";

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
                        //String numDoencas = "";
                        ArrayList<String> esp = new ArrayList<>();
                        for (int i = 0; i < splitSinais.length; i++) {
                            String[] splitPoints = splitSinais[i].split(":");
                            if (splitSinais[i].contains("nome"))
                                esp.add(splitPoints[splitPoints.length - 1].replaceAll("[\":}]", "").replaceAll("]", ""));
                            else
                                if (splitSinais[i].contains("desc"))
                                    esp.add(splitPoints[splitPoints.length - 1].replaceAll("[\":}]", "").replaceAll("]", ""));
                        }
                        if (esp.isEmpty())
                            Utils.errorToast("Os campos não possuem valores válidos.", getApplicationContext()).show();
                            //Toast.makeText(context, "Os campos não possuem valores válidos.", Toast.LENGTH_SHORT).show();
                        else {
                            String resposta = "";
                            for (int i = 0; i < esp.size(); i++)
                                resposta += esp.get(i) + "\n";
                            startSinais(resposta);
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loader.dismiss();
                        Utils.errorToast("Falha na conexão com o servidor. Tente novamente mais tarde.", getApplicationContext()).show();
                    }
                });

        queue.add(req);
    }
    */
}
