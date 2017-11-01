package senai.contatos.View;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import senai.contatos.R;
import senai.contatos.model.Bean.Contatos;
import senai.contatos.model.dao.ContatosDAO;
import senai.contatos.model.dao.DaoException;
import senai.contatos.utils.UtilsHelper;

public class AddContatoActivity extends AppCompatActivity {

    private EditText idNome;
    private EditText idEmail;
    private EditText idTelefone;
    private int idContato = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contato);

        //pega o ID passado
        idContato = getIntent().getIntExtra("idContato", 0);

        //pega os campos da tela
        idNome = (EditText) findViewById(R.id.idNome);
        idEmail = (EditText) findViewById(R.id.idEmail);
        idTelefone = (EditText) findViewById(R.id.idTelefone);

        if(idContato > 0) {

            try {
                //pega o contato selecionado na Lista de Contatos
                Contatos oldContatos = ContatosDAO.manager.get(idContato);

                //seta os dados do contato nos campos
                idNome.setText(oldContatos.getNome());
                idEmail.setText(oldContatos.getEmail());
                idTelefone.setText(oldContatos.getTelefone());


            } catch (DaoException e) {
                UtilsHelper.msg(getBaseContext(), e.getMessage());
                idContato = 0;
            }
        }

    }

            public void onSalvar(View view) {
                String nmNome     = idNome.getEditableText().toString();
                String nmEmail    = idEmail.getEditableText().toString();
                String nmTelefone = idTelefone.getEditableText().toString();

                Contatos contatos = new Contatos();
                contatos.setId(idContato);
                contatos.setNome(nmNome);
                contatos.setEmail(nmEmail);
                contatos.setTelefone(nmTelefone);

                try {
                    if (idContato == 0){ContatosDAO.manager.add(contatos);}
                    else               {ContatosDAO.manager.put(contatos);}

                   //mostra a mensagem de sucesso
                    UtilsHelper.msg(getBaseContext(), "Contato salvo com sucesso!");

                    setResult(Activity.RESULT_OK);

                } catch (DaoException e) {
                    UtilsHelper.msg(getBaseContext(),e.getMessage());
                    setResult(Activity.RESULT_CANCELED, null);
                }


                finish();

           /*     String txt = "Nome: " + nmNome + "\n";
                txt += "Email: " + nmEmail + "\n";
                txt += "Telefone: " + nmTelefone + "\n";

              Toast.makeText(getBaseContext(), txt, Toast.LENGTH_LONG).show();
*/            }

}
