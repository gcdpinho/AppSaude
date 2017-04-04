package br.com.appsaude.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.com.appsaude.R;
import br.com.appsaude.model.Profissional;

public class ProfissionaisAdapter extends ArrayAdapter<Profissional>{

    private Context context;
    private List<Profissional> prof;

    public ProfissionaisAdapter(Context context, List<Profissional> prof){
        super(context,0, prof);
        this.prof = prof;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        final Profissional profissional = prof.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_list_prof, null);

        TextView textViewEsp = (TextView) view.findViewById(R.id.textViewProf);
        textViewEsp.setText(profissional.getNome());

        TextView textViewPercent = (TextView)view.findViewById(R.id.textViewKm);
        textViewPercent.setBackgroundResource(R.drawable.prof_foto);

        ImageView imageViewProx = (ImageView) view.findViewById(R.id.imageViewProx2);
        imageViewProx.setImageResource(profissional.getImagem());

        LinearLayout linearItem = (LinearLayout) view.findViewById(R.id.linearItem2);
        linearItem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        return view;
    }

}
