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

import java.util.ArrayList;

public class GuiasAdapter extends ArrayAdapter<GuiasModel> {

    private ArrayList<GuiasModel> guiasArray;
    private Context context;

    public GuiasAdapter(Context context, int resource, ArrayList<GuiasModel> guiasArray){
        super(context, resource, guiasArray);

        this.context = context;
        this.guiasArray = guiasArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        GuiasAdapter.ViewHolder holder = null;

        if(convertView==null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.lista_guias, parent, false);
            holder = new GuiasAdapter.ViewHolder();
            holder.titulo = (TextView) convertView.findViewById(R.id.gTitulo);

            convertView.setTag(holder);
        }
        else
        {
            holder = (GuiasAdapter.ViewHolder)convertView.getTag();
        }
        GuiasModel gl = (GuiasModel) getItem(position);
        holder.titulo.setText(gl.getmTitulo());

        return convertView;
    }

    private static class ViewHolder {
        TextView titulo;
    }
}
