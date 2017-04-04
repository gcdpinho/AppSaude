package br.com.appsaude.util;


import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

import br.com.appsaude.R;

public class Services {

    public static void volleyAutoComplete(final Context context, String url, final Handler.Callback callback){
        RequestQueue queue = Volley.newRequestQueue(context);

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

                        Handler handler = new Handler(callback);
                        Message message = new Message();
                        message.arg1 = 0;
                        message.obj = allSintomas;
                        handler.sendMessage(message);
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Handler handler = new Handler(callback);
                        Message message = new Message();
                        message.arg1 = 1;
                        //String[] teste = new String[2];
                        //teste[0] = "teste0";
                        //teste[1] = "teste1";
                        //message.obj = teste;
                        message.obj = "Falha na conexão com o servidor. Tente novamente mais tarde.";
                        handler.sendMessage(message);
                    }
                });

        queue.add(req);
        //return resposta;
    }

    public static void getVolley(ArrayList<String> campos, Context context, String url, final Handler.Callback callback){
        RequestQueue queue = Volley.newRequestQueue(context);
        url += "?";

        for (int i=0; i<campos.size(); i++)
            url += "campo"+ i + "=" + campos.get(i) + "&";
        url = url.substring(0, url.length()-1);
        url = url.replaceAll(" ", "_");

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
                        if (esp.isEmpty()){
                            Handler handler = new Handler(callback);
                            Message message = new Message();
                            message.arg1 = 1;
                            message.obj = "Os campos não possuem valores válidos.";
                            handler.sendMessage(message);
                        }
                        else {
                            String resposta = "";
                            for (int i = 0; i < esp.size(); i++)
                                resposta += esp.get(i) + "\n";

                            Handler handler = new Handler(callback);
                            Message message = new Message();
                            message.arg1 = 0;
                            message.obj = resposta;
                            handler.sendMessage(message);
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Handler handler = new Handler(callback);
                        Message message = new Message();
                        message.arg1 = 1;
                        message.obj = "Falha na conexão com o servidor. Tente novamente mais tarde.";
                        handler.sendMessage(message);
                    }
                });

        queue.add(req);
    }
}
