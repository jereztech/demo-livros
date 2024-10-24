package br.com.mult_e.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "capitulos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Capitulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    @XmlTransient
    @JsonIgnore
    private Livro livro;

    @OneToMany(mappedBy = "capitulo", cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "paginas")
    @XmlElement(name = "pagina")
    private List<Pagina> paginas;

}
