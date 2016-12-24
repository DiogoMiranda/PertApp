package diogo.miranda.pert.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import diogo.miranda.pert.Model.Atividade;
import diogo.miranda.pert.R;

/**
 * Created by Diogo Miranda on 17/09/2016.
 */
public class AdapterAtividade extends BaseAdapter {

    private Context ctx;
    private ArrayList<Atividade> arrayAtividades;

    public AdapterAtividade(Context ctx, ArrayList<Atividade> arrayAtividades) {
        this.ctx = ctx;
        this.arrayAtividades = arrayAtividades;
    }

    @Override
    public int getCount() {
        return arrayAtividades.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayAtividades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return arrayAtividades.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_listview, parent, false);
        TextView tv_id = (TextView) view.findViewById(R.id.list_item_post_id_textview);
        TextView tv_title = (TextView) view.findViewById(R.id.list_item_post_title_textview);

        Atividade atividade = arrayAtividades.get(position);
        tv_id.setText(String.valueOf(atividade.getId()));
        tv_title.setText(atividade.getTitler());
        return view;
    }
}
