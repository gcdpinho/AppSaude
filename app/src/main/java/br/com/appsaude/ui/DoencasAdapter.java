package br.com.appsaude.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.com.appsaude.R;
import br.com.appsaude.TextViewEx;

public class DoencasAdapter extends ArrayAdapter<Doenca>{

    private Context context;
    private List<Doenca> doenca;

    public DoencasAdapter(Context context, List<Doenca> doenca){
        super(context,0, doenca);
        this.doenca = doenca;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        final Doenca doencas = doenca.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_list_doenca, null);

        TextView textViewDoenca = (TextView) view.findViewById(R.id.textViewDoenca);
        textViewDoenca.setText(doencas.getNomeDoenca());

        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/HINDGUNTUR-BOLD.TTF");
        textViewDoenca.setTypeface(myTypeface);

        TextView textViewPercent = (TextView)view.findViewById(R.id.textViewPorc);
        textViewPercent.setText(doencas.getPorc());

        TextViewEx textViewDesc = (TextViewEx)view.findViewById(R.id.textViewDesc);
        //textViewDesc.loadData(doencas.getDescDoenca(), "text/html", "utf-8");
        //CharSequence teste = Html.fromHtml();buscando textview p
        textViewDesc.setText(doencas.getDescDoenca(), true);
        textViewDesc.setLineSpacing(-16, 1);

        return view;
    }

}
