package com.tmdb.esqueceramdemim.views;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tmdb.esqueceramdemim.Adapters.ReceitaAdapter;
import com.tmdb.esqueceramdemim.Async.CriarBD;
import com.tmdb.esqueceramdemim.R;
import com.tmdb.esqueceramdemim.model.ReceitaModel;
import com.tmdb.esqueceramdemim.viewmodels.ReceitaViewModel;

import java.util.ArrayList;

public class ReceitasListaView extends AppCompatActivity {

    private ListView lv = null;
    private ArrayAdapter<ReceitaModel> radp = null;
    private ArrayList<ReceitaModel> rlist = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas_lista_view);

        lv = findViewById(R.id.rlv);

        rlist = new ArrayList<>();

        ReceitaModel rec = new ReceitaModel();
        rec.setmTitulo("Arroz Soltinho");
        rec.setmImagem(R.drawable.star_1_sm);

        radp = new ReceitaAdapter(this, R.layout.lista_receitas, rlist);

        lv.setAdapter(radp);
        radp.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(ReceitasListaView.this, ReceitasView.class);
                startActivity(intent);
            }
        });



        /*for (ReceitaModel r: rlist)
        {
            SQLiteDatabase db = getApplicationContext();
            rlist.add()
        }*/
        
    }
}
