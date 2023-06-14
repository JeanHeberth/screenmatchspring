package br.com.screenmatch.screenmatch.repository;

import br.com.screenmatch.screenmatch.entity.filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
