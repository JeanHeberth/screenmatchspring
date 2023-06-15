package br.com.screenmatch.screenmatch.controller;

import br.com.screenmatch.screenmatch.entity.filme.DadosCadastrosFilmes;
import br.com.screenmatch.screenmatch.entity.filme.Filme;
import br.com.screenmatch.screenmatch.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario() {
        return "filmes/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", filmeRepository.findAll());
        return "filmes/listagem";
    }

    @PostMapping
    public String cadastraFilme(DadosCadastrosFilmes dadosCadastrosFilmes) {
        var filme = new Filme(dadosCadastrosFilmes);
        filmeRepository.save(filme);

        return "redirect:/filmes";
    }

    @DeleteMapping
    public String removeFilme() {
        System.out.println("filme excluido");
        return "redirect:/filmes";

    }
}
