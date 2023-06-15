package br.com.screenmatch.screenmatch.service;

import br.com.screenmatch.screenmatch.entity.DadosAlteracaoFilmes;
import br.com.screenmatch.screenmatch.entity.filme.DadosCadastrosFilmes;
import br.com.screenmatch.screenmatch.entity.filme.Filme;
import br.com.screenmatch.screenmatch.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;


    public void carregaListagem(Model model) {
        model.addAttribute("lista", filmeRepository.findAll());
    }

    public void carregaFormulario(Long id, Model model) {
        if (id != null) {
            var filme = filmeRepository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }
    }

    public void salvaFilme(DadosCadastrosFilmes dadosCadastrosFilmes) {
        var filme = new Filme(dadosCadastrosFilmes);
        filmeRepository.save(filme);
    }


    public void alteraFilme(DadosAlteracaoFilmes dadosAlteracaoFilmes) {
        var filme = filmeRepository.getReferenceById(dadosAlteracaoFilmes.id());
        filme.atualizaFilmes(dadosAlteracaoFilmes);

    }

    public void deletaFilme(Long id) {
        filmeRepository.deleteById(id);
    }
}
