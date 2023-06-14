package br.com.screenmatch.screenmatch.entity.filme;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "filmes")
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String genero;

    private Integer duracaoEmMinutos;

    private Integer anoLancamento;
    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Filme(DadosCadastrosFilmes dadosCadastrosFilmes) {
        this.nome = dadosCadastrosFilmes.nome();
        this.genero = dadosCadastrosFilmes.genero();
        this.duracaoEmMinutos = dadosCadastrosFilmes.duracao();
        this.anoLancamento = dadosCadastrosFilmes.ano();
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                ", anoLancamento=" + anoLancamento +
                '}';
    }
}