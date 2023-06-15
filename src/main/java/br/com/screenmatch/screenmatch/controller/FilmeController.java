package br.com.screenmatch.screenmatch.controller;

import br.com.screenmatch.screenmatch.entity.DadosAlteracaoFilmes;
import br.com.screenmatch.screenmatch.entity.filme.DadosCadastrosFilmes;
import br.com.screenmatch.screenmatch.entity.filme.Filme;
import br.com.screenmatch.screenmatch.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var filme = filmeRepository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }
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

    @PutMapping
    @Transactional
    public String alteraFilme(DadosAlteracaoFilmes dadosAlteracaoFilmes) {
        var filme = filmeRepository.getReferenceById(dadosAlteracaoFilmes.id());
        filme.atualizaFilmes(dadosAlteracaoFilmes);
        return "redirect:/filmes";
    }


    @DeleteMapping
    public String removeFilme(Long id) {
        filmeRepository.deleteById(id);
        return "redirect:/filmes";

    }
}
