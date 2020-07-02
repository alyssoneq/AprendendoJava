package br.com.globallabs.SpringWebMVC.controller;

import br.com.globallabs.SpringWebMVC.model.Jedi;
import br.com.globallabs.SpringWebMVC.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//Essa anotação informa ao spring que esse é o controle do MVC
//Bean gerenciado pelo spring
@Controller
public class JediController {

    //Bean de autowired to inserir as dependencias
    //Inserido o repository
    @Autowired
    private JediRepository jediRepository;

    //Anotação para carregar o jedi.html ao acessar /Jedi
    @GetMapping("/jedi")
    public ModelAndView jedi(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", jediRepository.getAllJedi());
        return modelAndView;
    }

    //Anotação para carregar a view newJedi.html ao acessar /newJedi
    @GetMapping("/new-jedi")
    public ModelAndView newJedi(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newJedi");

        modelAndView.addObject("jedi", new Jedi());
        return modelAndView;
    }
}
