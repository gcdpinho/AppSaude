package br.com.appsaude.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.appsaude.R;

public class EspecialistasAdapter extends ArrayAdapter<Especialista> {

    private Context context;
    private List<Especialista> zombies = null;

    public EspecialistasAdapter(Context context, List<Especialista> zombies) {
        super(context,0, zombies);
        this.zombies = zombies;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Especialista especialista = zombies.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_list_zombies, null);

        ImageView imageViewZombie = (ImageView) view.findViewById(R.id.image_view_zombie);
        imageViewZombie.setImageResource(especialista.getImagem());
        imageViewZombie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, "hi", Toast.LENGTH_LONG).show();
            }
        });

        TextView textViewNomeZombie = (TextView) view.findViewById(R.id.text_view_nome_zombie);
        textViewNomeZombie.setText(especialista.getNome());


        TextView textViewIdade = (TextView)view.findViewById(R.id.text_view_idade_zombie);
        String textoIdade = String.valueOf(especialista.getPercent()) + " " + "";
        textViewIdade.setText(textoIdade);

        return view;
    }


}
