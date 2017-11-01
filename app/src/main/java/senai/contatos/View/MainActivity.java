package senai.contatos.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import senai.contatos.R;
import senai.contatos.View.adapter.ListaContatosAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ListaContatosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //carrega o layout padrão
        setContentView(R.layout.activity_main);

        adapter = new ListaContatosAdapter(getBaseContext());

        //pega o ListView
        listView = (ListView) findViewById(R.id.listaContato);
        listView.setAdapter(adapter);
    }

    //Método executado ao pressionar o botão Contatos
    public void onContatosClick(View view){
        Intent it = new Intent(getBaseContext(), AddContatoActivity.class);
        it.putExtra("idContato", 0);
        startActivityForResult(it, 100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            adapter.notifyDataSetChanged();
        }
    }
}
