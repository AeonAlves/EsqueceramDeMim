package com.tmdb.esqueceramdemim.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tmdb.esqueceramdemim.R;
import com.tmdb.esqueceramdemim.model.GuiasModel;
import com.tmdb.esqueceramdemim.model.ServicosModel;

import java.util.ArrayList;

public class ServicosAdapter extends ArrayAdapter<ServicosModel> {

    private ArrayList<ServicosModel> servicosArray;
    private Context context;

    public ServicosAdapter(Context context, int resource, ArrayList<ServicosModel> servicosArray){
        super(context, resource, servicosArray);

        this.context = context;
        this.servicosArray = servicosArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ServicosAdapter.ViewHolder holder = null;

        if(convertView==null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.lista_servicos, parent, false);
            holder = new ServicosAdapter.ViewHolder();
            holder.prestador = (TextView) convertView.findViewById(R.id.sPrestador);
            holder.produto = (TextView) convertView.findViewById(R.id.sProduto);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ServicosAdapter.ViewHolder)convertView.getTag();
        }
        ServicosModel sl = (ServicosModel) getItem(position);
        holder.prestador.setText(sl.getmPrestador());
        holder.produto.setText(sl.getmProduto());


        return convertView;
    }

    private static class ViewHolder {
        TextView prestador;
        TextView produto;
    }
}
