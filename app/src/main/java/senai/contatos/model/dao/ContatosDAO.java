package senai.contatos.model.dao;

import java.util.ArrayList;
import java.util.List;

import senai.contatos.model.Bean.Contatos;

/**
 * Created by Web on 31/10/2017.
 *
 * Classe DAO de controle dos dados
 */

public class ContatosDAO {
    public static ContatosDAO manager = new ContatosDAO();
    private List<Contatos> lista;
    private int id = 0;

   //Contructor
    private ContatosDAO() {
        lista = new ArrayList<>();
    }
    public int size(){return lista.size();}

    public void add(Contatos obj) throws DaoException {
        Contatos pesquisa = null;
        for(Contatos item:lista){
            if(item.getNome().equals(obj.getNome())){
                pesquisa = item;
                break;
            }
        }

        if(pesquisa != null){
            throw new DaoException("Contato duplicado para o nome: " + obj.getNome());
        }
        // incrementa o ID
        id++;

        obj.setId(id);
        lista.add(obj);
    }
    public Contatos get(int id) throws DaoException {
        Contatos pesquisa = null;
        for (Contatos item : lista) {
            if (item.getId() == id) {
                pesquisa = item;
                break;
            }
        }
        if (pesquisa == null) {
            throw new DaoException("Contato não encontrado para o id: " + id);
        }
        return pesquisa;
    }
    public void put (Contatos obj) throws DaoException {
        Contatos pesquisa = get(obj.getId());
                 pesquisa.setNome(obj.getNome());
                 pesquisa.setEmail(obj.getEmail());
                 pesquisa.setTelefone(obj.getTelefone());
                 pesquisa.setDel(obj.isDel());
    }
    //Método que retorna a lista de contatos
    public List<Contatos> all() {return lista;}

}
