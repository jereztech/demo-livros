package br.com.mult_e.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.Data;

@Entity
@Data
@Table(name = "paginas")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pagina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    @Column(columnDefinition = "TEXT")
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "capitulo_id")
    @XmlTransient
    @JsonIgnore
    private Capitulo capitulo;

}
