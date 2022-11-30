package br.senac.tads.dsw.filmes.cadastro.filme;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.senac.tads.dsw.filmes.cadastro.filme.Filme;

/**
 *
 * @author OffSys
 */
@Repository
public interface FilmeRepositorio extends  JpaRepository<Filme, Long>{

}
