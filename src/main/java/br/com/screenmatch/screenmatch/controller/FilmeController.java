package br.com.screenmatch.screenmatch.controller;

import br.com.screenmatch.screenmatch.entity.DadosAlteracaoFilmes;
import br.com.screenmatch.screenmatch.entity.filme.DadosCadastrosFilmes;
import br.com.screenmatch.screenmatch.entity.filme.Filme;
import br.com.screenmatch.screenmatch.repository.FilmeRepository;
import br.com.screenmatch.screenmatch.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;


    @GetMapping()
    public String carregarPaginaListagem(Model model) {
        filmeService.carregaListagem(model);
        return "filmes/listagem";
    }

    @GetMapping("/formulario")
    public String carregarPaginaFormulario(Long id, Model model) {
        filmeService.carregaFormulario(id, model);
        return "filmes/formulario";
    }

    @PostMapping
    public String salvarFilme(DadosCadastrosFilmes dadosCadastrosFilmes) {
        filmeService.salvaFilme(dadosCadastrosFilmes);
        return "redirect:/filmes";
    }

    @PutMapping
    @Transactional
    public String editaFilme(DadosAlteracaoFilmes dadosAlteracaoFilmes) {
        filmeService.alteraFilme(dadosAlteracaoFilmes);
        return "redirect:/filmes";
    }

    @DeleteMapping
    public String removeFilme(Long id) {
        filmeService.deletaFilme(id);
        return "redirect:/filmes";
    }
}
