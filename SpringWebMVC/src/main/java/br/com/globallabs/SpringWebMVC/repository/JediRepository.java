package br.com.globallabs.SpringWebMVC.repository;

import br.com.globallabs.SpringWebMVC.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//Bean gerenciado pelo spring
@Repository
public class JediRepository {
    public List<Jedi> getAllJedi(){

        List<Jedi> jedi = new ArrayList<>();
        jedi.add(new Jedi("Luke", "Skywalker"));
        return jedi;
    }
}
