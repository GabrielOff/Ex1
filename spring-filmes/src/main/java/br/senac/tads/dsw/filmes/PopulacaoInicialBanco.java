package br.senac.tads.dsw.filmes;

import br.senac.tads.dsw.filmes.cadastro.filme.Filme;
import br.senac.tads.dsw.filmes.cadastro.filme.FilmeRepositorio;
import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author OffSys
 */
@Transactional
@Component
public class PopulacaoInicialBanco implements CommandLineRunner {
    
    @Autowired
    private FilmeRepositorio filmeRepo;
    
    @Override
    public void run(String... args) throws Exception {
      
        Filme p = new Filme("Harry Potter");
        p.setGenero("Fantasia");
        p.setDataLancamento(LocalDate.of(1999, 3, 2));
        
    
    }
    
}
