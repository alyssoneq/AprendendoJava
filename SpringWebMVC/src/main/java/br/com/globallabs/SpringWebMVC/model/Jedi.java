package br.com.globallabs.SpringWebMVC.model;

import javax.validation.constraints.NotBlank;

public class Jedi {
    //Bean para informar que a variavel não pode receber valor vazio
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;

    public Jedi(String name, String lastname) {

        this.name = name;
        this.lastName = lastname;
    }

    public Jedi() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
