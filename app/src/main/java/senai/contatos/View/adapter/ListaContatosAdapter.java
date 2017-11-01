package senai.contatos.View.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import senai.contatos.R;
import senai.contatos.model.Bean.Contatos;
import senai.contatos.model.dao.ContatosDAO;

/**
 * Created by Web on 01/11/2017.
 */

public class ListaContatosAdapter extends BaseAdapter{

    private List<Contatos> lista;
    private LayoutInflater layout;

    public ListaContatosAdapter(Context context){

        lista = ContatosDAO.manager.all();
        layout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return (Contatos) lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contatos c = lista.get(position);

        // Verifica a View
        if(convertView == null){
           convertView = layout.inflate(R.layout.item_list, null, true);

        }
        //pega os campos
        TextView nome = (TextView) convertView.findViewById(R.id.lNome);
        TextView dados = (TextView) convertView.findViewById(R.id.lDados);

        nome.setText(c.getNome());
        dados.setText(c.getEmail() + "\n" + c.getTelefone());


        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
