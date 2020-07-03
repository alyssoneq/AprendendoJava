package br.com.globallabs.SpringWebMVC.repository;

import br.com.globallabs.SpringWebMVC.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//Bean gerenciado pelo spring
@Repository
public class JediRepository {
    //instanciando a variavel jedi
    private List<Jedi> jedi;

    //construtor do repositorio
    public JediRepository() {
        jedi = new ArrayList<>();
        jedi.add(new Jedi("Luke", "Skywalker"));
    }

    public List<Jedi> getAllJedi(){
        return this.jedi;
    }

    public void add(Jedi jedi) {
        this.jedi.add(jedi);
    }
}
