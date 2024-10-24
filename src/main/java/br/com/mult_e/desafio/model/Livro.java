package br.com.mult_e.desafio.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "livros")
@XmlRootElement(name = "livro")
@XmlAccessorType(XmlAccessType.FIELD)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    @XmlElementWrapper(name = "capitulos")
    @XmlElement(name = "capitulo")
    private List<Capitulo> capitulos;

}
