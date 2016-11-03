package br.com.appsaude.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.appsaude.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class EspecialistasAdapter extends ArrayAdapter<Especialista>{

    private Context context;
    private List<Especialista> esp;

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
        imageViewProx.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goEspecialistas(especialista.getNome());
            }
        });

        return view;
    }

    public void goEspecialistas(String resposta) {

        Intent secondActivity = new Intent(context, ProfissionaisActivity.class);
        secondActivity.putExtra(EXTRA_MESSAGE, resposta);
        context.startActivity(secondActivity);
    }

}
