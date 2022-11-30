package br.senac.tads.dsw.filmes.controle;

import br.senac.tads.dsw.filmes.cadastro.filme.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.senac.tads.dsw.filmes.cadastro.filme.FilmeRepositorio;
import java.util.Optional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author OffSys
 */
@Controller
public class FilmeControle {

    private FilmeRepositorio filmeRepo;

    public FilmeControle(FilmeRepositorio filmeRepo) {
        this.filmeRepo = filmeRepo;
    }

    @GetMapping("/lc/filmes")
    public String filmes(Model model) {
        model.addAttribute("listaFilmes", filmeRepo.findAll());
        return "lc/filmes/index";

    }

    @GetMapping("lc/filmes/novo")
    public String novoFilme(@ModelAttribute("filme") Filme filme) {
        return "lc/filmes/form";
    }

    @GetMapping("lc/filmes/{id}")
    public String alterarFilme(@PathVariable("id") long id, Model model) throws IllegalAccessException {
        Optional<Filme> filmeOpt = filmeRepo.findById(id);
        if (filmeOpt.isEmpty()) {
            throw new IllegalAccessException("Filme Inválido");
        }
        model.addAttribute("filme", filmeOpt.get());
        return "lc/filmes/form";
    }

    @PostMapping("/lc/filmes/salvar")
    public String salvarFilme(@ModelAttribute("filme") Filme filme) {
        filmeRepo.save(filme);
        return "redirect:/lc/filmes";
    }


    @GetMapping("/lc/filmes/excluir/{id}")
    public String excluirFilme(@PathVariable("id") long id) throws IllegalAccessException {
        Optional<Filme> filmeOpt = filmeRepo.findById(id);
        if (filmeOpt.isEmpty()) {
            throw new IllegalAccessException("Filme Inválido");
        }
        filmeRepo.delete(filmeOpt.get());
        return "redirect:/lc/filmes";

    }

}
