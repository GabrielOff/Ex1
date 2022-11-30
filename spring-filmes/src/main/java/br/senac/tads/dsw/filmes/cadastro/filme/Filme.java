package br.senac.tads.dsw.filmes.cadastro.filme;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author OffSys
 */
@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filme;

    private String genero;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;

    @Deprecated
    protected Filme() {
    }

    public Filme(String filme) {
        this.filme = filme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Filme other = (Filme) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", filme=" + filme + ", genero=" + genero + ", dataLancamento=" + dataLancamento + '}';
    }

}
