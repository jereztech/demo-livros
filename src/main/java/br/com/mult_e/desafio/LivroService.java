package br.com.mult_e.desafio;

import br.com.mult_e.desafio.model.Livro;
import br.com.mult_e.desafio.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro findLivroById(Long id){
        return livroRepository.findById(id).orElseThrow();
    }

}
