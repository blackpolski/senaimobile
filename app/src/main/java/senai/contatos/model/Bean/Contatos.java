package senai.contatos.model.Bean;

/**
 *
 * Classe Bean de Contato
 *
 *
 * Created by Fernando on 31/10/2017.
 *
 *
 *
 * DAO = Data Access Object
 * M = Model = manipula os dados
 * V = View = visualiza
 * C = Control = Controla os dados
 */

public class Contatos {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private boolean del;

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

