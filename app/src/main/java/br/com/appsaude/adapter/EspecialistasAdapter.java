package br.com.appsaude.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

import br.com.appsaude.R;
import br.com.appsaude.model.Especialista;
import br.com.appsaude.ui.ProfissionaisActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class EspecialistasAdapter extends ArrayAdapter<Especialista>{

    private Context context;
    private List<Especialista> esp;
    private View viewAux;

    public EspecialistasAdapter(Context context, List<Especialista> esp){
        super(context,0, esp);
        this.esp = esp;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        final Especialista especialista = esp.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_list_esp, null);

        TextView textViewEsp = (TextView) view.findViewById(R.id.textViewEsp);
        textViewEsp.setText(especialista.getNome());

        TextView textViewPercent = (TextView)view.findViewById(R.id.textViewPercent);
        textViewPercent.setText(especialista.getPercent());

        ImageView imageViewProx = (ImageView) view.findViewById(R.id.imageViewProx);
        imageViewProx.setImageResource(especialista.getImagem());
        viewAux = view;
        LinearLayout linearItem = (LinearLayout) view.findViewById(R.id.linearItem);
        linearItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getProfissionais(especialista.getNome(), viewAux);
            }
        });

        return view;
    }

    public void goProfissionais(String resposta) {

        Intent secondActivity = new Intent(context, ProfissionaisActivity.class);
        secondActivity.putExtra(EXTRA_MESSAGE, resposta);
        context.startActivity(secondActivity);
    }

    private void getProfissionais(final String prof, View v){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "http://web-saude.com/websaude/getProfissionais.php?prof=" + prof.replaceAll(" ", "_");

        //Toast.makeText(context, url, Toast.LENGTH_LONG).show();

        JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Toast.makeText(context, "Não há nenhum profissional próximo.", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                        String aux = response.toString().replaceAll("null,", "null\",");
                        String[] splitComma = aux.split("\",");
                        String message = "";
                        for (int i=0; i<splitComma.length; i++){
                            String[] splitPoints = splitComma[i].split(":");
                            if (i % 4 != 0 || i == 0 || i == splitComma.length-1)
                                message += splitPoints[splitPoints.length-1].replaceAll("\"", "").replaceAll("[]}]", "") + "\n";
                            else {
                                message += splitPoints[splitPoints.length - 2].replaceAll("\"", "").replaceAll("[]}]", "") + "\n";
                                message += splitPoints[splitPoints.length - 1].replaceAll("\"", "").replaceAll("[]}]", "") + "\n";
                            }
                        }
                        //Toast.makeText(context, message, Toast.LENGTH_LONG).show();
                        goProfissionais(prof+"\n"+message);
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Não há nenhum profissional próximo.", Toast.LENGTH_SHORT).show();
                    }
                });

        queue.add(req);
    }

}
