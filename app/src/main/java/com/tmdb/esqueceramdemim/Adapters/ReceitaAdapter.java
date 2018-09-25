package com.tmdb.esqueceramdemim.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tmdb.esqueceramdemim.R;
import com.tmdb.esqueceramdemim.model.ReceitaModel;

import java.util.ArrayList;

public class ReceitaAdapter extends ArrayAdapter<ReceitaModel> {

    private ArrayList<ReceitaModel> receitaArray;
    private Context context;

    public ReceitaAdapter(Context context, int resource, ArrayList<ReceitaModel> receitaArray){
        super(context, resource, receitaArray);

        this.context = context;
        this.receitaArray = receitaArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if(convertView==null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.lista_receitas, parent, false);
            holder = new ViewHolder();
            holder.imagem = (ImageView) convertView.findViewById(R.id.rImagem);
            holder.titulo = (TextView) convertView.findViewById(R.id.rTitulo);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        ReceitaModel rl = (ReceitaModel) getItem(position);
        holder.imagem.setImageResource(rl.getmImagem());
        holder.titulo.setText(rl.getmTitulo());

        return convertView;
    }

    private static class ViewHolder {
        TextView titulo;
        ImageView imagem;
    }
}
