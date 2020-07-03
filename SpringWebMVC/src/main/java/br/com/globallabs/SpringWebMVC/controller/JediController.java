package br.com.globallabs.SpringWebMVC.controller;

import br.com.globallabs.SpringWebMVC.model.Jedi;
import br.com.globallabs.SpringWebMVC.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

//Essa anotação informa ao spring que esse é o controle do MVC
//Bean gerenciado pelo spring
@Controller
public class JediController {

    //Bean de autowired to inserir as dependencias
    //Inserido o repository
    @Autowired
    private JediRepository repository;

    //Anotação para carregar o jedi.html ao acessar /Jedi
    @GetMapping("/jedi")
    public ModelAndView jedi(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", repository.getAllJedi());
        return modelAndView;
    }

    //Anotação para carregar a view newJedi.html ao acessar /newJedi
    @GetMapping("/newJedi")
    public ModelAndView newJedi(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newJedi");

        modelAndView.addObject("jedi", new Jedi());
        return modelAndView;
    }

    //Bean para o método POST usado no formulario do newJedi.html
    //O Post é direcionado para /jedi pois no formulario de newJedi o action é esse
    @PostMapping("/jedi")
    //@ModelAttribute relaciona os parametros da classe Jedi
    //Anotação @Valid permite validação da entrada feita pelo javax
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes){
        //Interface BindingResult permite tratar erros de preenchimento de formulario
        if (result.hasErrors()){
            return "newJedi";
        }
        repository.add(jedi);
        redirectAttributes.addFlashAttribute("message", "New Jedi entry");
        return "redirect:jedi";
    }
}
